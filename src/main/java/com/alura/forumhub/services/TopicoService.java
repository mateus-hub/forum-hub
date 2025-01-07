package com.alura.forumhub.services;

import com.alura.forumhub.dto.TopicoByIdDTO;
import com.alura.forumhub.dto.TopicoDTO;
import com.alura.forumhub.entities.Curso;
import com.alura.forumhub.entities.Topico;
import com.alura.forumhub.entities.Usuario;
import com.alura.forumhub.enums.Status;
import com.alura.forumhub.exceptions.DatabaseException;
import com.alura.forumhub.exceptions.ResourceNotFoundException;
import com.alura.forumhub.infra.service.AutenticacaoService;
import com.alura.forumhub.repositories.CursoRepository;
import com.alura.forumhub.repositories.TopicoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TopicoService {
	
	@Autowired
	private TopicoRepository topicoRepository;
	
	@Autowired
	private CursoRepository cursoRepository;

	@Autowired
	private AutenticacaoService autenticacaoService;


	@Transactional(readOnly = true)
	public Page<TopicoDTO> findAllPaged(Pageable pageable) {
		Page<Topico> page = topicoRepository.findAll(pageable);
		return page.map(TopicoDTO::new);
	}

	@Transactional(readOnly = true)
	public TopicoByIdDTO findById(Long id) {
		Optional<Topico> obj = topicoRepository.findById(id);
		Topico entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entidade não encontrada"));
		return new TopicoByIdDTO(entity, entity.getRespostas());
	}

	@Transactional
	public TopicoDTO insert(TopicoDTO dto) {
		Usuario usuario = autenticacaoService.authenticated();

		Topico entity = new Topico();

		entity.setTitulo(dto.getTitulo());
		entity.setMensagem(dto.getMensagem());

		entity.setDataCriacao(dto.getDataCriacao());
		entity.setStatus(dto.getStatus());



		entity.setCurso(cursoRepository.getOne(dto.getCursoId()));
		entity.setUsuario(usuario);

		entity = topicoRepository.save(entity);

		return new TopicoDTO(entity);
	}

	@Transactional
	public TopicoDTO update(Long id, TopicoDTO dto) {
		try {
			Topico entity = topicoRepository.getOne(id);
			entity.setTitulo(dto.getTitulo());
			entity.setMensagem(dto.getMensagem());
			entity = topicoRepository.save(entity);
			return new TopicoDTO(entity);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
	}

	public void delete(Long id) {
		try {
			topicoRepository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("integrity violation - não é possível deletar um tópico com respostas atreladas a ele.");
		}
	}


}
