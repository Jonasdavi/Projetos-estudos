package sql;

import LogicaBingo.Bingo;
import LogicaBingo.Jogador;

public class testes {
    public static void main(String[] args) {
        Bingo b= new Bingo();
        Jogador j= new Jogador("Jonas", 10, b);

        b.exibirCartelas();
    }
}
