package org.generation.generationstudents.domain.dto;

public record AtualizacaoDTO(
        String nome,
        int idade,
        float primeiroSemestre,
        float segundoSemestre,
        String professorNome,
        String numeroSala
) {
}
