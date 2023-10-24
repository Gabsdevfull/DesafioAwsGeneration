package org.generation.generationstudents.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.generation.generationstudents.domain.dto.AtualizacaoDTO;

@Entity
@Table(name = "tb_estudante")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Estudante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotNull
    private Integer idade;

    private float primeiroSemestre;
    private float segundoSemestre;
    private String professoresName;
    private String numeroSala;

    public void update(AtualizacaoDTO atualizacaoDTO) {
        this.nome = atualizacaoDTO.nome() == null ? this.nome : atualizacaoDTO.nome();
        this.idade = atualizacaoDTO.idade() == 0.0f ? this.idade : atualizacaoDTO.idade();
        this.primeiroSemestre = atualizacaoDTO.primeiroSemestre() == 0.0f ? this.primeiroSemestre : atualizacaoDTO.primeiroSemestre();
        this.segundoSemestre = atualizacaoDTO.segundoSemestre() == 0.0f ? this.segundoSemestre : atualizacaoDTO.segundoSemestre();
        this.professoresName = atualizacaoDTO.professorNome() == null ? this.professoresName : atualizacaoDTO.professorNome();
        this.numeroSala = atualizacaoDTO.numeroSala() == null ? this.numeroSala : atualizacaoDTO.numeroSala();
    }
}


