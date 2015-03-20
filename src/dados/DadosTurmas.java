/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dados;

import basicas.CursoAluno;
import basicas.Curso;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Julio
 */
public class DadosTurmas extends ConexaoBanco{
    private static DadosTurmas instancia;

    public static DadosTurmas obterInstancia() {
        if (instancia == null) {
            instancia = new DadosTurmas();
        }
        return instancia;
    }
    
    //TURMA
    public ArrayList<Curso> listarTurma(Curso filtro) {
        ArrayList<Curso> retorno = new ArrayList<Curso>();

        try {
            Statement conexao = conectar();

            String sql = "select  codigo_turma, descricao_turma";
            sql += " from turma";
            sql += " where codigo_turma = codigo_turma";
            if (filtro.getDescricao() != null && filtro.getDescricao().trim().equals("") == false) {
                sql += "and descricao like '%" + filtro.getDescricao().trim() + "%'";
            }
            if (filtro.getCodigo() > 0) {
                sql += "and codigo = " + filtro.getCodigo();
            }

            java.sql.ResultSet rs = conexao.executeQuery(sql);
            while (rs.next()) {
                Curso turma = new Curso();
                turma.setCodigo(rs.getInt("codigo_turma"));
                turma.setDescricao(rs.getString("descricao_turma"));
                
                
                retorno.add(turma);
            }

            desconectar();

        } catch (Exception e) {
            e.getMessage();
        }
        return retorno;
    }
    
    public ArrayList<CursoAluno> selectAlunoTurma(Curso filtro) throws Exception {
        //abrindo a conexÃ£o
        Statement conex = conectar();
        ArrayList<CursoAluno> retorno = new ArrayList<CursoAluno>();
        //instruÃ§Ã£o sql correspondente a seleÃ§Ã£o dos alunos

        String sql = " select sala.matricula_aluno, aluno.nome_aluno, sala.nota_sala, sala.faltas_sala "
                + " from sala "
                + " inner join aluno "
                + " on aluno.matricula_aluno = sala.matricula_aluno "
                + " and sala.codigo_turma = " + filtro.getCodigo();

        try {
            //executando a instruÃ§Ã£o sql
            ResultSet rs = conex.executeQuery(sql);
            while (rs.next()) {
                CursoAluno sala = new CursoAluno();
                sala.getAluno().setMatricula(rs.getInt("matricula_aluno"));
                sala.getAluno().setNome(rs.getString("nome_aluno"));
                sala.setNota(rs.getFloat("nota_sala"));
                sala.setFalta(rs.getInt("faltas_sala"));

                retorno.add(sala);
            }
        } catch (SQLException e) {
            //caso haja algum erro neste mÃ©todo serÃ¡ levantada esta execeÃ§Ã£o
            throw new Exception("Erro ao executar consulta: " + e.getMessage());
        }
        //fechando a conexÃ£o com o banco de dados
        desconectar();
        return retorno;
    }
    
}
