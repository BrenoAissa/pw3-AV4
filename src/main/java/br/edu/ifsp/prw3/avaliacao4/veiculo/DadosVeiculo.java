package br.edu.ifsp.prw3.avaliacao4.veiculo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosVeiculo(
        @NotBlank
        String marca,

        @NotBlank
        String modelo,

        @NotBlank
        @Pattern(regexp = "\\d{4}", message = "Ano deve ter o formato xxxx")
        String ano,
        String cor)
    {
}