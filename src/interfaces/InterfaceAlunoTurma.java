/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

import basicas.CursoAluno;
import exception.AlunoTurmaException;
import java.util.ArrayList;

/**
 *
 * @author Julio
 */
public interface InterfaceAlunoTurma {
    
    public void cadastrarNotaFalta(CursoAluno s) throws AlunoTurmaException;
    
    public ArrayList<CursoAluno> listarSala();
    
    
}
