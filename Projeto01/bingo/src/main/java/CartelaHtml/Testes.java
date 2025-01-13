/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cartelahtml;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import LogicaBingo.Bingo;
import LogicaBingo.Jogador;


/**
 * 
 * @author Jonas
 */
public class Testes {
    public static void main(String[] args) throws IOException, URISyntaxException {
        Bingo bingo = new Bingo();

        Jogador jogador= new Jogador("jonas", 3, bingo);
        Jogador jogador2= new Jogador("darlan", 2, bingo);

        ManipularCart mc= new ManipularCart();

        mc.addCartelas(jogador);

        mc.addCartelas(jogador2);






        
    }
}


/*Por quê vivo a sofrer
Pois eu nada fiz
Para merecer
Te dei carinho amor
Em troca ganhei ingratidão
Não sei porquê, mas acho
Que é falta de compreensão
Você me tem como réu
O culpado e o ladrão
Por tentar ganhar seu coração
Te dei carinho amor
Em troca ganhei ingratidão
Não sei porquê, mas acho
Que é falta de compreensão
Você me tem como réu
O culpado e o ladrão
Por tentar ganhar seu coração
Todo mundo erra
Todo mundo erra sempre
Todo mundo vai errar
Não sei porquê meu Deus
Sozinho eu vivo a penar
Não tenho nada a pedir
Também não tenho nada a dar
Por isso é que eu vou me mandar
Vou me embora agora
Vou me embora agora
Vou embora prá outro planeta
Na velocidade da luz
Ou quem sabe de um cometa
Eu vou solitário e frio
Onde a morte me aqueça
Talvez assim de uma vez
Para sempre eu lhe esqueça
Te dei carinho amor
Em troca ganhei ingratidão
Não sei porquê, mas acho
Que é falta de compreensão
Você me tem como réu
O culpado e o ladrão
Por tentar ganhar seu coração
Todo mundo erra
Todo mundo erra sempre
Todo mundo vai errar
Não sei porquê meu Deus
Sozinho eu vivo a penar
Não tenho nada a pedir
Também não tenho nada a dar
Por isso é que eu vou me mandar
Vou me embora agora
Vou me embora agora
Vou embora prá outro planeta
Na velocidade da luz
Ou quem sabe de um cometa
Eu vou solitário e frio
Onde a morte me aqueça
Talvez assim de uma vez
Todo mundo erra
Todo mundo erra sempre
Todo mundo vai errar
Não sei porquê meu Deus
Sozinho eu vivo a penar
Não tenho nada a pedir
Também não tenho nada a dar
Por isso é que eu vou me mandar
Por isso é que eu vou me mandar
Por isso é que eu vou me mandar*/
