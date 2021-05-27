package chamadostecnicos.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import chamadostecnicos.model.Area;
import chamadostecnicos.model.Usuario;
import chamadostecnicos.model.dao.utilDao.ConnectionFactory;

public class UsuarioDao {

	Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private DepartamentoDao departamentoDao;
	private EspecialidadeDao especialidadeDao;
	
	
	public UsuarioDao() {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connection = connectionFactory.getConnection(); 
	}
	
	
	public boolean salvarUsusario(Usuario usuario) {
		boolean salvo = false;
		String query = "insert into usuario (nome, telefone, cpf, email, senha, fk_id_departamento, isTecnico, fk_id_especialidade) "
				     + "values(?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, usuario.getNome());
			preparedStatement.setString(2, usuario.getTelefone());
			preparedStatement.setString(3, usuario.getCpf());
			preparedStatement.setString(4, usuario.getEmail());
			preparedStatement.setString(5, usuario.getSenha());
			preparedStatement.setInt(6, usuario.getIdDepartamento());
			
			
			if (usuario.isTecnico() == true) {
				preparedStatement.setInt(7, 1);
				preparedStatement.setInt(8, usuario.getIdEspecialidade());
			} else {
				preparedStatement.setInt(7, 0);
				preparedStatement.setNull(8, Types.INTEGER);
			}
			
			preparedStatement.execute();
			connection.commit();
			salvo = true;
			
		} catch (Exception e) {
			System.err.println("Erro ao salvar usuario: " + e.getMessage());
			salvo = false;
		}
		
