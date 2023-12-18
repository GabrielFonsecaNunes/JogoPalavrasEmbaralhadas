package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import bancodepalavras.BancoDePalavras;

public class SQLiteConnection {

    // URL de conexão com o banco de dados SQLite
    private static final String URL = "jdbc:sqlite:./db/database.db";
    // Método para abrir uma conexão com o banco de dados SQLite
    public static Connection conectar() {
        try {
            // Registra o driver JDBC do SQLite
            Class.forName("org.sqlite.JDBC");
            // Estabelece a conexão com o banco de dados
            Connection conexao = DriverManager.getConnection(URL);           
            return conexao;
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            return null; // Retorna null em caso de erro
        }
    }

    // Método para fechar a conexão com o banco de dados
    public static void desconectar(Connection conexao) {
        if (conexao != null) {
            try {
                conexao.close();
                System.out.println("Conexão fechada com sucesso!");
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }
    public static void executeQuery(String query) throws SQLException {
		Connection conexao = conectar();
		Statement statement = conexao.createStatement();
		statement.execute(query);
		conexao.commit();
		desconectar(conexao);
	}
}
