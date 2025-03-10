package com.alura.forumhub.controller;

import com.alura.forumhub.dto.RespostaDTO;
import com.alura.forumhub.services.RespostaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/respostas")
public class RespostaController {

	@Autowired
	private RespostaService respostaService;

	@PostMapping()
	public ResponseEntity<RespostaDTO> inserirResposta(@Valid @RequestBody RespostaDTO dto) {
		dto = respostaService.inserirResposta(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}	
}
