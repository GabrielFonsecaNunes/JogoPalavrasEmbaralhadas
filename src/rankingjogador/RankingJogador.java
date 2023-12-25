package rankingjogador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import bancodepalavras.BancoDePalavras;
import jogador.Player;
import conexao.SQLiteConnection;

public class RankingJogador {
	private ArrayList<Player> jogadores = new ArrayList<Player>();
	
	public RankingJogador() {
	}	
	
	public Player getLastJogador() {
        int index = jogadores.size() - 1;
	    return this.jogadores.get(index);
	}
	
	public Player getJogador(int index) {
		return this.jogadores.get(index);
	}
	
	public void addJogador(Player jogador) {
		this.jogadores.add(jogador);
	}
	
	public void createTableRatingScore(){
        String query = "CREATE TABLE IF NOT EXISTS tb_ranking_score (" +
        			   "id INTEGER PRIMARY KEY AUTOINCREMENT," +
        			   "name VARCHAR(46) NOT NULL,"+ 
        			   "score INTEGER NOT NULL)";
        try {
        	SQLiteConnection.executeQuery(query);
//            System.out.println("Tabela tb_ranking_score foi criada com suceso");
        } catch (Exception e) {
            System.out.println(e);
        }
	}
	
    public void dropTableRatingScore(){
        String query = "DROP TABLE tb_ranking_score;";
        try {
        	ResultSet result = SQLiteConnection.executeQuery(query);
        	result.close();
//            System.out.println("Tabela tb_ranking_score deletada com sucesso");
        } catch (Exception e) {
            System.out.println(e);
        }
	}

	public void insertPlayerRakingHistoric(){
		Player jogador = this.getLastJogador();
        String query = "INSERT INTO tb_ranking_score (name, score) VALUES ('%s', %d);";
        query = String.format(query, jogador.getName(), jogador.getScore());
        try (Connection connection = SQLiteConnection.conectar();
               PreparedStatement statement = connection.prepareStatement(query)) {
               statement.executeUpdate();
//               System.out.println(String.format("Jogador %s inserido com sucesso", jogador.getName()));
       } catch (SQLException e) {
           Logger.getLogger(BancoDePalavras.class.getName()).log(Level.SEVERE, null, e);
       }
	}
		
	public ArrayList<Player> getTopRanking() {
        ArrayList<Player> ranking = new ArrayList<Player>();
        String query = "SELECT name, score FROM tb_ranking_score ORDER BY score DESC LIMIT 5;";
    
        try {
            ResultSet resultSet = SQLiteConnection.executeQuery(query);
    
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int score = resultSet.getInt("score");
                Player jogador = new Player(name);
                while(jogador.getScore() < score)jogador.inscreaseScore();
                ranking.add(jogador);
            }
    
        } catch (SQLException e) {
            Logger.getLogger(RankingJogador.class.getName()).log(Level.SEVERE, null, e);
        }
    
        return ranking;
    }
	
	public void clearRanking() {
		String query = "DELETE FROM tb_ranking_score";
        try {
           SQLiteConnection.executeQuery(query);    
        } catch (SQLException e) {
//            Logger.getLogger(RankingJogador.class.getName()).log(Level.SEVERE, null, e);
        }
	}
	
	public void dropTbRanking() {
		String query = "DROP TABLE tb_ranking_score";
        try {
           SQLiteConnection.executeQuery(query);    
        } catch (SQLException e) {
            Logger.getLogger(RankingJogador.class.getName()).log(Level.SEVERE, null, e);
        }
	}
}