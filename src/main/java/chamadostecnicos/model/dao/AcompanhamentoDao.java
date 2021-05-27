package chamadostecnicos.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

import chamadostecnicos.model.Avaliacao;
import chamadostecnicos.model.Status;
import chamadostecnicos.model.dao.utilDao.ConnectionFactory;

public class AcompanhamentoDao {
	
	Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement;
	
	
	public AcompanhamentoDao() {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connection = connectionFactory.getConnection(); 
	}
	
	
	public boolean salvarAcompanhamento(int idChamado, int idTecnico) {
		boolean salvo = false;
		String query = "insert into acompanhamento (fk_id_chamado, fk_id_usuario_tecnico, solucionadoTecnico, solucionadoUsuario) "
					 + "values (?, ?, ?, ?)";
		
		try {
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, idChamado);
			preparedStatement.setInt(2, idTecnico);
			preparedStatement.setInt(3, 0);
			preparedStatement.setInt(4, 0);
			
			connection.commit();
			preparedStatement.execute();
			salvo = true;
			
		} catch (Exception e) {
			System.err.println("Erro ao salvar acompanhamento: " + e.getMessage());
			salvo = false;
		}
		
		return salvo;
	}
	
	public boolean finalizarAcompanhamentoUsuario(int id) {
		boolean finalizado = false;
		String query = "update acompanhamento "
					 + "set solucionadoUsuario = ? "
					 + "where id = ?";
		
		try {
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, 1);
			preparedStatement.setInt(2, id);
			
			preparedStatement.execute();
			connection.commit();
			finalizado = true;
			
		} catch (Exception e) {
			System.err.println("Erro ao finalizar acompanhamento: " + e.getMessage());
			finalizado = false;
		}
		
		return finalizado;
	}
	
	public boolean finalizarAcompanhamentoTecnico(int id) {
		boolean finalizado = false;
		String query = "update acompanhamento "
					 + "set solucionadoTecnico = ? "
					 + "where id = ?";
		
		try {
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, 1);
			preparedStatement.setInt(2, id);
			
			preparedStatement.execute();
			connection.commit();
			finalizado = true;
			
		} catch (Exception e) {
			System.err.println("Erro ao finalizar acompanhamento: " + e.getMessage());
			finalizado = false;
		}
		
		return finalizado;
	}
	
	public boolean finalizarAcompanhamento(int id, Avaliacao avaliacao) {
		boolean finalizado = false;
		
		String queryAvaliacao = "insert into avaliacao(qntEstrelas, comentario, dataAvaliacao) "
							  + "values(?, ?, ?)";
		
		String query = "update acompanhamento "
					 + "set fk_id_avaliacao = ? "
					 + "where id = ?";
		
		
	
		try {
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(queryAvaliacao);
			
			preparedStatement.setInt(1, avaliacao.getQuantEstrelas());
			preparedStatement.setString(2, avaliacao.getComentario());
			preparedStatement.setDate(3, java.sql.Date.valueOf(avaliacao.getDataAvalicacao()));
			
			preparedStatement.execute();
			
			
			ChamadoDao chamadoDao = new ChamadoDao();
			
			chamadoDao.editarStatusDoChamado(Status.CONCLUIDO, LocalDate.now(), id);
			
			
			statement = connection.createStatement();
			int idTemp = 0;
			try {
				ResultSet set = statement.executeQuery("select last_insert_id() as id");
				while (set.next()) {
					idTemp = set.getInt("id");
					
				}
			} catch (Exception e) {
				connection.rollback();
			}
			final int idAvaliacao = idTemp;
			
		
			try {
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, idAvaliacao);
				preparedStatement.setInt(2, id);
				
			} catch (Exception e) {
				connection.rollback();
			}
			
			preparedStatement.execute();
			connection.commit();
			finalizado = true;
			
		} catch (Exception e) {
			System.err.println("Erro ao finalizar acompanhamento: " + e.getMessage());
			finalizado = false;
		}
		
		return finalizado;
	}
	
	
	public LocalDate convertToLocalDateViaSqlDate(Date dateToConvert) {
	    return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
	}
	
}
