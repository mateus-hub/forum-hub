package com.alura.forumhub.repositories;

import com.alura.forumhub.entities.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Page<Topico> findAll(Pageable paginacao);


/*
    @Query("SELECT obj FROM Topico obj JOIN FETCH obj.respostas WHERE obj IN :topicos")
    List<Product> findTopicosWithRespostas(List<Topico> topicos);*/
}
