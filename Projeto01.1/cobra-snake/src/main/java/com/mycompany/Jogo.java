package com.mycompany;

import java.awt.Color;
import java.security.interfaces.XECPublicKey;
import java.util.ArrayList;
import java.util.Random;

public class Jogo {
    private TelaJogo tJogo;
    private int[][] area; //area do jogo
    private int[] xyTamanhoArea; //tamanho horizontal e vertical da area
    private int[] xyCabecaCobra;
    private ArrayList<int[]> xyHistoricoCabeca= new ArrayList<int[]>(); //hostorico para orientar a posicao do corpo da cobra 
    private int tamanhoCobra;
    private int direcao;
    private int tempoAndar; //quantidade de tempo em milisegundos que a cobra leva pra andar uma casa
    private int[] xyComida;
    //xy vazios para sortear a comida diretamente em um dos espacos vazios:
    private ArrayList<int[]> xyVazios= new ArrayList<int[]>();

    //constantes que ocuparao as areas:
    private final int COBRA=1;
    private final int COMIDA=2;
    private final int ESPACO=3;
    //constantes que ocuparao as areas na tela do jogo (cores):
    private final Color CORCOBRA= Color.GREEN;
    private final Color CORCOMIDA= Color.ORANGE;
    private final Color CORESPACO= Color.darkGray;
    //direcoes
    public final int DIREITA=4;
    public final int ESQUERDA=5;
    public final int CIMA=6;
    public final int BAIXO=7;
    private final int X=0; //referencia x dos arrays xy
    private final int Y=1; //referencia y dos arrays xy
    
    public Jogo(int xArea, int yArea, TelaJogo tj){
        tJogo=tj;//variavel da tela do jogo 
        
        //ajustando largura e altura da area
        xyTamanhoArea= new int[2];
        xyTamanhoArea[X]= xArea;
        xyTamanhoArea[Y]= yArea;
        
        //ajustando altura e largura da area na tela
        tJogo.ajustarTamanho(yArea, xArea); 
        
        //iniciando cobra na posicao [0][0] do tabuleiro
        xyCabecaCobra= new int[2];
        xyCabecaCobra[X]= 0; 
        xyCabecaCobra[Y]= 0;

        //iniciando tamanho da cobra como 1:
        tamanhoCobra=1;

        //iniciando direcao da cobra para direita
        direcao= DIREITA;

        //iniciando area:
        area= new int[yArea][xArea];
        
        //definindo espacos vazios na area:
        for(int y=0; y<yArea; y++){
            for (int x=0; x<xArea; x++){
                area[y][x]= ESPACO;
                tJogo.ajustarCor(y, x, CORESPACO);
                int [] xyVazio= {x,y};
                xyVazios.add(xyVazio);
            }
        }
        
        //definindo a posicao da cobra na area e tela:
        area[xyCabecaCobra[Y]][xyCabecaCobra[X]] = COBRA; //posicao [0][0] = cobra
        tJogo.ajustarCor(xyCabecaCobra[Y], xyCabecaCobra[X], CORCOBRA);
        
        //atualizando espacos vazios:
        addOcupacao(xyCabecaCobra[X], xyCabecaCobra[Y]);

        //definindo tempo que a cobra leva pra andar um bloco para 1 segundo
        tempoAndar= 50;

        //iniciando array de xy da comida
        xyComida= new int[2];
        //gerando a primeira comida
        gerarComida();

        
    }
    

    public void exibirArea(){
        for(int y=0; y<xyTamanhoArea[Y]; y++){
            for(int x=0; x<xyTamanhoArea[X]; x++){
                if(area[y][x]==COBRA){
                    System.out.print('+');
                }
                else if(area[y][x]==COMIDA){
                    System.out.print('*');
                }
                else{
                    System.out.print('-');
                }
            }
            System.out.println();
        }
    }

