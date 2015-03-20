 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import basicas.Aluno;
import exception.AlunoException;
import basicas.CursoAluno;
import interfaces.InterfaceAluno;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Medeiros
 */
public class DadosAluno extends ConexaoBanco implements InterfaceAluno {

    private static DadosAluno instancia;

    public static DadosAluno obterInstancia() {
        if (instancia == null) {
            instancia = new DadosAluno();
        }
        return instancia;
    }

    //ALUNO---------------------------------------------------------------------
    @Override
    public void cadastrar(Aluno a) throws AlunoException {
        try {
            Statement conexao = conectar();
            String sql = "INSERT INTO aluno (matricula_aluno, nome_aluno, cpf_aluno, rg_aluno)";
            sql += "VALUES ('" + a.getMatricula() + "','" + a.getNome() + "','" + a.getCpf() + "','" + a.getRg() + "')";
            conexao.execute(sql);
            for (CursoAluno s : a.getListaTurmas()) {
                sql = "INSERT INTO sala ( matricula_aluno, codigo_turma )";
                sql += "VALUES (" + a.getMatricula() + "," + s.getTurma().getCodigo() + ")";

                conexao.execute(sql);
            }
            desconectar();
        } catch (ClassNotFoundException ex) {
            ex.getMessage();

        } catch (SQLException ex) {
            ex.getMessage();
        }
    }

    @Override
    public void alterar(Aluno a) throws AlunoException {

        try {
            Statement conexao = conectar();
            String sql = "UPDATE aluno SET nome_aluno = '" + a.getNome() + "',cpf_aluno = '" + a.getCpf() + "',Rg_aluno='" + a.getRg() + "' WHERE matricula_aluno = " + a.getMatricula();

            conexao.execute(sql);
            for (CursoAluno s : a.getListaTurmas()) {
                //novas linhas
                if (s.getStatus() == 1) {
                    sql = "INSERT INTO sala ( matricula_aluno, codigo_turma )";
                    sql += "VALUES (" + a.getMatricula() + "," + s.getTurma().getCodigo() + ")";

                } else if (s.getStatus() == 2) {//remover
                    sql = "delete from sala where codigo_sala = " + s.getCodigo_sala();
                }

                conexao.execute(sql);
            }
            desconectar();
        } catch (ClassNotFoundException ex) {
            ex.getMessage();

        } catch (SQLException ex) {
            ex.getMessage();
        }
    }

    @Override
    public ArrayList<Aluno> listarAlunos(Aluno filtro) throws AlunoException {
        ArrayList<Aluno> retorno = new ArrayList<Aluno>();

        try {
            Statement conexao = conectar();
            String sql = "Select nome_aluno, matricula_aluno, cpf_aluno, rg_aluno ";
            sql += " from aluno ";
            sql += " where matricula_aluno = matricula_aluno ";
            if (filtro.getNome() != null && filtro.getNome().trim().equals("") == false) {
                sql += " and nome_aluno like '%" + filtro.getNome().trim() + "%'";
            }
            if (filtro.getMatricula() > 0) {
                sql += " and matricula_aluno = " + filtro.getMatricula();
            }

            java.sql.ResultSet rs = conexao.executeQuery(sql);
            while (rs.next()) {
                Aluno a = new Aluno();

                a.setNome(rs.getString("nome_aluno"));
                a.setMatricula(rs.getInt("matricula_aluno"));
                a.setCpf(rs.getString("cpf_aluno"));
                a.setRg(rs.getString("rg_aluno"));
                a.setListaTurmas(retornarAlunos(a));

                retorno.add(a);
            }
            desconectar();

        } catch (ClassNotFoundException ex) {
            throw new AlunoException(ex.getMessage());

        } catch (SQLException ex) {
            throw new AlunoException(ex.getMessage());
        }
        return retorno;
    }

    public ArrayList<CursoAluno> listar() throws AlunoException {
        ArrayList<CursoAluno> retorno = new ArrayList<CursoAluno>();

        try {
            Statement conexao = conectar();
            String sql = "Select  s.matricula_aluno, a.cpf_aluno ";
            sql += " from aluno a, sala s ";
            sql += " where a.matricula_aluno = s.matricula_aluno ";

            java.sql.ResultSet rs = conexao.executeQuery(sql);
            while (rs.next()) {
                // Aluno a = new Aluno();
                CursoAluno c = new CursoAluno();

                c.getAluno().setCpf(rs.getString("cpf_aluno"));
                c.getAluno().setMatricula(rs.getInt("matricula_aluno"));
                c.setLista(retorno);

                retorno.add(c);
            }

            desconectar();

        } catch (ClassNotFoundException ex) {
            throw new AlunoException(ex.getMessage());

        } catch (SQLException ex) {
            throw new AlunoException(ex.getMessage());
        }
        return retorno;
    }

