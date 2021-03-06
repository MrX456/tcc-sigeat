/*
 * Tela de geração do relatório de clientes
 */
package com.sigeat.app;

import com.sigeat.model.bean.Clientes;
import com.sigeat.model.dao.ClientesDAO;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/*
 * SIGEAT/ Application / Clientes/ Report
 * @author Junior
 * Version : 1.0.0
 */
public class FrmClientesReports extends javax.swing.JDialog {

    /**
     * Creates new form FrmClientesReports
     */
    public FrmClientesReports(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        panTable.setVisible(false);
        
        ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getClass().getResource("/com/sigeat/images/logo_big.png"));
        this.setIconImage(icon.getImage());
        
        this.mostrarDados();
    }

    private void mostrarDados() {
        ClientesDAO dao = new ClientesDAO();
        List<Clientes> clientes = dao.findAll();
        this.popularTabela(clientes);
    }

    private void popularTabela(List<Clientes> clientes) {
        DefaultTableModel model = new DefaultTableModel();
        tblClientes.setModel(model);

        model.addColumn("Id");
        model.addColumn("Nome");
        model.addColumn("Endereço");
        model.addColumn("Telefone");
        model.addColumn("Email");

        for (Clientes c : clientes) {
            model.addRow(
                    new Object[]{
                        c.getId(),
                        c.getNome(),
                        c.getEndereco(),
                        c.getTelefone(),
                        c.getEmail()
                    }
            );
        }

        tblClientes.getColumnModel().getColumn(0).setMinWidth(25);
        tblClientes.getColumnModel().getColumn(1).setMinWidth(150);

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblMsg = new javax.swing.JLabel();
        btnSim = new javax.swing.JButton();
        btnNao = new javax.swing.JButton();
        panTable = new javax.swing.JPanel();
        jScrollPane = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerar relatório");

        lblMsg.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblMsg.setText("Deseja gerar um relatório de clientes?");

        btnSim.setText("Sim");
        btnSim.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimActionPerformed(evt);
            }
        });

        btnNao.setText("Não");
        btnNao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNaoActionPerformed(evt);
            }
        });

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        tblClientes.setToolTipText("Clique sobre o registro desejado para editar");
        tblClientes.setOpaque(false);
        jScrollPane.setViewportView(tblClientes);

        javax.swing.GroupLayout panTableLayout = new javax.swing.GroupLayout(panTable);
        panTable.setLayout(panTableLayout);
        panTableLayout.setHorizontalGroup(
            panTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 191, Short.MAX_VALUE)
            .addGroup(panTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panTableLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        panTableLayout.setVerticalGroup(
            panTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(panTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panTableLayout.createSequentialGroup()
                    .addGap(6, 6, 6)
                    .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMsg)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(btnSim, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnNao, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblMsg)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSim)
                    .addComponent(btnNao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panTable, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimActionPerformed

        Reports rep = new Reports();
        rep.createUserReportFolder();//Criar pasta se não existir

        //Salvar código. Abrir na pasta criada para salvar códigos
        JFileChooser save = new JFileChooser(System.getProperty("user.home") + "\\Documents\\SIGEAT\\Meus Relatórios");
        save.setDialogTitle("Salvar relatório");
        save.setAcceptAllFileFilterUsed(false); //remove "all files option"
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF", "pdf");
        save.setFileFilter(filter);
        int excelChooser = save.showSaveDialog(null);

        if (excelChooser == JFileChooser.APPROVE_OPTION) {
            String total = String.valueOf(tblClientes.getRowCount());
            String path = save.getSelectedFile().getAbsolutePath() + ".pdf";
            String tableName = "Clientes Cadastrados";
            rep.tableReports(tblClientes, total, path, tableName);

        }

        this.dispose();
    }//GEN-LAST:event_btnSimActionPerformed

    private void btnNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNaoActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnNaoActionPerformed

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
            java.util.logging.Logger.getLogger(FrmClientesReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmClientesReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmClientesReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmClientesReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmClientesReports dialog = new FrmClientesReports(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnNao;
    private javax.swing.JButton btnSim;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JLabel lblMsg;
    private javax.swing.JPanel panTable;
    private javax.swing.JTable tblClientes;
    // End of variables declaration//GEN-END:variables
}
