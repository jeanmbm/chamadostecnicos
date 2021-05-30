package chamadostecnicos.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import chamadostecnicos.model.Chamado;
import chamadostecnicos.model.Status;
import chamadostecnicos.model.dao.utilDao.ConnectionFactory;

public class ChamadoDao {

	Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private ServicoDao servicoDao;
	private UsuarioDao usuarioDao;
	
	
	public ChamadoDao() {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connection = connectionFactory.getConnection();
	}
	
	
	public boolean salvarChamado(Chamado chamado) {
		boolean salvo = false;
		String query = "insert into chamado(fk_id_usuario, fk_id_servico, status, mensagem, dataAbertura, prazoSolucao) "
				     + "values(?, ?, ?, ?, ?, ?)";
		
		try {
			connection.setAutoCommit(false);
			preparedStatement= connection.prepareStatement(query);
			
			preparedStatement.setInt(1, chamado.getIdUsuario());
			preparedStatement.setInt(2, chamado.getIdServico());
			preparedStatement.setString(3, chamado.getStatus().getDescricao());
			preparedStatement.setString(4, chamado.getMensagem());
			preparedStatement.setDate(5, java.sql.Date.valueOf(chamado.getDataAbertura()));
			preparedStatement.setDate(6, java.sql.Date.valueOf(chamado.getPrazoSolucao()));
			
			preparedStatement.execute();
			connection.commit();
			salvo = true;
			
		} catch (Exception e) {
			System.err.println("Erro ao salvar chamado: " + e.getMessage());
			salvo = false;
		}
		
		return salvo;
	}
	
	public List<Chamado> listarChamados() {
		List<Chamado> chamados = new ArrayList<Chamado>();
		ResultSet resultSet;
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from chamado");
			
			while (resultSet.next()) {
				Chamado chamado = new Chamado();
				
				chamado.setId(resultSet.getInt("id"));
				
				usuarioDao = new UsuarioDao();
				chamado.setUsuario(usuarioDao.selecioanarUsuarioPorId(resultSet.getInt("fk_id_usuario")));
				
				servicoDao = new ServicoDao();
				chamado.setServico(servicoDao.selecionarServicoPorId(resultSet.getInt("fk_id_servico")));
				
				String status = resultSet.getString("status");
				if (status.equalsIgnoreCase("Em análise")) {
					chamado.setStatus(Status.ANALISE);
				} else if(status.equalsIgnoreCase("Em aberto")) {
					chamado.setStatus(Status.ABERTO);
				} else if(status.equalsIgnoreCase("Em andamento")) {
					chamado.setStatus(Status.ANDAMENTO);
				} else if(status.equalsIgnoreCase("Concluído")) {
					chamado.setStatus(Status.CONCLUIDO);
				} else {
					chamado.setStatus(Status.CANCELADO);
				}
				
				chamado.setMensagem(resultSet.getString("mensagem"));
				
				chamado.setDataAbertura(convertToLocalDateViaSqlDate(resultSet.getDate("dataAbertura")));
				chamado.setPrazoSolucao(convertToLocalDateViaSqlDate(resultSet.getDate("prazoSolucao")));
				
				if (resultSet.getDate("dataSolucao") == null) {
					chamado.setDataSolucao(null);
				} else {
					chamado.setDataSolucao(convertToLocalDateViaSqlDate(resultSet.getDate("dataSolucao")));
				}
				
				
				
				chamados.add(chamado);
			}
			
		} catch (Exception e) {
			System.err.println("Erro ao listar chamados: " + e.getMessage());
		}
		
		return chamados;
		
	}
	
	public boolean editarStatusDoChamado(Status status, LocalDate data, int id) {
		boolean editado = false;
		String query = "update chamado "
			     	 + "set status = ?, "
			     	 + "dataSolucao = ?"
			     	 + "where id = ?";
		
		try {
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, status.getDescricao());
			preparedStatement.setDate(2, java.sql.Date.valueOf(data));
			preparedStatement.setInt(3, id);
			
			preparedStatement.execute();
			connection.commit();
			editado = true;
			
		} catch (Exception e) {
			System.err.println("Erro ao editar chamado: " + e.getMessage());
			editado = false;
		}
		
		return editado;
	}
	
	public Chamado selecionarChamadoPorId(int id) {
		List<Chamado> chamados = new ArrayList<Chamado>();
		ResultSet resultSet;
		
		try {
		    preparedStatement = connection.prepareStatement("select * from chamado where id = " + id);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Chamado chamado = new Chamado();
				
				chamado.setId(resultSet.getInt("id"));
				
				usuarioDao = new UsuarioDao();
				chamado.setUsuario(usuarioDao.selecioanarUsuarioPorId(resultSet.getInt("fk_id_usuario")));
				
				servicoDao = new ServicoDao();
				chamado.setServico(servicoDao.selecionarServicoPorId(resultSet.getInt("fk_id_servico")));
				
				String status = resultSet.getString("status");
				if (status.equalsIgnoreCase("Em análise")) {
					chamado.setStatus(Status.ANALISE);
				} else if(status.equalsIgnoreCase("Em aberto")) {
					chamado.setStatus(Status.ABERTO);
				} else if(status.equalsIgnoreCase("Em andamento")) {
					chamado.setStatus(Status.ANDAMENTO);
				} else if(status.equalsIgnoreCase("Concluído")) {
					chamado.setStatus(Status.CONCLUIDO);
				} else {
					chamado.setStatus(Status.CANCELADO);
				}
				
				chamado.setMensagem(resultSet.getString("mensagem"));
				
				chamado.setDataAbertura(convertToLocalDateViaSqlDate(resultSet.getDate("dataAbertura")));
				chamado.setPrazoSolucao(convertToLocalDateViaSqlDate(resultSet.getDate("prazoSolucao")));
				
				if (resultSet.getDate("dataSolucao") == null) {
					chamado.setDataSolucao(null);
				} else {
					chamado.setDataSolucao(convertToLocalDateViaSqlDate(resultSet.getDate("dataSolucao")));
				}
				
				chamados.add(chamado);
			}
			
		} catch (Exception e) {
			System.err.println("Erro ao selecionar chamado: " + e.getMessage());
		}
		
		return chamados.get(0);
	}
	
	
	public LocalDate convertToLocalDateViaSqlDate(Date dateToConvert) {
	    return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
	}
	
}
