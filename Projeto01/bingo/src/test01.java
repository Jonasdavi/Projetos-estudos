public class test01 {
    public static void main(String[] args) throws Exception {
        Bingo bingo= new Bingo();
        Jogador j[]= new Jogador[1000];

        for(int i=0; i<j.length; i++){
            j[i]= new Jogador("jogador "+ (i+1));
            j[i].comprarCartelas(5, bingo);
        }

        do {
            System.out.println("rodada: "+ (bingo.getQtNumsSorteados() + 1));
            //sortea o numero e atualiza as cartelas em seguida
            bingo.atualizarCartelas(bingo.sortearNum());

            //verificando se há vencedores:
            for(int i=0; i<j.length; i++){
                if(j[i].ganhou()){
                    bingo.addGanhador(j[i]);
                }
                //ystem.out.println(j[i].getNome()+":");
                //j[i].exibirCartelas();
            }
            System.out.println();
            Thread.sleep(100);
        } while (bingo.getGanhadores().isEmpty());

        System.out.println();
        System.out.println("Quantidade de rodadas: "+bingo.getQtNumsSorteados());
        for(Jogador ganhador : bingo.getGanhadores()){
            System.out.println(ganhador.getNome());
            ganhador.exibirCartelasPremiadas();
        }
    }
}
