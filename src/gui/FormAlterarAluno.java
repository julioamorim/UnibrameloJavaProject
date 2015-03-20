package gui;

import basicas.Aluno;
import exception.AlunoException;
import basicas.CursoAluno;
import basicas.Curso;
import dados.ConexaoBanco;
import fachada.Fachada;
import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import mascaras.TeclasPermitidasNome;

/**
 *
 * @author Julio
 */
public class FormAlterarAluno extends javax.swing.JFrame {

    Fachada fachada = new Fachada();
    private ArrayList<CursoAluno> existe;
    private ArrayList<Curso> listaTurma;
    private final Aluno aa;
    ArrayList<Aluno> listaAluno;

    public FormAlterarAluno(Aluno a) {
        initComponents();
        this.setLocationRelativeTo(this);
        this.carregarTurmas();
        jTextFieldAlterarNome.setDocument(new TeclasPermitidasNome());
        jLabel3.setText(a.getMatricula() + "");
        jTextFieldAlterarNome.setText(a.getNome());
        jFormattedAlCpf.setText(a.getCpf());
        jFormattedTextFielAlRg.setText(a.getRg());
        this.aa = a;
        try {

            ConexaoBanco conn = new ConexaoBanco();
            this.aa.setListaTurmas(fachada.selectCursoAluno(aa));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        this.carregarTabelaCursoAluno();

    }

    private void carregarTurmas() {
        try {

            Curso filtro = new Curso();
            this.listaTurma = fachada.listarCurso(filtro);
            DefaultComboBoxModel modelo = new DefaultComboBoxModel();

            for (int i = 0; i < listaTurma.size(); i++) {
                modelo.addElement(listaTurma.get(i).getCodigo() + " - " + listaTurma.get(i).getDescricao());
            }

            jComboBox1.setModel(modelo);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }

    private void carregarTabelaCursoAluno() {
        DefaultTableModel modeloAlunoSala = new DefaultTableModel();
        modeloAlunoSala.setColumnIdentifiers(new String[]{"Código Curso", "Curso", "Nota", "Faltas", "Status"});

        try {

            for (CursoAluno sala : aa.getListaTurmas()) {
                modeloAlunoSala.addRow(new String[]{sala.getTurma().getCodigo() + "", sala.getTurma().getDescricao(), sala.getNota() + "", sala.getFalta() + "", sala.statusStr()});
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }

        jTableSCursoAluno.setModel(modeloAlunoSala);
    }

    private void listarItensDoAluno() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new String[]{"Turma"});
        for (CursoAluno sala : this.aa.getListaTurmas()) {
            modelo.addRow(new String[]{sala.getTurma().getDescricao() + ""});
        }
        jTableSCursoAluno.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        jLabelAlterarCPF = new javax.swing.JLabel();
        jLabelAlterarRG = new javax.swing.JLabel();
        jTextFieldAlterarNome = new javax.swing.JTextField();
        jFormattedAlCpf = new javax.swing.JFormattedTextField();
        jFormattedTextFielAlRg = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButtonSalvar1 = new javax.swing.JButton();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableSCursoAluno = new javax.swing.JTable();
        jButtonRemoverCurso = new javax.swing.JButton();
        jButtonAdicionarCurso = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jInternalFrame1.setTitle("Alterar dados do Aluno");
        jInternalFrame1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jInternalFrame1.setVisible(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Nome");

        jLabelAlterarCPF.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelAlterarCPF.setText("Cpf");

        jLabelAlterarRG.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelAlterarRG.setText("Rg");

        try {
            jFormattedAlCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jFormattedTextFielAlRg.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#.###.###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel2.setText("Matrícula:");

        jLabel3.setText("jLabel3");

        jButtonSalvar1.setText("Salvar");
        jButtonSalvar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvar1ActionPerformed(evt);
            }
        });

        jInternalFrame2.setTitle("Cursos do aluno");
        jInternalFrame2.setVisible(true);

        jTableSCursoAluno.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableSCursoAluno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableSCursoAlunoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableSCursoAluno);

        jButtonRemoverCurso.setText("Remover Curso");
        jButtonRemoverCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverCursoActionPerformed(evt);
            }
        });

        jButtonAdicionarCurso.setText("Adicionar Curso");
        jButtonAdicionarCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarCursoActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonAdicionarCurso))
                            .addComponent(jButtonRemoverCurso))
                        .addGap(0, 234, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAdicionarCurso))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonRemoverCurso)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jInternalFrame2)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                    .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabelAlterarRG)
                                        .addComponent(jLabelAlterarCPF))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jFormattedAlCpf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jFormattedTextFielAlRg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(18, 18, 18)
                                    .addComponent(jTextFieldAlterarNome, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(5, 5, 5)))
                            .addComponent(jButtonSalvar1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldAlterarNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelAlterarCPF)
                    .addComponent(jFormattedAlCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextFielAlRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAlterarRG))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jInternalFrame2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonSalvar1)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jInternalFrame1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableSCursoAlunoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableSCursoAlunoMouseClicked
     
    }//GEN-LAST:event_jTableSCursoAlunoMouseClicked

    private void jButtonRemoverCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverCursoActionPerformed
        try {
            if (jTableSCursoAluno.getSelectedRow() < 0) {
                JOptionPane.showMessageDialog(this, "Selecione a Turma a remover");
                return;
            }
            int del = jTableSCursoAluno.getSelectedRow();
            aa.getListaTurmas().get(del).setStatus(2);
            JOptionPane.showMessageDialog(this, "Turma removida com sucesso");
            this.carregarTabelaCursoAluno();
        } catch (HeadlessException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_jButtonRemoverCursoActionPerformed

    private void jButtonAdicionarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarCursoActionPerformed
        try {
            CursoAluno ca = new CursoAluno();

            Curso turma = this.listaTurma.get(jComboBox1.getSelectedIndex());
            ca.setTurma(turma);
            ca.setStatus(1);
            this.aa.adicionarTurma(ca);
            this.carregarTabelaCursoAluno();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }

    }//GEN-LAST:event_jButtonAdicionarCursoActionPerformed

    private void jButtonSalvar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvar1ActionPerformed

        try {
            CursoAluno at = new CursoAluno();
            this.existe = fachada.listar();

            this.aa.setNome(jTextFieldAlterarNome.getText().toUpperCase());
            this.aa.setCpf(jFormattedAlCpf.getText());
            this.aa.setRg(jFormattedTextFielAlRg.getText());

            for (int i = 0; i < existe.size(); i++) {
                if (aa.getCpf().equals(existe.get(i).getAluno().getCpf())) {
                    this.aa.setCpf(existe.get(i).getAluno().getCpf());
                    
                }
            }
            
             

            fachada.alterar(aa);
            JOptionPane.showMessageDialog(this, "Aluno atualizado com sucesso!");
            this.carregarTabelaCursoAluno();
            this.dispose();

        } catch (AlunoException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Informe a Matrícula");
        }
    }//GEN-LAST:event_jButtonSalvar1ActionPerformed

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
            java.util.logging.Logger.getLogger(FormAlterarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormAlterarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormAlterarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormAlterarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormAlterarAluno(new Aluno()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionarCurso;
    private javax.swing.JButton jButtonRemoverCurso;
    private javax.swing.JButton jButtonSalvar1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JFormattedTextField jFormattedAlCpf;
    private javax.swing.JFormattedTextField jFormattedTextFielAlRg;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelAlterarCPF;
    private javax.swing.JLabel jLabelAlterarRG;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableSCursoAluno;
    private javax.swing.JTextField jTextFieldAlterarNome;
    // End of variables declaration//GEN-END:variables
}
