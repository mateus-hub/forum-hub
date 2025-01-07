package com.alura.forumhub.repositories;

import com.alura.forumhub.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    //UserDetails findByEmail(String email);

    Usuario findByEmail(String email);

    boolean existsByEmail(String email);

    @Query("select u from Usuario u where u.email = :email")
    Usuario getReferenceByEmail(@Param("email") String email);
}
