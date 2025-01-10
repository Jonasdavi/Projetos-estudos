package LogicaBingo;

import java.util.Arrays;
import java.util.Random;

import sql.CartelaDAO;

public class Cartela{
    private int cartela[][];
    private int cartelaMarcada[][]; //cartela retira os numeros já sorteados na mesma posição deixa -1
    private Integer[][] colunas; // para certificar que as colunas nao tenham numeros repetidos (Integer porque vou usar o metodo asList da classe Arrays que aceita apenas objetos)
    private int qtNumsMarcados;

    private final int QTNUMS=24; //Quantidade de numeros de uma cartela
    private final int TAMANHOLC=5; //tamanho da quantidade de linhas e colunas da cartela
    private final int LUGARFREE=0;
    
    //private static int idIncrement=1;
    private final int ID;

    private Random rand= new Random();
    
    private Bingo bingo;

    public Cartela(Bingo b){
        //iniciando id:
        //ID= idIncrement++;

        //como o id é depois do ultimo criado ate entao, o id desse é igual o ultimo mais 1
        ID= CartelaDAO.getUltimoId() + 1;
        
        bingo=b;
        
        //inicializando variaveis:
        cartela= new int[TAMANHOLC][TAMANHOLC];
        cartelaMarcada= new int[TAMANHOLC][TAMANHOLC];
        colunas= new Integer[TAMANHOLC][TAMANHOLC];
        qtNumsMarcados=0;

        gerarCartela();
    }

    public Cartela(Bingo b, int[][] cartela, int[][] cartelaMarcada, int id){
        bingo= b;
        this.ID= id;

        this.cartelaMarcada= cartelaMarcada;
        this.cartela= cartela;
    }


    public void gerarCartela(){
        
        do{
            //zerar numeros anteriores das colunas (para nao quebrar a verificaçao dos numeros repetidos)
            for(int c=0; c<TAMANHOLC; c++){
               for(int n=0; n<TAMANHOLC; n++){
                   colunas[c][n]=0;
               }
            }

            //percorrendo o laço de forma que as arrays da matrizes sejam as colunas
            for(int l=0; l<TAMANHOLC; l++){
                for(int c=0; c<TAMANHOLC; c++){
                    //para cada coluna, há um intervale de numero diferente
                
                    //coluna 0 (numeros possiveis: 1-15)
                    //coluna 1 (numeros possiveis: 16-30)
                    //coluna 2 (numeros possiveis: 31-45)
                    //coluna 3 (numeros possiveis: 46-60)
                    //coluna 4 (numeros possiveis: 61-75)

                    int numSorteado;
                    do{ 
                        numSorteado=(rand.nextInt(15)+1) + 15*c; //ajusta o intervalo de numeros possiveis de ser sorteado de acordo com a coluna
                    }while(Arrays.asList(colunas[c]).contains(numSorteado)); //verifica se a coluna ja tem o numero sorteado:

                    colunas[c][l]=numSorteado; //adicionando o numero sorteado a sua respectiva coluna

                    cartela[l][c]=  numSorteado; //adicionando numero a cartela

                    cartelaMarcada[l][c]=  numSorteado;
                }
            }
            //retirando o numero do meio da cartela por ele ser "free"
            cartela[2][2]= LUGARFREE;
            cartelaMarcada[2][2]= LUGARFREE;
            colunas[2][2]= LUGARFREE;
            
        }while(bingo.containsCartela(this));//gere numeros diferentes enquanto os numeros gerados for igual aos numeros de alguma cartela que já tem no bingo
    }
    

    
    public boolean equals(Cartela o){
        Integer[][] colunas= o.getColunas();

        for(int col=0; col<TAMANHOLC; col++){
            for(int n=0; n<TAMANHOLC; n++){
                if(Arrays.asList(colunas[col]).contains(this.colunas[col][n])){
                    continue;
                }
                else{
                    return false;
                }
            }
        }

        return true;
    }

    private boolean equals(Integer[][] colunasAtualizadas){

        for(int col=0; col<TAMANHOLC; col++){
            for(int n=0; n<TAMANHOLC; n++){
                if(Arrays.asList(colunas[col]).contains(this.colunas[col][n])){
                    continue;
                }
                else{
                    return false;
                }
            }
        }

        return true;
    }
    
    protected void inserirNumSorteado(int numSorteado){
        int colunaSorteada= numSorteado%15==0? numSorteado/15-1 : numSorteado/15; //encontrando o a coluna em função do numero sorteado

        for(int i=0; i<TAMANHOLC; i++){
            if(colunas[colunaSorteada][i] == numSorteado){
                cartelaMarcada[i][colunaSorteada]=-1;
                qtNumsMarcados++;
            }
        }
    }

    protected void exibirCartela(){
        System.out.println("ID: " + this.ID);
        
        for(int l=0; l<TAMANHOLC; l++){
            for(int c=0; c<TAMANHOLC; c++){
                System.out.print(cartela[l][c]+ (cartela[l][c]<=9?"   ":"  "));
            }
            System.out.println();

        }
        System.out.println("------------------");
        for(int l=0; l<TAMANHOLC; l++){
            for(int c=0; c<TAMANHOLC; c++){
                System.out.print((cartelaMarcada[l][c]==-1?"X" : cartelaMarcada[l][c]) + (cartelaMarcada[l][c]<=9?"   ":"  "));
            }
            System.out.println();

        }
        System.out.println();
    }

    protected boolean ganhou(){
        return qtNumsMarcados==QTNUMS;
    }

    public void setNumsCart(int[][] nums) {
        this.cartela = nums;
    }
    
    public void setMarcCart(int[][] marc) {
        this.cartelaMarcada = marc;
    }

    public int[][] getCartela(){
        return cartela;
    }
    public int[][] getCartelaMarcada(){
        return cartelaMarcada;
    }
    private Integer[][] getColunas(){
        return colunas;
    }

    public int getId(){
        return ID;
    }
}