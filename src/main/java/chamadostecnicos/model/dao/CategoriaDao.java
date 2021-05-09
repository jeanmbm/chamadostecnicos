package chamadostecnicos.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import chamadostecnicos.model.CategoriaServico;
import chamadostecnicos.model.dao.utilDao.ConnectionFactory;

public class CategoriaDao {

	Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement;
	
	
	public CategoriaDao() {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connection = connectionFactory.getConnection(); 
	}
	
	
	public boolean salvarCategoria(CategoriaServico categoria) {
		boolean salvo = false;
		String query = "insert into categoria(nome, descricao) "
					 + "values(?, ?)";
		
		try {
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, categoria.getNome());
			preparedStatement.setString(2, categoria.getDescricao());
			
			preparedStatement.execute();
			connection.commit();
			salvo = true;
			
		} catch (Exception e) {
			System.err.println("Erro ao salvar categoria: " + e.getMessage());
			salvo = false;
		}
		
		return salvo;
	}
	
	
	public List<CategoriaServico> listarCategorias(){
		List<CategoriaServico> categorias = new ArrayList<CategoriaServico>();
		ResultSet resultSet;
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from categoria;");
			
			while (resultSet.next()) {
				CategoriaServico categoria = new CategoriaServico();
				categoria.setId(resultSet.getInt("id"));
				categoria.setNome(resultSet.getString("nome"));
				categoria.setDescricao(resultSet.getString("descricao"));
				categorias.add(categoria);
			}
			
		} catch (Exception e) {
			System.err.println("Erro ao listar categorias: " + e.getMessage());
		}
		
		return categorias;
	}
	
	
	public boolean editarCategoria(CategoriaServico categoria) {
		boolean editado = false;
		String query = "update categoria "
					 + "set nome = ?, "
					 + "descricao = ? "
					 + "where id = ? ";
		
		try {
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, categoria.getNome());
			preparedStatement.setString(2, categoria.getDescricao());
			preparedStatement.setInt(3, categoria.getId());
			
			preparedStatement.execute();
			connection.commit();
			editado = true;
			
		} catch (Exception e) {
			System.err.println("Erro ao editar categoria: " + e.getMessage());
			editado = false;
		}
		
		return editado;
	}
	
	
	public boolean deletarCategoria(int id) {
		boolean deletado = false;
		String query = "delete from categoria where id = ?";
		
		try {
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			
			preparedStatement.execute();
			connection.commit();
			deletado = true;
			
		} catch (Exception e) {
			System.err.println("Erro ao deletar categoria: " + e.getMessage());
			deletado = false;
		}
		
		return deletado;
	}
	
	
	public CategoriaServico selecionarCategoriaPorId(int id) {
		String query = "select * from categoria where id =  " + id;
		ResultSet resultSet;
		List<CategoriaServico> categorias = new ArrayList<CategoriaServico>();
		
		try {
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				CategoriaServico categoria = new CategoriaServico();
				categoria.setId(resultSet.getInt("id"));
				categoria.setNome(resultSet.getString("nome"));
				categoria.setDescricao(resultSet.getString("descricao"));
				categorias.add(categoria);
			}
			
		} catch (Exception e) {
			System.err.println("Erro ao selecionar categoria: " + e.getMessage());
		}
		
		return categorias.get(0);
	}
	
}
