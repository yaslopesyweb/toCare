package br.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.toCare.model.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
    
}
