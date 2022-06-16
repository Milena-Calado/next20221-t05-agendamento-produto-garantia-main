package com.next.technical.support.repositories;

import com.next.technical.support.models.AssistenciaTecnicaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AssistenciaTecnicaRepository extends JpaRepository<AssistenciaTecnicaModel, Long> {

    Optional<List<AssistenciaTecnicaModel>> findByEquipamentoId(Long equipamentoId);
}
