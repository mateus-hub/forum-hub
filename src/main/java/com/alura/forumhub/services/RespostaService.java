package com.alura.forumhub.services;

import com.alura.forumhub.dto.RespostaDTO;
import com.alura.forumhub.dto.TopicoDTO;
import com.alura.forumhub.entities.Resposta;
import com.alura.forumhub.entities.Topico;
import com.alura.forumhub.entities.Usuario;
import com.alura.forumhub.exceptions.ResourceNotFoundException;
import com.alura.forumhub.infra.service.AutenticacaoService;
import com.alura.forumhub.repositories.RespostaRepository;
import com.alura.forumhub.repositories.TopicoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RespostaService {

	@Autowired
	private RespostaRepository respostaRepository;
	
	@Autowired
	private TopicoRepository topicoRepository;
	
	@Autowired
	private AutenticacaoService autenticacaoService;


	@Transactional
	public RespostaDTO inserirResposta(RespostaDTO dto) {
		Usuario usuario = autenticacaoService.authenticated();
		Resposta entity = new Resposta();
		entity.setMensagem(dto.getMensagem());
		entity.setTopico(topicoRepository.getOne(dto.getTopicoId()));
		entity.setUsuario(usuario);
		entity = respostaRepository.save(entity);
		return new RespostaDTO(entity);
	}
}
