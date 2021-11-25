/*
 * Tela principal do SIGEAT
 */
package com.sigeat.app;

import com.sigeat.controller.Session;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.sql.*;
import java.util.Locale;
import javax.swing.ImageIcon;

/*
 * SIGEAT/ Application /Home
 * @author Junior
 * Version : 1.0.0
 */
public class FrmHome extends javax.swing.JFrame {

    public FrmHome() {

        initComponents();
        mitUsuarios.setVisible(false);
        mitRelatorios.setVisible(false);

        this.setTitle("SIGEAT - " + Session.getNome());
        lblUsuario.setText(Session.getLogin());

        this.setPermissao();

        this.setExtendedState(MAXIMIZED_BOTH);

        ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getClass().getResource("/com/sigeat/images/logo_big.png"));
        this.setIconImage(icon.getImage());
    }

    private void sair() {
        int exit = JOptionPane.showConfirmDialog(null, "Deseja sair do SIGEAT?",
                "Sair?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (exit == 0) {
            System.exit(0);
        }
    }

    private void setPermissao() {
        if (Session.getPerfil().equals("administrador")) {
            mitUsuarios.setVisible(true);
            mitRelatorios.setVisible(true);
        }
    }
    
    private void mostraData() {
        new Timer(0, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Date data = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy - kk:mm:ss");
                // Colocando data e hora atual na label
                lblData.setText(sdf.format(data));
                SimpleDateFormat sdf2 = new SimpleDateFormat("EEEE", new Locale("pt", "BR"));
                lblDayofWeek.setText(sdf2.format(data));
            }

        }).start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panFundo = new javax.swing.JPanel();
        lblSigeat = new javax.swing.JLabel();
        imgLogo = new javax.swing.JLabel();
        lblSair = new javax.swing.JLabel();
        Desktop = new javax.swing.JDesktopPane();
        lblUsuario = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        lblDayofWeek = new javax.swing.JLabel();
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
        mitFerramentasCalculadora = new javax.swing.JMenuItem();
        mitFerramentasCalendario = new javax.swing.JMenuItem();
        mitAjuda = new javax.swing.JMenu();
        mitAjudaSobre = new javax.swing.JMenuItem();
        mitAjudaAtalhos = new javax.swing.JMenuItem();
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
            .addGap(0, 535, Short.MAX_VALUE)
        );

        lblUsuario.setForeground(new java.awt.Color(102, 102, 102));
        lblUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsuario.setText("..");

        lblData.setBackground(new java.awt.Color(215, 232, 242));
        lblData.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblData.setForeground(new java.awt.Color(0, 51, 102));
        lblData.setText("Data");
        lblData.setToolTipText("");
        lblData.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblData.setOpaque(true);

        lblDayofWeek.setBackground(new java.awt.Color(215, 232, 242));
        lblDayofWeek.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblDayofWeek.setForeground(new java.awt.Color(0, 51, 102));
        lblDayofWeek.setText("day of week");
        lblDayofWeek.setToolTipText("");
        lblDayofWeek.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblDayofWeek.setOpaque(true);

        javax.swing.GroupLayout panFundoLayout = new javax.swing.GroupLayout(panFundo);
        panFundo.setLayout(panFundoLayout);
        panFundoLayout.setHorizontalGroup(
            panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFundoLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(imgLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSigeat, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 784, Short.MAX_VALUE)
                .addGroup(panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblData, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panFundoLayout.createSequentialGroup()
                            .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblSair, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap()))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panFundoLayout.createSequentialGroup()
                        .addComponent(lblDayofWeek, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))))
            .addComponent(Desktop)
        );
        panFundoLayout.setVerticalGroup(
            panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFundoLayout.createSequentialGroup()
                .addGroup(panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panFundoLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(imgLogo)
                            .addComponent(lblSigeat, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panFundoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSair)
                            .addComponent(lblUsuario))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDayofWeek, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblData)))
                .addGap(18, 18, 18)
                .addComponent(Desktop))
        );

        mitUsuarios.setText("Usuários");
        mitUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        mitUsuariosNovo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.ALT_MASK));
        mitUsuariosNovo.setText("Novo");
        mitUsuariosNovo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mitUsuariosNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitUsuariosNovoActionPerformed(evt);
            }
        });
        mitUsuarios.add(mitUsuariosNovo);

        mitUsuariosPesquisar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_MASK));
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

        mitClientesNovo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.ALT_MASK));
        mitClientesNovo.setText("Novo");
        mitClientesNovo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mitClientesNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitClientesNovoActionPerformed(evt);
            }
        });
        mitClientes.add(mitClientesNovo);

        mitClientesPesquisar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
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

        mitServicosOS.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.ALT_MASK));
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
        mitRelatoriosUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitRelatoriosUsuariosActionPerformed(evt);
            }
        });
        mitRelatorios.add(mitRelatoriosUsuarios);
        mitRelatorios.add(jSeparator1);

        mitRelatoriosClientes.setText("Clientes");
        mitRelatoriosClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mitRelatoriosClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitRelatoriosClientesActionPerformed(evt);
            }
        });
        mitRelatorios.add(mitRelatoriosClientes);
        mitRelatorios.add(jSeparator2);

        mitRelatoriosOS.setText("OS");
        mitRelatoriosOS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mitRelatoriosOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitRelatoriosOSActionPerformed(evt);
            }
        });
        mitRelatorios.add(mitRelatoriosOS);

        menMenu.add(mitRelatorios);

        mitFerramentas.setText("Ferramentas");
        mitFerramentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        mitFerramentasCalculadora.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.ALT_MASK));
        mitFerramentasCalculadora.setText("Calculadora");
        mitFerramentasCalculadora.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mitFerramentasCalculadora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitFerramentasCalculadoraActionPerformed(evt);
            }
        });
        mitFerramentas.add(mitFerramentasCalculadora);

        mitFerramentasCalendario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        mitFerramentasCalendario.setText("Calendário");
        mitFerramentasCalendario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mitFerramentasCalendario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitFerramentasCalendarioActionPerformed(evt);
            }
        });
        mitFerramentas.add(mitFerramentasCalendario);

        menMenu.add(mitFerramentas);

        mitAjuda.setText("Ajuda");
        mitAjuda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        mitAjudaSobre.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        mitAjudaSobre.setText("Sobre");
        mitAjudaSobre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mitAjudaSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitAjudaSobreActionPerformed(evt);
            }
        });
        mitAjuda.add(mitAjudaSobre);

        mitAjudaAtalhos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_MASK));
        mitAjudaAtalhos.setText("Atalhos de Teclado");
        mitAjudaAtalhos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mitAjudaAtalhos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitAjudaAtalhosActionPerformed(evt);
            }
        });
        mitAjuda.add(mitAjudaAtalhos);

        menMenu.add(mitAjuda);

        mitOpcoes.setText("Opções");
        mitOpcoes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        mitOpcoesSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
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

    private void mitRelatoriosUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitRelatoriosUsuariosActionPerformed
        Screens.abrirUsuariosReport();
    }//GEN-LAST:event_mitRelatoriosUsuariosActionPerformed

    private void mitRelatoriosClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitRelatoriosClientesActionPerformed
        Screens.abrirClientesReport();
    }//GEN-LAST:event_mitRelatoriosClientesActionPerformed

    private void mitRelatoriosOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitRelatoriosOSActionPerformed
        Screens.abrirOSReport();
    }//GEN-LAST:event_mitRelatoriosOSActionPerformed

    private void mitFerramentasCalculadoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitFerramentasCalculadoraActionPerformed
        Screens.abrirCalculadora();
    }//GEN-LAST:event_mitFerramentasCalculadoraActionPerformed

    private void mitFerramentasCalendarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitFerramentasCalendarioActionPerformed
        Screens.abrirCalendario();
    }//GEN-LAST:event_mitFerramentasCalendarioActionPerformed

    private void mitAjudaAtalhosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitAjudaAtalhosActionPerformed
        Screens.abrirAtalhos();
    }//GEN-LAST:event_mitAjudaAtalhosActionPerformed

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
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblDayofWeek;
    private javax.swing.JLabel lblSair;
    private javax.swing.JLabel lblSigeat;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JMenuBar menMenu;
    private javax.swing.JMenu mitAjuda;
    private javax.swing.JMenuItem mitAjudaAtalhos;
    private javax.swing.JMenuItem mitAjudaSobre;
    private javax.swing.JMenu mitClientes;
    private javax.swing.JMenuItem mitClientesNovo;
    private javax.swing.JMenuItem mitClientesPesquisar;
    private javax.swing.JMenu mitFerramentas;
    private javax.swing.JMenuItem mitFerramentasCalculadora;
    private javax.swing.JMenuItem mitFerramentasCalendario;
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
