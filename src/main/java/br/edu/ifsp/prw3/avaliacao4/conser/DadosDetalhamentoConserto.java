package br.edu.ifsp.prw3.avaliacao4.conser;

import br.edu.ifsp.prw3.avaliacao4.mecanico.Mecanico;
import br.edu.ifsp.prw3.avaliacao4.veiculo.Veiculo;


public record DadosDetalhamentoConserto(
        Long id,
        String dataEntrada,
        String dataSaida,
        Mecanico mecanico,
        Veiculo veiculo

) {
    public DadosDetalhamentoConserto(Conserto conserto) {
        this(
                conserto.getId(),
                conserto.getDataEntrada(),
                conserto.getDataSaida(),
                conserto.getMecanico(),
                conserto.getVeiculo()
        );
    }
}