		return salvo;
	}
	
	public List<Usuario> listarUsuarios() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		ResultSet resultSet;
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from usuario;");
			
			while (resultSet.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(resultSet.getInt("id"));
				usuario.setNome(resultSet.getString("nome"));
				usuario.setTelefone(resultSet.getString("telefone"));
				usuario.setCpf(resultSet.getString("cpf"));
				usuario.setEmail(resultSet.getString("email"));
				usuario.setSenha(resultSet.getNString("senha"));
				
				departamentoDao = new DepartamentoDao();
				usuario.setDepartamento(departamentoDao.selecionarDepartamentoPorId(resultSet.getInt("fk_id_departamento")));
				
				int aux = resultSet.getInt("isTecnico");
				if (aux == 1) {
					usuario.setTecnico(true);
					especialidadeDao = new EspecialidadeDao();
					usuario.setEspecialidade(especialidadeDao.selecionarEspecialidadePorId(resultSet.getInt("fk_id_especialidade")));
				} else {
					usuario.setTecnico(false);
					usuario.setEspecialidade(null);
				}
				
				usuarios.add(usuario);
			}
			
		} catch (Exception e) {
			System.err.println("Erro ao listar ususarios: " + e.getMessage());
		}
		
		return usuarios;
	}
	
	public boolean editarUsuario(Usuario usuario, String email, String senha) {
		boolean editado = false;
		String query = "update usuario "
					 + "set nome = ?, "
					 + "telefone = ?, "
					 + "cpf = ?, "
					 + "email = ?, "
					 + "senha = ? "
					 + "where email = ? and senha = ?";
		
		try {
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, usuario.getNome());
			preparedStatement.setString(2, usuario.getTelefone());
			preparedStatement.setString(3, usuario.getCpf());
			preparedStatement.setString(4, usuario.getEmail());
			preparedStatement.setString(5, usuario.getSenha());
			preparedStatement.setInt(6, usuario.getId());
			
			preparedStatement.execute();
			connection.commit();
			editado = true;
			
		} catch (Exception e) {
			System.err.println("Erro ao editar usuario: " + e.getMessage());
			editado = false;
		}
		
		return editado;
	}
	
	public boolean deletarUsuario(String email, String senha) {
		boolean deletado = false;
		String query = "delete from usuario where email = ? and senha = ?";
		
		try {
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, senha);
			
			preparedStatement.execute();
			connection.commit();
			deletado = true;
			
		} catch (Exception e) {
			System.err.println("Erro ao deletar usuario: " + e.getMessage());
			deletado = false;
		}
		
		
		return deletado;
	}
	
	public Usuario selecionarUsuarioPorEmailESenha(String email, String senha) {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		ResultSet resultSet;
		String query = "select * from usuario where email = '" + email + "' and senha = '" + senha  + "'";
		
		try {
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(resultSet.getInt("id"));
				usuario.setNome(resultSet.getString("nome"));
				usuario.setTelefone(resultSet.getString("telefone"));
				usuario.setCpf(resultSet.getString("cpf"));
				usuario.setEmail(resultSet.getString("email"));
				usuario.setSenha(resultSet.getNString("senha"));
				
				departamentoDao = new DepartamentoDao();
				usuario.setDepartamento(departamentoDao.selecionarDepartamentoPorId(resultSet.getInt("fk_id_departamento")));
				
				int aux = resultSet.getInt("isTecnico");
				if (aux == 1) {
					usuario.setTecnico(true);
					especialidadeDao = new EspecialidadeDao();
					usuario.setEspecialidade(especialidadeDao.selecionarEspecialidadePorId(resultSet.getInt("fk_id_especialidade")));
				} else {
					usuario.setTecnico(false);
					usuario.setEspecialidade(null);
				}
				
				usuarios.add(usuario);
			}
			
		} catch (Exception e) {
			System.err.println("Erro ao selecionar usuario: " + e.getMessage());
		}
		
		return usuarios.get(0);
	}
	
	public Usuario selecioanarUsuarioPorId(int id) {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		ResultSet resultSet;
		String query = "select * from usuario where id = " + id;
		
		try {
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(resultSet.getInt("id"));
				usuario.setNome(resultSet.getString("nome"));
				usuario.setTelefone(resultSet.getString("telefone"));
				usuario.setCpf(resultSet.getString("cpf"));
				usuario.setEmail(resultSet.getString("email"));
				usuario.setSenha(resultSet.getNString("senha"));
				
				departamentoDao = new DepartamentoDao();
				usuario.setDepartamento(departamentoDao.selecionarDepartamentoPorId(resultSet.getInt("fk_id_departamento")));
				
				int aux = resultSet.getInt("isTecnico");
				if (aux == 1) {
					usuario.setTecnico(true);
					especialidadeDao = new EspecialidadeDao();
					usuario.setEspecialidade(especialidadeDao.selecionarEspecialidadePorId(resultSet.getInt("fk_id_especialidade")));
				} else {
					usuario.setTecnico(false);
					usuario.setEspecialidade(null);
				}
				
				usuarios.add(usuario);
			}
			
		} catch (Exception e) {
			System.err.println("Erro ao selecionar usuario: " + e.getMessage());
		}
		
		return usuarios.get(0);
	}
	
	public Usuario selecioanarUsuarioTecnico(String area) {
		List<Usuario> usuarios = new ArrayList<Usuario>();;
		ResultSet resultSet;
		String query = "select * from usuario where isTecnico = " + 1 ;
		
		try {
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(resultSet.getInt("id"));
				usuario.setNome(resultSet.getString("nome"));
				usuario.setTelefone(resultSet.getString("telefone"));
				usuario.setCpf(resultSet.getString("cpf"));
				usuario.setEmail(resultSet.getString("email"));
				usuario.setSenha(resultSet.getNString("senha"));
				
				departamentoDao = new DepartamentoDao();
				usuario.setDepartamento(departamentoDao.selecionarDepartamentoPorId(resultSet.getInt("fk_id_departamento")));
				
				int aux = resultSet.getInt("isTecnico");
				if (aux == 1) {
					usuario.setTecnico(true);
					especialidadeDao = new EspecialidadeDao();
					usuario.setEspecialidade(especialidadeDao.selecionarEspecialidadePorId(resultSet.getInt("fk_id_especialidade")));
				} else {
					usuario.setTecnico(false);
					usuario.setEspecialidade(null);
				}
				
				if (usuario.getEspecialidade().getArea().getDescricao().equals(area)) {
					usuarios.add(usuario);
				}
				
			}
			
		} catch (Exception e) {
			System.err.println("Erro ao selecionar usuario: " + e.getMessage());
		}
		
		Collections.shuffle(usuarios);
		
		return usuarios.get(0);
	}
	
}
