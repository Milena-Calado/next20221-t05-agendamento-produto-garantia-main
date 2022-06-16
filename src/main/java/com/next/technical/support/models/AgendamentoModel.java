package com.next.technical.support.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class AgendamentoModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String cpf;
    @Column
    private String protocolo;
    @Column
    private LocalDateTime dataHora;
    @Column
    private Long equipamentoId;
    @Column
    private Long assistTechId;

    @ManyToOne(targetEntity = ClienteModel.class)
    @JoinColumn(name = "cliente_id")
    private ClienteModel cliente;

    public AgendamentoModel() {
    }

    public AgendamentoModel(String cpf, LocalDateTime dataHora, Long equipamentoId, Long assistTechId) {
        this.cpf = cpf;
        this.dataHora = dataHora;
        this.equipamentoId = equipamentoId;
        this.assistTechId = assistTechId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
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

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }
}
