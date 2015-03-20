/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dados;

import basicas.CursoAluno;
import exception.AlunoTurmaException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Julio
 */
public class DadosAlunoTurma extends ConexaoBanco{
    private static DadosAlunoTurma instancia;

    public static DadosAlunoTurma obterInstancia() {
        if (instancia == null) {
            instancia = new DadosAlunoTurma();
        }
        return instancia;
    }

    public void cadastrarNotaFalta(CursoAluno s) throws AlunoTurmaException {
        try {
            Statement conexao = conectar();
            String sql = "update sala  set ";
            sql += " nota_sala = " + s.getNota() + "," + "";
            sql += " faltas_sala = " + s.getFalta() + "";
            sql += " where matricula_aluno = " + s.getAluno().getMatricula() + " ";
            sql += " and codigo_turma = " + s.getTurma().getCodigo() + " ";
            conexao.execute(sql);

            desconectar();
        } catch (ClassNotFoundException ex) {
            ex.getMessage();

        } catch (SQLException ex) {
            ex.getMessage();
        }
    }

    
    public ArrayList<CursoAluno> listarSala() {
        ArrayList<CursoAluno> retorno = new ArrayList<CursoAluno>();

        try {
            Statement conexao = conectar();

            String sql = "select  s.codigo_turma, t.descricao_turma, s.nota_sala, s.faltas_sala";
            sql += " from sala s, turma t";
            sql += " where s.codigo_turma = t.codigo_turma";

            java.sql.ResultSet rs = conexao.executeQuery(sql);
            while (rs.next()) {
                CursoAluno sala = new CursoAluno();
                sala.getTurma().setCodigo(rs.getInt("codigo_turma"));
                sala.getTurma().setDescricao(rs.getString("descricao_turma"));
                sala.setNota(rs.getFloat("nota_sala"));
                sala.setFalta(rs.getInt("faltas_sala"));

                retorno.add(sala);
            }

            desconectar();

        } catch (Exception e) {
            e.getMessage();
        }
        return retorno;
    }

}
