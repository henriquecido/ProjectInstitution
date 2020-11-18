/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import database.DAOBaseJDBC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cargo;
import view.AlteraFuncionario;
import view.CadastroFuncionario;

/**
 *
 * @author User
 */
public class CargoDAOJDBC extends DAOBaseJDBC implements CargoDAO {

    public CargoDAOJDBC() throws ClassNotFoundException, SQLException {
    }
    
    @Override
    public boolean cadastrarCargo(Cargo cargo) {
        
        
        PreparedStatement pstm;
        String sql = "INSERT INTO Cargo (nomecar,atribuicoes) VALUES (?,?)";
        
        try {

            pstm = con.prepareStatement(sql);
            pstm.setString(1, cargo.getNome());
            pstm.setString(2, cargo.getAtribuicoes());

            pstm.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        return true;
        
        
    }
    
    public void visualizarCargoCA(CadastroFuncionario fun){
        
        try {
            PreparedStatement pstm;
        
            String sql1 = "Select * from Cargo";
            pstm = con.prepareStatement(sql1);
            
            ResultSet rs1 = pstm.executeQuery (sql1);
            
            if(!rs1.isBeforeFirst() && rs1.getRow() == 0){
                fun.addjComboBox2(" Não existe Cargo cadastrado no momento.");
            }else{
                while(rs1.next()) {
                    String n = rs1.getString("nomecar");
                    fun.addjComboBox2(n);
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CargoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void visualizarCargoAL(AlteraFuncionario fun){
        
        try {
            PreparedStatement pstm;
        
            String sql1 = "Select * from Cargo";
            pstm = con.prepareStatement(sql1);
            
            ResultSet rs1 = pstm.executeQuery (sql1);
            
            if(!rs1.isBeforeFirst() && rs1.getRow() == 0){
                fun.addjComboBox2(" Não existe Cargo cadastrado no momento.");
            }else{
                while(rs1.next()) {
                    String n = rs1.getString("nomecar");
                    fun.addjComboBox2(n);
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CargoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
