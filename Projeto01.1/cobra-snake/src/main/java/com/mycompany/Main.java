package com.mycompany;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        TelaJogo tJogo= new TelaJogo();
        Jogo jogo= new Jogo(10, 10, tJogo);
        
        //pega tecla clicada:
        tJogo.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e){
                switch(e.getKeyCode()){
                    //se for sima
                    case KeyEvent.VK_UP: jogo.setDirecao(jogo.CIMA); break;

                    //se for baixo
                    case KeyEvent.VK_DOWN: jogo.setDirecao(jogo.BAIXO); break;

                    //se for direita
                    case KeyEvent.VK_RIGHT: jogo.setDirecao(jogo.DIREITA); break;

                    //se for esquerda
                    case KeyEvent.VK_LEFT: jogo.setDirecao(jogo.ESQUERDA); break;
                }
            }
        });
        
        tJogo.setVisible(true);
        
        while(true){
            jogo.cobraAndarUm();
            jogo.exibirArea();
            jogo.pausarCobra();
            System.out.println();
        }
    }
}