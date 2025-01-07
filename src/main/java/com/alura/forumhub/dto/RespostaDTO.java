package com.alura.forumhub.dto;

import com.alura.forumhub.entities.Resposta;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.List;

public class RespostaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotBlank(message = "Campo requerido")
	private String mensagem;
	private Long topicoId;
	
    private String usuario;
	
	public RespostaDTO() {
	}

	public RespostaDTO(Long id, String mensagem, Long topicoId, String usuario) {
		this.id = id;
		this.mensagem = mensagem;
		this.topicoId = topicoId;
		this.usuario = usuario;
	}
	
	public RespostaDTO(Resposta entity) {
		id = entity.getId();
		mensagem = entity.getMensagem();
		topicoId = entity.getTopico().getId();
		usuario = entity.getUsuario().getNome();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public Long getTopicoId() {
		return topicoId ;
	}

	public void setTopicoId(Long topicoId) {
		this.topicoId  = topicoId ;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}
