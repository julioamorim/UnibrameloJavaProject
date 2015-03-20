/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import basicas.Aluno;
import exception.AlunoException;
import basicas.CursoAluno;
import exception.AlunoTurmaException;
import dados.DadosAlunoTurma;
import dados.DadosAluno;
import java.util.ArrayList;

/**
 *
 * @author Julio
 */
public class NegocioCursoAluno {

    public ArrayList<CursoAluno> selectCursoAluno(Aluno filtro) throws Exception {
        DadosAluno dados = DadosAluno.obterInstancia();
        return dados.selectCursoAluno(filtro);
    }

    public ArrayList<CursoAluno> listarSala() {
        DadosAlunoTurma dados = DadosAlunoTurma.obterInstancia();
        return dados.listarSala();
    }

    public void cadastrarNotaFalta(CursoAluno s) throws AlunoTurmaException {

        if (s.getNota() < 0) {
            throw new AlunoTurmaException("A nota deve ser entre 0 e 10");
        } else if (s.getNota() > 10) {
            throw new AlunoTurmaException("A nota deve ser entre 0 e 10");
        } else if (s.getFalta() < 0) {
            throw new AlunoTurmaException("O Número de faltas deve igual o maior que zero");
        }
        DadosAlunoTurma dados = DadosAlunoTurma.obterInstancia();
        dados.cadastrarNotaFalta(s);
    }

  

}
