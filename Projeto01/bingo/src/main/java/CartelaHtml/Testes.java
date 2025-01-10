/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cartelahtml;

import LogicaBingo.Bingo;
import LogicaBingo.Jogador;


/**
 * 
 * @author Jonas
 */
public class Testes {
    public static void main(String[] args) {
        Bingo bingo = new Bingo();
        bingo.venderCartela(new Jogador("Jogador1", 1, bingo)); // Supondo que isso crie a cartela para o jogador1

        ManipularCart manipularCart = new ManipularCart();
        manipularCart.adicionarCartela(bingo.pegarCartelaPeloId(1));

        // Se quiser adicionar mais cartelas, continue o processo
        bingo.venderCartela(new Jogador("Jogador2", 2, bingo));
        manipularCart.adicionarCartela(bingo.pegarCartelaPeloId(2));

        // Apagar cartelas
        manipularCart.apagarCartelas();
    }
}