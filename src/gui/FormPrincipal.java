package gui;

import basicas.Aluno;
import exception.AlunoException;
import basicas.CursoAluno;
import exception.AlunoTurmaException;
import basicas.Curso;
import dados.ConexaoBanco;
import fachada.Fachada;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import mascaras.TeclasPermitidasNome;
import mascaras.TeclasPermitidasNumeros;

/**
 *
 * @author Julio
 */
public class FormPrincipal extends javax.swing.JFrame {

    Fachada fachada = new Fachada();
    ArrayList<Aluno> listaAluno;
    ArrayList<CursoAluno> listaCursoAluno;
    ArrayList<Curso> listaCurso;

    //Inicializa componentes automaticamente
    public FormPrincipal() {
        initComponents();
        this.setLocationRelativeTo(this);
        this.listarAluno();
        this.listarTurma();
        jTextFieldMatricula.setDocument(new TeclasPermitidasNumeros());
        jTextFieldNota.setDocument(new TeclasPermitidasNumeros());
        jTextFieldFalta.setDocument(new TeclasPermitidasNumeros());
        jTextFieldNome.setDocument(new TeclasPermitidasNome());

    }
    
    private void listarAluno() {
        try {
            Aluno filtro = new Aluno();
            filtro.setNome(jTextFieldNome.getText().toUpperCase());
            if (jTextFieldMatricula.getText().equals("") == false) {
                filtro.setMatricula(Integer.parseInt(jTextFieldMatricula.getText()));
            }
            this.listaAluno = fachada.listarAlunos(filtro);

            DefaultTableModel tabela = new DefaultTableModel();
            tabela.setColumnIdentifiers(new String[]{"Nome", "Matrícula", "Cpf", "Rg"});
            if (listaAluno.size() > 0) {
                for (int i = 0; i < listaAluno.size(); i++) {
                    tabela.addRow(new String[]{listaAluno.get(i).getNome(), listaAluno.get(i).getMatricula() + "", listaAluno.get(i).getCpf(), listaAluno.get(i).getRg()});
                }
            } else {
                JOptionPane.showMessageDialog(this, "Cadastro não encontrado!");
            }
            jTableAluno.setModel(tabela);
        } catch (AlunoException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }

    }
    
