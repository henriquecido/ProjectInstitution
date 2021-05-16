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
public class Trilha {
    private String dataCriacao;
    private Integer idCargo;
    private Integer idFuncionario;

    public Trilha(){
        
    }
    
    public Trilha(String dataCriacao, Integer idCargo, Integer idFuncionario) {
        this.dataCriacao = dataCriacao;
        this.idCargo = idCargo;
        this.idFuncionario = idFuncionario;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Integer getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Integer idCargo) {
        this.idCargo = idCargo;
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
    
    public String toString() {
        return "Trilha{ Data Criacao=" + dataCriacao + "}";
    }
    
}
