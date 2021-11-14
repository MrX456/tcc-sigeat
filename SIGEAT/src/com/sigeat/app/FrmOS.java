/*
 * Tela de gerenciamento de os
 */
package com.sigeat.app;

import com.sigeat.controller.Controller;
import com.sigeat.controller.ControllerOS;
import com.sigeat.model.bean.Clientes;
import com.sigeat.model.bean.OS;
import com.sigeat.model.dao.ClientesDAO;
import com.sigeat.model.dao.OSDAO;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * SIGEAT/ Application / OS
 * @author Junior
 * Version : 1.0.0
 */
public class FrmOS extends javax.swing.JInternalFrame {

    //Esta variavel armazena a opção selecionada pelo radio button
    private String tipo;

    /**
     * Creates new form FrmOS
     */
    public FrmOS() {
        initComponents();
        radOrcamento.setSelected(true);
        tipo = "Orçamento";
    }

    private void filtrarDados() {
        ClientesDAO dao = new ClientesDAO();
        List<Clientes> clientes = dao.findByNomeLike(txtNome.getText());
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
            model.addRow(new Object[]{
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

    private void setCliente() {
        int puts = tblClientes.getSelectedRow();

        txtID.setText(tblClientes.getModel().getValueAt(puts, 0).toString());
        txtNome.setText(tblClientes.getModel().getValueAt(puts, 1).toString());
        btnCadastrar.setEnabled(true);
        btnPesquisar.setEnabled(false);
        btnAtualizar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnImprimir.setEnabled(false);

    }

    private OS setOS() {
        Clientes cliente = new Clientes();
        cliente.setId(Integer.parseInt(txtID.getText()));
        cliente.setNome(txtNome.getText());

        OS os = new OS();
        if (!txtOs.getText().isEmpty()) {
            os.setNmr_os(Integer.parseInt(txtOs.getText()));
        }
        os.setTipo(tipo);
        os.setSituacao(cboSituacao.getSelectedItem().toString());
        os.setEquipamento(txtEquipamento.getText());
        os.setDefeito(txtDefeito.getText());
        os.setServico(txtServico.getText());
        os.setTecnico(txtTecnico.getText());
        if (txtValorTotal.getText().isEmpty()) {
            os.setValor(BigDecimal.ZERO);
        } else {
            os.setValor(new BigDecimal(txtValorTotal.getText().replace(",", ".")));
        }
        os.setCliente(cliente);

        return os;
    }

    private void pesquisarOS() {
        String num = JOptionPane.showInputDialog("Número da OS");

        Controller ctr = new Controller();
        if (ctr.isNumber(num)) {
            OSDAO dao = new OSDAO();

            // trate caso o numero pesquisado não esteja registrado
            try {
                OS o = dao.findById(Integer.parseInt(num));

                txtOs.setText(o.getNmr_os().toString());

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy - kk:mm:ss");
                txtData.setText(sdf.format(o.getDt_os()));

                String rbTipo = o.getTipo();
                if (rbTipo.equals("OS")) {
                    radOs.setSelected(true);
                    tipo = "OS";
                } else {
                    radOrcamento.setSelected(true);
                    tipo = "Orçamento";
                }

                cboSituacao.setSelectedItem(o.getSituacao());

                txtEquipamento.setText(o.getEquipamento());
                txtDefeito.setText(o.getDefeito());
                txtServico.setText(o.getServico());
                txtTecnico.setText(o.getTecnico());
                txtValorTotal.setText(o.getValor().toString().replace(".", ","));

                txtID.setText(o.getCliente().getId().toString());
                txtNome.setText(o.getCliente().getNome());

                btnCadastrar.setEnabled(false);
                btnPesquisar.setEnabled(false);
                btnAtualizar.setEnabled(true);
                btnExcluir.setEnabled(true);
                btnImprimir.setEnabled(true);
                txtNome.setEnabled(false);
                tblClientes.setVisible(false);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "OS não encontrada!",
                        "OS", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Número de OS inválido!",
                    "Erro de OS", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void limparCampos() {
        txtOs.setText("");
        txtData.setText("");
        txtEquipamento.setText("");
        txtDefeito.setText("");
        txtServico.setText("");
        txtTecnico.setText("");
        txtValorTotal.setText("");
        txtID.setText("");
        txtNome.setText("");
        radOrcamento.setSelected(true);
        cboSituacao.setSelectedIndex(0);

        btnCadastrar.setEnabled(false);
        btnPesquisar.setEnabled(true);
        btnAtualizar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnImprimir.setEnabled(false);
        txtNome.setEnabled(true);
        tblClientes.setVisible(true);

        ((DefaultTableModel) tblClientes.getModel()).setRowCount(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpTipo = new javax.swing.ButtonGroup();
        panFundo = new javax.swing.JPanel();
        panOs = new javax.swing.JPanel();
        lblOs = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        txtOs = new javax.swing.JTextField();
        txtData = new javax.swing.JTextField();
        radOrcamento = new javax.swing.JRadioButton();
        radOs = new javax.swing.JRadioButton();
        lblSituacao = new javax.swing.JLabel();
        cboSituacao = new javax.swing.JComboBox();
        panCliente = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        imgPesquisar = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        lblId = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        txtEquipamento = new javax.swing.JTextField();
        lblEquipamento = new javax.swing.JLabel();
        lblDefeito = new javax.swing.JLabel();
        txtDefeito = new javax.swing.JTextField();
        lblServico = new javax.swing.JLabel();
        txtServico = new javax.swing.JTextField();
        lblTecnico = new javax.swing.JLabel();
        txtTecnico = new javax.swing.JTextField();
        lblValorTotal = new javax.swing.JLabel();
        txtValorTotal = new javax.swing.JTextField();
        btnExcluir = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Gerenciamento de OS");

        panFundo.setBackground(new java.awt.Color(255, 255, 255));

        panOs.setBackground(new java.awt.Color(255, 255, 255));
        panOs.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblOs.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblOs.setForeground(new java.awt.Color(102, 102, 102));
        lblOs.setText("N° OS");

        lblData.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblData.setForeground(new java.awt.Color(102, 102, 102));
        lblData.setText("Data");

        txtOs.setEditable(false);

        txtData.setEditable(false);

        grpTipo.add(radOrcamento);
        radOrcamento.setForeground(new java.awt.Color(102, 102, 102));
        radOrcamento.setText("Orçamento");
        radOrcamento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        radOrcamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radOrcamentoActionPerformed(evt);
            }
        });

        grpTipo.add(radOs);
        radOs.setForeground(new java.awt.Color(102, 102, 102));
        radOs.setText("OS");
        radOs.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        radOs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radOsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panOsLayout = new javax.swing.GroupLayout(panOs);
        panOs.setLayout(panOsLayout);
        panOsLayout.setHorizontalGroup(
            panOsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panOsLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panOsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panOsLayout.createSequentialGroup()
                        .addComponent(radOrcamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(radOs)
                        .addGap(65, 65, 65))
                    .addGroup(panOsLayout.createSequentialGroup()
                        .addGroup(panOsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblOs)
                            .addComponent(txtOs, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(panOsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblData)
                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panOsLayout.setVerticalGroup(
            panOsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panOsLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(panOsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOs)
                    .addComponent(lblData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panOsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtOs)
                    .addComponent(txtData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(panOsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radOrcamento)
                    .addComponent(radOs))
                .addGap(25, 25, 25))
        );

        lblSituacao.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblSituacao.setForeground(new java.awt.Color(102, 102, 102));
        lblSituacao.setText("Situação :");

        cboSituacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Na Bancada", "Entrega OK", "Orçamento REPROVADO", "Aguardando aprovação", "Aguardando peças", "Abandonado pelo cliente", "Retornou" }));
        cboSituacao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        panCliente.setBackground(new java.awt.Color(255, 255, 255));
        panCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));

        lblNome.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblNome.setForeground(new java.awt.Color(102, 102, 102));
        lblNome.setText("Nome:");

        txtNome.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtNome.setToolTipText("Digite o nome do cliente para fazer a pesquis");
        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeKeyReleased(evt);
            }
        });

        imgPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/sigeat/images/zoom.png"))); // NOI18N

        txtID.setEditable(false);
        txtID.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        lblId.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblId.setForeground(new java.awt.Color(102, 102, 102));
        lblId.setText("Id* :");

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Nome", "Fone"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblClientes.setToolTipText("Clique sobre o registro desejado para selecionar o cliente.");
        tblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblClientes);

        javax.swing.GroupLayout panClienteLayout = new javax.swing.GroupLayout(panCliente);
        panCliente.setLayout(panClienteLayout);
        panClienteLayout.setHorizontalGroup(
            panClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panClienteLayout.createSequentialGroup()
                .addGroup(panClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panClienteLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panClienteLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(panClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panClienteLayout.createSequentialGroup()
                                .addComponent(lblNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(imgPesquisar))
                            .addGroup(panClienteLayout.createSequentialGroup()
                                .addComponent(lblId)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        panClienteLayout.setVerticalGroup(
            panClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panClienteLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNome)
                        .addComponent(lblNome))
                    .addComponent(imgPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblId))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        txtEquipamento.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        lblEquipamento.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblEquipamento.setForeground(new java.awt.Color(102, 102, 102));
        lblEquipamento.setText("Equipamento* :");

        lblDefeito.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblDefeito.setForeground(new java.awt.Color(102, 102, 102));
        lblDefeito.setText("Defeito* :");

        txtDefeito.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        lblServico.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblServico.setForeground(new java.awt.Color(102, 102, 102));
        lblServico.setText("Serviço :");

        txtServico.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtServico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtServicoKeyReleased(evt);
            }
        });