    public void cobraAndarUm(){
        int passoHorizontal, passoVertical;
        int PDIREITA, PBAIXO, PCIMA, PESQUERDA, PARADO;//definindo constantes da direçao em relacao ao passo na matriz
        PDIREITA= PBAIXO =  1; 
        PESQUERDA= PCIMA= -1;
        PARADO=0;
        
        int bordaDirecao; //borda que a cobra esta indo em direcao
        int proximoPasso;// proximo passo da cabeca da cobra em relacao a direcao que ela está
        
        if(direcao==DIREITA){
            passoHorizontal= PDIREITA;
            passoVertical= PARADO;
            bordaDirecao= area[0].length; 
            proximoPasso= xyCabecaCobra[X]+passoHorizontal;
        }
        else if(direcao==ESQUERDA){
            passoHorizontal= PESQUERDA;
            passoVertical= PARADO;
            bordaDirecao= -1;
            proximoPasso= xyCabecaCobra[X]+passoHorizontal;
        }
        else if(direcao==BAIXO){
            passoHorizontal= PARADO;
            passoVertical= PBAIXO;
            bordaDirecao= area.length;
            proximoPasso= xyCabecaCobra[Y]+passoVertical;
        }
        else{ //CIMA
            passoHorizontal= PARADO;
            passoVertical= PCIMA;
            bordaDirecao=-1;
            proximoPasso= xyCabecaCobra[Y]+passoVertical;
        }
        
        if (proximoPasso == bordaDirecao) {
                //perdeu
                return;
        }
        
        //posicao xy da cobra caso ela ande:
        int posicaoYCabeca= xyCabecaCobra[Y]+passoVertical;
        int posicaoXCabeca= xyCabecaCobra[X]+passoHorizontal;
        
        //verificar se o proximo passo é o proprio corpo da cobra
        if(area[posicaoYCabeca][posicaoXCabeca] == COBRA){
            //perdeu
            return;
        }
        
        //se nao perdeu, entao:
        //adicionar o local onde ele tava no historico:
        int[] xyAddHistorico= {xyCabecaCobra[X], xyCabecaCobra[Y]}; //mudando referencia
        xyHistoricoCabeca.add(xyAddHistorico);

        //adicionar novo local na area e tela:
        xyCabecaCobra[Y]= posicaoYCabeca;
        xyCabecaCobra[X]= posicaoXCabeca;
        
        area[xyCabecaCobra[Y]][xyCabecaCobra[X]]= COBRA;
        tJogo.ajustarCor(xyCabecaCobra[Y], xyCabecaCobra[X], CORCOBRA);

        //adicionando a nova ocupacao da area no historico: 
        addOcupacao(xyCabecaCobra[X], xyCabecaCobra[Y]);
        
        //se o proximo passo for comida
        if(area[posicaoYCabeca][posicaoXCabeca] == COMIDA){
            gerarComida();
        }
        else{ //se for espaco vazio
            //entao corte a calda que ficaria no final da cobra
            //a calda esta na primeira insersao (nao exluida ate entao)
                int indiceCaldaHistorico= 0; 
            int[] xyCalda= xyHistoricoCabeca.get(indiceCaldaHistorico);
            //remover na area e tela:
            area[xyCalda[Y]][xyCalda[X]]= ESPACO;
            tJogo.ajustarCor(xyCalda[Y], xyCalda[X], CORESPACO);

            //removendo ocupacao onde a calda da cobra estava
            removerOcupacao(xyCalda[X], xyCalda[Y]);
        }
        
        if(direcao==DIREITA){
            int passoDireita=1;
            //verificar se dps de andar ela bate na borda:
            

            //verificar se o proximo passo é vazio:
            if(area[xyCabecaCobra[Y]][xyCabecaCobra[X]+passoDireita] == ESPACO){
                //adicionar o local onde ele tava no historico:
                int[] xyAddHistorico= {xyCabecaCobra[X], xyCabecaCobra[Y]}; //mudando referencia
                xyHistoricoCabeca.add(xyAddHistorico);

                //adicionar novo local na area e tela:
                xyCabecaCobra[X]++; //passo à direita
                area[xyCabecaCobra[Y]][xyCabecaCobra[X]]= COBRA;
                tJogo.ajustarCor(xyCabecaCobra[Y], xyCabecaCobra[X], CORCOBRA);

                //a calda esta na primeira insersao (nao exluida ate entao)
                int indiceCaldaHistorico= 0; 
                int[] xyCalda= xyHistoricoCabeca.get(indiceCaldaHistorico);

                //remover na area e tela:
                area[xyCalda[Y]][xyCalda[X]]= ESPACO;
                tJogo.ajustarCor(xyCalda[Y], xyCalda[X], CORESPACO);

                //corrigir ocupaçoes:
                addOcupacao(xyCabecaCobra[X], xyCabecaCobra[Y]);
                removerOcupacao(xyCalda[X], xyCalda[Y]);

                //remover do historico
                xyHistoricoCabeca.remove(indiceCaldaHistorico);



            }
            //verificar se o proximo passo é comida
            else if(area[xyCabecaCobra[Y]][xyCabecaCobra[X]+passoDireita] == COMIDA){
                //adicionar o local onde ele tava no historico:
                int[] xyAddHistorico= {xyCabecaCobra[X], xyCabecaCobra[Y]}; //mudando referencia
                xyHistoricoCabeca.add(xyAddHistorico);

                //adicionar novo local na area e tela:
                xyCabecaCobra[X]++; //passo à direita
                area[xyCabecaCobra[Y]][xyCabecaCobra[X]]= COBRA;
                tJogo.ajustarCor(xyCabecaCobra[Y], xyCabecaCobra[X], CORCOBRA);

                //corrigir ocupaçoes:
                addOcupacao(xyCabecaCobra[X], xyCabecaCobra[Y]);


                gerarComida();
                tamanhoCobra++;

            }
            //verificar se a cobra bate na borda ou em si mesma
            else{
                //bateu
                return;
            }
        
        }
        else if (direcao==ESQUERDA) {
            int passoEsquerda=-1;
            //verificar se dps de andar ela bate na borda:
            if (xyCabecaCobra[X]+passoEsquerda == -1) {
                //perdeu
                return;
            }

            //verificar se o proximo passo é vazio:
            if(area[xyCabecaCobra[Y]][xyCabecaCobra[X]+passoEsquerda] == ESPACO){
                //adicionar o local onde ele tava no historico:
                int[] xyAddHistorico= {xyCabecaCobra[X], xyCabecaCobra[Y]}; //mudando referencia
                xyHistoricoCabeca.add(xyAddHistorico);

                //adicionar novo local da cobra na area e tela:
                xyCabecaCobra[X]--; //passo à esquerda
                area[xyCabecaCobra[Y]][xyCabecaCobra[X]]= COBRA;
                tJogo.ajustarCor(xyCabecaCobra[Y], xyCabecaCobra[X], CORCOBRA);

                //a calda esta na primeira insersao (nao exluida ate entao)
                int indiceCaldaHistorico= 0; 
                int[] xyCalda= xyHistoricoCabeca.get(indiceCaldaHistorico);

                //remover na area e tela:
                area[xyCalda[Y]][xyCalda[X]]= ESPACO;
                tJogo.ajustarCor(xyCalda[Y], xyCalda[X], CORESPACO);

                //corrigir ocupaçoes:
                addOcupacao(xyCabecaCobra[X], xyCabecaCobra[Y]);
                removerOcupacao(xyCalda[X], xyCalda[Y]);

                //remover do historico
                xyHistoricoCabeca.remove(indiceCaldaHistorico);



            }
            //verificar se o proximo passo é comida
            else if(area[xyCabecaCobra[Y]][xyCabecaCobra[X]+passoEsquerda] == COMIDA){
                //adicionar o local onde ele tava no historico:
                int[] xyAddHistorico= {xyCabecaCobra[X], xyCabecaCobra[Y]}; //mudando referencia
                xyHistoricoCabeca.add(xyAddHistorico);

                //adicionar novo local na area e tela:
                xyCabecaCobra[X]--; //passo à esquerda
                area[xyCabecaCobra[Y]][xyCabecaCobra[X]]= COBRA;
                tJogo.ajustarCor(xyCabecaCobra[Y], xyCabecaCobra[X], CORCOBRA);

                //corrigir ocupaçoes:
                addOcupacao(xyCabecaCobra[X], xyCabecaCobra[Y]);


                gerarComida();
                tamanhoCobra++;

            }
            //verificar se a cobra bate na borda ou em si mesma
            else{
                //bateu
                return;
            }
        
        }
        else if (direcao==BAIXO) {
            int passoBaixo=1;
            //verificar se dps de andar ela bate na borda:
            if (xyCabecaCobra[Y]+passoBaixo == area.length) {
                //perdeu
                return;
            }

            //verificar se o proximo passo é vazio:
            if(area[xyCabecaCobra[Y]+passoBaixo][xyCabecaCobra[X]] == ESPACO){
                //adicionar o local onde ele tava no historico:
                int[] xyAddHistorico= {xyCabecaCobra[X], xyCabecaCobra[Y]}; //mudando referencia
                xyHistoricoCabeca.add(xyAddHistorico);

                //adicionar novo local na area e tela:
                xyCabecaCobra[Y]++; //passo para baixo
                area[xyCabecaCobra[Y]][xyCabecaCobra[X]]= COBRA;
                tJogo.ajustarCor(xyCabecaCobra[Y], xyCabecaCobra[X], CORCOBRA);

                //a calda esta na primeira insersao (nao exluida ate entao)
                int indiceCaldaHistorico= 0; 
                int[] xyCalda= xyHistoricoCabeca.get(indiceCaldaHistorico);

                //remover na area e tela:
                area[xyCalda[Y]][xyCalda[X]]= ESPACO;
                tJogo.ajustarCor(xyCalda[Y], xyCalda[X], CORESPACO);

                //corrigir ocupaçoes:
                addOcupacao(xyCabecaCobra[X], xyCabecaCobra[Y]);
                removerOcupacao(xyCalda[X], xyCalda[Y]);

                //remover do historico
                xyHistoricoCabeca.remove(indiceCaldaHistorico);



            }
            //verificar se o proximo passo é comida
            else if(area[xyCabecaCobra[Y]+passoBaixo][xyCabecaCobra[X]] == COMIDA){
                //adicionar o local onde ele tava no historico:
                int[] xyAddHistorico= {xyCabecaCobra[X], xyCabecaCobra[Y]}; //mudando referencia
                xyHistoricoCabeca.add(xyAddHistorico);

                //adicionar novo local na area e tela:
                xyCabecaCobra[Y]++; //passo para baixo
                area[xyCabecaCobra[Y]][xyCabecaCobra[X]]= COBRA;
                tJogo.ajustarCor(xyCabecaCobra[Y], xyCabecaCobra[X], CORCOBRA);

                //corrigir ocupaçoes:
                addOcupacao(xyCabecaCobra[X], xyCabecaCobra[Y]);


                gerarComida();
                tamanhoCobra++;

            }
            //verificar se a cobra bate na borda ou em si mesma
            else{
                //bateu
                return;
            }
        }
        else{ //CIMA
            int passoCima=-1;
            //verificar se dps de andar ela bate na borda:
            if (xyCabecaCobra[Y]+passoCima == -1) {
                //perdeu
                return;
            }

            //verificar se o proximo passo é vazio:
            if(area[xyCabecaCobra[Y]+passoCima][xyCabecaCobra[X]] == ESPACO){
                //adicionar o local onde ele tava no historico:
                int[] xyAddHistorico= {xyCabecaCobra[X], xyCabecaCobra[Y]}; //mudando referencia
                xyHistoricoCabeca.add(xyAddHistorico);

                //adicionar novo local na area e tela:
                xyCabecaCobra[Y]--; //passo para cima
                area[xyCabecaCobra[Y]][xyCabecaCobra[X]]= COBRA;
                tJogo.ajustarCor(xyCabecaCobra[Y], xyCabecaCobra[X], CORCOBRA);

                //a calda esta na primeira insersao (nao exluida ate entao)
                int indiceCaldaHistorico= 0; 
                int[] xyCalda= xyHistoricoCabeca.get(indiceCaldaHistorico);

                //remover na area e tela:
                area[xyCalda[Y]][xyCalda[X]]= ESPACO;
                tJogo.ajustarCor(xyCalda[Y], xyCalda[X], CORESPACO);

                //corrigir ocupaçoes:
                addOcupacao(xyCabecaCobra[X], xyCabecaCobra[Y]);
                removerOcupacao(xyCalda[X], xyCalda[Y]);

                //remover do historico
                xyHistoricoCabeca.remove(indiceCaldaHistorico);



            }
            //verificar se o proximo passo é comida
            else if(area[xyCabecaCobra[Y]+passoCima][xyCabecaCobra[X]] == COMIDA){
                //adicionar o local onde ele tava no historico:
                int[] xyAddHistorico= {xyCabecaCobra[X], xyCabecaCobra[Y]}; //mudando referencia
                xyHistoricoCabeca.add(xyAddHistorico);

                //adicionar novo local na area e tela:
                xyCabecaCobra[Y]--; //passo para cima
                area[xyCabecaCobra[Y]][xyCabecaCobra[X]]= COBRA;
                tJogo.ajustarCor(xyCabecaCobra[Y], xyCabecaCobra[X], CORCOBRA);

                //corrigir ocupaçoes:
                addOcupacao(xyCabecaCobra[X], xyCabecaCobra[Y]);


                gerarComida();
                tamanhoCobra++;

            }
            //verificar se a cobra bate na borda ou em si mesma
            else{
                //bateu
                return;
            }
        }
    }

    

