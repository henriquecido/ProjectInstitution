/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Setor;
import view.AlteraFuncionario;
import view.CadastroFuncionario;

/**
 *
 * @author User
 */
public interface SetorDAO {
    public boolean cadastrarSetor(Setor setor);
    
    public void visualizaSetorCA(CadastroFuncionario fun);
    
    public void visualizaSetorAL(AlteraFuncionario fun);
}
