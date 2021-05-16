/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Cargo;
import view.AlteraFuncionario;
import view.CadastroFuncionario;

/**
 *
 * @author User
 */
public interface CargoDAO {
    public boolean cadastrarCargo(Cargo cargo);
    
    public void visualizarCargoCA(CadastroFuncionario fun);
    
    public void visualizarCargoAL(AlteraFuncionario fun);
}
