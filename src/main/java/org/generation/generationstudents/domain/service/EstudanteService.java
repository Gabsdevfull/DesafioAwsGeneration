package org.generation.generationstudents.domain.service;

import org.generation.generationstudents.domain.dto.AtualizacaoDTO;
import org.generation.generationstudents.domain.exception.UserNotFoundException;
import org.generation.generationstudents.domain.model.Estudante;
import org.generation.generationstudents.domain.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EstudanteService {

    @Autowired
    StudentRepository repository;

    public List<Estudante> findAll() {
        return repository.findAll();
    }

    public Estudante findStudentById(Long id) {
        return this.findById(id);
    }

    public List<Estudante> findAllByNome(String name) {
        return repository.findByNomeContainingIgnoreCase(name);
    }

    public List<Estudante> findByTeacher(String name) {
        return repository.findByProfessoresNameContainingIgnoreCase(name);
    }

    public List<Estudante> findByClassroom(String number) {
        return repository.findByNumeroSalaContainingIgnoreCase(number);
    }

    public Estudante create(Estudante estudante) {
        return repository.save(estudante);
    }

    @Transactional
    public Estudante update(Long id, AtualizacaoDTO atualizacaoDTO) {
        Estudante estudante = findById(id);
        estudante.update(atualizacaoDTO);
        return estudante;
    }

    public void delete(Long id){
        Estudante estudante = findById(id);
        repository.delete(estudante);
    }

    private Estudante findById(Long id) {
        return repository.findById(id).orElseThrow(UserNotFoundException::new);
    }

}
