package com.next.technical.support.controllers;

import com.next.technical.support.dtos.AgendamentoDto;
import com.next.technical.support.models.AgendamentoModel;
import com.next.technical.support.models.AssistenciaTecnicaModel;
import com.next.technical.support.models.ClienteModel;
import com.next.technical.support.repositories.AgendamentoRepository;
import com.next.technical.support.repositories.AssistenciaTecnicaRepository;
import com.next.technical.support.repositories.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@RestController
public class AgendamentoController {

    @Autowired
    private AgendamentoRepository agendamentoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private AssistenciaTecnicaRepository assistenciaTecnicaRepository;
    @Transactional
    @PostMapping("/agendamento")
    public ResponseEntity<String> agendar(@RequestBody @Valid AgendamentoDto agendamentoDto){
        Optional<AssistenciaTecnicaModel> assistTecOptional = assistenciaTecnicaRepository.findById(agendamentoDto.getAssistTechId());
        if (assistTecOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Assistência Técnica inválida");
        }
        Optional<AgendamentoModel> agendamentoOptional = agendamentoRepository.findByDataHora(agendamentoDto.getDataHora());
        if (agendamentoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Este horário não está disponível");
        }
        Optional<ClienteModel> clienteOptional = clienteRepository.findByCpf(agendamentoDto.getCpf());
        if (clienteOptional.isEmpty()) {
            ClienteModel cliente = new ClienteModel(agendamentoDto.getCpf());
            clienteRepository.save(cliente);
        }
        ClienteModel cliente = clienteRepository.findByCpf(agendamentoDto.getCpf()).get();
        AgendamentoModel agendamentoModel = new AgendamentoModel();
        BeanUtils.copyProperties(agendamentoDto, agendamentoModel);
        agendamentoModel.setCliente(cliente);
        Random random = new Random();
        agendamentoModel.setProtocolo(Integer.toString(random.nextInt()).substring(3));
        agendamentoRepository.save(agendamentoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body("Protocolo: " + agendamentoModel.getProtocolo());
    }

    @Transactional
    @DeleteMapping("/cancelamento/{protocolo}")
    public ResponseEntity<String> deletePost(@PathVariable String protocolo ) {
        Optional<AgendamentoModel> agendamentoOptional = agendamentoRepository.findByProtocolo(protocolo);
        if (agendamentoOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Protocolo inválido");
        }
        agendamentoRepository.delete(agendamentoOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Agendamento cancelado com sucesso");
    }
}
