package com.next.technical.support.models;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class AssistenciaTecnicaModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String nome;

    @ManyToMany(targetEntity = EquipamentoModel.class, mappedBy = "assistenciaTecnica")
    private List<EquipamentoModel> equipamento;

    public AssistenciaTecnicaModel() {
    }

    public AssistenciaTecnicaModel(String nome) {
        this.nome = nome;
    }

    public AssistenciaTecnicaModel(int i, String s) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<EquipamentoModel> getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(List<EquipamentoModel> equipamento) {
        this.equipamento = equipamento;
    }
}
