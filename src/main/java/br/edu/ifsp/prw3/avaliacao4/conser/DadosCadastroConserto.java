package br.edu.ifsp.prw3.avaliacao4.conser;

import br.edu.ifsp.prw3.avaliacao4.mecanico.DadosMecanico;
import br.edu.ifsp.prw3.avaliacao4.veiculo.DadosVeiculo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroConserto(

        @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "Data de entrada deve ter o formato dd/mm/aaaa") // Formato "xx/xx/xxxx" (Parte 2)
        String dataEntrada,

        @Pattern(regexp = "^(\\d{2}/\\d{2}/\\d{4})?$", message = "Data de saída deve ter o formato dd/mm/aaaa ou ser vazia") // Permite nulo ou formato correto
        String dataSaida,

        @NotNull(message = "Dados do mecânico são obrigatórios")
        @Valid
        DadosMecanico mecanico,

        @NotNull(message = "Dados do veículo são obrigatórios")
        @Valid
        DadosVeiculo veiculo
) {
}