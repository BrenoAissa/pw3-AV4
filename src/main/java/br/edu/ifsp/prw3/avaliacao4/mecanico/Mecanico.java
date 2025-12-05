package br.edu.ifsp.prw3.avaliacao4.mecanico;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Mecanico {
    private String nome;
    private Integer anosExperiencia;

    public void atualizarInformacoes(DadosMecanico dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.anosExperiencia() != null) {
            this.anosExperiencia = dados.anosExperiencia();
        }
    }
}