package com.next.technical.support.repositories;

import com.next.technical.support.models.AgendamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface AgendamentoRepository extends JpaRepository<AgendamentoModel, Long> {
    Optional<AgendamentoModel> findByDataHora(LocalDateTime dataHora);
    Optional<AgendamentoModel> findByProtocolo(String protocolo);
}
