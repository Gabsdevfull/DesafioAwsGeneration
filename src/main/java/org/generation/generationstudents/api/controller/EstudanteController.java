package org.generation.generationstudents.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.generation.generationstudents.domain.dto.AtualizacaoDTO;
import org.generation.generationstudents.domain.model.Estudante;
import org.generation.generationstudents.domain.service.EstudanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/estudantes")
public class EstudanteController {

    @Autowired
    EstudanteService estudanteService;

    @GetMapping
    @Operation(summary = "Busca todos os alunos")
    public ResponseEntity<List<Estudante>> findAll() {
        List<Estudante> estudantes = estudanteService.findAll();
        return ResponseEntity.ok(estudantes);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca Aluno por ID")
    public ResponseEntity<Estudante> findById(@PathVariable Long id) {
        Estudante estudante = estudanteService.findStudentById(id);
        return ResponseEntity.ok(estudante);
    }

    @GetMapping("/nome/{nome}")
    @Operation(summary = "Busca Aluno por nome")
    public ResponseEntity<List<Estudante>> findByName(@PathVariable String nome) {
        List<Estudante> estudantes = estudanteService.findAllByNome(nome);
        return ResponseEntity.ok(estudantes);
    }

    @GetMapping("/professor/{nome}")
    @Operation(summary = "Busca professor por nome")
    public ResponseEntity<List<Estudante>> findByTeacher(@PathVariable String nome) {
        List<Estudante> estudantes = estudanteService.findByTeacher(nome);
        return ResponseEntity.ok(estudantes);
    }

    @GetMapping("/sala/{numero}")
    @Operation(summary = "Busca sala por número")
    public ResponseEntity<List<Estudante>> findByClassroom(@PathVariable String numero) {
        List<Estudante> estudantes = estudanteService.findByClassroom(numero);
        return ResponseEntity.ok(estudantes);
    }

    @PostMapping
    @Operation(summary = "Cadastra novo aluno")
    public ResponseEntity<Estudante> create(@RequestBody @Valid Estudante estudante, UriComponentsBuilder uriBuilder) {
        Estudante response = estudanteService.create(estudante);
        URI uri = uriBuilder.path("/estudantes/{id}").buildAndExpand(response.getId()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza os dados, nota, semestre, etc.")
    public ResponseEntity<Estudante> update(@PathVariable Long id, @RequestBody AtualizacaoDTO atualizacaoDTO) {
        Estudante estudante = estudanteService.update(id, atualizacaoDTO);
        return ResponseEntity.ok(estudante);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta dados do aluno")
    public ResponseEntity delete(@PathVariable Long id) {
        estudanteService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
