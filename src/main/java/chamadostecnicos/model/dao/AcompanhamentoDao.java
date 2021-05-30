package chamadostecnicos.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import chamadostecnicos.model.Acompanhamento;
import chamadostecnicos.model.Avaliacao;
import chamadostecnicos.model.Status;
import chamadostecnicos.model.Usuario;
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
		
		String queryChamado = "update chamado "
     						+ "set status = ? "
     						+ "where id = ?";
		
		
		try {
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, idChamado);
			preparedStatement.setInt(2, idTecnico);
			preparedStatement.setInt(3, 0);
			preparedStatement.setInt(4, 0);
			
			preparedStatement.execute();
			
			try {
				preparedStatement = connection.prepareStatement(queryChamado);
				preparedStatement.setString(1, Status.ANDAMENTO.getDescricao());
				preparedStatement.setInt(2, idChamado);
				
				preparedStatement.execute();
				
			} catch (Exception e) {
				connection.rollback();
			}
			
			connection.commit();
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
	
	public List<Acompanhamento> lisatrAcompanhamentos() {
		List<Acompanhamento> acompanhamentos = new ArrayList<Acompanhamento>();
		ResultSet resultSet;
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from acompanhamento");
			
			while (resultSet.next()) {
				Acompanhamento acompanhamento = new  Acompanhamento();
				
				acompanhamento.setId(resultSet.getInt("id"));
				
				ChamadoDao chamadoDao = new ChamadoDao();
				acompanhamento.setChamado(chamadoDao.selecionarChamadoPorId(resultSet.getInt("fk_id_chamado")));
				
				UsuarioDao usuarioDao = new UsuarioDao();
				acompanhamento.setTecnico(usuarioDao.selecioanarUsuarioPorId(resultSet.getInt("fk_id_usuario_tecnico")));
				
				int aux = resultSet.getInt("solucionadoTecnico");
				if (aux == 0) {
					acompanhamento.setSolucionadoTecnico(false);
				} else {
					acompanhamento.setSolucionadoTecnico(true);
				}
				
				aux = resultSet.getInt("solucionadoUsuario");
				if (aux == 0) {
					acompanhamento.setSolucionadoUsuario(false);
				} else {
					acompanhamento.setSolucionadoUsuario(true);
				}
				
				AvaliacaoDao avaliacaoDao = new AvaliacaoDao();
				int isAvaliacao = resultSet.getInt("fk_id_avaliacao");
				if (isAvaliacao == 0) {
					acompanhamento.setAvaliacao(null);
				} else {
					acompanhamento.setAvaliacao(avaliacaoDao.selecionarAvaliacaoPorId(isAvaliacao));
				}
				
				acompanhamentos.add(acompanhamento);
				
			}
		} catch (Exception e) {
			System.err.println("Erro ao listar acompanhamento: " + e.getMessage());
		}
		
		return acompanhamentos;
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
		
		String queryAcompanhamento = "update acompanhamento "
					 			   + "set fk_id_avaliacao = ? "
					 			   + "where id = ?";
		
		try {
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(queryAvaliacao);
			
			preparedStatement.setInt(1, avaliacao.getQuantEstrelas());
			preparedStatement.setString(2, avaliacao.getComentario());
			preparedStatement.setDate(3, java.sql.Date.valueOf(avaliacao.getDataAvalicacao()));
			
			preparedStatement.execute();
			
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
			
			ChamadoDao chamadoDao = new ChamadoDao();
			chamadoDao.editarStatusDoChamado(Status.CONCLUIDO, LocalDate.now(), id);
			
		
			try {
				preparedStatement = connection.prepareStatement(queryAcompanhamento);
				preparedStatement.setInt(1, idAvaliacao);
				preparedStatement.setInt(2, id);
				
				preparedStatement.execute();
				
			} catch (Exception e) {
				connection.rollback();
			}
			
			connection.commit();
			finalizado = true;
			
		} catch (Exception e) {
			System.err.println("Erro ao finalizar acompanhamento: " + e.getMessage());
			finalizado = false;
		}
		
		return finalizado;
	}
	
	
	public boolean verificarFinalizado(int id) {
		boolean solucionado = false;
		ResultSet resultSet;
		int solTec = 0, solUsu = 0;
	
		try {
			preparedStatement = connection.prepareStatement("select solucionadoTecnico, solucionadoUsuario from acompanhamento where id = " + id);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				solTec = resultSet.getInt("solucionadoTecnico");
				solUsu = resultSet.getInt("solucionadoUsuario");
			}
		
			if (solTec == 1 && solUsu == 1) {
				solucionado = true;
			} else {
				solucionado = false;
			}
			
		} catch (Exception e) {
			solucionado = false;
		}
	
		return solucionado;
	
	}
	
	
	public LocalDate convertToLocalDateViaSqlDate(Date dateToConvert) {
	    return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
	}
	
}
