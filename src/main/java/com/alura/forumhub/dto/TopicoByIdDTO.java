package com.alura.forumhub.dto;

import com.alura.forumhub.entities.Resposta;
import com.alura.forumhub.entities.Topico;
import com.alura.forumhub.enums.Status;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TopicoByIdDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String titulo;
	private String mensagem;
	private LocalDateTime dataCriacao;
	private Status status;

	private String nomeCurso;

	private Long cursoId;

	private String usuario;

	private List<RespostaDTO> respostas = new ArrayList<>();

	public TopicoByIdDTO() {
	}

	public TopicoByIdDTO(Long id, String titulo, String mensagem, LocalDateTime dataCriacao, Status status, String nomeCurso, Long cursoId, String usuario) {
		this.id = id;
		this.titulo = titulo;
		this.mensagem = mensagem;
		this.dataCriacao = dataCriacao;
		this.status = status;
		this.nomeCurso = nomeCurso;
		this.cursoId = cursoId;
		this.usuario = usuario;
	}

	public TopicoByIdDTO(Topico entity) {
		id = entity.getId();
		titulo = entity.getTitulo();
		mensagem = entity.getMensagem();

		dataCriacao = LocalDateTime.now();
		status = Status.NAO_RESPONDIDO;

		nomeCurso = entity.getCurso().getNome();
		cursoId = entity.getCurso().getId();
		usuario = entity.getUsuario().getNome();


	}
	public TopicoByIdDTO(Topico entity, List<Resposta> respostas) {
		this(entity);
		respostas.forEach(res -> this.respostas.add(new RespostaDTO(res)));
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}


	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}


	public Long getCursoId() {
		return cursoId;
	}

	public void setCursoId(Long cursoId) {
		this.cursoId = cursoId;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public List<RespostaDTO> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<RespostaDTO> respostas) {
		this.respostas = respostas;
	}
}
