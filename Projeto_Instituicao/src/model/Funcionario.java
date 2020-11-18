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
public class Funcionario {
    private String nome;
    private String dataAdmissao;
    private String dataRecisao;
    private Integer idCargo;
    private Integer idSetor;

    public Funcionario(){
        
    }
    
    public Funcionario(String nome, String dataAdmissao, String dataRecisao, Integer idCargo, Integer idSetor) {
        this.nome = nome;
        this.dataAdmissao = dataAdmissao;
        this.dataRecisao = dataRecisao;
        this.idCargo = idCargo;
        this.idSetor = idSetor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(String dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public String getDataRecisao() {
        return dataRecisao;
    }

    public void setDataRecisao(String dataRecisao) {
        this.dataRecisao = dataRecisao;
    }

    public Integer getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Integer idCargo) {
        this.idCargo = idCargo;
    }

    public Integer getIdSetor() {
        return idSetor;
    }

    public void setIdSetor(Integer idSetor) {
        this.idSetor = idSetor;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "nome=" + nome + ", dataAdmissao=" + dataAdmissao + ", dataRecisao=" + dataRecisao + ", idCargo=" + idCargo + ", idSetor=" + idSetor + '}';
    }
    
    
}
