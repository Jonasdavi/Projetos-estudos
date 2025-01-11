package cartelahtml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import LogicaBingo.Cartela;
import LogicaBingo.Jogador;

public class ManipularCart {

    private Document doc;
    private String[] numerosCartelaHtml = new String[25];

    public ManipularCart() throws URISyntaxException {
        try {
            // Carregar o arquivo HTML existente (index.html) a partir de 'Projeto01/bingo/src/main/resources'
            File inputFile = new File(getClass().getClassLoader().getResource("cartelahtml/index.html").toURI());
            doc = Jsoup.parse(inputFile, "UTF-8");
        } catch (IOException e) {
            System.out.println("Erro ao carregar arquivo: " + e.getMessage());
        }
    }

    public void adicionarCartela(Cartela cartela) {
        int[][] matrizCartela = cartela.getCartela();
        int qtColunas = matrizCartela[0].length;

        // Preencher os números da cartela
        for (int l = 0; l < matrizCartela.length; l++) {
            for (int c = 0; c < matrizCartela[0].length; c++) {
                String zeroEsquerda = matrizCartela[l][c] < 10 ? "0" : "";
                int indiceArray = l * qtColunas + c;
                numerosCartelaHtml[indiceArray] = zeroEsquerda + String.valueOf(matrizCartela[l][c]);
            }
        }

        // Encontrar a tabela existente no HTML
        Element corpo = doc.body();

        Element tabela = corpo.select("table").first();  // Seleciona a primeira tabela existente

        // Se não encontrar a tabela, cria uma nova
        if (tabela == null) {
            tabela = corpo.appendElement("table");
            tabela.attr("border", "1");
        }

        // Criação de uma nova linha na tabela para a cartela
        Element corpoTabela = tabela.select("tbody").first();
        if (corpoTabela == null) {
            corpoTabela = tabela.appendElement("tbody");
        }

        // Preencher a tabela com os números da cartela
        for (int i = 0; i < 5; i++) {
            Element linha = corpoTabela.appendElement("tr");
            for (int j = 0; j < 5; j++) {
                int indice = i * 5 + j;
                if (indice < 25) {
                    Element botao = linha.appendElement("td").appendElement("button");
                    botao.attr("id", String.valueOf(indice));
                    botao.attr("onclick", "mudarCor()");
                    botao.text(numerosCartelaHtml[indice]);
                }
            }
        }

        // Adicionar o rodapé da cartela
        Element rodapeTabela = tabela.appendElement("tfoot");
        Element linhaRodape = rodapeTabela.appendElement("tr");
        linhaRodape.appendElement("td").attr("colspan", "5").attr("id", "idCartela").text("ID: " + cartela.getId());
        linhaRodape = rodapeTabela.appendElement("tr");
        linhaRodape.appendElement("td").attr("colspan", "5").attr("id", "nomeJogador").text("Jogador: ");

        // Salvar o arquivo HTML modificado
        try (FileWriter writer = new FileWriter("cartela_nova.html")) {
            writer.write(doc.html());
            System.out.println("Cartela adicionada com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo: " + e.getMessage());
        }
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public void apagarCartelas() throws URISyntaxException {
        try {
            // Carregar novamente o arquivo index.html da pasta resources
            File inputFile = new File(getClass().getClassLoader().getResource("cartelahtml/index.html").toURI());
            doc = Jsoup.parse(inputFile, "UTF-8");
            doc.body().empty();  // Apagar todo o conteúdo da página

            // Salvar o arquivo HTML vazio
            FileWriter writer = new FileWriter("cartela_nova.html");
            writer.write(doc.html());
            writer.close();
            System.out.println("Cartelas apagadas com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao apagar cartelas: " + e.getMessage());
        }
    }

    public void addCartelas(Jogador jogador){
        ArrayList<Cartela> cartelas = jogador.getCartelas();

        for(Cartela cartela : cartelas){
            addCartela(cartela, jogador.getNome());
        }
    }


    private int indiceNum=0;
    private void addCartela(Cartela cartela, String nomeJogador){
        String idCartela= String.valueOf(cartela.getId());

        int[][] matrizCartela = cartela.getCartela();
        int qtColunas = matrizCartela[0].length;

        // Preencher os números da cartela
        for (int l = 0; l < matrizCartela.length; l++) {
            for (int c = 0; c < matrizCartela[0].length; c++) {
                
                String zeroEsquerda = matrizCartela[l][c] < 10 ? "0" : "";
                int indiceArray = l * qtColunas + c;
                numerosCartelaHtml[indiceArray] = zeroEsquerda + String.valueOf(matrizCartela[l][c]);
            }
        }

        Element localAddCart= doc.getElementById("addCartelas");

        indiceNum= 0;
        String textoNovaCartela= "<div>\r\n" + //
                        "            <table border=\"1\">\r\n" + //
                        "                <thead>\r\n" + //
                        "                    <tr>\r\n" + //
                        "                        <th colspan=\"5\">Cartela</th>\r\n" + //
                        "                    </tr>\r\n" + //
                        "                </thead>\r\n" + //
                        "                <tbody>\r\n" + //
                        "                    <tr>\r\n" + //
                        "                        <td><button id=\"0\" onclick=\"mudarCor()\">" + numerosCartelaHtml[indiceNum++]  +  "</button></td>\r\n" + //
                        "                        <td><button id=\"1\" onclick=\"mudarCor()\">" + numerosCartelaHtml[indiceNum++]  +  "</button></td>\r\n" + //
                        "                        <td><button id=\"2\" onclick=\"mudarCor()\">" + numerosCartelaHtml[indiceNum++]  +  "</button></td>\r\n" + //
                        "                        <td><button id=\"3\" onclick=\"mudarCor()\">" + numerosCartelaHtml[indiceNum++] + "</button></td>\r\n" + //
                        "                        <td><button id=\"4\" onclick=\"mudarCor()\">" + numerosCartelaHtml[indiceNum++] + "</button></td>\r\n" + //
                        "                    </tr>\r\n" + //
                        "                    <tr>\r\n" + //
                        "                        <td><button id=\"5\" onclick=\"mudarCor()\">" + numerosCartelaHtml[indiceNum++] + "</button></td>\r\n" + //
                        "                        <td><button id=\"6\" onclick=\"mudarCor()\">" + numerosCartelaHtml[indiceNum++] + "</button></td>\r\n" + //
                        "                        <td><button id=\"7\" onclick=\"mudarCor()\">" + numerosCartelaHtml[indiceNum++] + "</button></td>\r\n" + //
                        "                        <td><button id=\"8\" onclick=\"mudarCor()\">" + numerosCartelaHtml[indiceNum++] + "</button></td>\r\n" + //
                        "                        <td><button id=\"9\" onclick=\"mudarCor()\">" + numerosCartelaHtml[indiceNum++] + "</button></td>\r\n" + //
                        "                    </tr>\r\n" + //
                        "                    <tr>\r\n" + //
                        "                        <td><button id=\"10\" onclick=\"mudarCor()\">" + numerosCartelaHtml[indiceNum++] + "</button></td>\r\n" + //
                        "                        <td><button id=\"11\" onclick=\"mudarCor()\">" + numerosCartelaHtml[indiceNum++] + "</button></td>\r\n" + //
                        "                        <td><p>Espaco</p><p>Livre</p></td>\r\n" + corrigirIndice() + //
                        "                        <td><button id=\"13\" onclick=\"mudarCor()\">" + numerosCartelaHtml[indiceNum++] + "</button></td>\r\n" + //
                        "                        <td><button id=\"14\" onclick=\"mudarCor()\">" + numerosCartelaHtml[indiceNum++] + "</button></td>\r\n" + //
                        "                    </tr>\r\n" + //
                        "                    <tr>\r\n" + //
                        "                        <td><button id=\"15\" onclick=\"mudarCor()\">" + numerosCartelaHtml[indiceNum++] + "</button></td>\r\n" + //
                        "                        <td><button id=\"16\" onclick=\"mudarCor()\">" + numerosCartelaHtml[indiceNum++] + "</button></td>\r\n" + //
                        "                        <td><button id=\"17\" onclick=\"mudarCor()\">" + numerosCartelaHtml[indiceNum++] + "</button></td>\r\n" + //
                        "                        <td><button id=\"18\" onclick=\"mudarCor()\">" + numerosCartelaHtml[indiceNum++] + "</button></td>\r\n" + //
                        "                        <td><button id=\"19\" onclick=\"mudarCor()\">" + numerosCartelaHtml[indiceNum++] + "</button></td>\r\n" + //
                        "                    </tr>\r\n" + //
                        "                    <tr>\r\n" + //
                        "                        <td><button id=\"20\" onclick=\"mudarCor()\">" + numerosCartelaHtml[indiceNum++] + "</button></td>\r\n" + //
                        "                        <td><button id=\"21\" onclick=\"mudarCor()\">" + numerosCartelaHtml[indiceNum++] + "</button></td>\r\n" + //
                        "                        <td><button id=\"22\" onclick=\"mudarCor()\">" + numerosCartelaHtml[indiceNum++] + "</button></td>\r\n" + //
                        "                        <td><button id=\"23\" onclick=\"mudarCor()\">" + numerosCartelaHtml[indiceNum++] + "</button></td>\r\n" + //
                        "                        <td><button id=\"24\" onclick=\"mudarCor()\">" + numerosCartelaHtml[indiceNum++] + "</button></td>\r\n" + //
                        "                    </tr>\r\n" + //
                        "                </tbody>\r\n" + //
                        "                <tfoot>\r\n" + //
                        "                    <tr>\r\n" + //
                        "                        <td colspan=\"5\" id=\"idCartela\">ID: "+ idCartela +"</td>\r\n" + //
                        "                    </tr>\r\n" + //
                        "                    <tr>\r\n" + //
                        "                        <td colspan=\"5\" id=\"nomeJogador\">Jogador: "+ nomeJogador +"</td>\r\n" + //
                        "                    </tr>\r\n" + //
                        "                </tfoot>\r\n" + //
                        "            </table>\r\n" + //
                        "        </div>\r\n" + //
                        "      <br>";

        localAddCart.append(textoNovaCartela);

        try {
            File outputFile = new File("src/main/java/cartelahtml/cartela_nova.html");
            FileWriter writer = new FileWriter(outputFile);
            writer.write(doc.outerHtml());
            writer.close();
            
            System.out.println("Arquivo salvo com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        

    }

    private String corrigirIndice(){
        indiceNum++;
        return "";
    }
    
}