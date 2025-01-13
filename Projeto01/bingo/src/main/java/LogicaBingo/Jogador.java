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
            if(cartela==null){
                continue;
            }
            
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
    
    public boolean containsThisCartelaPremiada(Cartela c){
        return cartelasPremiadas.contains(c);
    }
    
    public boolean containsThisCartela(Cartela c){
        return cartelas.contains(c);
    }
    
    public void removerCartela(Cartela c){
        for(int i=0; i<cartelas.size(); i++){
            if(cartelas.get(i)==null){
                continue;
            }
            
            if(cartelas.get(i).equals(c)){
                cartelas.set(i, null);
                
                break;
            }
        }
        
        for(int i=0; i<cartelasPremiadas.size(); i++){
            if(cartelasPremiadas.get(i)==null){
                continue;
            }
            
            if(cartelasPremiadas.get(i).equals(c)){
                cartelasPremiadas.set(i, null);
                
                break;
            }
        }
        
    }

    protected void exibirCartelasPremiadas(){
        for(Cartela cartela : cartelasPremiadas){
            if(cartela==null){
                continue;
            }
            cartela.exibirCartela();
        }
    }

    public void exibirCartelas(){
        for(Cartela cartela : cartelas){
            if(cartela==null){
                continue;
            }
            cartela.exibirCartela();
        }
    }
    
    public void reiniciarCartelasPremiadas(){
        cartelasPremiadas= new ArrayList<Cartela>();
    }
    
    public boolean cartelasVazias(){
        for(Cartela cartela: cartelas){
            if(cartela!=null){
                return false;
            }
        }
        return true;
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