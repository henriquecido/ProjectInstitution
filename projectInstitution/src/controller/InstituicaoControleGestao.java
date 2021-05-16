/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import dao.*;
import model.*;
import view.*;

public class InstituicaoControleGestao {

        public boolean cadastrarUsuario(CadastroLogin a) throws ClassNotFoundException, SQLException{
            Login log = new Login();
            log.setNome(a.getjTextField1().getText());
            log.setSenha(a.getjTextField2().getText());
            
            LoginDAO logs = new LoginDAOJDBC();
            logs.salvar(log);
            return true;
        }
        
        public boolean loginUsuario(Loguin a)throws ClassNotFoundException, SQLException{
            boolean aux =false;
            Login log = new Login();
            log.setNome(a.getjTextField1().getText());
            log.setSenha(a.getjTextField2().getText());
            
            LoginDAO logs = new LoginDAOJDBC();
            aux = logs.login(log);
            return aux;
        }
        
        public boolean validaFuncionario(ValidaFuncionario a,int x)throws ClassNotFoundException, SQLException{
            FuncionarioDAO fu = new FuncionarioDAOJDBC();
            return fu.validaFuncionario(a,x);
        }
        
        public boolean validaCurso(ValidaCurso a,int x)throws ClassNotFoundException, SQLException{
            CursoDAO cu = new CursoDAOJDBC();
            return  cu.validaCurso(a,x);
        }
        
        public boolean cadastrarFuncionario(CadastroFuncionario a) throws ClassNotFoundException, SQLException{
            Funcionario fun = new Funcionario();
            fun.setNome(a.getjTextField1().getText());
            fun.setDataAdmissao(a.getjTextField2().getText());
            fun.setIdSetor(a.getjComboBox1().getSelectedIndex()+1);
            fun.setIdCargo(a.getjComboBox2().getSelectedIndex()+1);
            fun.setDataRecisao(a.getjTextField3().getText());
            
            FuncionarioDAO funDAO = new FuncionarioDAOJDBC();
            funDAO.salvar(fun);
            return true;
        }
        
        public boolean cadastrarCargo(Cargos a) throws ClassNotFoundException, SQLException{
            Cargo car = new Cargo();
            car.setNome(a.getjTextField1().getText());
            car.setAtribuicoes(a.getjTextField3().getText());
            
            CargoDAO cargs = new CargoDAOJDBC();
            cargs.cadastrarCargo(car);
            
            return true;
        }
        
        public boolean cadastrarSetor(Setores a) throws ClassNotFoundException, SQLException{
            Setor se = new Setor();
            se.setNome(a.getjTextField1().getText());
            
            SetorDAO set = new SetorDAOJDBC();
            set.cadastrarSetor(se);
            
            
            return true;
        }
       
        public boolean cadastrarCurso(CadastroCurso a)throws ClassNotFoundException, SQLException{
            
            Curso cu = new Curso();
            cu.setNome(a.getjTextField1().getText());
            cu.setEmenta(a.getjTextField2().getText());
            cu.setCargaHoraria(Integer.parseInt(a.getjTextField3().getText()));
            
            CursoDAO cur = new CursoDAOJDBC();
            cur.salvar(cu);

            return true;
        }
        
        public void visualizarCursos(CursoLista a) throws ClassNotFoundException, SQLException{
            
            CursoDAO cur = new CursoDAOJDBC();
            cur.visualizarCurso(a);
        }
        
        public void visualizarSetorCA(CadastroFuncionario a) throws ClassNotFoundException, SQLException{
            
            SetorDAO se = new SetorDAOJDBC();
            se.visualizaSetorCA(a);
            
        }
        
        public void visualizarCargoCA(CadastroFuncionario a) throws ClassNotFoundException, SQLException{
            
            CargoDAO ca = new CargoDAOJDBC();
            ca.visualizarCargoCA(a);
        }
        
        public void visualizarSetorAL(AlteraFuncionario a) throws ClassNotFoundException, SQLException{
            
            SetorDAO se = new SetorDAOJDBC();
            se.visualizaSetorAL(a);
            
        }
        
        public void visualizarCargoAL(AlteraFuncionario a) throws ClassNotFoundException, SQLException{
            
            CargoDAO ca = new CargoDAOJDBC();
            ca.visualizarCargoAL(a);
        }
        
        public void visualizarFuncionario(FuncionarioLista a) throws ClassNotFoundException, SQLException{
            
            FuncionarioDAO fu = new FuncionarioDAOJDBC();
            fu.visualizarFuncionario(a);
        }
        
        public boolean alterarFuncionario(AlteraFuncionario a)throws ClassNotFoundException, SQLException{
            
            FuncionarioDAO fu = new FuncionarioDAOJDBC();
            return fu.alteraFuncionario(a);
            
        }
        
        public boolean alterarCurso(AlteraCurso a)throws ClassNotFoundException, SQLException{
            
            CursoDAO cu = new CursoDAOJDBC();
            return cu.alterarCurso(a);
            
        }
        
        public boolean deletarFuncionario(DeletarFuncionario a)throws ClassNotFoundException, SQLException{
            
            FuncionarioDAO fu = new FuncionarioDAOJDBC();
            return fu.deletarFuncionario(a);
            
            
        }
        
        public boolean deletarCurso(DeletarCurso a)throws ClassNotFoundException, SQLException{
            
            CursoDAO cu = new CursoDAOJDBC();
            return cu.deletarCurso(a);
            
        }


}
