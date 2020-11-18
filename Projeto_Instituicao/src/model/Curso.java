/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author User
 */
public class Curso {
    private String nome;
    private String ementa;
    private Integer cargaHoraria;
    private Integer idTrilha;

    public Curso() {
    }

    public Curso(String ementa, String nome,Integer cargaHoraria, Integer idTrilha) {
        this.ementa = ementa;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.idTrilha = idTrilha;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
    
    public Integer getIdTrilha() {
        return idTrilha;
    }

    public void setIdTrilha(Integer idTrilha) {
        this.idTrilha = idTrilha;
    }
    
    public String toString() {
        return "Curso{" + "nome=" + nome + ", ementa=" + ementa + "carga Horaria="+cargaHoraria+'}';
    }
    
}
