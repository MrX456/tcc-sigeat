/*
 * Tela principal do SIGEAT
 */

package com.sigeat.app;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;
//para gerar relatórios
import java.sql.*;

/*
 * SIGEAT/ Application /Home
 * @author Junior
 * Version : 1.0.0
 */

public class FrmHome extends javax.swing.JFrame {

    Connection conexao = null;
    
    public FrmHome() {
        initComponents();
        
        /*conexao = ModuloConexao.conector();*/
        
        this.setExtendedState(MAXIMIZED_BOTH);
        //mitUsuarios.setEnabled(false);
    }
    
    private void sair() {
        int exit = JOptionPane.showConfirmDialog(null, "Deseja sair do SIGEAT?",
                "Sair?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if(exit == 0)
            System.exit(0);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panFundo = new javax.swing.JPanel();
        lblSigeat = new javax.swing.JLabel();
        imgLogo = new javax.swing.JLabel();
        lblSair = new javax.swing.JLabel();
        Desktop = new javax.swing.JDesktopPane();
        menMenu = new javax.swing.JMenuBar();
        mitUsuarios = new javax.swing.JMenu();
        mitUsuariosNovo = new javax.swing.JMenuItem();
        mitUsuariosPesquisar = new javax.swing.JMenuItem();
        mitClientes = new javax.swing.JMenu();
        mitClientesNovo = new javax.swing.JMenuItem();
        mitClientesPesquisar = new javax.swing.JMenuItem();
        mitServicos = new javax.swing.JMenu();
        mitServicosOS = new javax.swing.JMenuItem();
        mitRelatorios = new javax.swing.JMenu();
        mitRelatoriosUsuarios = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mitRelatoriosClientes = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mitRelatoriosOS = new javax.swing.JMenuItem();
        mitFerramentas = new javax.swing.JMenu();
        mitAjuda = new javax.swing.JMenu();
        mitAjudaSobre = new javax.swing.JMenuItem();
        mitOpcoes = new javax.swing.JMenu();
        mitOpcoesSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SIGEAT - Tela principal");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        panFundo.setBackground(new java.awt.Color(215, 232, 242));

        lblSigeat.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblSigeat.setForeground(new java.awt.Color(65, 167, 190));
        lblSigeat.setText("SIGEAT");

        imgLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/sigeat/images/logo.png"))); // NOI18N

        lblSair.setBackground(new java.awt.Color(215, 232, 242));
        lblSair.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblSair.setForeground(new java.awt.Color(0, 51, 102));
        lblSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/sigeat/images/power-24.png"))); // NOI18N
        lblSair.setText("Sair");
        lblSair.setToolTipText("");
        lblSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSair.setOpaque(true);
        lblSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSairMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblSairMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblSairMouseExited(evt);
            }
        });

        javax.swing.GroupLayout DesktopLayout = new javax.swing.GroupLayout(Desktop);
        Desktop.setLayout(DesktopLayout);
        DesktopLayout.setHorizontalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        DesktopLayout.setVerticalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 538, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panFundoLayout = new javax.swing.GroupLayout(panFundo);
        panFundo.setLayout(panFundoLayout);
        panFundoLayout.setHorizontalGroup(
            panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFundoLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(imgLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSigeat, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 945, Short.MAX_VALUE)
                .addComponent(lblSair, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(Desktop)
        );
        panFundoLayout.setVerticalGroup(
            panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFundoLayout.createSequentialGroup()
                .addGroup(panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panFundoLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(imgLogo)
                            .addComponent(lblSigeat, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panFundoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblSair)))
                .addGap(18, 18, 18)
                .addComponent(Desktop))
        );

        mitUsuarios.setText("Usuários");
        mitUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        mitUsuariosNovo.setText("Novo");
        mitUsuariosNovo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mitUsuariosNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitUsuariosNovoActionPerformed(evt);
            }
        });
        mitUsuarios.add(mitUsuariosNovo);

        mitUsuariosPesquisar.setText("Pesquisar");
        mitUsuariosPesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mitUsuariosPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitUsuariosPesquisarActionPerformed(evt);
            }
        });
        mitUsuarios.add(mitUsuariosPesquisar);

        menMenu.add(mitUsuarios);

        mitClientes.setText("Clientes");
        mitClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        mitClientesNovo.setText("Novo");
        mitClientesNovo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mitClientesNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitClientesNovoActionPerformed(evt);
            }
        });
        mitClientes.add(mitClientesNovo);

        mitClientesPesquisar.setText("Pesquisar");
        mitClientesPesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mitClientesPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitClientesPesquisarActionPerformed(evt);
            }
        });
        mitClientes.add(mitClientesPesquisar);

        menMenu.add(mitClientes);

        mitServicos.setText("Serviços");
        mitServicos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        mitServicosOS.setText("OS");
        mitServicosOS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mitServicosOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitServicosOSActionPerformed(evt);
            }
        });
        mitServicos.add(mitServicosOS);

        menMenu.add(mitServicos);

        mitRelatorios.setText("Relatórios");
        mitRelatorios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        mitRelatoriosUsuarios.setText("Usuários");
        mitRelatoriosUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mitRelatorios.add(mitRelatoriosUsuarios);
        mitRelatorios.add(jSeparator1);

        mitRelatoriosClientes.setText("Clientes");
        mitRelatoriosClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mitRelatorios.add(mitRelatoriosClientes);
        mitRelatorios.add(jSeparator2);

        mitRelatoriosOS.setText("OS");
        mitRelatoriosOS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mitRelatorios.add(mitRelatoriosOS);

        menMenu.add(mitRelatorios);

        mitFerramentas.setText("Ferramentas");
        mitFerramentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menMenu.add(mitFerramentas);

        mitAjuda.setText("Ajuda");
        mitAjuda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        mitAjudaSobre.setText("Sobre");
        mitAjudaSobre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mitAjudaSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitAjudaSobreActionPerformed(evt);
            }
        });
        mitAjuda.add(mitAjudaSobre);

        menMenu.add(mitAjuda);

        mitOpcoes.setText("Opções");
        mitOpcoes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        mitOpcoesSair.setText("Sair");
        mitOpcoesSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mitOpcoesSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitOpcoesSairActionPerformed(evt);
            }
        });
        mitOpcoes.add(mitOpcoesSair);

        menMenu.add(mitOpcoes);

        setJMenuBar(menMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panFundo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1280, 690));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        mostraData();
    }//GEN-LAST:event_formWindowActivated

    private void mitUsuariosNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitUsuariosNovoActionPerformed
        Screens.abrirUsuarioCadastroWindow(Desktop);
    }//GEN-LAST:event_mitUsuariosNovoActionPerformed

    private void mitAjudaSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitAjudaSobreActionPerformed
        Screens.abrirSobre();
    }//GEN-LAST:event_mitAjudaSobreActionPerformed

    private void mitOpcoesSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitOpcoesSairActionPerformed
        this.sair();
    }//GEN-LAST:event_mitOpcoesSairActionPerformed

    private void lblSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSairMouseClicked
        this.sair();
    }//GEN-LAST:event_lblSairMouseClicked

    private void lblSairMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSairMouseEntered
        lblSair.setBackground(new Color(185, 202, 212));
    }//GEN-LAST:event_lblSairMouseEntered

    private void lblSairMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSairMouseExited
        lblSair.setBackground(new Color(215, 232, 242));
    }//GEN-LAST:event_lblSairMouseExited

    private void mitUsuariosPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitUsuariosPesquisarActionPerformed
        Screens.abrirUsuarioPesquisaWindow(Desktop);
    }//GEN-LAST:event_mitUsuariosPesquisarActionPerformed

    private void mitClientesNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitClientesNovoActionPerformed
        Screens.abrirClienteCadastroWindow(Desktop);
    }//GEN-LAST:event_mitClientesNovoActionPerformed

    private void mitClientesPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitClientesPesquisarActionPerformed
        Screens.abrirClientePesquisaWindow(Desktop);
    }//GEN-LAST:event_mitClientesPesquisarActionPerformed

    private void mitServicosOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitServicosOSActionPerformed
        Screens.abrirOSWindow(Desktop);
    }//GEN-LAST:event_mitServicosOSActionPerformed

    //Método que mostra data e hora atual
    private void mostraData() {
        new Timer(0, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Date data = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy - kk:mm:ss");
                 // Colocando data e hora atual na label
                //lblData.setText(sdf.format(data));
            }
            
        }).start();
    }
    
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
            java.util.logging.Logger.getLogger(FrmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Desktop;
    private javax.swing.JLabel imgLogo;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JLabel lblSair;
    private javax.swing.JLabel lblSigeat;
    private javax.swing.JMenuBar menMenu;
    private javax.swing.JMenu mitAjuda;
    private javax.swing.JMenuItem mitAjudaSobre;
    private javax.swing.JMenu mitClientes;
    private javax.swing.JMenuItem mitClientesNovo;
    private javax.swing.JMenuItem mitClientesPesquisar;
    private javax.swing.JMenu mitFerramentas;
    private javax.swing.JMenu mitOpcoes;
    private javax.swing.JMenuItem mitOpcoesSair;
    private javax.swing.JMenu mitRelatorios;
    private javax.swing.JMenuItem mitRelatoriosClientes;
    private javax.swing.JMenuItem mitRelatoriosOS;
    private javax.swing.JMenuItem mitRelatoriosUsuarios;
    private javax.swing.JMenu mitServicos;
    private javax.swing.JMenuItem mitServicosOS;
    private javax.swing.JMenu mitUsuarios;
    private javax.swing.JMenuItem mitUsuariosNovo;
    private javax.swing.JMenuItem mitUsuariosPesquisar;
    private javax.swing.JPanel panFundo;
    // End of variables declaration//GEN-END:variables
}
