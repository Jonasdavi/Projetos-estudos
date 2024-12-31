package com.mycompany;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class Main {
    public static Jogo jogo= new Jogo(10, 7); 
    public static void main(String[] args) {
        TelaJogo tJogo= new TelaJogo();
        
        
        tJogo.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e){
                switch(e.getKeyCode()){
                    case KeyEvent.VK_UP: jogo.setDirecao(jogo.CIMA); break;

                    case KeyEvent.VK_DOWN: jogo.setDirecao(jogo.BAIXO); break;

                    case KeyEvent.VK_RIGHT: jogo.setDirecao(jogo.DIREITA); break;

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