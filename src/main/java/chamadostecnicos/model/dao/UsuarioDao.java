package chamadostecnicos.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import chamadostecnicos.model.dao.utilDao.ConnectionFactory;

public class UsuarioDao {

	Connection con;
	private Statement statement;
	private PreparedStatement preparedStatement;
	
	
	public UsuarioDao() {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		con = connectionFactory.getConnection(); 
	}
	
}
