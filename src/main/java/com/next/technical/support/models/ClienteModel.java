package com.next.technical.support.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Entity
public class ClienteModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String cpf;

    @OneToMany(targetEntity = AgendamentoModel.class, mappedBy = "cliente")
    private List<AgendamentoModel> agendamentos;

    public ClienteModel() {
    }

    public ClienteModel(String cpf) {
        this.cpf = cpf;
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

    public List<AgendamentoModel> getAgendamentos() {
        return agendamentos;
    }

    public void addAgendamentos(AgendamentoModel agendamento) {
        agendamentos.add(agendamento);
    }
}
