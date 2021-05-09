package chamadostecnicos.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import chamadostecnicos.model.Departamento;
import chamadostecnicos.model.dao.utilDao.ConnectionFactory;

public class DepartamentoDao {
	
	Connection con;
	private Statement statement;
	private PreparedStatement preparedStatement;
	
	
	public DepartamentoDao() {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		con = connectionFactory.getConnection(); 
	}
	
	
	public boolean salvarDepartamento(Departamento departamento) {
		boolean salvo = false;
		String query = "insert into departamento(nome, descricao) "
				     + "values(?, ?)";
		
		try {
			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, departamento.getNome());
			preparedStatement.setString(2, departamento.getDescricao());
			
			preparedStatement.execute();
			con.commit();
			salvo = true;
		} catch (Exception e) {
			System.err.println("Erro ao salvar departamento: " + e.getMessage());
			salvo = false;
		}
		
		return salvo;
	}
	
	
	public List<Departamento> listarDepartamentos(){
		List<Departamento> departamentos = new ArrayList<Departamento>();
		ResultSet resultSet;
		
		try {
			statement = con.createStatement();
			resultSet = statement.executeQuery("select * from departamento;");
			
			while (resultSet.next()) {
				Departamento departamento = new Departamento();
				departamento.setId(resultSet.getInt("id"));
				departamento.setNome(resultSet.getString("nome"));
				departamento.setDescricao(resultSet.getString("descricao"));
				departamentos.add(departamento);
			}
			
		} catch (Exception e) {
			System.err.println("Erro ao listar departamentos: " + e.getMessage());
		}
		
		return departamentos;
	}
	
	
	public boolean editarDepartamento(Departamento departamento) {
		boolean salvo = false;
		String query = "update departamento "
				 + "set nome = ?, "
				 + "descricao = ? "
				 + "where id = ? ";
		
		try {
			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, departamento.getNome());
			preparedStatement.setString(2, departamento.getDescricao());
			preparedStatement.setInt(3, departamento.getId());
			
			preparedStatement.execute();
			con.commit();
			salvo = true;
			
		} catch (Exception e) {
			System.err.println("Erro ao editar departamento: " + e.getMessage());
			salvo = false;
		}
		
		return salvo;
	}
	
	
	public boolean deletarDepartamento(int id) {
		boolean deletado = false;
		String query = "delete from departamento where id = ?";
		
		try {
			con.setAutoCommit(false);
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, id);
			
			preparedStatement.execute();
			con.commit();
			deletado = true;
			
		} catch (Exception e) {
			System.err.println("Erro ao deletar departamento: " + e.getMessage());
			deletado = false;
		}
		
		return deletado;
	}
	
	
	public Departamento selecionarDepartamentoPorId(int id) {
		String query = "select * from departamento where id =  " + id;
		ResultSet resultSet;
		List<Departamento> departamentos = new ArrayList<Departamento>();
		
		try {
			preparedStatement = con.prepareStatement(query);
			resultSet = preparedStatement.executeQuery(query);
			
			while (resultSet.next()) {
				Departamento departamento = new Departamento();
				departamento.setId(resultSet.getInt("id"));
				departamento.setNome(resultSet.getString("nome"));
				departamento.setDescricao(resultSet.getString("descricao"));
				departamentos.add(departamento);
			}
			
		} catch (Exception e) {
			System.err.println("Erro ao selecionar departamento: " + e.getMessage());
		}
		
		return departamentos.get(0);
	}

}
