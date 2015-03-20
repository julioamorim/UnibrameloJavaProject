package basicas;

import java.util.ArrayList;

/**
 *
 * @author Medeiros
 */
public class Curso {

    private ArrayList<CursoAluno> listaSala;
    private int codigo;
    private String descricao;
    private String nome_professor;
    private float media;
    private int codigo_professor;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

  

    public float getMedia() {
        return media;
    }

    public void setMedia(float media) {
        this.media = media;
    }

    public int getCodigo_professor() {
        return codigo_professor;
    }

    public void setCodigo_professor(int codigo_professor) {
        this.codigo_professor = codigo_professor;
    }

    public ArrayList<CursoAluno> getListaSala() {
        return listaSala;
    }

    public void setListaSala(ArrayList<CursoAluno> listaSala) {
        this.listaSala = listaSala;
    }

}
