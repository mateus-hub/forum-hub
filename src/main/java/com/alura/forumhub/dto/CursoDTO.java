package com.alura.forumhub.dto;

import com.alura.forumhub.entities.Curso;

import java.io.Serializable;

public class CursoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String categoria;
	
	public CursoDTO() {
	}

	public CursoDTO(Long id, String nome, String categoria) {
		this.id = id;
		this.nome = nome;
		this.categoria = categoria;
	}
	
	public CursoDTO(Curso entity) {
		id = entity.getId();
		nome = entity.getNome();
		categoria = entity.getCategoria();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}
