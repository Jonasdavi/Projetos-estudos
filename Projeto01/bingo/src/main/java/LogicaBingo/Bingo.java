package LogicaBingo;

import java.util.ArrayList;
import java.util.Random;

public class Bingo{
    private ArrayList<Cartela> cartelasVendidas= new ArrayList<Cartela>();
    private ArrayList<Integer> numsRestantes= new ArrayList<Integer>(); //para verificar numeros repetidos
    private ArrayList<Jogador> jogadores= new ArrayList<Jogador>();
    private ArrayList<Jogador> ganhadores= new ArrayList<Jogador>();
    
    private int qtNumsSorteados;

    Random rand= new Random();

    public Bingo(){
        for(Integer i=1 ; i<=75 ; i++){
            numsRestantes.add(i);
        }

        qtNumsSorteados=0;
    }


    
    public void addJogador(Jogador j){
        jogadores.add(j);
    }

    public Cartela venderCartela(){
        Cartela c= new Cartela();
        boolean cartelaRepetida= false;

        
        do{ //faça isso enquanto a cartela for repetida
            //c.gerarCartela();
            for (Cartela cartelas : cartelasVendidas) {
                if(c.equals(cartelas)){
                    cartelaRepetida=true;
                    c.gerarCartela();
                    break;
                }
            }
            cartelaRepetida=false;
        }while(cartelaRepetida); //laço para rodar enquanto a cartela criada for repetida as quais já foram vendidas
        
        cartelasVendidas.add(c);
        return c;
    }

    public int sortearNum(){
        int indiceSorteado;
        Integer numSorteado;

        indiceSorteado= rand.nextInt(numsRestantes.size()); //sorteia um indice do arraylist dos numeros ainda nao sorteados
        numSorteado= numsRestantes.get(indiceSorteado); //pega o numero do indice sorteado
        numsRestantes.remove(indiceSorteado); //remove o numero do indice sorteado

        qtNumsSorteados++;
        System.out.println("sorteado: " + numSorteado);
        return numSorteado;
        
    }

    public void atualizarCartelas(int numSorteado){
        for(Cartela cartela : cartelasVendidas){
            cartela.inserirNumSorteado(numSorteado);
        }
    }

    public void addGanhador(Jogador ganhador){
        ganhadores.add(ganhador);
    }

    public ArrayList<Jogador> getGanhadores(){
        return ganhadores;
    }
    public int getQtNumsSorteados(){
        return qtNumsSorteados;
    }
}