package com.next.technical.support.repositories;

import com.next.technical.support.models.EquipamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface EquipamentoRepository extends JpaRepository<EquipamentoModel, Long> {
    Optional<EquipamentoModel> findById(Long equipId);

}
