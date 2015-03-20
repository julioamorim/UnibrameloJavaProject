/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import basicas.Aluno;
import exception.AlunoException;
import basicas.CursoAluno;
import java.util.ArrayList;

/**
 *
 * @author Julio
 */
public interface InterfaceAluno {

    public void cadastrar(Aluno a) throws AlunoException;

    public void alterar(Aluno a) throws AlunoException;

    public ArrayList<Aluno> listarAlunos(Aluno filtro) throws AlunoException;

    public void remover(Aluno a) throws AlunoException;

    public ArrayList<CursoAluno> selectCursoAluno(Aluno filtro) throws Exception;

    public ArrayList<CursoAluno> listar() throws AlunoException;
}
