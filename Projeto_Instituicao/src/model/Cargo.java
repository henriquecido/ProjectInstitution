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
public class Cargo {
    private String nome;
    private String atribuicoes;
    
    public Cargo(){
        
    }
    
    public Cargo(String nome, String atribuicoes) {
        this.nome = nome;
        this.atribuicoes = atribuicoes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAtribuicoes() {
        return atribuicoes;
    }

    public void setAtribuicoes(String atribuicoes) {
        this.atribuicoes = atribuicoes;
    }

    @Override
    public String toString() {
        return "Cargo{" + "nome=" + nome + ", atribuicoes=" + atribuicoes + '}';
    }
    
}
