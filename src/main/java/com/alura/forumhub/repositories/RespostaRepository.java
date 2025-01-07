package com.alura.forumhub.repositories;

import com.alura.forumhub.entities.Resposta;
import com.alura.forumhub.entities.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RespostaRepository extends JpaRepository<Resposta, Long>{

	
	List<Resposta> findByTopico(Topico movie);
	

}