    public void gerarComida(){
        Random rand= new Random();
        int indiceSorteado= rand.nextInt(xyVazios.size());
        int[] xySorteado= xyVazios.get(indiceSorteado);

        area[xySorteado[Y]][xySorteado[X]]= COMIDA;
        tJogo.ajustarCor(xySorteado[Y], xySorteado[X], CORCOMIDA);

        //removendo o local da comida dos espacos vazios:
        xyVazios.remove(xySorteado);
    }

    public void pausarCobra(){
        try {
            Thread.sleep(tempoAndar);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void setTempoAndar(int tempoAndar){
        this.tempoAndar= tempoAndar;
    }

    public void addOcupacao(int x, int y){
        for(int i=0; i<xyVazios.size(); i++){
            if(xyVazios.get(i)[X]==x  && xyVazios.get(i)[Y]==y){
                xyVazios.remove(xyVazios.get(i));
                return;
            }
        }
        return;
        
    }
    
    public void removerOcupacao(int x, int y){
        int [] xy= {x, y};
        xyVazios.add(xy);
        return;
        
    }

    public void teste(){
        for(int[] xyvazio : xyVazios){
            for(int i=0; i<2; i++){
                System.out.print(xyvazio[i] + "  ");
            }
            System.out.println();
        }
    }

    public void setDirecao(int DIRECAO){
        //se for setar para uma direção oposta, nao faça nada
        if(direcao==ESQUERDA && DIRECAO==DIREITA || direcao==DIREITA && DIRECAO==ESQUERDA
        || direcao==CIMA && DIRECAO==BAIXO || direcao==BAIXO && DIRECAO==CIMA){
            return;
        }
        else{
            direcao=DIRECAO;
        }
    }
    
//    public static void main(String[] args) {
//        Jogo j=new Jogo(10, 7);
//        for(int i=2; i<j.area[0].length; i++){
//            System.out.println();
//            j.pausarCobra();
//            j.exibirArea();
//            j.cobraAndarUm();
//        }
//        j.setDirecao(j.BAIXO);
//        for(int i=2; i<j.area.length; i++){
//            System.out.println();
//            j.pausarCobra();
//            j.exibirArea();
//            j.cobraAndarUm();
//        }
//        j.setDirecao(j.ESQUERDA);
//        for(int i=2; i<j.area[0].length; i++){
//            System.out.println();
//            j.pausarCobra();
//            j.exibirArea();
//            j.cobraAndarUm();
//        }
//        j.setDirecao(j.CIMA);
//        for(int i=2; i<j.area.length; i++){
//            System.out.println();
//            j.pausarCobra();
//            j.exibirArea();
//            j.cobraAndarUm();
//        }
//    }
//    
}
