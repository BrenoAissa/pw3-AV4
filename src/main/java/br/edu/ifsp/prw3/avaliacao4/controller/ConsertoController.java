package br.edu.ifsp.prw3.avaliacao4.controller;

import br.edu.ifsp.prw3.avaliacao4.conser.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("consertos")
public class ConsertoController {

    @Autowired
    private ConsertoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoConserto> cadastrar(@RequestBody @Valid DadosCadastroConserto dados, UriComponentsBuilder uriBuilder) {
        Conserto conserto = new Conserto(dados);
        repository.save(conserto);

        URI uri = uriBuilder.path("/consertos/{id}").buildAndExpand(conserto.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoConserto(conserto));
    }

    @GetMapping
    public ResponseEntity<Page<DadosDetalhamentoConserto>> listarTodos(Pageable paginacao) {
        Page<Conserto> pageConserto = repository.findAllByAtivoTrue(paginacao);
        Page<DadosDetalhamentoConserto> pageDto = pageConserto.map(DadosDetalhamentoConserto::new);
        return ResponseEntity.ok(pageDto);
    }

    @GetMapping("/algunsdados")
    public ResponseEntity<List<DadosListagemConserto>> listarAlgunsDados() {
        List<Conserto> consertosAtivos = repository.findAllByAtivoTrue();
        List<DadosListagemConserto> listaDto = consertosAtivos.stream()
                .map(DadosListagemConserto::new)
                .toList();
        return ResponseEntity.ok(listaDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoConserto> detalhar(@PathVariable Long id) {
        Optional<Conserto> consertoOptional = repository.findById(id);

        if (consertoOptional.isEmpty() || !consertoOptional.get().getAtivo()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(new DadosDetalhamentoConserto(consertoOptional.get()));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoConserto> atualizar(@RequestBody @Valid DadosAtualizacaoConserto dados) {
        try {
            Conserto conserto = repository.getReferenceById(dados.id());

            if (!conserto.getAtivo()) {
                return ResponseEntity.notFound().build();
            }

            conserto.atualizarInformacoes(dados);

            return ResponseEntity.ok(new DadosDetalhamentoConserto(conserto));
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        try {
            Conserto conserto = repository.getReferenceById(id);

            if (!conserto.getAtivo()) {return ResponseEntity.noContent().build(); }

            conserto.excluir();

            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.noContent().build();
        }
    }
}