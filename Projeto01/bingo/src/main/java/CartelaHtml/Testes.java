/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CartelaHtml;

import LogicaBingo.Bingo;
import LogicaBingo.Cartela;
import LogicaBingo.Jogador;

/**
 *
 * @author Jonas
 */
public class Testes {
    public static void main(String[] args) {
        Bingo bingo= new Bingo();
        bingo.venderCartela(new Jogador("", 1, bingo));

        //sua cartelas para testes:
        int[][] matrizCartela= bingo.pegarCartelaPeloId(1).getCartela();
    }
}
