/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import curso.CursoDAO;
import disciplina.DisciplinaDAO;
import java.util.List;
import javax.swing.JOptionPane;
import aluno.Aluno;
import aluno.AlunoDAO;
import aluno.AlunoTableModel;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import util.Util;

/**
 *
 * @author Everton
 */
public class CadastroAluno extends javax.swing.JFrame {
    
    Aluno aluno = new Aluno();
    AlunoDAO alunoDAO = new AlunoDAO();
    
    CursoDAO cursoDAO = new CursoDAO();
    DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
    /**
     * Creates new form CadastroMonitor
     */
    public CadastroAluno() {
        initComponents();
        
        
    }

    public void limparCampos(){
        tfMatricula.setText("");
        tfNome.setText("");
        tfEmail.setText("");
        tfCpf.setText("");
        tfTelefone.setText("");
        btnFoto.setIcon(new ImageIcon(getClass().getResource("")));
        aluno = new Aluno();
    }
    
    public void selecionarFoto(){
        BufferedImage bi;
        File file;
        selecionarFoto.setFileFilter(new javax.swing.filechooser.FileFilter() {
            public boolean accept(File f) {
                return (f.getName().endsWith(".jpg")) || f.isDirectory();
            }

            public String getDescription() {
                return "Arquivos em Formato (*.jpg)";
            }
        });
        int returnVal = selecionarFoto.showOpenDialog(this);
        if (returnVal == selecionarFoto.APPROVE_OPTION) {
            try {
                file = selecionarFoto.getSelectedFile();
                bi = ImageIO.read(file);//carrega a imagem real num buffer  
                BufferedImage aux = new BufferedImage(120, 140, bi.getType());//cria um buffer auxiliar com o tamanho desejado    
                Graphics2D g = aux.createGraphics();//pega a classe graphics do aux para edicao    
                AffineTransform at = AffineTransform.getScaleInstance((double) 120 / bi.getWidth(), (double) 140 / bi.getHeight());//cria a transformacao  
                g.drawRenderedImage(bi, at);//pinta e transforma a imagem real no auxiliar 
                // Capturar foto formatada e converter bytes pra salvar
                ImageIcon foto = new ImageIcon();
                foto.setImage(aux);
                btnFoto.setIcon(foto);
                aluno.setFotoAluno(Util.imageToByte(aux));

            } catch (IOException e) {
                JOptionPane.showMessageDialog(rootPane, "Não foi possível carregar essa imagem",
                        "Erro ao carregar imagem", JOptionPane.ERROR_MESSAGE);
                btnFoto.setIcon(new ImageIcon(getClass().getResource("")));
            }

        }
    }
    
