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
import model.Setor;
import view.AlteraFuncionario;
import view.CadastroFuncionario;

/**
 *
 * @author User
 */
public class SetorDAOJDBC extends DAOBaseJDBC implements SetorDAO{
    
    public SetorDAOJDBC() throws ClassNotFoundException, SQLException {
    }

    @Override
    public boolean cadastrarSetor(Setor setor) {
         
        PreparedStatement pstm;
        String sql = "INSERT INTO Setor (nomeset) VALUES (?)";
        
        try {

            pstm = con.prepareStatement(sql);
            pstm.setString(1, setor.getNome());

            pstm.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        return true;
    }
    
    public void visualizaSetorCA(CadastroFuncionario fun){
        
        try {
            PreparedStatement pstm;
       
            String sql1 = "Select * from Setor";
            pstm = con.prepareStatement(sql1);
            ResultSet rs1 = pstm.executeQuery (sql1);
            
            if(!rs1.isBeforeFirst() && rs1.getRow() == 0){
                fun.addjComboBox1(" Não existe Setor cadastrado no momento.");
            }else{
                while(rs1.next()) {
                    String n = rs1.getString("nomeset");
                    fun.addjComboBox1(n);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SetorDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void visualizaSetorAL(AlteraFuncionario fun){
        
        try {
            PreparedStatement pstm;
       
            String sql1 = "Select * from Setor";
            pstm = con.prepareStatement(sql1);
            ResultSet rs1 = pstm.executeQuery (sql1);
            
            if(!rs1.isBeforeFirst() && rs1.getRow() == 0){
                fun.addjComboBox1(" Não existe Setor cadastrado no momento.");
            }else{
                while(rs1.next()) {
                    String n = rs1.getString("nomeset");
                    fun.addjComboBox1(n);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SetorDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
