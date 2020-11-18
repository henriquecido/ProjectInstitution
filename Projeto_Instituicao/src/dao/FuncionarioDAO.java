/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Funcionario;
import view.AlteraFuncionario;
import view.DeletarFuncionario;
import view.FuncionarioLista;
import view.ValidaFuncionario;

/**
 *
 * @author User
 */
public interface FuncionarioDAO {
    public boolean salvar(Funcionario funcionario);
    
    public void visualizarFuncionario(FuncionarioLista fun);
    
    public boolean validaFuncionario(ValidaFuncionario a,int x);
    
    public boolean alteraFuncionario(AlteraFuncionario a);
    
    public boolean deletarFuncionario(DeletarFuncionario a);
}
