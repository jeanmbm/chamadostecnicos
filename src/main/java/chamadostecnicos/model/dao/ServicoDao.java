package chamadostecnicos.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import chamadostecnicos.model.Area;
import chamadostecnicos.model.Prioridade;
import chamadostecnicos.model.Servico;
import chamadostecnicos.model.dao.utilDao.ConnectionFactory;

public class ServicoDao {

	Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private CategoriaDao categoriaDao;
	
	
	public ServicoDao() {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connection = connectionFactory.getConnection(); 
	}
	
	
	public boolean salvarServico(Servico servico) {
		boolean salvo = false;
		String query = "insert into servico(nome, descricao, prioridade, area, fk_id_categoria) "
				     + "values(?, ?, ?, ?, ?)";
		
		try {
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, servico.getNome());
			preparedStatement.setString(2, servico.getDescricao());
			preparedStatement.setString(3, servico.getPrioridade().getDescricao());
			preparedStatement.setString(4, servico.getArea().getDescricao());
			preparedStatement.setInt(5, servico.getIdCategoria());
			
			preparedStatement.execute();
			connection.commit();
			salvo = true;
			
		} catch (Exception e) {
			System.out.println("Erro ao salvar servico: "  + e.getMessage());
			salvo = false;
		}
		
		return salvo;
	}
	
	
	public List<Servico> listarServico() {
		List<Servico> servicos = new ArrayList<Servico>();
		ResultSet resultSet;
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from servico;");
			
			while (resultSet.next()) {
				Servico servico = new Servico();
				servico.setId(resultSet.getInt("id"));
				servico.setNome(resultSet.getString("nome"));
				servico.setDescricao(resultSet.getString("descricao"));
				
				String aux;
				
				aux = resultSet.getString("prioridade");
				if (aux.equalsIgnoreCase("Baixa")) {
					servico.setPrioridade(Prioridade.BAIXA);
				} else  if (aux.equalsIgnoreCase("Média")) {
					servico.setPrioridade(Prioridade.MEDIA);
				} else  if (aux.equalsIgnoreCase("Alta")){
					servico.setPrioridade(Prioridade.ALTA);
				} else {
					servico.setPrioridade(Prioridade.URGENTE);
				}
				
				aux = resultSet.getString("area");
				if (aux.equals("Software")) {
					servico.setArea(Area.SOFTWARE);
				} else {
					servico.setArea(Area.HARDWARE);
				}
				
				categoriaDao = new CategoriaDao();
				servico.setCategoria(categoriaDao.selecionarCategoriaPorId(resultSet.getInt("fk_id_categoria")));
				
				servicos.add(servico);
			}
			
		} catch (Exception e) {
			System.err.println("Erro ao listar serviços: " + e.getMessage());
		}
		
		return servicos;
	}
	
	
	public boolean editarServico(Servico servico) {
		boolean editado = false;
		String query = "update servico "
					 + "set nome = ?, "
					 + "descricao = ?, "
					 + "prioridade = ?, "
					 + "area = ? "
					 + "where id = ?";
		
		try {
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, servico.getNome());
			preparedStatement.setString(2, servico.getDescricao());
			preparedStatement.setString(3, servico.getPrioridade().getDescricao());
			preparedStatement.setString(4, servico.getArea().getDescricao());
			preparedStatement.setInt(5, servico.getId());
			
			preparedStatement.execute();
			connection.commit();
			editado = true;
			
		} catch (Exception e) {
			System.err.println("Erro ao editar serviço: " + e.getMessage());
			editado = false;
		}
		
		return editado;
	}
	
	
	public boolean deletarServico(int id) {
		boolean deletado = false;
		String query = "delete from servico where id = ?";
		
		try {
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			
			preparedStatement.execute();
			connection.commit();
			deletado = true;
			
		} catch (Exception e) {
			System.err.println("Erro ao deletar servico: " + e.getMessage());
			deletado = false;
		}
		
		return deletado;
	}
	
	public Servico selecionarServicoPorId(int id) {
		List<Servico> servicos = new ArrayList<Servico>();
		String query = "select * from servico where id = " + id;
		ResultSet resultSet;
		
		try {
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Servico servico = new Servico();
				servico.setId(resultSet.getInt("id"));
				servico.setNome(resultSet.getString("nome"));
				servico.setDescricao(resultSet.getString("descricao"));
				
				String aux;
				
				aux = resultSet.getString("prioridade");
				if (aux.equalsIgnoreCase("Baixa")) {
					servico.setPrioridade(Prioridade.BAIXA);
				} else  if (aux.equalsIgnoreCase("Média")) {
					servico.setPrioridade(Prioridade.MEDIA);
				} else  if (aux.equalsIgnoreCase("Alta")){
					servico.setPrioridade(Prioridade.ALTA);
				} else {
					servico.setPrioridade(Prioridade.URGENTE);
				}
				
				aux = resultSet.getString("area");
				if (aux.equals("Software")) {
					servico.setArea(Area.SOFTWARE);
				} else {
					servico.setArea(Area.HARDWARE);
				}

				categoriaDao = new CategoriaDao();
				servico.setCategoria(categoriaDao.selecionarCategoriaPorId(resultSet.getInt("fk_id_categoria")));
				
				servicos.add(servico);
			}
			
		} catch (Exception e) {
			System.err.println("Erro ao selecionar servico: " + e.getMessage());
		}
		
		
		return servicos.get(0);
	}
	
}
