/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import database.DAOBaseJDBC;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Trilha;

/**
 *
 * @author User
 */
public class TrilhaDAOJDBC  extends DAOBaseJDBC implements TrilhaDAO{

    public int idTrilha;
    
    public TrilhaDAOJDBC() throws ClassNotFoundException, SQLException {
    }
    
    @Override
    public boolean salvar(Trilha trilha) {
        
        PreparedStatement pstm;
        String sql1 = "INSERT INTO Trilha (dataCriacao,Funcionario_idFuncionario) VALUES (NOW(),?)";

        try {
            pstm = con.prepareStatement(sql1);
            pstm.setString(1, trilha.getIdFuncionario().toString());
            //pstm.setString(2, trilha.getIdCargo().toString());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TrilhaDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return true;
    }
    
    public int getIdTrilha() {
        return idTrilha;
    }

    public void setIdTrilha(int idTrilha) {
        this.idTrilha = idTrilha;
    }
    
    
}
