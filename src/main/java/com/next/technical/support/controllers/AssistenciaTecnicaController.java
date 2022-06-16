package com.next.technical.support.controllers;

import com.next.technical.support.models.AssistenciaTecnicaModel;
import com.next.technical.support.models.EquipamentoModel;
import com.next.technical.support.repositories.AssistenciaTecnicaRepository;
import com.next.technical.support.repositories.EquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class AssistenciaTecnicaController {

    @Autowired
    private AssistenciaTecnicaRepository assistenciaTecnicaRepository;
    @Autowired
    private EquipamentoRepository equipamentoRepository;

    public AssistenciaTecnicaController(AssistenciaTecnicaRepository assistenciaTecnicaRepository, EquipamentoRepository equipamentoRepository) {
    }
    public AssistenciaTecnicaController(EquipamentoRepository equipamentoRepository) {
        this.equipamentoRepository = equipamentoRepository;
    }
    public AssistenciaTecnicaController(AssistenciaTecnicaRepository assistenciaTecnicaRepository) {
        this.assistenciaTecnicaRepository = assistenciaTecnicaRepository;
    }

    @GetMapping("/assistencias/{equipId}")
    public ResponseEntity<String> findAssistTechByEquipId(@PathVariable @Valid Long equipId) {
        Optional<EquipamentoModel> equipamentoOptional = equipamentoRepository.findById(equipId);
        if (equipamentoOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo de Equipamento inválido");
        }

        Optional<List<AssistenciaTecnicaModel>> assistTechOptional = assistenciaTecnicaRepository.findByEquipamentoId(equipId);
        return ResponseEntity.status(HttpStatus.CREATED).body("Assistências: " + assistTechOptional.get());

        }

}
