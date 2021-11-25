/*
 * Formulário responsável pela calculadora
 */

package com.sigeat.app;

import java.math.BigDecimal;
import java.math.RoundingMode;

/*
 * SIGEAT/ Application / Calculadora
 * @author Junior
 * Version : 1.0.0
 */

public class FrmCalculadora extends javax.swing.JDialog {

    private BigDecimal num;
    private BigDecimal resultado;
    private String operacao;
    
    /**
     * Creates new form FrmCalculadora
     */
    public FrmCalculadora(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    private void buttonPress(String str) {
        
        this.resultMaxLength();

        txtResultado.setText(txtResultado.getText() + str);
        lblResultado.setText(lblResultado.getText() + str);
        
    }
    
    private void buttonOperationPress(String str) {
        
        try {
            num = new BigDecimal(txtResultado.getText().replace(",", "."));
            //num = Double.parseDouble(txtResultado.getText().replace(",", "."));
            txtResultado.setText("");
            lblResultado.setText(lblResultado.getText() + str);
            
            this.releaseButtons();
            
            btnMais.setEnabled(false);
            btnMenos.setEnabled(false);
            btnVezes.setEnabled(false);
            btnDividir.setEnabled(false);
            
            if(str.equals("+"))
                operacao = "soma";
            else if(str.equals("-"))
                operacao = "subtração";
            else if(str.equals("x"))
                operacao = "multiplicação";
            else if(str.equals("/"))
                operacao = "divisão";
            
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
    
    private boolean containsComma() {
        
        if(txtResultado.getText().contains(",") || txtResultado.getText().trim().isEmpty()) {
            return false;
        } else {
            return true;
        }
        
    }
    
    private void calcular() {
        
        try {
            resultado = new BigDecimal(txtResultado.getText().replace(",", "."));
            if(operacao.equals("soma"))   
                resultado = num.add(resultado);

            else if(operacao.equals("subtração"))
                resultado = num.subtract(resultado);

            else if(operacao.equals("multiplicação"))
                resultado = num.multiply(resultado);

            else if(operacao.equals("divisão")) {
                try {
                    resultado = num.divide(resultado);
                } catch(ArithmeticException e) {
                    resultado = num.divide(resultado, 14, RoundingMode.HALF_EVEN);
                }
            }
            
            String total = resultado.toString();
            txtResultado.setText(total.replace(".", ","));
            lblResultado.setText(total.replace(".", ","));
            
            this.blockButtons();
            this.resultMaxLength();
            
        } catch (NullPointerException | NumberFormatException e) {
        }
        
        btnMais.setEnabled(true);
        btnMenos.setEnabled(true);
        btnVezes.setEnabled(true);
        btnDividir.setEnabled(true);
        
    }
    
    private void maisMenos() {
        
        try {
            if(Double.parseDouble(txtResultado.getText().replace(",", ".")) > 0) {
                txtResultado.setText("-" + txtResultado.getText().replace(".", ","));
                lblResultado.setText("-" + lblResultado.getText().replace(".", ","));
            } else {
                String expressao = txtResultado.getText().replace(".", ",");
                String replaced = expressao.replace("-", "");
                txtResultado.setText(replaced);
                lblResultado.setText(replaced);
            }
        } catch (Exception e) {
        }
        
    }
      
    private void blockButtons() {
        
        btnZero.setEnabled(false);
        btnUm.setEnabled(false);
        btnDois.setEnabled(false);
        btnTres.setEnabled(false);
        btnQuatro.setEnabled(false);
        btnCinco.setEnabled(false);
        btnSeis.setEnabled(false);
        btnSete.setEnabled(false);
        btnOito.setEnabled(false);
        btnNove.setEnabled(false);
        btnVirgula.setEnabled(false);
        
    }
    
    private void releaseButtons() {
        
        btnZero.setEnabled(true);
        btnUm.setEnabled(true);
        btnDois.setEnabled(true);
        btnTres.setEnabled(true);
        btnQuatro.setEnabled(true);
        btnCinco.setEnabled(true);
        btnSeis.setEnabled(true);
        btnSete.setEnabled(true);
        btnOito.setEnabled(true);
        btnNove.setEnabled(true);
        btnVirgula.setEnabled(true);
        
    }
    
    private void resultMaxLength() {
        
        if(txtResultado.getText().length() > 14) {
            txtResultado.setText(txtResultado.getText().substring(0, 14));
            lblResultado.setText(lblResultado.getText().substring(0, 14));
        }
        
    }
     
    private void setDefaultState() {
        
        txtResultado.setText("");
        lblResultado.setText("");
        
        btnMais.setEnabled(true);
        btnMenos.setEnabled(true);
        btnVezes.setEnabled(true);
        btnDividir.setEnabled(true);
        this.releaseButtons();
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panFundo = new javax.swing.JPanel();
        txtResultado = new javax.swing.JTextField();
        btnOito = new javax.swing.JButton();
        btnSete = new javax.swing.JButton();
        btnNove = new javax.swing.JButton();
        btnDividir = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnQuatro = new javax.swing.JButton();
        btnCinco = new javax.swing.JButton();
        btnSeis = new javax.swing.JButton();
        btnVezes = new javax.swing.JButton();
        btnMaisMenos = new javax.swing.JButton();
        btnUm = new javax.swing.JButton();
        btnDois = new javax.swing.JButton();
        btnTres = new javax.swing.JButton();
        btnMenos = new javax.swing.JButton();
        btnZero = new javax.swing.JButton();
        btnVirgula = new javax.swing.JButton();
        btnMais = new javax.swing.JButton();
        btnIgual = new javax.swing.JButton();
        lblResultado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Calculadora");
        setResizable(false);

        panFundo.setBackground(new java.awt.Color(255, 255, 255));

        txtResultado.setEditable(false);
        txtResultado.setBackground(new java.awt.Color(34, 202, 237));
        txtResultado.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        txtResultado.setForeground(new java.awt.Color(7, 63, 86));
        txtResultado.setCaretColor(new java.awt.Color(34, 202, 237));
        txtResultado.setDisabledTextColor(new java.awt.Color(7, 63, 86));

        btnOito.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnOito.setText("8");
        btnOito.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOitoActionPerformed(evt);
            }
        });

        btnSete.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnSete.setText("7");
        btnSete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeteActionPerformed(evt);
            }
        });

        btnNove.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnNove.setText("9");
        btnNove.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoveActionPerformed(evt);
            }
        });

        btnDividir.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnDividir.setText("/");
        btnDividir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDividir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDividirActionPerformed(evt);
            }
        });

        btnLimpar.setBackground(new java.awt.Color(255, 0, 0));
        btnLimpar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnLimpar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpar.setText("CE");
        btnLimpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnQuatro.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnQuatro.setText("4");
        btnQuatro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnQuatro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuatroActionPerformed(evt);
            }
        });

        btnCinco.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnCinco.setText("5");
        btnCinco.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCinco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCincoActionPerformed(evt);
            }
        });

        btnSeis.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnSeis.setText("6");
        btnSeis.setToolTipText("");
        btnSeis.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSeis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeisActionPerformed(evt);
            }
        });

        btnVezes.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnVezes.setText("x");
        btnVezes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVezes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVezesActionPerformed(evt);
            }
        });

        btnMaisMenos.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnMaisMenos.setText("+-");
        btnMaisMenos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMaisMenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaisMenosActionPerformed(evt);
            }
        });

        btnUm.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnUm.setText("1");
        btnUm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUmActionPerformed(evt);
            }
        });

        btnDois.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnDois.setText("2");
        btnDois.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDois.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoisActionPerformed(evt);
            }
        });

        btnTres.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnTres.setText("3");
        btnTres.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTresActionPerformed(evt);
            }
        });

        btnMenos.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnMenos.setText("-");
        btnMenos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenosActionPerformed(evt);
            }
        });

        btnZero.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnZero.setText("0");
        btnZero.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnZero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZeroActionPerformed(evt);
            }
        });

        btnVirgula.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnVirgula.setText(",");
        btnVirgula.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVirgula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVirgulaActionPerformed(evt);
            }
        });

        btnMais.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnMais.setText("+");
        btnMais.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaisActionPerformed(evt);
            }
        });

        btnIgual.setBackground(new java.awt.Color(0, 0, 0));
        btnIgual.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnIgual.setForeground(new java.awt.Color(255, 255, 255));
        btnIgual.setText("=");
        btnIgual.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIgual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIgualActionPerformed(evt);
            }
        });

        lblResultado.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblResultado.setForeground(new java.awt.Color(7, 63, 86));

        javax.swing.GroupLayout panFundoLayout = new javax.swing.GroupLayout(panFundo);
        panFundo.setLayout(panFundoLayout);
        panFundoLayout.setHorizontalGroup(
            panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFundoLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panFundoLayout.createSequentialGroup()
                        .addComponent(btnQuatro, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCinco, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSeis, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVezes, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMaisMenos, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panFundoLayout.createSequentialGroup()
                        .addComponent(btnSete, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOito, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNove, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDividir, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panFundoLayout.createSequentialGroup()
                        .addGroup(panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panFundoLayout.createSequentialGroup()
                                .addComponent(btnZero, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnVirgula, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMais, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panFundoLayout.createSequentialGroup()
                                .addComponent(btnUm, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDois, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTres, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMenos, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnIgual, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblResultado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtResultado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        panFundoLayout.setVerticalGroup(
            panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFundoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSete, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnOito, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNove, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDividir, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMaisMenos, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnQuatro, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCinco, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSeis, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnVezes, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panFundoLayout.createSequentialGroup()
                        .addGroup(panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMenos, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnUm, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnDois, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnTres, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnZero, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVirgula, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMais, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnIgual, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
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

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    //#region - Números
    
    private void btnZeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZeroActionPerformed
        this.buttonPress(btnZero.getText());
    }//GEN-LAST:event_btnZeroActionPerformed

    private void btnUmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUmActionPerformed
        this.buttonPress(btnUm.getText());
    }//GEN-LAST:event_btnUmActionPerformed

    private void btnDoisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoisActionPerformed
        this.buttonPress(btnDois.getText());
    }//GEN-LAST:event_btnDoisActionPerformed

    private void btnTresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTresActionPerformed
        this.buttonPress(btnTres.getText());
    }//GEN-LAST:event_btnTresActionPerformed

    private void btnQuatroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuatroActionPerformed
        this.buttonPress(btnQuatro.getText());
    }//GEN-LAST:event_btnQuatroActionPerformed

    private void btnCincoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCincoActionPerformed
        this.buttonPress(btnCinco.getText());
    }//GEN-LAST:event_btnCincoActionPerformed

    private void btnSeisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeisActionPerformed
        this.buttonPress(btnSeis.getText());
    }//GEN-LAST:event_btnSeisActionPerformed

    private void btnSeteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeteActionPerformed
        this.buttonPress(btnSete.getText());
    }//GEN-LAST:event_btnSeteActionPerformed

    private void btnOitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOitoActionPerformed
        this.buttonPress(btnOito.getText());
    }//GEN-LAST:event_btnOitoActionPerformed

    private void btnNoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoveActionPerformed
        this.buttonPress(btnNove.getText());
    }//GEN-LAST:event_btnNoveActionPerformed

    //#endregion
    
    private void btnMaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaisActionPerformed
        this.buttonOperationPress(btnMais.getText());
    }//GEN-LAST:event_btnMaisActionPerformed

    private void btnMenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenosActionPerformed
        this.buttonOperationPress(btnMenos.getText());
    }//GEN-LAST:event_btnMenosActionPerformed

    private void btnVezesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVezesActionPerformed
        this.buttonOperationPress(btnVezes.getText());
    }//GEN-LAST:event_btnVezesActionPerformed

    private void btnDividirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDividirActionPerformed
        this.buttonOperationPress(btnDividir.getText());
    }//GEN-LAST:event_btnDividirActionPerformed

    private void btnVirgulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVirgulaActionPerformed
        if(this.containsComma())
            this.buttonPress(btnVirgula.getText());
    }//GEN-LAST:event_btnVirgulaActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        this.setDefaultState();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnMaisMenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaisMenosActionPerformed
        this.maisMenos();
    }//GEN-LAST:event_btnMaisMenosActionPerformed

    private void btnIgualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIgualActionPerformed
        this.calcular();
    }//GEN-LAST:event_btnIgualActionPerformed

    
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
            java.util.logging.Logger.getLogger(FrmCalculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCalculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCalculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCalculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmCalculadora dialog = new FrmCalculadora(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnCinco;
    private javax.swing.JButton btnDividir;
    private javax.swing.JButton btnDois;
    private javax.swing.JButton btnIgual;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnMais;
    private javax.swing.JButton btnMaisMenos;
    private javax.swing.JButton btnMenos;
    private javax.swing.JButton btnNove;
    private javax.swing.JButton btnOito;
    private javax.swing.JButton btnQuatro;
    private javax.swing.JButton btnSeis;
    private javax.swing.JButton btnSete;
    private javax.swing.JButton btnTres;
    private javax.swing.JButton btnUm;
    private javax.swing.JButton btnVezes;
    private javax.swing.JButton btnVirgula;
    private javax.swing.JButton btnZero;
    private javax.swing.JLabel lblResultado;
    private javax.swing.JPanel panFundo;
    private javax.swing.JTextField txtResultado;
    // End of variables declaration//GEN-END:variables

}
