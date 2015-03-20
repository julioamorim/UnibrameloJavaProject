/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

import basicas.CursoAluno;
import basicas.Curso;
import dados.DadosTurmas;
import java.util.ArrayList;

/**
 *
 * @author Julio
 */
public class NegocioCurso {
    
     public ArrayList<Curso> listarTurma(Curso filtro) {
        DadosTurmas dados = DadosTurmas.obterInstancia();
        return dados.listarTurma(filtro);
    }
    
     public ArrayList<CursoAluno> selectAlunoTurma(Curso filtro) throws Exception {
        DadosTurmas dados = DadosTurmas.obterInstancia();
        return dados.selectAlunoTurma(filtro);
    }
     
}
