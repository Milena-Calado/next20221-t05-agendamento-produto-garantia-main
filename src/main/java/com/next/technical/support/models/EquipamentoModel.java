package com.next.technical.support.models;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class EquipamentoModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String tipo;

    @ManyToMany(targetEntity = AssistenciaTecnicaModel.class)
    @JoinTable(name = "equipamento_assistencia",
            joinColumns = @JoinColumn(name = "equipamento_id"),
            inverseJoinColumns = @JoinColumn(name = "assistencia_tecnica_id"))
    private List<AssistenciaTecnicaModel> assistenciaTecnica;

    public EquipamentoModel() {
    }

    public EquipamentoModel(String tipo) {
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<AssistenciaTecnicaModel> getAssistenciaTecnica() {
        return assistenciaTecnica;
    }

    public void setAssistenciaTecnica(List<AssistenciaTecnicaModel> assistenciaTecnica) {
        this.assistenciaTecnica = assistenciaTecnica;
    }
}
