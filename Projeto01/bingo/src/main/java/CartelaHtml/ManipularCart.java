package cartelahtml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import LogicaBingo.Cartela;

public class ManipularCart {

    private Document doc;
    private String[] numerosCartelaHtml = new String[25];

    public ManipularCart() {
        try {
            // Carregar o arquivo HTML existente (index.html)
            doc = Jsoup.parse(new File("src/main/java/cartelahtml/index.html"), "UTF-8");
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
        try (FileWriter writer = new FileWriter("src/main/java/cartelahtml/cartela_nova.html")) {
            writer.write(doc.html());
            System.out.println("Cartela adicionada com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo: " + e.getMessage());
        }
    }

    
    @SuppressWarnings("ConvertToTryWithResources")
    public void apagarCartelas() {
        try {
            // Carregar novamente o arquivo index.html
            doc = Jsoup.parse(new File("src/main/java/cartelahtml/index.html"), "UTF-8");
            doc.body().empty();  // Apagar todo o conteúdo da página
            FileWriter writer = new FileWriter("src/main/java/cartelahtml/cartela_nova.html");
            writer.write(doc.html());
            writer.close();
            System.out.println("Cartelas apagadas com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao apagar cartelas: " + e.getMessage());
        }
    }
}
