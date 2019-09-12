/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import util.FormataTamanhoColunasJTable;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Adriano Lima
 */
public class PesquisaGenerica extends javax.swing.JDialog {

    private static Object objeto;

    public static Object exibeTela(AbstractTableModel atm, String pesquisa) {
        PesquisaGenerica tp = new PesquisaGenerica(atm, pesquisa);
        tp.setVisible(true);
        return objeto;

    }

    private PesquisaGenerica(AbstractTableModel atm, String pesquisa) {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/birdpoint/imagens/logo-1.png")).getImage());
        tbPesquisa.setAutoCreateRowSorter(true);
        tbPesquisa.setModel(atm);
        setLocationRelativeTo(null);
        tbPesquisa.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        FormataTamanhoColunasJTable.packColumns(tbPesquisa, 1);
        tfPesquisa.grabFocus();
        btEditar.setEnabled(false);
        this.setIconImage(new ImageIcon(getClass().getResource("/birdpoint/imagens/logo-1.png")).getImage());
        setModal(true);
    }

    public PesquisaGenerica(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    private void procuraTable(String nome) {
        for (int linha = 0; linha < tbPesquisa.getRowCount(); linha++) {
            String nomeTabela = String.valueOf(tbPesquisa.getValueAt(linha, 1));
            if (nomeTabela.toLowerCase().startsWith(nome.toLowerCase())) {
                tbPesquisa.setRowSelectionInterval(linha, linha);
                JViewport viewport = (JViewport) tbPesquisa.getParent();
                Rectangle rect = tbPesquisa.getCellRect(linha, 1, true);
                Point pt = viewport.getViewPosition();
                rect.setLocation(rect.x - pt.x, rect.y - pt.y);
                viewport.scrollRectToVisible(rect);
                break;
            }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tbPesquisa = new javax.swing.JTable();
        btEditar = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();
        tfPesquisa = new javax.swing.JTextField();
        jlPesquisar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(602, 421));
        setModal(true);
        setUndecorated(true);
        getContentPane().setLayout(null);

        tbPesquisa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbPesquisa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tbPesquisaFocusGained(evt);
            }
        });
        tbPesquisa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPesquisaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbPesquisa);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 100, 560, 240);

        btEditar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/birdpoint/imagens/editar.png"))); // NOI18N
        btEditar.setText("Selecionar");
        btEditar.setContentAreaFilled(false);
        btEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });
        getContentPane().add(btEditar);
        btEditar.setBounds(240, 350, 110, 60);

        btVoltar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/birdpoint/imagens/voltar.png"))); // NOI18N
        btVoltar.setText("Voltar");
        btVoltar.setContentAreaFilled(false);
        btVoltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btVoltar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btVoltar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(btVoltar);
        btVoltar.setBounds(10, 350, 80, 60);

        tfPesquisa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfPesquisaKeyPressed(evt);
            }
        });
        getContentPane().add(tfPesquisa);
        tfPesquisa.setBounds(100, 53, 340, 30);

        jlPesquisar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/birdpoint/imagens/pesquisar_1.png"))); // NOI18N
        jlPesquisar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jlPesquisar);
        jlPesquisar.setBounds(0, 0, 2, 420);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        int row = tbPesquisa.getSelectedRow();
        if (row > -1) {
            objeto = tbPesquisa.getValueAt(row, 0);
            dispose();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione o Ítem!",
                    "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btEditarActionPerformed

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        objeto = null;
        dispose();
    }//GEN-LAST:event_btVoltarActionPerformed

    private void tbPesquisaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tbPesquisaFocusGained
        btEditar.setEnabled(true);
    }//GEN-LAST:event_tbPesquisaFocusGained

    private void tbPesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPesquisaMouseClicked
        if (evt.getClickCount() == 2) {
            btEditarActionPerformed(null);
        }
    }//GEN-LAST:event_tbPesquisaMouseClicked

    private void tfPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPesquisaKeyPressed
        procuraTable(tfPesquisa.getText());

    }//GEN-LAST:event_tfPesquisaKeyPressed

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
            java.util.logging.Logger.getLogger(PesquisaGenerica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PesquisaGenerica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PesquisaGenerica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PesquisaGenerica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PesquisaGenerica dialog = new PesquisaGenerica(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btVoltar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlPesquisar;
    private javax.swing.JTable tbPesquisa;
    private javax.swing.JTextField tfPesquisa;
    // End of variables declaration//GEN-END:variables

}
