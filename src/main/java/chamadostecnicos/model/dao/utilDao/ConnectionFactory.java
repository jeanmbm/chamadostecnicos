package chamadostecnicos.model.dao.utilDao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	
	private Connection con;
	
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_construcao", "root", "root");
			return con;
		} catch (Exception e) {
			System.err.println("Erro ao obter conexão: " + e.getMessage());
		}
		
		return con;
	}
	

	
	public void setClose() {
		try {
			con.close();
		} catch (Exception e) {
			System.err.println("Erro ao fechar conexão: " + e.getMessage());
		}
	}
	
}
