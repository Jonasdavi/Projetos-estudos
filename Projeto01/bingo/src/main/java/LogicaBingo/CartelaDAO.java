package LogicaBingo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CartelaDAO
{
    public void salvarNoBanco(int cartela[][], int cartelaMarcada[][], Jogador j)
    {
        String cartelaString = "";
        String sql = "insert into cartelas (numeros, marcados, jogador_nome) values (?, ?, ?)";
        try (Connection conn = Conexao.obterConexao())
        {
            PreparedStatement stmt = conn.prepareStatement(sql);

            //Converter os números da cartela para strings separadas por vírgulas
            cartelaString = matrizParaString(cartela);
            String cartelaMarcString = matrizParaString(cartelaMarcada);

            stmt.setString(1, cartelaString);
            stmt.setString(2, cartelaMarcString);
            stmt.setString(3, j.getNome());

            stmt.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public Cartela buscarPorId(int id)
    {
        String sql = "select * from cartelas where id = ?";
        Cartela cartela = null;
        try (Connection conn = Conexao.obterConexao())
        {
            //Verificando se o id é negativo
            if (id <= 0)
            {
                throw new IllegalArgumentException("O ID fornecido é inválido");
            }
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery())
            {
                if (rs.next())
                {
                    String numerosString = rs.getString("numeros");
                    String marcadosString = rs.getString("marcados");
                    String jogadorNome = rs.getString("jogador_nome"); //Nem usei
                    
                    //Transformar as strings numerosString e marcadosString em matrizes
                    int[][] numerosMatriz = stringParaMatriz(numerosString, 5, 5);
                    int[][] marcadosMatriz = stringParaMatriz(marcadosString, 5, 5);

                    Bingo bingo = new Bingo();
                    cartela = new Cartela(bingo);

                    cartela.setNumsCart(numerosMatriz);
                    cartela.setMarcCart(marcadosMatriz);
                }
                else
                {
                    System.out.println("Nenhuma cartela encontrada com o ID " + id);
                }
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException("Erro ao buscar a cartela no banco de dados");
        }
        return cartela;
    }

    public int getUltimoId()
    {
        String sql = "select max(id) as ultimo_id from cartelas";
        int ultimoId = -1;

        try (Connection conn = Conexao.obterConexao())
        {
            PreparedStatement stmt = conn.prepareStatement(sql);
            try (ResultSet rs = stmt.executeQuery())
            {
                if (rs.next())
                {
                    ultimoId = rs.getInt("ultimo_id");
                }
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException("Erro ao buscar o último ID no banco de dados");
        }
        return ultimoId;

    }

    //Métodos auxiliares
    private String matrizParaString(int[][] matriz)
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < matriz.length; i++)
        {
            for (int j = 0; i < matriz[i].length; i++)
            {
                sb.append(matriz[i][j]).append(",");
            }
        }
        //Remover vírgula final
        if (sb.length() > 0)
        {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    private int[][] stringParaMatriz(String data, int linhas, int colunas)
    {
        int[][] matriz = new int[linhas][colunas];
        String[] valores = data.split(",");

        for (int i = 0; i < linhas; i++)
        {
            for (int j = 0; j < colunas; j++)
            {
                matriz[i][j] = Integer.parseInt(valores[i*colunas + j]); //A cada linha o j retorna a 0 e o i aumenta em um, lembrando do tamanha de cada linha (colunas), multiplicando pelo i
            }
        }
        return matriz;
    }
}