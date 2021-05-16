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
import model.Login;

/**
 *
 * @author User
 */
public class LoginDAOJDBC extends DAOBaseJDBC implements LoginDAO {
     
    public LoginDAOJDBC() throws ClassNotFoundException, SQLException {
    }
    
    @Override
    public boolean salvar(Login log) {
        
        PreparedStatement pstm;
        String sql = "INSERT INTO Login (nome,senha) VALUES (?,?)";

        try {
            
            pstm = con.prepareStatement(sql);
            pstm.setString(1, log.getNome());
            pstm.setString(2, log.getSenha());

            pstm.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        return true;
 
    }
    
    public boolean login(Login log){
        
        PreparedStatement pstm;
        String sql = "SELECT * FROM Login";
        boolean aux = false;
        try {
            
            pstm = con.prepareStatement(sql);

            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                if(rs.getString("nome").equals(log.getNome()) && rs.getString("senha").equals(log.getSenha())){
                     aux = true;
                }              
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return aux;
    }
}
