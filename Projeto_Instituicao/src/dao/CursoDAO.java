/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import model.Curso;
import view.AlteraCurso;
import view.CursoLista;
import view.DeletarCurso;
import view.ValidaCurso;
/**
 *
 * @author User
 */
public interface CursoDAO {
    public boolean salvar(Curso curso);
    
    public void visualizarCurso(CursoLista a);
    
    public boolean validaCurso(ValidaCurso a,int x);
    
    public boolean deletarCurso(DeletarCurso a);
    
    public boolean alterarCurso(AlteraCurso a);
}
