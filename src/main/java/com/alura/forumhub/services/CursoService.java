package com.alura.forumhub.services;

import com.alura.forumhub.dto.CursoDTO;
import com.alura.forumhub.entities.Curso;
import com.alura.forumhub.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CursoService {
	
	@Autowired
	private CursoRepository repository;
	
	@Transactional(readOnly = true)
	public List<CursoDTO> findAll() {
		List<Curso> list = repository.findAll();
		return list.stream().map(x -> new CursoDTO(x)).collect(Collectors.toList());
	}
	
	
}
