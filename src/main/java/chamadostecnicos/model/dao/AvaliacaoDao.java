package chamadostecnicos.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import chamadostecnicos.model.Avaliacao;
import chamadostecnicos.model.dao.utilDao.ConnectionFactory;

public class AvaliacaoDao {
	
	Connection connection;
	private PreparedStatement preparedStatement;
	
	public AvaliacaoDao() {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connection = connectionFactory.getConnection(); 
	}

	
	public Avaliacao selecionarAvaliacaoPorId(int id) {
		List<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();
		ResultSet resultSet;
		String query = "select * from avaliacao where id = " + id;
		
		try {
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Avaliacao avaliacao = new Avaliacao();
				avaliacao.setId(resultSet.getInt("id"));
				avaliacao.setQuantEstrelas(resultSet.getInt("qntEstrelas"));
				avaliacao.setComentario(resultSet.getString("comentario"));
				avaliacao.setDataAvalicacao(convertToLocalDateViaSqlDate(resultSet.getDate("dataAvaliacao")));
				
				avaliacoes.add(avaliacao);
			}
			
		} catch (Exception e) {
			System.err.println("Erro ao selecionar avaliacao: " + e.getMessage());
		}
		
		return avaliacoes.get(0);
	}
	
	public LocalDate convertToLocalDateViaSqlDate(Date dateToConvert) {
	    return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
	}
	
}
