package br.edu.ifsp.prw3.avaliacao4.conser;

import br.edu.ifsp.prw3.avaliacao4.mecanico.DadosMecanico;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosAtualizacaoConserto(
        @NotNull(message = "ID é obrigatório para atualização")
        Long id,

        @Pattern(regexp = "^(\\d{2}/\\d{2}/\\d{4})?$", message = "Data de saída deve ter o formato dd/mm/aaaa ou ser vazia") // Permite nulo/vazio ou formato correto
        String dataSaida,

        @Valid
        DadosMecanico mecanico
) {
}