        lblTecnico.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblTecnico.setForeground(new java.awt.Color(102, 102, 102));
        lblTecnico.setText("Técnico :");

        txtTecnico.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtTecnico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTecnicoKeyReleased(evt);
            }
        });

        lblValorTotal.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblValorTotal.setForeground(new java.awt.Color(102, 102, 102));
        lblValorTotal.setText("Valor Total :");

        txtValorTotal.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtValorTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtValorTotalKeyReleased(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/sigeat/images/delete.png"))); // NOI18N
        btnExcluir.setText("Excluir OS");
        btnExcluir.setToolTipText("Excluir");
        btnExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExcluir.setEnabled(false);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/sigeat/images/update_22485.png"))); // NOI18N
        btnAtualizar.setText("Atualizar OS");
        btnAtualizar.setToolTipText("Atualizar");
        btnAtualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAtualizar.setEnabled(false);
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/sigeat/images/search_1.png"))); // NOI18N
        btnPesquisar.setText("Pesquisar OS");
        btnPesquisar.setToolTipText("Pesquiar");
        btnPesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/sigeat/images/add_icon.png"))); // NOI18N
        btnCadastrar.setText("Cadastrar OS");
        btnCadastrar.setToolTipText("Cadastrar");
        btnCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCadastrar.setEnabled(false);
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/sigeat/images/printer_blue.png"))); // NOI18N
        btnImprimir.setText("Imprimir OS");
        btnImprimir.setToolTipText("Imprimir");
        btnImprimir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImprimir.setEnabled(false);
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        btnLimpar.setBackground(new java.awt.Color(86, 186, 236));
        btnLimpar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpar.setText("Limpar");
        btnLimpar.setToolTipText("Limpar todos os campos");
        btnLimpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panFundoLayout = new javax.swing.GroupLayout(panFundo);
        panFundo.setLayout(panFundoLayout);
        panFundoLayout.setHorizontalGroup(
            panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFundoLayout.createSequentialGroup()
                .addContainerGap(171, Short.MAX_VALUE)
                .addGroup(panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panFundoLayout.createSequentialGroup()
                        .addGroup(panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panOs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panFundoLayout.createSequentialGroup()
                                .addComponent(lblSituacao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panFundoLayout.createSequentialGroup()
                        .addGroup(panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panFundoLayout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panFundoLayout.createSequentialGroup()
                                        .addGroup(panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblServico)
                                            .addComponent(lblDefeito)
                                            .addComponent(lblTecnico))
                                        .addGap(18, 18, 18)
                                        .addGroup(panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(txtServico, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
                                                .addComponent(txtDefeito))
                                            .addGroup(panFundoLayout.createSequentialGroup()
                                                .addComponent(txtTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(lblValorTotal)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(panFundoLayout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(btnCadastrar)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnPesquisar)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnAtualizar)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnImprimir))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panFundoLayout.createSequentialGroup()
                                .addComponent(lblEquipamento)
                                .addGap(18, 18, 18)
                                .addComponent(txtEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGap(27, 27, 27)))
                .addContainerGap(171, Short.MAX_VALUE))
        );
        panFundoLayout.setVerticalGroup(
            panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFundoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panFundoLayout.createSequentialGroup()
                        .addComponent(panOs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addGroup(panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSituacao)
                            .addComponent(cboSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(panCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEquipamento))
                .addGap(18, 18, 18)
                .addGroup(panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDefeito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDefeito))
                .addGap(18, 18, 18)
                .addGroup(panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblServico))
                .addGap(18, 18, 18)
                .addGroup(panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTecnico)
                        .addComponent(lblValorTotal)
                        .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnLimpar))
                .addGap(18, 18, 18)
                .addGroup(panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAtualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExcluir))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panFundoLayout.createSequentialGroup()
                        .addComponent(btnImprimir)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(104, 104, 104))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void radOrcamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radOrcamentoActionPerformed
        // Se este radio button for selecionado
        tipo = "Orçamento";
    }//GEN-LAST:event_radOrcamentoActionPerformed

    private void radOsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radOsActionPerformed
        // Se este radio button for selecionado
        tipo = "OS";
    }//GEN-LAST:event_radOsActionPerformed

    private void txtNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyReleased
        this.filtrarDados();
    }//GEN-LAST:event_txtNomeKeyReleased

    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMouseClicked
        this.setCliente();
    }//GEN-LAST:event_tblClientesMouseClicked

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        OS os = this.setOS();
        ControllerOS ctr = new ControllerOS();
        OSDAO dao = new OSDAO();
        if (ctr.validate(os)) {
            dao.save(os);
            JOptionPane.showMessageDialog(null, "OS gerada com sucesso!",
                    "OS gerada", JOptionPane.INFORMATION_MESSAGE);
            this.limparCampos();
            //Imprima a OS para consultas posteriores e atualizações
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        this.pesquisarOS();
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        this.limparCampos();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        OS os = this.setOS();
        ControllerOS ctr = new ControllerOS();
        OSDAO dao = new OSDAO();
        if (ctr.validate(os)) {
            dao.save(os);
            JOptionPane.showMessageDialog(null, "OS atualizada com sucesso!",
                    "OS atualizada", JOptionPane.INFORMATION_MESSAGE);
            this.limparCampos();
        }
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int excluir = JOptionPane.showConfirmDialog(null, "Deseja excluir esta OS?",
                "Excluir OS?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (excluir == 0) {
            OSDAO dao = new OSDAO();
            dao.remove(Integer.parseInt(txtOs.getText()));
            JOptionPane.showMessageDialog(null, "OS excluída com sucesso!",
                    "Exclusão confirmada", JOptionPane.INFORMATION_MESSAGE);
            this.limparCampos();
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void txtServicoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtServicoKeyReleased
        Controller ctr = new Controller();
        if(ctr.reachMaxLength(100, txtServico.getText())) {
            txtServico.setText(txtServico.getText().substring(0, 100));
        }
    }//GEN-LAST:event_txtServicoKeyReleased

    private void txtTecnicoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTecnicoKeyReleased
        Controller ctr = new Controller();
        if(ctr.reachMaxLength(50, txtTecnico.getText())) {
            txtTecnico.setText(txtTecnico.getText().substring(0, 50));
        }
    }//GEN-LAST:event_txtTecnicoKeyReleased

    private void txtValorTotalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorTotalKeyReleased
        Controller ctr = new Controller();
        if(ctr.isDouble(txtValorTotal.getText().replace(",", "."))) {}
        else
            txtValorTotal.setText("");
    }//GEN-LAST:event_txtValorTotalKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JComboBox cboSituacao;
    private javax.swing.ButtonGroup grpTipo;
    private javax.swing.JLabel imgPesquisar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblDefeito;
    private javax.swing.JLabel lblEquipamento;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblOs;
    private javax.swing.JLabel lblServico;
    private javax.swing.JLabel lblSituacao;
    private javax.swing.JLabel lblTecnico;
    private javax.swing.JLabel lblValorTotal;
    private javax.swing.JPanel panCliente;
    private javax.swing.JPanel panFundo;
    private javax.swing.JPanel panOs;
    private javax.swing.JRadioButton radOrcamento;
    private javax.swing.JRadioButton radOs;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtDefeito;
    private javax.swing.JTextField txtEquipamento;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtOs;
    private javax.swing.JTextField txtServico;
    private javax.swing.JTextField txtTecnico;
    private javax.swing.JTextField txtValorTotal;
    // End of variables declaration//GEN-END:variables
}
