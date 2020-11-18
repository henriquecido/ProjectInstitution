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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Curso;
import view.AlteraCurso;
import view.CursoLista;
import view.DeletarCurso;
import view.ValidaCurso;

/**
 *
 * @author User
 */
public class CursoDAOJDBC extends DAOBaseJDBC implements CursoDAO{

    TrilhaDAOJDBC tr = new TrilhaDAOJDBC();
    
    public CursoDAOJDBC() throws ClassNotFoundException, SQLException {
    }
    
    @Override
    public boolean salvar(Curso curso) {

        PreparedStatement pstm;
        
        String sql1 = "SELECT * FROM Trilha";
        String sql2 = "INSERT INTO Curso (nome,ementa,cargaHoraria,Trilha_idTrilha) VALUES (?,?,?,?)";
        
        try {
            int idTrilha=1;
            pstm = con.prepareStatement(sql1);
            ResultSet rs1 = pstm.executeQuery(sql1);
            if(rs1.last()){
                idTrilha= rs1.getInt("idTrilha");
            }
            
            pstm = con.prepareStatement(sql2);
            pstm.setString(1, curso.getNome());
            pstm.setString(2, curso.getEmenta());
            pstm.setString(3, curso.getCargaHoraria().toString());
            pstm.setString(4, String.valueOf(idTrilha));
            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;     
    }
    
    public void visualizarCurso(CursoLista cu){
        
        
        //Executando Query para alimentar o jTable
        PreparedStatement pstm;

        
        String sql1 = "select * from curso INNER join trilha ON curso.Trilha_idTrilha = trilha.idTrilha inner join funcionario on trilha.Funcionario_idFuncionario = funcionario.idFuncionario inner join cargo on cargo.idCargo = funcionario.Cargo_idCargo;";
        try {
            pstm = con.prepareStatement(sql1);
            ResultSet rs1 = pstm.executeQuery (sql1);
            
             DefaultTableModel model = (DefaultTableModel) cu.getjTable1().getModel();
        
        //Centralizar a coluna CargaHoraria
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        cu.getjTable1().getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        
        //Alimentando o JTable
        while(rs1.next()) {
            model.addRow(new Object[]{rs1.getString("nome"),rs1.getString("ementa"),rs1.getInt("cargaHoraria"),rs1.getString("dataCriacao"),rs1.getString("nomefun"),rs1.getString("nomecar")});
        }
        
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
    }
    
    public boolean validaCurso(ValidaCurso a,int x){
        
        int aux=0;
        boolean aus=false;
        DeletarCurso cu = new DeletarCurso();
        AlteraCurso cur = new AlteraCurso();
        try {
            PreparedStatement pstm;
            String sql1 = "select * from curso inner join trilha on idTrilha = Trilha_idTrilha; ";
            pstm = con.prepareStatement(sql1);
            ResultSet rs1 = pstm.executeQuery (sql1);
            
            while(rs1.next()){
                if(rs1.getString("nome").equals(a.getjTextField1().getText())){
                    if(x==2){
                        JOptionPane.showMessageDialog(null, "Validação realizado com sucesso!");
                        Thread.sleep(200);
                        cu.setVisible(true);
                        cu.setIdTri(rs1.getInt("Trilha_idTrilha"));
                        cu.getjTextField1().setText(rs1.getString("nome"));
                        cu.getjTextField2().setText(rs1.getString("ementa"));
                        cu.getjTextField3().setText(rs1.getString("cargaHoraria"));
                        cu.getjTextField4().setText(rs1.getString("dataCriacao"));
                        aux = 1;
                        aus = true;
                    }else{
                        JOptionPane.showMessageDialog(null, "Validação realizado com sucesso!");
                        Thread.sleep(200);
                        cur.setVisible(true);
                        cur.setIdCur(rs1.getInt("idCurso"));
                        cur.getjTextField1().setText(rs1.getString("nome"));
                        cur.getjTextField2().setText(rs1.getString("ementa"));
                        cur.getjTextField3().setText(String.valueOf(rs1.getInt("cargaHoraria")));
                        aux = 1;
                        aus = true;
                    }
                }
            }
            if (aux != 1) {
                    aus = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(CursoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

        return aus;
    }
    
    public boolean deletarCurso(DeletarCurso a){
        boolean aux=false;
        try {
            
            PreparedStatement pstm;
            String sql3 = "DELETE FROM Curso WHERE Trilha_idTrilha = ?";
            pstm = con.prepareStatement(sql3);
            pstm.setString(1, String.valueOf(a.getIdTri()));
            pstm.executeUpdate();

            String sql2 = "DELETE FROM Trilha WHERE idTrilha = ?";
            pstm = con.prepareStatement(sql2);
            pstm.setString(1, String.valueOf(a.getIdTri()));
            pstm.executeUpdate();
            
            aux=true;
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aux;
    }
    
    public boolean alterarCurso(AlteraCurso a){
        
        boolean aux =false;
 
        try {
            PreparedStatement pstm;
            String sql1 = "UPDATE Curso SET nome = ?, ementa = ?, cargaHoraria = ? WHERE idCurso = ?";
            pstm = con.prepareStatement(sql1);
            pstm.setString(1, a.getjTextField1().getText());
            pstm.setString(2, a.getjTextField2().getText());
            pstm.setString(3, a.getjTextField3().getText());
            pstm.setString(4, String.valueOf(a.getIdCur()));
            
            pstm.executeUpdate();
            
            aux=true;
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

        return aux;
    } 
    
    
}
