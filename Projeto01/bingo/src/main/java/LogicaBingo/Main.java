package LogicaBingo;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
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
        
        tela.setVisible(true);
        tela.irSorteio();
        
        while(true){
            //while(true){
            if(tela.getSorteio().jogoPausado){
                //System.out.println("jogoPausado");
                try {//pausar fala pela quantidade de tempo desejada
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(PanelSorteio.class.getName()).log(Level.SEVERE, null, ex);
                }
                continue;
                
            }
            else if(tela.getSorteio().jogoAcabado){
                break;
            }
            else{ 
                //sortear:
                tela.getSorteio().sortearNum();
                
                //se o jogo nao estiver acabado ou pausado, continue o sorteio
                //System.out.println("jogorodando");
                try {//pausar fala pela quantidade de tempo desejada
                    Thread.sleep(tela.getSorteio().tempoSortear*1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(PanelSorteio.class.getName()).log(Level.SEVERE, null, ex);
                }
                
           // }
        }
        }
        System.out.println("fim Sorteio");
        
    }
}