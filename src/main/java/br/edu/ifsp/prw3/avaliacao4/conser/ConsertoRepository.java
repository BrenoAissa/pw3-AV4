package br.edu.ifsp.prw3.avaliacao4.conser;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ConsertoRepository extends JpaRepository<Conserto, Long> {

    Page<Conserto> findAllByAtivoTrue(Pageable paginacao);

    List<Conserto> findAllByAtivoTrue();

    @Query("SELECT c FROM Conserto c WHERE c.veiculo.ano >= :ano")
    List<Conserto> buscarPorAnoVeiculoMinimo(String ano);
}