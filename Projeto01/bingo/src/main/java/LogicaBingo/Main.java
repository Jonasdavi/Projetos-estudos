package LogicaBingo;

import java.awt.CardLayout;
import java.awt.Component;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JPanel;
import tela.PanelCompraCartela;
import tela.PanelSorteio;
import tela.Tela;

public class Main {
    public static void main(String[] args) {
        
        Tela tela= new Tela();
        tela.setSize(600, 400);
//        JDialog jd= new JDialog(tela, "teste", true);
//        //jd.setModal(true);
//        jd.getContentPane().add(new PanelCompraCartela(tela));
//        
//        tela.setVisible(true);
//        jd.setSize(300, 300);
//        jd.setVisible(true);
        

        tela.irTelaInicial();

        //painel com o cardLayout da tela:
        JPanel card= tela.getCard();
        
        //painel de sorteio da tela:
        PanelSorteio pSorteio;
        
        
        tela.setVisible(true);
        while(true){
            pSorteio= tela.getPanelSorteio(); //atualizar referencia do painel de sorteio
            for(Component componente : card.getComponents()){ //pega todos os paineis do card
                if(componente.isVisible() && componente==pSorteio){ //pega o panel de sorteio quando estiver visivel
                    
                    //quando estiver na tela de sorteio:
                    while(!pSorteio.isSorteioAcabado()){ //faça isso enquanto o sorteio nao tiver acabado
                        
                        if(pSorteio.isSorteioPausado()){ //se o sorteio estiver pausado
                            
                            //dar uma pequena pausa pra nao bugar o programa
                            try {//pausar fala pela quantidade de tempo desejada
                                Thread.sleep(100);
                            } 
                            catch (InterruptedException ex) {
                                Logger.getLogger(PanelSorteio.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                            //e nao faça o sorteio do numero
                            continue;
                        }
                        else{ //se o sorteio estiver rolando
                            
                            //sortear:
                            pSorteio.sortearNum();

                            //pausar sorteio pra dar tempo marcarem as cartelas (pela quantidade de segundos desejada por quem ta sorteando)
                            try {//pausar fala pela quantidade de tempo desejada
                                Thread.sleep(pSorteio.getTempoSortear()*1000); //*1000 pra deixar o tempo em segundos
                            } catch (InterruptedException ex) {
                                Logger.getLogger(PanelSorteio.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
            }
        }
    }
}