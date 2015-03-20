package fachada;

import basicas.Aluno;
import exception.AlunoException;
import basicas.CursoAluno;
import exception.AlunoTurmaException;
import interfaces.InterfaceAluno;
import basicas.Curso;
import dados.DadosAluno;
import interfaces.InterfaceAlunoTurma;
import interfaces.InterfaceCurso;
import java.util.ArrayList;
import negocio.NegocioAluno;
import negocio.NegocioCursoAluno;
import negocio.NegocioCurso;

/**
 *
 * @author Julio
 */
public class Fachada implements InterfaceAluno, InterfaceCurso, InterfaceAlunoTurma {

    //ALUNO
   
    @Override
    public void cadastrar(Aluno a) throws AlunoException {
        NegocioAluno dados = new NegocioAluno();
        dados.cadastrar(a);
    }

    @Override
    public void alterar(Aluno a) throws AlunoException {
        NegocioAluno dados = new NegocioAluno();
        dados.alterar(a);
    }

    @Override
    public ArrayList<Aluno> listarAlunos(Aluno filtro) throws AlunoException {
        NegocioAluno dados = new NegocioAluno();
        return dados.listarAlunos(filtro);
    }

    @Override
    public void remover(Aluno a) throws AlunoException {
        NegocioAluno dados = new NegocioAluno();
        dados.remover(a);

    }

    //TURMA
    @Override
    public ArrayList<Curso> listarCurso(Curso filtro) {
        NegocioCurso dados = new NegocioCurso();
        return dados.listarTurma(filtro);
    }

    //RELAÇÃO
    @Override
    public ArrayList<CursoAluno> selectCursoAluno(Aluno filtro) throws Exception {
        NegocioCursoAluno dados = new NegocioCursoAluno();
        return dados.selectCursoAluno(filtro);
    }

    @Override
    public ArrayList<CursoAluno> listarSala() {
        NegocioCursoAluno dados = new NegocioCursoAluno();
        return dados.listarSala();
    }

    //FOCO DO PROGRAMA
    @Override
    public void cadastrarNotaFalta(CursoAluno s) throws AlunoTurmaException {
        NegocioCursoAluno dados = new NegocioCursoAluno();
        dados.cadastrarNotaFalta(s);
    }

    @Override
    public ArrayList<CursoAluno> selectAlunoTurma(Curso filtro) throws Exception {
        NegocioCurso dados = new NegocioCurso();
        return dados.selectAlunoTurma(filtro);
    }

    @Override
    public ArrayList<CursoAluno> listar() throws AlunoException {
     DadosAluno dados = DadosAluno.obterInstancia();
      return dados.listar();
        
 }
    
    
}
