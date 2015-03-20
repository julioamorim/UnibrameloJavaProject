/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

import basicas.CursoAluno;
import basicas.Curso;
import java.util.ArrayList;

/**
 *
 * @author Julio
 */
public interface InterfaceCurso {
    
    
    public ArrayList<Curso> listarCurso(Curso filtro);
    public ArrayList<CursoAluno> selectAlunoTurma(Curso filtro) throws Exception;
}
