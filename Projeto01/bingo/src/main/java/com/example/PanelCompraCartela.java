/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.example;

/**
 *
 * @author Jonas
 */
public class PanelCompraCartela extends javax.swing.JPanel {

    /**
     * Creates new form PanelJogo
     */
    public PanelCompraCartela() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jtNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        qtCartelasComprar = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setLayout(new java.awt.GridLayout(3, 2));

        jLabel3.setText("nome (opicional):");
        add(jLabel3);
        add(jtNome);

        jLabel4.setText("Quantidade de Cartelas");
        add(jLabel4);

        qtCartelasComprar.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        add(qtCartelasComprar);

        jButton1.setText("Cancelar");
        add(jButton1);

        jButton2.setText("Confirmar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Integer qtCartelas= (Integer)(qtCartelasComprar.getValue());
        String nome = jtNome.getText()==null? "" : jtNome.getText();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jtNome;
    private javax.swing.JSpinner qtCartelasComprar;
    // End of variables declaration//GEN-END:variables
}