     //método responsável por listar as informações dos alunos existentes na tabela sala
    private void carregarTabelaCursoAluno() {
        DefaultTableModel modeloCursoAluno = new DefaultTableModel();
        modeloCursoAluno.setColumnIdentifiers(new String[]{"Código Curso", "Curso", "Nota", "Faltas"});
        try {
            if (jTableAluno.getSelectedRow() >= 0) {
                ConexaoBanco conn = new ConexaoBanco();
                Aluno filtro = this.listaAluno.get(jTableAluno.getSelectedRow());
                this.listaCursoAluno = fachada.selectCursoAluno(filtro);
                for (CursoAluno ca : listaCursoAluno) {
                    modeloCursoAluno.addRow(new String[]{ca.getTurma().getCodigo() + "", ca.getTurma().getDescricao(), ca.getNota() + "", ca.getFalta() + ""});
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
        jTableCursoAluno.setModel(modeloCursoAluno);
    }
    
    //método responsável por listar as informações dos alunos existentes na tabela turma
    private void listarTurma() {
        Curso filtro = new Curso();
        this.listaCurso = fachada.listarCurso(filtro);
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new String[]{"Código Curso", "Descrição"});
        if (listaCurso.size() > 0) {
            for (int i = 0; i < listaCurso.size(); i++) {
                modelo.addRow(new String[]{listaCurso.get(i).getCodigo() + "", listaCurso.get(i).getDescricao()});
            }
        }
        jTableTurmas.setModel(modelo);
    }

    //método responsável por listar as informações dos alunos existentes na tabela aluno
    private void carregarTabelaTurmaAluno() {
        DefaultTableModel modeloTurmaAluno = new DefaultTableModel();
        modeloTurmaAluno.setColumnIdentifiers(new String[]{"Matrícula", "Nome", "Nota", "Faltas"});
        try {
            Curso filtro = this.listaCurso.get(jTableTurmas.getSelectedRow());
            this.listaCursoAluno = fachada.selectAlunoTurma(filtro);
            for (CursoAluno ca : listaCursoAluno) {
                modeloTurmaAluno.addRow(new String[]{ca.getAluno().getMatricula() + "", ca.getAluno().getNome(), ca.getNota() + "", ca.getFalta() + ""});
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
        jTableTurmaAluno.setModel(modeloTurmaAluno);
    }
   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jTextFieldNome = new javax.swing.JTextField();
        jButtonFiltrarAluno = new javax.swing.JButton();
        jButtonCadastrarAluno = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButtonAlterar = new javax.swing.JButton();
        jButtonRemover = new javax.swing.JButton();
        jTextFieldMatricula = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableAluno = new javax.swing.JTable();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCursoAluno = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldNota = new javax.swing.JTextField();
        jTextFieldFalta = new javax.swing.JTextField();
        jButtonSalvar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jInternalFrame3 = new javax.swing.JInternalFrame();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableTurmaAluno = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableTurmas = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        jFormattedTextField2.setText("jFormattedTextField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jInternalFrame1.setTitle("Aluno");
        jInternalFrame1.setMaximumSize(new java.awt.Dimension(150, 250));
        jInternalFrame1.setPreferredSize(new java.awt.Dimension(150, 250));
        jInternalFrame1.setVisible(true);

        jTextFieldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeActionPerformed(evt);
            }
        });

        jButtonFiltrarAluno.setMnemonic('i');
        jButtonFiltrarAluno.setText("Ir");
        jButtonFiltrarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFiltrarAlunoActionPerformed(evt);
            }
        });

        jButtonCadastrarAluno.setMnemonic('c');
        jButtonCadastrarAluno.setText("Cadastrar");
        jButtonCadastrarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarAlunoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Nome");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Matrícula");

        jButtonAlterar.setMnemonic('a');
        jButtonAlterar.setText("Alterar");
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });

        jButtonRemover.setMnemonic('r');
        jButtonRemover.setText("Remover");
        jButtonRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverActionPerformed(evt);
            }
        });

        jTableAluno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "Matrícula", "Cpf", "Rg"
            }
        ));
        jTableAluno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableAlunoMouseClicked(evt);
            }
        });
        jTableAluno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableAlunoKeyReleased(evt);
            }
        });
        jScrollPane5.setViewportView(jTableAluno);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(36, 36, 36)
                                        .addComponent(jLabel3)
                                        .addGap(27, 27, 27))
                                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                        .addComponent(jTextFieldMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonFiltrarAluno))
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addComponent(jButtonCadastrarAluno)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonAlterar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonRemover)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonFiltrarAluno)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCadastrarAluno)
                    .addComponent(jButtonAlterar)
                    .addComponent(jButtonRemover))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jInternalFrame2.setTitle("Cursos Por Aluno");
        jInternalFrame2.setPreferredSize(new java.awt.Dimension(150, 180));
        jInternalFrame2.setVisible(true);

        jTableCursoAluno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código Curso", "Curso", "Nota", "Faltas"
            }
        ));
        jTableCursoAluno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCursoAlunoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableCursoAluno);

        jLabel2.setText("Falta");

        jButtonSalvar.setMnemonic('s');
        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jLabel1.setText("Nota");

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldNota, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldFalta, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSalvar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldFalta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButtonSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jInternalFrame3.setTitle("Alunos por Cursos");
        jInternalFrame3.setPreferredSize(new java.awt.Dimension(150, 180));
        jInternalFrame3.setVisible(true);

        jTableTurmaAluno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Matrícula", "Nome", "Notas", "Faltas"
            }
        ));
        jScrollPane3.setViewportView(jTableTurmaAluno);

        jTableTurmas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Código Turma", "Descrição"
            }
        ));
        jTableTurmas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTurmasMouseClicked(evt);
            }
        });
        jTableTurmas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableTurmasKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(jTableTurmas);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Cursos");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Aluno por Curso  ");

        javax.swing.GroupLayout jInternalFrame3Layout = new javax.swing.GroupLayout(jInternalFrame3.getContentPane());
        jInternalFrame3.getContentPane().setLayout(jInternalFrame3Layout);
        jInternalFrame3Layout.setHorizontalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 544, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(242, 242, 242))
        );
        jInternalFrame3Layout.setVerticalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("UNIBRAMELO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.DEFAULT_SIZE, 1025, Short.MAX_VALUE)
                    .addComponent(jInternalFrame2, javax.swing.GroupLayout.DEFAULT_SIZE, 1025, Short.MAX_VALUE)
                    .addComponent(jInternalFrame3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1025, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(300, 300, 300))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jInternalFrame2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jInternalFrame3, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableCursoAlunoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCursoAlunoMouseClicked

        if (jTableCursoAluno.getSelectedRow() >= 0 && this.listaCursoAluno != null) {
            jTextFieldFalta.setText(this.listaCursoAluno.get(jTableCursoAluno.getSelectedRow()).getFalta() + "");
            jTextFieldNota.setText(this.listaCursoAluno.get(jTableCursoAluno.getSelectedRow()).getNota() + "");
        }
    }//GEN-LAST:event_jTableCursoAlunoMouseClicked

    private void jButtonFiltrarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFiltrarAlunoActionPerformed
        this.listarAluno();
    }//GEN-LAST:event_jButtonFiltrarAlunoActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        try {
            if (jTableAluno.getSelectedRow() < 0) {
                JOptionPane.showMessageDialog(rootPane, "Selecione o Aluno a gerenciar!");
                return;
            } else if (jTableCursoAluno.getSelectedRow() < 0) {
                JOptionPane.showMessageDialog(rootPane, "Selecione a Curso a gerenciar!");
                return;
            }

            CursoAluno ca = new CursoAluno();
            ca = this.listaCursoAluno.get(jTableCursoAluno.getSelectedRow());

            Aluno a = this.listaAluno.get(jTableAluno.getSelectedRow());
            ca.setAluno(a);
            ca.setNota(Float.parseFloat(jTextFieldNota.getText()));
            ca.setFalta(Integer.parseInt(jTextFieldFalta.getText()));
            fachada.cadastrarNotaFalta(ca);
            JOptionPane.showMessageDialog(this, "Informações Incluídas com sucesso!");
            this.carregarTabelaCursoAluno();
        } catch (AlunoTurmaException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }

    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonCadastrarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarAlunoActionPerformed
        new FormCadastroAluno().setVisible(true);
    }//GEN-LAST:event_jButtonCadastrarAlunoActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        if (jTableAluno.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(rootPane, "Selecione o Aluno para Alterar!");
            return;
        }

        Aluno a = new Aluno();

        a.setMatricula(this.listaAluno.get(jTableAluno.getSelectedRow()).getMatricula());
        a.setNome(this.listaAluno.get(jTableAluno.getSelectedRow()).getNome());
        a.setCpf(this.listaAluno.get(jTableAluno.getSelectedRow()).getCpf());
        a.setRg(this.listaAluno.get(jTableAluno.getSelectedRow()).getRg());
        new FormAlterarAluno(a).setVisible(true);
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jButtonRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverActionPerformed
        try {
            if (jTableAluno.getSelectedRow() < 0) {
                JOptionPane.showMessageDialog(rootPane, "Selecione o aluno a remover");
                return;
            }

            int del = jTableAluno.getSelectedRow();
            Aluno a = listaAluno.get(del);
            fachada.remover(a);
            this.listarAluno();
            this.carregarTabelaCursoAluno();
            JOptionPane.showMessageDialog(rootPane, "Aluno removido com sucesso!!!");
            
        } catch (AlunoException ex) {
            ex.getMessage();
        }
    }//GEN-LAST:event_jButtonRemoverActionPerformed

    private void jTableTurmasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTurmasMouseClicked
        this.carregarTabelaTurmaAluno();
    }//GEN-LAST:event_jTableTurmasMouseClicked

    private void jTableTurmasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableTurmasKeyReleased
        this.carregarTabelaTurmaAluno();
    }//GEN-LAST:event_jTableTurmasKeyReleased

    private void jTableAlunoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAlunoMouseClicked
        this.carregarTabelaCursoAluno();
    }//GEN-LAST:event_jTableAlunoMouseClicked

    private void jTableAlunoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableAlunoKeyReleased
        this.carregarTabelaCursoAluno();
    }//GEN-LAST:event_jTableAlunoKeyReleased

    private void jTextFieldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonCadastrarAluno;
    private javax.swing.JButton jButtonFiltrarAluno;
    private javax.swing.JButton jButtonRemover;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JInternalFrame jInternalFrame3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTableAluno;
    private javax.swing.JTable jTableCursoAluno;
    private javax.swing.JTable jTableTurmaAluno;
    private javax.swing.JTable jTableTurmas;
    private javax.swing.JTextField jTextFieldFalta;
    private javax.swing.JTextField jTextFieldMatricula;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldNota;
    // End of variables declaration//GEN-END:variables
}
