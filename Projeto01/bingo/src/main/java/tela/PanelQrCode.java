/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package tela;

/**
 *
 * @author Jonas
 */
public class PanelQrCode extends javax.swing.JPanel {

    /**
     * Creates new form qrCode
     */
    public PanelQrCode() {
        initComponents();
        
        lbImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baixarhtml/qrcode.png"))); // NOI18N
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbImagem = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        lbImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baixarhtml/qrcode.png"))); // NOI18N
        add(lbImagem, java.awt.BorderLayout.CENTER);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Baixe suas cartelas através deste qrcode:");
        jLabel2.setOpaque(true);
        add(jLabel2, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbImagem;
    // End of variables declaration//GEN-END:variables
}
