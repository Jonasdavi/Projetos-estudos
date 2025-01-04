/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.example;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Jonas
 */
public class PanelDetalheCompra extends javax.swing.JPanel {

    /**
     * Creates new form PanelDetalheCompra
     */
    public PanelDetalheCompra(int qtCartelas) {
        initComponents();
        
        //mudando o panel dos dados para gridLayout com a quantidade de linhas de acordo com a quantidade de cartelas e duas colunas 
        panelDados.setLayout(new GridLayout(qtCartelas, 2));
        
        for(int i=1; i<=qtCartelas; i++){
            String cartelaNum= "Cartela " + String.valueOf(i);
            
            JLabel jlb= new JLabel(cartelaNum);
            JButton jbt= new JButton("Visualizar cartela");
            
            panelDados.add(jlb);
            panelDados.add(jbt);
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

        panelDados = new javax.swing.JPanel();

        setLayout(new java.awt.GridBagLayout());

        javax.swing.GroupLayout panelDadosLayout = new javax.swing.GroupLayout(panelDados);
        panelDados.setLayout(panelDadosLayout);
        panelDadosLayout.setHorizontalGroup(
            panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        panelDadosLayout.setVerticalGroup(
            panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        add(panelDados, new java.awt.GridBagConstraints());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelDados;
    // End of variables declaration//GEN-END:variables
}
