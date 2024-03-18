package br.com.fiap.toCare.controller;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;



import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.toCare.model.Agendamento;
import br.repository.AgendamentoRepository;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("agendamento")
@Slf4j
public class AgendamentoController {

    @Autowired
    AgendamentoRepository repository;

    @GetMapping
    public List<Agendamento> index() {
        return repository.findAll();
    }

    @PostMapping()
    @ResponseStatus(CREATED)
    public Agendamento created(@RequestBody Agendamento agendamento) {
        log.info("cadastrando agendamento{}", agendamento);
        repository.save(agendamento);
        return agendamento;
        
    }

    @GetMapping("{id}")
    public ResponseEntity<Agendamento> show (@PathVariable Long id) {
        log.info("buscando agendamento com id{}", id);

        return repository
                    .findById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void destroy(@PathVariable Long id){
        log.info("apagando agendamento {}", id);

        verificarSeAgendamentoExiste(id);
        repository.deleteById(id);
    }    
    
    @PutMapping("{id}")
    public Agendamento update (@PathVariable Long id, @ RequestBody Agendamento agendamento){
        log.info("Atualizando agendamento {} para {}", id, agendamento);
        verificarSeAgendamentoExiste(id);
        agendamento.setId(id);
        return repository.save(agendamento);
    }

        private void verificarSeAgendamentoExiste(Long id){
            repository
                .findById(id)
                .orElseThrow(
                    () -> new ResponseStatusException(NOT_FOUND, "Não existe agendamento com id informado")
                );
        }
}
