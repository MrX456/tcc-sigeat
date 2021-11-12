/*
 * Tela de carregamento do SIGEAT
 */
package com.sigeat.app;

import com.sigeat.connection.ConnectionFactory;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.MemoryImageSource;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/*
 * SIGEAT/ Application /Splash Screen
 * @author Junior
 * Version : 1.0.0
 */
public class FrmSplashScreen extends javax.swing.JFrame {

    public FrmSplashScreen() {

        initComponents();
        // Custom icon for jar and Jframe
        /*this.setIconImage(CoolStuff.createIcon().getImage());*/
        hideCursor();
        fillBar();
    }

    //Fill progress bar method
    private void fillBar() {
        pbLoading.setVisible(false);
        new Thread() {
            @Override
            public void run() {

                for (int i = 0; i < 101; i++) {
                    try {

                        sleep(60);
                        pbLoading.setValue(i);

                        //Testar conexão 
                        if (i == 30) {
                            try {
                                lblStatus.setText("Tentando conectar ao banco de dados...");
                                EntityManager emf = ConnectionFactory.getConnection();
                                emf.close();
                            }
                            catch(ExceptionInInitializerError e) {
                                FrmSplashScreen.this.dispose();

                                JOptionPane.showMessageDialog(null, "Não foi possivel conectar-se ao banco de dados!"
                                        + "\nVerifique se o banco de dados está em execução!",
                                        "Erro de conexão", JOptionPane.ERROR_MESSAGE);
                                //Fechar aplicação
                                System.exit(0);
                            }
                        } else if (i == 80) {
                            lblStatus.setText("Carregando dados...");
                        }

                    } catch (Exception e) {

                        e.printStackTrace();
                    }

                }
                FrmSplashScreen.this.dispose();
                FrmLogin login = new FrmLogin();
                login.setVisible(true);
            }
        }.start();
    }

    private void hideCursor() {
        int[] pixels = new int[16 * 16];
        Image img = Toolkit.getDefaultToolkit().createImage(
                new MemoryImageSource(16, 16, pixels, 0, 16));
        Cursor transparentCursor
                = Toolkit.getDefaultToolkit().createCustomCursor(img, new Point(0, 0), "invisible cursor");
        this.setCursor(transparentCursor);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pbLoading = new javax.swing.JProgressBar();
        lblStatus = new javax.swing.JLabel();
        lblWallPaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImages(null);
        setUndecorated(true);
        getContentPane().setLayout(null);
        getContentPane().add(pbLoading);
        pbLoading.setBounds(80, 240, 280, 20);

        lblStatus.setForeground(new java.awt.Color(255, 255, 255));
        lblStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblStatus);
        lblStatus.setBounds(100, 260, 230, 20);

        lblWallPaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/sigeat/images/splash_screen.png"))); // NOI18N
        getContentPane().add(lblWallPaper);
        lblWallPaper.setBounds(0, 0, 440, 280);

        setSize(new java.awt.Dimension(439, 279));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(FrmSplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmSplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmSplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmSplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmSplashScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblWallPaper;
    private javax.swing.JProgressBar pbLoading;
    // End of variables declaration//GEN-END:variables
}