    @Override
    public void remover(Aluno a) throws AlunoException {
        try {

            //abrindo a conexao
            ConexaoBanco b = new ConexaoBanco();
            Statement conex = b.conectar();
            //instrucao sql correspondente a insersao do aluno
            String sql = "DELETE FROM sala WHERE matricula_aluno = " + a.getMatricula();
            String sqll = "DELETE FROM aluno WHERE matricula_aluno = " + a.getMatricula();
            //executando a instrucao sql
            conex.execute(sql);
            conex.execute(sqll);

            //fechando a conexao com o banco de dados
            b.desconectar();
        } catch (ClassNotFoundException ex) {
            throw new AlunoException(ex.getMessage());
        } catch (SQLException ex) {
            throw new AlunoException(ex.getMessage());
        }
    }

    //listar alunos
    public ArrayList<CursoAluno> selectCursoAluno(Aluno filtro) throws Exception {
        //abrindo a conexÃ£o
        Statement conex = conectar();
        ArrayList<CursoAluno> retorno = new ArrayList<CursoAluno>();
        //instruÃ§Ã£o sql correspondente a seleÃ§Ã£o dos alunos
        String sql = " select s.codigo_sala, s.codigo_turma, t.descricao_turma, "
                + " s.matricula_aluno, s.nota_sala, s.faltas_sala "
                + " from turma t, sala s"
                + " where s.codigo_turma = t.codigo_turma "
                + " and s.matricula_aluno =" + filtro.getMatricula();

        try {
            //executando a instruÃ§Ã£o sql
            ResultSet rs = conex.executeQuery(sql);
            while (rs.next()) {
                CursoAluno ca = new CursoAluno();
                ca.setCodigo_sala(rs.getInt("codigo_sala"));
                ca.getTurma().setCodigo(rs.getInt("codigo_turma"));
                ca.getTurma().setDescricao(rs.getString("descricao_turma"));
                ca.getAluno().setMatricula(rs.getInt("matricula_aluno"));
                ca.setNota(rs.getFloat("nota_sala"));
                ca.setFalta(rs.getInt("faltas_sala"));

                retorno.add(ca);
            }
        } catch (SQLException e) {
            //caso haja algum erro neste mÃ©todo serÃ¡ levantada esta execeÃ§Ã£o
            throw new Exception("Erro ao executar consulta: " + e.getMessage());
        }
        //fechando a conexÃ£o com o banco de dados
        desconectar();
        return retorno;
    }

    public ArrayList<CursoAluno> retornarAlunos(Aluno a) throws AlunoException {
        ArrayList<CursoAluno> retorno = new ArrayList<CursoAluno>();

        try {
            Statement conexao = conectar();

            String sql = " ";
            sql += "SELECT";
            sql += "turma.codigo as turma_codigo,";
            sql += "turma.descricao as turma_descricao,";
            sql += "turma.dataInicial as data_inicial,";
            sql += "turma.dataFinal as data_final,";
            sql += "turma.mediaAprovacao as media,";
            sql += "sala.Matricula as sala_Matricula,";
            sql += "sala.codigo as sala_codigo,";
            sql += "sala.nota as sala_Nota,";
            sql += "sala.falta as sala_Falta,";
            sql += "aluno.nome as aluno_Nome,";
            sql += "aluno.matricula as aluno_Matricula,";
            sql += "aluno.cpf as aluno_Cpf,";
            sql += "aluno.rg as aluno_Rg,";

            sql += "FROM";
            sql += "aluno, turma, sala";
            sql += "WHERE";
            sql += "aluno.matricula = sala.matricula AND";
            sql += "turma.codigo= sala.codigo AND aluno.matricula = " + a.getMatricula();

            java.sql.ResultSet rs = conexao.executeQuery(sql);
            while (rs.next()) {
                CursoAluno sala = new CursoAluno();
                sala.getTurma().setCodigo(rs.getInt("turma_codigo"));
                sala.getTurma().setDescricao(rs.getString("turma_descricao"));
                sala.getTurma().setMedia(rs.getInt("media"));
                sala.getAluno().setMatricula(rs.getInt("sala_Matricula"));
                sala.setCodigo_sala(rs.getInt("(sala_codigo"));
                sala.setNota(rs.getFloat("sala_nota"));
                sala.setFalta(rs.getInt("sala_falta"));
                sala.getAluno().setNome(rs.getString("aluno_nome"));
                sala.getAluno().setMatricula(rs.getInt("aluno_Matricula"));
                sala.getAluno().setCpf(rs.getString("aluno_Cpf"));
                sala.getAluno().setRg(rs.getString("aluno_Rg"));
                retorno.add(sala);
            }
            desconectar();

        } catch (ClassNotFoundException ex) {
            ex.getMessage();
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return retorno;
    }

}
