package cartelahtml;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import LogicaBingo.Cartela;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ManipularCart{

    private String numerosCartelaHtml[]= new String[25];

    public ManipularCart(){
        
    }
    
    public void geraCartela(Cartela cartela){
        int[][] matrizCartela= cartela.getCartela();

        int qtColunas= matrizCartela[0].length;

        //tranformar a matriz em array de String:
        for(int l=0; l<matrizCartela.length; l++){
            for(int c=0; c<matrizCartela[0].length; c++){

                String zeroEsquerda= matrizCartela[l][c]<10? "0" : "";

                int indiceArray= l*qtColunas + c; //indice do array em relacao a matriz

                numerosCartelaHtml[indiceArray]= zeroEsquerda + String.valueOf(matrizCartela[l][c]);
            }
        }

        for(int l=0; l<numerosCartelaHtml.length; l++){

                System.out.println(numerosCartelaHtml[l]);
            
        }



        try{
            Document doc = Jsoup.parse(new File("src/main/java/cartelahtml/index.html"), "UTF-8");

            for(int i=0; i<numerosCartelaHtml.length; i++){

                if(numerosCartelaHtml[i].equals("00")){
                    continue;
                }

                String id= String.valueOf(i);
                Element botao= doc.getElementById(id);

                botao.text(numerosCartelaHtml[i]);
            }
            //Elements elementosNumeros = doc.select("button");


            // int indice = 0;
            // for (int i = 0; i < matrizCartela.length; i++) {
            //     for (int j = 0; j < matrizCartela[i].length; j++) {
            //         if (matrizCartela[i][j] != 0) {
            //             //Element botao = botoes.get(indice++);
            //             //botao.text(String.valueOf(matrizCartela[i][j]));
            //         } else {
            //             indice++; // Pula o elemento "Espaco Livre"
            //         }
            //     }
            // }

            FileWriter writer = new FileWriter("src/main/java/cartelahtml/cartela_nova.html");
            writer.write(doc.html());
            writer.close();

            System.out.println("Arquivo modificado salvo com sucesso!");
        }
        catch (IOException e) {
            System.out.println("Erro ao manipular arquivo: " + e.getMessage());
        }
    }
}