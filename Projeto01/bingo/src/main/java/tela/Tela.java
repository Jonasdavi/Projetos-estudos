/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tela;

import LogicaBingo.Jogador;
import LogicaBingo.Bingo;

import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Jonas
 */
public class Tela extends javax.swing.JFrame {
    private Bingo bingo= new Bingo();
    
    //panels da tela e seus idCards:
    private PanelSorteio pSorteio;
    public final String PSORTEIO= "1";
    
    private PanelInicial pInicial;
    public final String PINICIAL= "2";
    
    private PanelDetalheCompra pDetalheCompra;
    public final String PDETALHECOMPRA= "3";
    
    
    
    

    /**
     * Creates new form Tela
     */
    public Tela() {
        initComponents();
        
        //iniciar no panel da tela inicial:
        irTelaInicial();
        
        //maximizando tela:
        setExtendedState(MAXIMIZED_BOTH);
        
    }
    
    
    //metodos pra ajudar na classe principal;
    public PanelSorteio getPanelSorteio(){
        return pSorteio;
    }
    
    public JPanel getCard(){
        return card;
    }
    
    
    //metodos pra mudar de panel 
    public void irDetalheCompra(Jogador jogador){
        pDetalheCompra= new PanelDetalheCompra(this, jogador);
        card.add(pDetalheCompra, PDETALHECOMPRA);
        
        
        ((CardLayout) (card.getLayout())).show(card, PDETALHECOMPRA);
        
    }
    
    public void irTelaInicial(){
        int qtCartelas= bingo.getQtCartelasValidas();
        int qtJogadores= bingo.getQtJogadores();
        
        
        pInicial= new PanelInicial(this, qtCartelas, qtJogadores);
        card.add(pInicial, PINICIAL);
        ((CardLayout) (card.getLayout())).show(card, PINICIAL);
        
        
        
    }
    
    public void irSorteio(){
        pSorteio= new PanelSorteio(this, bingo);
        card.add(pSorteio, PSORTEIO);
        ((CardLayout) (card.getLayout())).show(card, PSORTEIO);
    }
    
    
    //metodos pra ajudar no sorteio:
    public Bingo getBingo(){
        return bingo;
    }
    
    
    public void finalizarSorteio(){
        bingo= new Bingo();
        irTelaInicial();
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        card = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        card.setLayout(new java.awt.CardLayout());
        getContentPane().add(card, java.awt.BorderLayout.CENTER);

        pack();
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
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel card;
    // End of variables declaration//GEN-END:variables
}
