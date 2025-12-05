package br.edu.ifsp.prw3.avaliacao4.mecanico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record DadosMecanico(
        @NotBlank
        String nome,
        @NotNull
        @PositiveOrZero
        Integer anosExperiencia)
    {
}