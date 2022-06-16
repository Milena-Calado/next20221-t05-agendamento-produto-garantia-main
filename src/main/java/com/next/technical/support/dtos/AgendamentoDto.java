package com.next.technical.support.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;

public class AgendamentoDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String cpf;
    private LocalDateTime dataHora;
    private Long equipamentoId;
    private Long assistTechId;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Long getEquipamentoId() {
        return equipamentoId;
    }

    public void setEquipamentoId(Long equipamentoId) {
        this.equipamentoId = equipamentoId;
    }

    public Long getAssistTechId() {
        return assistTechId;
    }

    public void setAssistTechId(Long assistTechId) {
        this.assistTechId = assistTechId;
    }
}
