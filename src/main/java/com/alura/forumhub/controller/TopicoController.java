package com.alura.forumhub.controller;

import com.alura.forumhub.dto.TopicoByIdDTO;
import com.alura.forumhub.dto.TopicoDTO;
import com.alura.forumhub.services.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("topicos")
public class TopicoController {

    @Autowired
    private TopicoService service;


    @GetMapping
    public ResponseEntity <Page<TopicoDTO>> findAllPaged(
            @RequestParam(value = "nome", defaultValue = "") String nome,
            Pageable pageable) {
        Page<TopicoDTO> page = service.findAllPaged(pageable);
        return ResponseEntity.ok().body(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicoByIdDTO> listarTopicoPorId(@PathVariable Long id){
        TopicoByIdDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<TopicoDTO> insert(@RequestBody @Valid TopicoDTO dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<TopicoDTO> update(@PathVariable Long id, @RequestBody TopicoDTO dto){
        dto = service.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
