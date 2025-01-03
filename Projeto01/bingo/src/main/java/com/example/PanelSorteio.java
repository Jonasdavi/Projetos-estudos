/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.example;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

/**
 *
 * @author Jonas
 */
public class PanelSorteio extends javax.swing.JPanel {
    private final int QTNUMSSORTEIO= 75;
    JLabel numerosSorteio[];

    /**
     * Creates new form PanelCompraCartela
     */
    public PanelSorteio() {
        initComponents();
        
        //iniciar todos os numeros onde mostrarar os numeros sorteados e nao sorteados
        numerosSorteio= new JLabel[QTNUMSSORTEIO];
        for(int i=0; i<QTNUMSSORTEIO; i++){
            if(i<9){ //numeros de 1 a 9 sao exibidos com o 0 à esquerda
                numerosSorteio[i]= new JLabel("0" + String.valueOf((i+1)));
            }
            else{
                numerosSorteio[i]= new JLabel(String.valueOf((i+1)));
            }
            
            numerosSorteio[i].setHorizontalAlignment(SwingConstants.CENTER);
            
            //permitir cor de fundo:
            numerosSorteio[i].setOpaque(true);
            
            //iniciar cor de fundo como branco
            numerosSorteio[i].setBackground(Color.GRAY);
            
            //adicionar borda
            //numerosSorteio[i].setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, new java.awt.Color(0, 0, 0), null));
            panelNums.add(numerosSorteio[i]);
        }
    }
    
    private void reiniciarNumerosSorteio(){
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSorteacao = new javax.swing.JPanel();
        numSorteado = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        historico1 = new javax.swing.JLabel();
        historico2 = new javax.swing.JLabel();
        historico3 = new javax.swing.JLabel();
        panelNums = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        panelSorteacao.setBackground(new java.awt.Color(204, 204, 204));

        numSorteado.setBackground(new java.awt.Color(255, 255, 204));
        numSorteado.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        numSorteado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numSorteado.setText("00");
        numSorteado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        numSorteado.setOpaque(true);

        jPanel1.setLayout(new java.awt.GridLayout(3, 1));

        historico1.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        historico1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        historico1.setText("00");
        historico1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(historico1);

        historico2.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        historico2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        historico2.setText("00");
        historico2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(historico2);

        historico3.setFont(new java.awt.Font("Segoe UI Black", 0, 16)); // NOI18N
        historico3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        historico3.setText("00");
        historico3.setToolTipText("");
        jPanel1.add(historico3);

        javax.swing.GroupLayout panelSorteacaoLayout = new javax.swing.GroupLayout(panelSorteacao);
        panelSorteacao.setLayout(panelSorteacaoLayout);
        panelSorteacaoLayout.setHorizontalGroup(
            panelSorteacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSorteacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSorteacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSorteacaoLayout.createSequentialGroup()
                        .addGap(0, 152, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(numSorteado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        panelSorteacaoLayout.setVerticalGroup(
            panelSorteacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSorteacaoLayout.createSequentialGroup()
                .addComponent(numSorteado, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(panelSorteacao, java.awt.BorderLayout.LINE_END);

        panelNums.setBackground(new java.awt.Color(153, 153, 153));
        panelNums.setLayout(new java.awt.GridLayout(8, 10, 4, 4));
        add(panelNums, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel historico1;
    private javax.swing.JLabel historico2;
    private javax.swing.JLabel historico3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel numSorteado;
    private javax.swing.JPanel panelNums;
    private javax.swing.JPanel panelSorteacao;
    // End of variables declaration//GEN-END:variables
}