import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class ManipularCart.java{
    public void geraCartela(int[][] matrizCartela){
        try{
            Document doc = Jsoup.parse(new File("index.html"), "UTF-8");
            Elements elementosNumeros = doc.select("button");

            //doc.getElement

            int indice = 0;
            for (int i = 0; i < matrizCartela.length; i++) {
                for (int j = 0; j < matrizCartela[i].length; j++) {
                    if (matrizCartela[i][j] != 0) {
                        Element botao = botoes.get(indice++);
                        botao.text(String.valueOf(matrizCartela[i][j]));
                    } else {
                        indice++; // Pula o elemento "Espaco Livre"
                    }
                }
            }
            FileWriter writer = new FileWriter("cartela_nova.html");
            writer.write(doc.html());
            writer.close();

            System.out.println("Arquivo modificado salvo com sucesso!");
        }
        catch (IOException e) {
            System.out.println("Erro ao manipular arquivo: " + e.getMessage());
        }
    }
}