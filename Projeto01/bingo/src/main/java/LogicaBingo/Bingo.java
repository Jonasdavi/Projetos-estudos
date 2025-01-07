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

    public void venderCartela(Jogador comprador){
        Cartela c= new Cartela(this);
        
        comprador.addCartela(c);
        cartelasVendidas.add(c);
        
        if(!jogadores.contains(comprador)){
            jogadores.add(comprador);
        }
    }
    
    public boolean containsCartela(Cartela c){ //verifica se os numeros da cartela sao iguais as que ja tem
        for (Cartela cartela : cartelasVendidas) {
            if(c.equals(cartela) && c!=cartela){ //se tiver alguma cartela com o mesmo numero e a referencia for diferente
                return true;
            }
        }
        return false;
    }

    public int sortearNum(){
        
        int indiceSorteado;
        Integer numSorteado;

        indiceSorteado= rand.nextInt(numsRestantes.size()); //sorteia um indice do arraylist dos numeros ainda nao sorteados
        numSorteado= numsRestantes.get(indiceSorteado); //pega o numero do indice sorteado
        numsRestantes.remove(indiceSorteado); //remove o numero do indice sorteado

        qtNumsSorteados++;
        
        System.out.println("sorteado: " + numSorteado);
        
        //após sortear o num, atualizar as cartelas e verificar vitoria 
        this.atualizarCartelas(numSorteado);
        this.verificarVitoria();
        
        return numSorteado;
        
        
    }
    
    private void verificarVitoria(){
        if(qtNumsSorteados>24){
            for(int i=0; i<jogadores.size(); i++){
                if(jogadores.get(i).ganhou()){
                    if(ganhadores.isEmpty()){ //se nao tiver nada na lista de ganhadores
                        ganhadores.add(jogadores.get(i));
                    }
                    else{ //se ja tiver ganhadores
                        if(!ganhadores.contains(jogadores.get(i))){ //verifica se a lista de ganhadores já tem esse jogador para nao duplicalo
                            ganhadores.add(jogadores.get(i));
                        }
                    }
                    
                }
            }
        }
    }

    private void atualizarCartelas(int numSorteado){
        for(Cartela cartela : cartelasVendidas){
            cartela.inserirNumSorteado(numSorteado);
        }
    }
    
    public void exibirCartelasPremiadas(){
        if(!ganhadores.isEmpty()){
            for(int i=0; i<ganhadores.size(); i++){
                ganhadores.get(i).exibirCartelasPremiadas();
            }
        }
    }

    public void addGanhador(Jogador ganhador){
        ganhadores.add(ganhador);
    }

    public ArrayList<Jogador> getGanhadores(){
        return ganhadores;
    }
    
    public Cartela pegarCartelaPeloId(int id){
        if(id>cartelasVendidas.size() || id<1){
            return null;
        }
        return cartelasVendidas.get(id-1);
    }
    
    public int getQtNumsSorteados(){
        return qtNumsSorteados;
    }
    
    public int getQtJogadores(){
        return jogadores.size();
    }
    
   public int getQtCartelas(){
       return cartelasVendidas.size();
   }
}