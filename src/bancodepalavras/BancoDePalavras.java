package bancodepalavras;

import conexao.SQLiteConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BancoDePalavras {
	private static String[] palavras = {
		"Bola", "Gato", "Mesa", "Flor", "Sol", "Pato", "Rato",
		"Livro", "Água", "Porta", "Lápis", "Cama", "Arco", "Vaso",
		"Pão", "Casa", "Jardim", "Rede", "Cadeira", "Carro", "Peixe",
		"Riso", "Leão", "Rã", "Pote", "Lua", "Nuvem", "Folha",
		"Olho", "Abelha", "Cana", "Dedo", "Fogo", "Céu", "Copo",
		"Neve", "Dado", "Mel", "Nariz", "Pena", "Piso", "Mapa",
		"Taco", "Bife", "Sapato", "Aço", "Sal", "Vela", "Rua",
		"Pica", "Lama", "Mola", "Pala", "Tela", "Solo", "Tuba",
		"Cama", "Cesto", "Rima", "Foca", "Portão", "Galo", "Meio",
		"Teia", "Barco", "Aula", "Pico", "Cérebro", "Rima", "Mito",
		"Mosaico", "Chão", "Sino", "Mapa", "Vida", "Sapo", "Pato",
		"Coco", "Luva", "Palha", "Pala", "Mimo", "Tigre", "Lupa",
		"Fila", "Paco", "Rima", "Pura", "Lua", "Bico", "Foca",
		"Rio", "Ouro", "Lona", "Goma", "Voto", "Roça", "Pena",
		"Lupa"   
	};

    public void createTbPalavras() {
        String query = "CREATE TABLE IF NOT EXISTS tb_palavras (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "palavra VARCHAR(46) NOT NULL)";
        try {
            SQLiteConnection.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void inserirTodasPalavras() {
        String query = "INSERT INTO tb_palavras (palavra) VALUES (?)";

        try (Connection connection = SQLiteConnection.conectar();
             PreparedStatement statement = connection.prepareStatement(query)) {

            for (String palavra : palavras) {
                statement.setString(1, palavra);
                statement.executeUpdate();
            }
            System.out.println("Palavras inseridas com sucesso!");

        } catch (SQLException e) {
            Logger.getLogger(BancoDePalavras.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void dropTbPalavras(){
        String query = "DROP TABLE tb_palavras";

        try (Connection connection = SQLiteConnection.conectar();
             PreparedStatement statement = connection.prepareStatement(query)) {

            for (String palavra : palavras) {
                statement.setString(1, palavra);
                statement.executeUpdate();
            }
            System.out.println("Palavras inseridas com sucesso!");

        } catch (SQLException e) {
            Logger.getLogger(BancoDePalavras.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public String getPalavraAleatoria() {
        String query = "SELECT palavra FROM tb_palavras ORDER BY RANDOM() LIMIT 1";
        try (Connection connection = SQLiteConnection.conectar();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getString("palavra").toUpperCase();
            }

        } catch (SQLException e) {
            Logger.getLogger(BancoDePalavras.class.getName()).log(Level.SEVERE, null, e);
        }

        return null;
    }

    public static void main(String[] args) {
        BancoDePalavras banco = new BancoDePalavras();
        // banco.dropTbPalavras();
        banco.createTbPalavras();
        // banco.inserirTodasPalavras();
    }
}

