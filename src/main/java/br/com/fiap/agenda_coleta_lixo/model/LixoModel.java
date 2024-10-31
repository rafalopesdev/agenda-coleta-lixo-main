package br.com.fiap.agenda_coleta_lixo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "agenda-coleta-lixo")
public class LixoModel {
    @Id
    private String id; // Anotação para indicar que este é o campo de ID

    private String tipo;
    private String dia;
    private String horario;
    private String endereco;

    public LixoModel(String tipo, String dia, String horario, String endereco) {
        this.tipo = tipo;
        this.dia = dia;
        this.horario = horario;
        this.endereco = endereco;
    }
    public LixoModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}