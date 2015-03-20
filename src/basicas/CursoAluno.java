package basicas;

import java.util.ArrayList;

/**
 *
 * @author Medeiros
 */
public class CursoAluno {

    private int codigo_sala;
    private Aluno aluno;
    private Curso turma;
    private float nota;
    private int falta;
    private ArrayList<CursoAluno> lista;
    private int status;

    public CursoAluno() {
        this.aluno = new Aluno();
        this.turma = new Curso();
        this.lista = new ArrayList<CursoAluno>();
        this.status = 0;
    }

    public String statusStr() {
        if (this.status == 0) {
            return "";
        } else if (this.status == 1) {
            return "Novo";
        } else {
            return "Removido";
        }
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public int getFalta() {
        return falta;
    }

    public void setFalta(int falta) {
        this.falta = falta;
    }

    public Curso getTurma() {
        return turma;
    }

    public void setTurma(Curso turma) {
        this.turma = turma;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public ArrayList<CursoAluno> getLista() {
        return lista;
    }

    public void setLista(ArrayList<CursoAluno> lista) {
        this.lista = lista;
    }

    public int getCodigo_sala() {
        return codigo_sala;
    }

    public void setCodigo_sala(int codigo_sala) {
        this.codigo_sala = codigo_sala;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
