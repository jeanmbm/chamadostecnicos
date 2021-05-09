package chamadostecnicos.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import chamadostecnicos.model.Area;
import chamadostecnicos.model.Especialidade;
import chamadostecnicos.model.dao.utilDao.ConnectionFactory;

public class EspecialidadeDao {

	Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement;
	
	
	public EspecialidadeDao() {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connection = connectionFactory.getConnection(); 
	}
	
	
	public boolean salvarEspecialidade(Especialidade especialidade) {
		boolean salvo = false;
		String query = "insert into especialidade(nome, descricao, area) "
				 + "values(?, ?, ?)";
		
		try {
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, especialidade.getNome());
			preparedStatement.setString(2, especialidade.getDescricao());
			preparedStatement.setString(3, especialidade.getArea().getDescricao());
			
			preparedStatement.execute();
			connection.commit();
			salvo = true;
			
		} catch (Exception e) {
			System.err.println("Erro ao salvar especialidade: " + e.getMessage());
			salvo = false;
		}
		
		return salvo;
	}
	
	
	public List<Especialidade> listarEspecialidades() {
		List<Especialidade> especialidades = new ArrayList<Especialidade>();
		ResultSet resultSet;
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from especialidade;");
			
			while (resultSet.next()) {
				Especialidade especialidade = new Especialidade();
				especialidade.setId(resultSet.getInt("id"));
				especialidade.setNome(resultSet.getString("nome"));
				especialidade.setDescricao(resultSet.getString("descricao"));
				
				String aux = resultSet.getString("area");
				if (aux.equals("Software")) {
					especialidade.setArea(Area.SOFTWARE);
				} else {
					especialidade.setArea(Area.HARDWARE);
				}
				especialidades.add(especialidade);
			}
			
		} catch (Exception e) {
			System.err.println("Erro ao listar especialidade: " + e.getMessage());
		}
		
		return especialidades;
	}
	
	
	public boolean editarEspecialidade(Especialidade especialidade) {
		boolean editado = false;
		String query = "update especialidade "
				     + "set nome = ?, "
				     + "descricao = ?, "
				     + "area = ? "
				     + "where id = ?";
		
		try {
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, especialidade.getNome());
			preparedStatement.setString(2, especialidade.getDescricao());
			preparedStatement.setString(3, especialidade.getArea().getDescricao());
			preparedStatement.setInt(4, especialidade.getId());
			
			preparedStatement.execute();
			connection.commit();
			editado = true;
			
		} catch (Exception e) {
			System.err.println("Erro ao editar especialidade: " + e.getMessage());
			editado = false;
		}
		
		return editado;
	}
	
	
	public boolean deletarEspecialidade(int id) {
		boolean deletado = false;
		String query = "delete from especialidade where id = ?;";
		
		try {
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			
			preparedStatement.execute();
			connection.commit();
			deletado = true;
			
		} catch (Exception e) {
			System.err.println("Erro ao deletar especialidade: " + e.getMessage());
			deletado = false;
		}
		
		return deletado;
	}
	
	
	public Especialidade selecionarEspecialidadePorId(int id) {
		List<Especialidade> especialidades = new ArrayList<Especialidade>();
		ResultSet resultSet;
		String query = "select * from especialidade where id = " + id;
		
		try {
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Especialidade especialidade = new Especialidade();
				especialidade.setId(resultSet.getInt("id"));
				especialidade.setNome(resultSet.getString("nome"));
				especialidade.setDescricao(resultSet.getString("descricao"));
				String aux = resultSet.getString("area");
				if (aux.equals("Software")) {
					especialidade.setArea(Area.SOFTWARE);
				} else {
					especialidade.setArea(Area.HARDWARE);
				}
				especialidades.add(especialidade);
			}
			
		} catch (Exception e) {
			System.err.println("Erro ao selecionar especialidade: " + e.getMessage());
		}
		
		return especialidades.get(0);
	}
	
}
