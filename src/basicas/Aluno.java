package basicas;

import java.util.ArrayList;

/**
 *
 * @author Medeiros
 */
public class Aluno extends Pessoa{

    private ArrayList<CursoAluno> listaTurmas;
    private Pessoa pessoa;

    public Aluno() {
        pessoa = new Pessoa() {
        };
        this.listaTurmas = new ArrayList<CursoAluno>();
    }

    public void adicionarTurma(CursoAluno at) throws Exception {
        for (CursoAluno alunoTurma : getListaTurmas()) {
            if (at.getTurma().getCodigo() == alunoTurma.getTurma().getCodigo()) {
                throw new Exception("Esta referida turma já está vinculada a este aluno");
            }
        }

       this.getListaTurmas().add(at);
    }

    public void removerTurma(CursoAluno at) throws Exception {
        for (int i = 0; i < this.listaTurmas.size(); i++) {
            if (this.listaTurmas.get(i).getTurma().getCodigo() == at.getTurma().getCodigo()) {
                this.listaTurmas.remove(i);
                
            }
        }

    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public ArrayList<CursoAluno> getListaTurmas() {
        return listaTurmas;
    }

    public void setListaTurmas(ArrayList<CursoAluno> listaTurmas) {
        this.listaTurmas = listaTurmas;
    }
}
