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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Funcionario;
import model.Trilha;
import view.AlteraFuncionario;
import view.CadastroCurso;
import view.CadastroFuncionario;
import view.DeletarFuncionario;
import view.FuncionarioLista;
import view.ValidaFuncionario;

/**
 *
 * @author User
 */
public class FuncionarioDAOJDBC extends DAOBaseJDBC implements FuncionarioDAO {

    public int idFun;
    
    public FuncionarioDAOJDBC() throws ClassNotFoundException, SQLException {
    }

    @Override
    public boolean salvar(Funcionario funcionario) {

        PreparedStatement pstm;
        String sql = "INSERT INTO Funcionario (nomefun,dataAdmissao,dataRecisao,Cargo_idCargo,Setor_idSetor) VALUES (?,?,?,?,?)";

        try {

            pstm = con.prepareStatement(sql);
            pstm.setString(1, funcionario.getNome());
            pstm.setString(2, funcionario.getDataAdmissao());
            pstm.setString(3, funcionario.getDataRecisao());
            pstm.setString(4, funcionario.getIdCargo().toString());
            pstm.setString(5, funcionario.getIdSetor().toString());
            pstm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CursoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;

    }

    public void visualizarFuncionario(FuncionarioLista fun) {

        //Executando Query para alimentar o jTable
        PreparedStatement pstm;

        String sql1 = "select * from funcionario inner join cargo on cargo.idCargo=funcionario.Cargo_idCargo inner join setor on setor.idSetor = funcionario.Setor_idSetor;";
        try {
            pstm = con.prepareStatement(sql1);
            ResultSet rs1 = pstm.executeQuery(sql1);

            DefaultTableModel model = (DefaultTableModel) fun.getjTable1().getModel();

            //Alimentando o JTable
            String aux = "";
            while (rs1.next()) {
                if (rs1.getInt("dataRecisao") == 0) {
                    aux = "Não possui";
                    model.addRow(new Object[]{rs1.getString("nomefun"), rs1.getString("dataAdmissao"), aux, rs1.getString("nomecar"), rs1.getString("nomeset")});
                } else {
                    model.addRow(new Object[]{rs1.getString("nomefun"), rs1.getString("dataAdmissao"), rs1.getString("dataRecisao"), rs1.getString("nomecar"), rs1.getString("nomeset")});
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(CursoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean validaFuncionario(ValidaFuncionario a,int x) {
        int aux = 0;
        boolean aus = true;
        
        try {
            AlteraFuncionario fu = new AlteraFuncionario();
            DeletarFuncionario fun = new DeletarFuncionario();
            PreparedStatement pstm;
            String sql = "select * from funcionario inner join cargo on cargo.idCargo=funcionario.Cargo_idCargo inner join setor on setor.idSetor = funcionario.Setor_idSetor;";
            pstm = con.prepareStatement(sql);
            ResultSet rs1 = pstm.executeQuery(sql);

            if (!rs1.isBeforeFirst() && rs1.getRow() == 0) {
                JOptionPane.showMessageDialog(null, " Não existe Funcionário cadastrado no momento.");
            } else {
                while (rs1.next()) {

                    if (rs1.getString("nomefun").equals(a.getjTextField1().getText())) {
                        if(x==1){
                            JOptionPane.showMessageDialog(null, "Validação realizado com sucesso!");
                            Thread.sleep(200);
                            fu.setVisible(true);
                            fu.setIdFun(rs1.getInt("idFuncionario"));
                            fu.getjTextField1().setText(rs1.getString("nomefun"));
                            fu.getjTextField2().setText(rs1.getString("dataAdmissao"));
                            fu.getjComboBox2().setSelectedIndex(rs1.getInt("Cargo_idCargo")-1);
                            fu.getjComboBox1().setSelectedIndex(rs1.getInt("Setor_idSetor")-1);
                            fu.getjTextField3().setText(rs1.getString("dataRecisao"));
                            aux = 1;
                            aus = true;
                        }else if(x==2){
                            JOptionPane.showMessageDialog(null, "Validação realizado com sucesso!");
                            Thread.sleep(200);
                            fun.setVisible(true);
                            fun.setIdFun(rs1.getInt("idFuncionario"));
                            fun.getjTextField1().setText(rs1.getString("nomefun"));
                            fun.getjTextField2().setText(rs1.getString("dataAdmissao"));
                            fun.getjTextField3().setText(rs1.getString("dataRecisao"));
                            fun.getjTextField4().setText(rs1.getString("nomecar"));
                            fun.getjTextField5().setText(rs1.getString("nomeset"));
                            aux = 1;
                            aus = true;
                        }else{
                            int idFun = 1, idCargo = 1;
                            idFun = rs1.getInt("idFuncionario");
                            idCargo = rs1.getInt("Cargo_idCargo");

                            Trilha tr = new Trilha();
                            tr.setIdFuncionario(idFun);
                            tr.setIdCargo(idCargo);

                            TrilhaDAO tri = new TrilhaDAOJDBC();
                            tri.salvar(tr);
                            
                            JOptionPane.showMessageDialog(null, "Validação realizado com sucesso!");
                            Thread.sleep(200);
                            CadastroCurso cu = new CadastroCurso();
                            cu.setVisible(true);
                            
                            aux = 1;
                            aus = true;
                        }
                    }
                }
                if (aux != 1) {
                    aus = false;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(CadastroFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FuncionarioDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(FuncionarioDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

        return aus;

    }

    public boolean alteraFuncionario(AlteraFuncionario a){
        boolean aux =false;
        
        try {
            
            PreparedStatement pstm;
            String sql1 = "UPDATE Funcionario SET nomefun = ?, dataAdmissao = ?, dataRecisao = ?, Cargo_idCargo = ?, Setor_idSetor = ? WHERE idFuncionario = ?";
            pstm = con.prepareStatement(sql1);
            pstm.setString(1, a.getjTextField1().getText());
            pstm.setString(2, a.getjTextField2().getText());
            pstm.setString(3, a.getjTextField3().getText());
            pstm.setString(4, String.valueOf(a.getjComboBox2().getSelectedIndex()+1));
            pstm.setString(5, String.valueOf(a.getjComboBox1().getSelectedIndex()+1));
            pstm.setString(6, String.valueOf(a.getIdFun()));
            pstm.executeUpdate();
            
            aux=true;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return aux;
    }

    public boolean deletarFuncionario(DeletarFuncionario a){
        boolean aux=false;
        try {
            
            PreparedStatement pstm;
            String sql3 = "DELETE FROM Funcionario WHERE idFuncionario = ?";
            pstm = con.prepareStatement(sql3);
            pstm.setString(1, String.valueOf(a.getIdFun()));
            
            pstm.executeUpdate();
            aux=true;
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aux;
    }
    
    public int getIdFun() {
        return idFun;
    }

    public void setIdFun(int idFun) {
        this.idFun = idFun;
    }
    
    
}
