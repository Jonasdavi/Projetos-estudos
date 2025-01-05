package LogicaBingo;

import java.util.ArrayList;

public class Jogador{
    private String nome;
    private ArrayList<Cartela> cartelas= new ArrayList<Cartela>();
    private int qtCartelas;
    private boolean ganhou;
    private ArrayList<Cartela> cartelasPremiadas= new ArrayList<Cartela>();
    
    private Bingo bingo;


    public Jogador(String nome, int qtCartelas, Bingo b){
        this.nome=nome;
        ganhou= false;
        
        bingo=b;
        
        this.qtCartelas= qtCartelas;
        comprarCartelas();
    }

    private void comprarCartelas(){
        for(int i=0; i<qtCartelas; i++){
            bingo.venderCartela(this);
        }
    }
    
    protected void addCartela(Cartela c){
        cartelas.add(c);
    }
    


    protected boolean ganhou(){
        boolean ganhou=false;
        for(Cartela cartela : cartelas){
            if(cartela.ganhou()){
                if(cartelasPremiadas.isEmpty()){ //se a lista de cartelas premiadas tiver vazia
                    cartelasPremiadas.add(cartela);
                }
                else{ //se a lista de cartelas premiadas nao estiver vazia
                    if(!cartelasPremiadas.contains(cartela)){ //verificar se na lista de cartelas premiadas nao tem essa cartela ainda
                        cartelasPremiadas.add(cartela);
                    }
                }
                
                ganhou= true;
            }
        }
        return ganhou;
    }

    protected void exibirCartelasPremiadas(){
        for(Cartela cartela : cartelasPremiadas){
            cartela.exibirCartela();
        }
    }

    public void exibirCartelas(){
        for(Cartela cartela : cartelas){
            cartela.exibirCartela();
        }
    }

    public ArrayList<Cartela> getCartelas(){
        return cartelas;
    }
    public ArrayList<Cartela> getCartelasPremiadas(){
        return cartelasPremiadas;
    }

    public String getNome(){
        return nome;
    }
    
    public int getQtCartelas(){
        return qtCartelas;
    }
}