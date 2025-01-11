package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    private static final String URL = "jdbc:mysql://sql10.freesqldatabase.com:3306/sql10757136";
    private static final String USUARIO = "sql10757136";
    private static final String SENHA = "emJRsUEpVz";

    public static Connection obterConexao() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}