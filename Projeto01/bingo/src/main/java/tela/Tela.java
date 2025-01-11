/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tela;

import LogicaBingo.Cartela;
import LogicaBingo.Jogador;
import LogicaBingo.Bingo;

import java.awt.CardLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 *
 * @author Jonas
 */
public class Tela extends javax.swing.JFrame {
    private Bingo bingo= new Bingo();
    
    private PanelSorteio pSorteio;
    public final String PSORTEIO= "1";
    
    private PanelInicial pInicial;
    public final String PINICIAL= "2";
    
    private PanelGUICartela pGuiCartela;
    public final String PGUICARTELA= "3";
    
    private PanelCompraCartela pCompraCartela;
    public final String PCOMPRACARTELA= "4";
    
    private PanelDetalheCompra pDetalheCompra;
    public final String PDETALHECOMPRA= "5";
    
    private PanelVerificarVitoria pVerificVitoria;
    
    
    

    /**
     * Creates new form Tela
     */
    public Tela() {
        initComponents();
        
        irTelaInicial();
        
        //configurando dialog de compra de cartela:
        pCompraCartela=new PanelCompraCartela(this);
        jdCompra.add(pCompraCartela);
        
        //quando o X de sair for clicado, antes de sair reiniciar informacoes do painel de compra:
        jdCompra.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                pCompraCartela.reiniciarInfor();
                jdCompra.dispose();
            }
        });
        
        pVerificVitoria= new PanelVerificarVitoria(bingo);
        jdVerificarId.add(pVerificVitoria);
        
        jdVerificarId.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                pVerificVitoria.sairDialog();
                jdVerificarId.dispose();
            }
        });
        
        //deixando todos os JDialogs no centro da tela:
        jdCompra.setLocationRelativeTo(null);
        jdCartela.setLocationRelativeTo(null);
        jdVerificarId.setLocationRelativeTo(null);
        jdQrcode.setLocationRelativeTo(null);
        
        //exibirQrcode();
        
        
        setExtendedState(MAXIMIZED_BOTH);
        
    }
    
    
    
    public PanelSorteio getPanelSorteio(){
        return pSorteio;
    }
    
    public JPanel getCard(){
        return card;
    }
    
    public PanelCompraCartela getPCompraCartela(){
        return pCompraCartela;
    }
    
    public void irDetalheCompra(Jogador jogador){
        pDetalheCompra= new PanelDetalheCompra(this, jogador);
        card.add(pDetalheCompra, PDETALHECOMPRA);
        
        
        ((CardLayout) (card.getLayout())).show(card, PDETALHECOMPRA);
        
    }
    
    public void irCartela(Cartela c, Jogador j){
        pGuiCartela= new PanelGUICartela(jdCartela, c, j);
        //card.add(pGuiCartela, PGUICARTELA);
        jdCartela.getContentPane().add(pGuiCartela, PGUICARTELA);
        
        ((CardLayout) (jdCartela.getContentPane().getLayout())).show(jdCartela.getContentPane(), PGUICARTELA);
        jdCartela.setVisible(true);
    }
    
    public void irTelaInicial(){
        int qtCartelas= bingo.getQtCartelas();
        int qtJogadores= bingo.getQtJogadores();
        
        
        pInicial= new PanelInicial(this, qtCartelas, qtJogadores);
        card.add(pInicial, PINICIAL);
        ((CardLayout) (card.getLayout())).show(card, PINICIAL);
        
        
        
    }
    
    public void irCompraCartela(){
        //pCompraCartela= new PanelCompraCartela(this);
        //card.add(pCompraCartela, PCOMPRACARTELA);
        //((CardLayout) (card.getLayout())).show(card, PCOMPRACARTELA);
        
        //jdCompra.add(pCompraCartela);
        
        jdCompra.setVisible(true);
    }
    
    public void fecharJdCompra(){
        jdCompra.setVisible(false);
    }
    
    public void irSorteio(){
        pSorteio= new PanelSorteio(this, bingo);
        card.add(pSorteio, PSORTEIO);
        ((CardLayout) (card.getLayout())).show(card, PSORTEIO);
    }
    
    public Bingo getBingo(){
        return bingo;
    }
    
    public void finalizarSorteio(){
        bingo= new Bingo();
        irTelaInicial();
    }
    
    public void exibirDialogVerificarId(){
        jdVerificarId.setVisible(true);
    }
    
    
    public void exibirQrcode(){
        PanelQrCode pQr= new PanelQrCode();
        String indiceQr= "qr";
        
        jdQrcode.getContentPane().add(pQr, indiceQr);
        ((CardLayout) (jdQrcode.getContentPane().getLayout())).show(jdQrcode.getContentPane(), indiceQr);
        
        jdQrcode.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdCompra = new javax.swing.JDialog();
        jdVerificarId = new javax.swing.JDialog();
        jdCartela = new javax.swing.JDialog();
        jdQrcode = new javax.swing.JDialog();
        card = new javax.swing.JPanel();

        jdCompra.setMinimumSize(new java.awt.Dimension(200, 100));
        jdCompra.setModal(true);
        jdCompra.setSize(new java.awt.Dimension(350, 150));

        jdVerificarId.setMinimumSize(new java.awt.Dimension(200, 100));
        jdVerificarId.setModal(true);
        jdVerificarId.setSize(new java.awt.Dimension(300, 150));

        jdCartela.setMinimumSize(new java.awt.Dimension(200, 300));
        jdCartela.setModal(true);
        jdCartela.setSize(new java.awt.Dimension(300, 400));
        jdCartela.getContentPane().setLayout(new java.awt.CardLayout());

        jdQrcode.setModal(true);
        jdQrcode.setSize(new java.awt.Dimension(320, 350));
        jdQrcode.getContentPane().setLayout(new java.awt.CardLayout());

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
    private javax.swing.JDialog jdCartela;
    private javax.swing.JDialog jdCompra;
    private javax.swing.JDialog jdQrcode;
    private javax.swing.JDialog jdVerificarId;
    // End of variables declaration//GEN-END:variables
}
