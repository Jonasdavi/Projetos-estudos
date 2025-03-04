/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package tela;

import LogicaBingo.Bingo;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

/**
 *
 * @author Jonas
 */
public class PanelSorteio extends javax.swing.JPanel {
    private Tela tela;
    private Bingo bingo;
    
    private boolean sorteioPausado;
    private boolean sorteioAcabado;
    private int tempoSortear;
    
    private final int QTNUMSSORTEIO= 75;
    JLabel numerosSorteio[];

    /**
     * Creates new form PanelCompraCartela
     */
    public PanelSorteio(Tela t, Bingo b) {
        initComponents();
        
        tempoSortear= 1;
        sorteioPausado= true;
        sorteioAcabado=false;
        
        tela=t;
        bingo= b;
        
        iniciarLabelsSorteio();
        
        
    }
    
    private void iniciarLabelsSorteio(){
        //iniciar todos os numeros onde mostrarár os numeros sorteados e nao sorteados
        numerosSorteio= new JLabel[QTNUMSSORTEIO];
        for(int i=0; i<QTNUMSSORTEIO; i++){
            if(i<9){ //numeros de 1 a 9 sao exibidos com o 0 à esquerda
                numerosSorteio[i]= new JLabel("0" + String.valueOf((i+1)));
            }
            else{
                numerosSorteio[i]= new JLabel(String.valueOf((i+1)));
            }
            
            //alinhar no centro
            numerosSorteio[i].setHorizontalAlignment(SwingConstants.CENTER);
            
            //permitir cor de fundo:
            numerosSorteio[i].setOpaque(true);
            
            //iniciar cor de fundo como cinza
            numerosSorteio[i].setBackground(Color.GRAY);
            
            //adicionar borda
            numerosSorteio[i].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

            
            //mudar tamanho e fonte:
            numerosSorteio[i].setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 36)); // NOI18N
           
            panelNums.add(numerosSorteio[i]);
            
            
        }
    }
    
    public void sortearNum(){
        if(bingo.getQtNumsSorteados()==75){
            sorteioAcabado= true;
            return;
        }
        
        int numSorteado= bingo.sortearNum();
        
        lbHistorico3.setText(lbHistorico2.getText());
        lbHistorico2.setText(lbHistorico1.getText());
        lbHistorico1.setText(lbNumSorteado.getText());
        lbNumSorteado.setText(String.valueOf(numSorteado));
        
        //deixar label do numero sorteado amarelo
        numerosSorteio[numSorteado-1].setBackground(Color.YELLOW);
    }
    
    
    public void pausarSorteio(){
        sorteioPausado=true;
    }
    
    public void tirarPausa(){
        sorteioPausado=false;
    }
    
    public void setTempoSortearNum(int segundos){
        tempoSortear= segundos;
    }
    
    public boolean isSorteioPausado(){
        return sorteioPausado;
    }
    
    public boolean isSorteioAcabado(){
        return sorteioAcabado;
    }
    
    public int getTempoSortear(){
        return tempoSortear;
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
        lbNumSorteado = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lbHistorico1 = new javax.swing.JLabel();
        lbHistorico2 = new javax.swing.JLabel();
        lbHistorico3 = new javax.swing.JLabel();
        btFinalizarSorteio = new javax.swing.JButton();
        btVerificarVitoria = new javax.swing.JButton();
        btPausarContinuar = new javax.swing.JButton();
        panelNums = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        panelSorteacao.setBackground(new java.awt.Color(153, 153, 153));

        lbNumSorteado.setBackground(new java.awt.Color(255, 255, 204));
        lbNumSorteado.setFont(new java.awt.Font("Segoe UI Black", 1, 90)); // NOI18N
        lbNumSorteado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbNumSorteado.setText("00");
        lbNumSorteado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        lbNumSorteado.setOpaque(true);

        jPanel1.setLayout(new java.awt.GridLayout(3, 1));

        lbHistorico1.setFont(new java.awt.Font("Segoe UI Black", 1, 28)); // NOI18N
        lbHistorico1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbHistorico1.setText("00");
        lbHistorico1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(lbHistorico1);

        lbHistorico2.setFont(new java.awt.Font("Segoe UI Black", 0, 22)); // NOI18N
        lbHistorico2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbHistorico2.setText("00");
        lbHistorico2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(lbHistorico2);

        lbHistorico3.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        lbHistorico3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbHistorico3.setText("00");
        lbHistorico3.setToolTipText("");
        jPanel1.add(lbHistorico3);

        btFinalizarSorteio.setText("Finalizar Sorteio");
        btFinalizarSorteio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFinalizarSorteioActionPerformed(evt);
            }
        });

        btVerificarVitoria.setText("Verificar Vitoria");
        btVerificarVitoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVerificarVitoriaActionPerformed(evt);
            }
        });

        btPausarContinuar.setText("Iniciar Sorteio");
        btPausarContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPausarContinuarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSorteacaoLayout = new javax.swing.GroupLayout(panelSorteacao);
        panelSorteacao.setLayout(panelSorteacaoLayout);
        panelSorteacaoLayout.setHorizontalGroup(
            panelSorteacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSorteacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSorteacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNumSorteado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSorteacaoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelSorteacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                            .addComponent(btVerificarVitoria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btFinalizarSorteio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btPausarContinuar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );
        panelSorteacaoLayout.setVerticalGroup(
            panelSorteacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSorteacaoLayout.createSequentialGroup()
                .addComponent(lbNumSorteado, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btPausarContinuar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btVerificarVitoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btFinalizarSorteio))
        );

        add(panelSorteacao, java.awt.BorderLayout.LINE_END);

        panelNums.setBackground(new java.awt.Color(51, 0, 51));
        panelNums.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelNums.setLayout(new java.awt.GridLayout(8, 10, 4, 4));
        add(panelNums, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btVerificarVitoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVerificarVitoriaActionPerformed
        // TODO add your handling code here:
        tela.exibirDialogVerificarId();
    }//GEN-LAST:event_btVerificarVitoriaActionPerformed

    private void btFinalizarSorteioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFinalizarSorteioActionPerformed
        // TODO add your handling code here:
        sorteioAcabado=true;
        tela.finalizarSorteio();
    }//GEN-LAST:event_btFinalizarSorteioActionPerformed

    private void btPausarContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPausarContinuarActionPerformed
        // TODO add your handling code here:
        JButton botaoClicado= (JButton) (evt.getSource());
        
        String textoPausar= "Pausar Sorteio";
        String textoContinuar= "Continuar Sorteio";
        
        if(sorteioPausado){ //se quando o botao foi apertado o jogo estiver pausado, entao despausar
            sorteioPausado= false; //jogo sorteando
            botaoClicado.setText(textoPausar); //jogo sorteando e o botao perguntando se quer pausar
            
            //iniciarSorteio();
        }
        else{ //se quando o botao foi apertado o jogo estiver rodando, entao pausar
            sorteioPausado= true;
            botaoClicado.setText(textoContinuar); //jogoo pausado e botao perguntando se quer continuar
        }
    }//GEN-LAST:event_btPausarContinuarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btFinalizarSorteio;
    private javax.swing.JButton btPausarContinuar;
    private javax.swing.JButton btVerificarVitoria;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbHistorico1;
    private javax.swing.JLabel lbHistorico2;
    private javax.swing.JLabel lbHistorico3;
    private javax.swing.JLabel lbNumSorteado;
    private javax.swing.JPanel panelNums;
    private javax.swing.JPanel panelSorteacao;
    // End of variables declaration//GEN-END:variables
}