    public boolean existeMatricula(){
        List<Aluno> lista = alunoDAO.checkExistseq("matricula", tfMatricula.getText());
        if(!lista.isEmpty()){
            JOptionPane.showMessageDialog(null, "Já existe um Aluno cadastrado com essa matrícula");
            tfMatricula.setText("");
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        selecionarFoto = new javax.swing.JFileChooser();
        tfNome = new javax.swing.JTextField();
        tfEmail = new javax.swing.JTextField();
        btnExcluir = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        tfMatricula = new javax.swing.JFormattedTextField();
        tfCpf = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        btnPesquisar = new javax.swing.JButton();
        tfTelefone = new javax.swing.JFormattedTextField();
        btnFoto = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfNome.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        tfNome.setAlignmentX(10.0F);
        tfNome.setBorder(null);
        tfNome.setMargin(null);
        tfNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNomeActionPerformed(evt);
            }
        });
        getContentPane().add(tfNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 274, 590, 35));

        tfEmail.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        tfEmail.setBorder(null);
        tfEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEmailActionPerformed(evt);
            }
        });
        getContentPane().add(tfEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 323, 590, 35));

        btnExcluir.setBorder(null);
        btnExcluir.setContentAreaFilled(false);
        btnExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(558, 507, 121, 36));

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botaosalvar.png"))); // NOI18N
        btnSalvar.setBorder(null);
        btnSalvar.setBorderPainted(false);
        btnSalvar.setContentAreaFilled(false);
        btnSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(706, 507, 121, 36));

        btnLimpar.setBorder(null);
        btnLimpar.setContentAreaFilled(false);
        btnLimpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 507, 121, 36));

        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botaovoltar.png"))); // NOI18N
        btnVoltar.setBorder(null);
        btnVoltar.setContentAreaFilled(false);
        btnVoltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(btnVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 507, -1, -1));

        tfMatricula.setBorder(null);
        try {
            tfMatricula.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfMatricula.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tfMatricula.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        tfMatricula.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfMatriculaFocusLost(evt);
            }
        });
        getContentPane().add(tfMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(233, 423, 190, 35));

        tfCpf.setBorder(null);
        try {
            tfCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfCpf.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        getContentPane().add(tfCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 374, 250, 35));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/labelmatricula.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 420, -1, -1));

        btnPesquisar.setBorder(null);
        btnPesquisar.setBorderPainted(false);
        btnPesquisar.setContentAreaFilled(false);
        btnPesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPesquisar.setFocusPainted(false);
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });
        getContentPane().add(btnPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 507, 125, 36));

        tfTelefone.setBorder(null);
        try {
            tfTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) # ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfTelefone.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        getContentPane().add(tfTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 374, 220, 35));

        btnFoto.setBorder(null);
        btnFoto.setBorderPainted(false);
        btnFoto.setContentAreaFilled(false);
        btnFoto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFotoActionPerformed(evt);
            }
        });
        getContentPane().add(btnFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 267, 120, 150));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/TelaCadastroAluno.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tfNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNomeActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if(!tfNome.getText().equals("") && !tfEmail.getText().equals("") && !tfMatricula.getText().equals("          ")) {
            aluno.setNome(tfNome.getText());
            aluno.setEmail(tfEmail.getText());
            aluno.setMatricula(tfMatricula.getText());
            aluno.setCpf(tfCpf.getText());
            aluno.setTelefone(tfTelefone.getText());
            if(!existeMatricula()){
                alunoDAO.salvar(aluno);
                limparCampos();
                btnFoto.setIcon(new ImageIcon(getClass().getResource("")));
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Verifique se os campos estão preenchidos corretamente!");
        }    
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparCampos();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
     Object[] options = {"Sim", "Não"};
        if (aluno.getId()!= 0) {
            if (JOptionPane.showOptionDialog(rootPane, "Deseja excluir o(a) aluno(a) " + aluno.getNome()
                    + "?", "InspectMonitorPoint", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == JOptionPane.YES_OPTION) {
                if (alunoDAO.remover(aluno)) {
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Não foi possível excluir o(a) aluno(a) " + aluno.getNome(),
                            "Erro ao Excluir", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "A exclusão foi cancelada!");
            }
        limparCampos();
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        List<Aluno> lista = alunoDAO.listar();
        AlunoTableModel model = new AlunoTableModel(lista);
        Object objetoRetorno = PesquisaGenerica.exibeTela(model, "Aluno");
        if(objetoRetorno != null){
            aluno = alunoDAO.consultarObjetoId("id", objetoRetorno);
            tfCpf.setText(aluno.getCpf());
            tfEmail.setText(aluno.getEmail());
            tfMatricula.setText(aluno.getMatricula());
            tfNome.setText(aluno.getNome());
            tfTelefone.setText(aluno.getTelefone());
            try {
                ImageIcon foto = new ImageIcon();
                foto.setImage(Util.byteToImage(aluno.getFotoAluno()));
                btnFoto.setIcon(foto);
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void tfEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfEmailActionPerformed

    private void btnFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFotoActionPerformed
        selecionarFoto();
    }//GEN-LAST:event_btnFotoActionPerformed

    private void tfMatriculaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfMatriculaFocusLost
        
    }//GEN-LAST:event_tfMatriculaFocusLost

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
            java.util.logging.Logger.getLogger(CadastroAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroAluno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFoto;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JFileChooser selecionarFoto;
    private javax.swing.JFormattedTextField tfCpf;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JFormattedTextField tfMatricula;
    private javax.swing.JTextField tfNome;
    private javax.swing.JFormattedTextField tfTelefone;
    // End of variables declaration//GEN-END:variables
}
