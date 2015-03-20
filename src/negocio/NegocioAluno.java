/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import basicas.Aluno;
import basicas.CursoAluno;
import exception.AlunoException;
import dados.DadosAluno;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Julio
 */
public class NegocioAluno{
    
    ArrayList<CursoAluno> listaAluno;
   DadosAluno d = new DadosAluno();

    public void cadastrar(Aluno a) throws AlunoException {
        listaAluno = d.listar();
        for (int i = 0; i < listaAluno.size(); i++) {
                if (listaAluno.get(i).getAluno().getMatricula() == a.getMatricula()) {
                    
                    throw new AlunoException("matricula existe");
                }
                if (a.getCpf().equals(listaAluno.get(i).getAluno().getCpf())) {
                    throw new AlunoException("cpf existe");
                }
            }
        
        //validações de matrícula
        if (a.getMatricula() < 0) {
            throw new AlunoException("Preencha a Matrícula corretamente");
        }

        //Validações do Nome
        if (a.getNome() == null) {
            throw new AlunoException("O Aluno não foi instanciado");
        } else if (a.getNome().equals("")) {
            throw new AlunoException("O campo Nome está vazio");
        } else if (a.getNome().length() > 50) {
            throw new AlunoException("O campo nome contém mais de 50 caracteres");
        } else if (a.getNome().length() < 4) {
            throw new AlunoException("O campo Nome deverá ter no mínimo 4 caracteres");
        } else if (!a.getNome().trim().equals(a.getNome())) {
            throw new AlunoException("O campo Nome não poderá ter espaços em BRANCO desnecessários");
        }

       
        //validaçoes do CPF
        if (a.getCpf() == null) {
            throw new AlunoException("O campo CPF está nulo");
        } else if (a.getCpf().equals("")) {
            throw new AlunoException("O campo CPF está vazio");

        } else if (a.getCpf().length() != 14) {
            throw new AlunoException("O campo CPF deve conter 11 caracteres!");
        } else if (!a.getCpf().trim().equals(a.getCpf())) {
            throw new AlunoException("O campo CPF está com espaços em BRANCO desnecessários");
        }
        

        //Validações do RG 
        if (a.getRg() == null) {
            throw new AlunoException("O campo RG não pode ser nulo");
        } else if (a.getRg().equals("")) {
            throw new AlunoException("O campo RG está vazio");
        } else if (a.getRg().length() != 9) {
            throw new AlunoException("O campo RG deve conter 4 caracteres!");
        } else if (!a.getRg().trim().equals(a.getRg())) {
            throw new AlunoException("O campo RG não poderá ter espaços em BRANCO desnecessários");
        }
        DadosAluno dados = DadosAluno.obterInstancia();
        dados.cadastrar(a);
    }

    public void alterar(Aluno a) throws AlunoException {
        //Validações do Nome
        if (a.getNome() == null) {
            throw new AlunoException("O Aluno não foi instanciado");
        } else if (a.getNome().equals("")) {
            throw new AlunoException("O campo Nome está vazio");
        } else if (a.getNome().length() > 50) {
            throw new AlunoException("O campo nome contém mais de 50 caracteres");
        } else if (a.getNome().length() < 4) {
            throw new AlunoException("O campo Nome deverá ter no mínimo 4 caracteres");
        } else if (!a.getNome().trim().equals(a.getNome())) {
            throw new AlunoException("O campo Nome não poderá ter espaços em BRANCO desnecessários");
        }
        

        //validaçoes do CPF
        
        if (a.getCpf().equals("")) {
            throw new AlunoException("O campo CPF está vazio");

        } else if (a.getCpf().length() != 14) {
            throw new AlunoException("O campo CPF deve conter 11 caracteres!");
        } else if (!a.getCpf().trim().equals(a.getCpf())) {
            throw new AlunoException("O campo CPF está com espaços em BRANCO desnecessários");
        }
        

        //Validações do RG 
        if (a.getRg() == null) {
            throw new AlunoException("O campo RG não pode ser nulo");
        } else if (a.getRg().equals("")) {
            throw new AlunoException("O campo RG está vazio");
        } else if (a.getRg().length() != 9) {
            throw new AlunoException("O campo RG deve conter 4 caracteres!");
        } else if (!a.getRg().trim().equals(a.getRg())) {
            throw new AlunoException("O campo RG não poderá ter espaços em BRANCO desnecessários");
        }
        DadosAluno dados = DadosAluno.obterInstancia();
        dados.alterar(a);
    }
    
    

    public ArrayList<Aluno> listarAlunos(Aluno filtro) throws AlunoException {
        DadosAluno dados = DadosAluno.obterInstancia();
        return dados.listarAlunos(filtro);
    }

   

    public void remover(Aluno a) throws AlunoException {
        DadosAluno dados = DadosAluno.obterInstancia();
        dados.remover(a);

    }

    
 public ArrayList<CursoAluno> listar() throws AlunoException {
     DadosAluno dados = DadosAluno.obterInstancia();
      return dados.listar();
        
 }
    

}
