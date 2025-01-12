package LogicaBingo;

import java.awt.Component;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import tela.PanelSorteio;
import tela.Tela;

public class Main {
    public static void main(String[] args) {
        
        Tela tela= new Tela();

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
                            
                            //pausar sorteio pra dar tempo marcarem as cartelas (pela quantidade de segundos desejada por quem ta sorteando)
                            try {//pausar fala pela quantidade de tempo desejada
                                Thread.sleep(pSorteio.getTempoSortear()*1000); //*1000 pra deixar o tempo em segundos
                            } catch (InterruptedException ex) {
                                Logger.getLogger(PanelSorteio.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                            //se depois da pausa dos segundos assima, o sorteio ainda estiver rolando:
                            if(!pSorteio.isSorteioPausado()){
                                //sortear:
                                pSorteio.sortearNum();    
                            }

                        }
                    }
                }
            }
        }
    }
}