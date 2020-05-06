package database;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class QueryGenerator {
	
	private final static String url = "jdbc:postgresql://localhost:5432/ShadowHunterDatabase";
    private final static String user = "shManager";
    private final static String password = "shadowhunter1234";

	public static String AllFrom(String tableName) {
		return "SELECT * FROM " + getTable(tableName);
	}
	
	public static String WithId(String tableName, int d) {
		return "SELECT * FROM " + getTable(tableName) + "WHERE id =" + d;
	}
	
	public static String WithName(String tableName, String name) {
		return "SELECT * FROM " + getTable(tableName) + "WHERE nom ='" + name + "'";
	}
	
	public static String getTable(String tableName) {
		return "public." + '"' + tableName + '"';
	}
	
	public static String getIdWithNameFrom(String table, String name) {
		return "SELECT 'id' FROM " + getTable(table) + "WHERE nom ='" + name + "'";
	}
	
	public static String getNameWithIdFrom(String table, int d) {
		return "SELECT name FROM " + getTable(table) + "WHERE id =" + d;
	}
	
	public static String selectObjectWithId(int id, String tableName) {
		return "SELECT objet FROM" + getTable(tableName) + " WHERE id =" + id;
	}
	
	 public static Connection connect() throws SQLException {
	        return DriverManager.getConnection(url, user, password);
	   }
	
	public static String queryInsertObject(int id, Object o) throws IOException, SQLException {
		
		String table = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos;
		
		oos = new ObjectOutputStream(baos);
		oos.writeObject(o);
		oos.close();
			
		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());

		byte[] object = bais.readAllBytes();
		InputStream objectIS = new ByteArrayInputStream(object);
				
		if(id <= 16) {
			table = getTable("CartesLumiere");
		} else if(id <= 32) {
			table = getTable("CartesTenebre");
		} else if(id <= 47) {
			table = getTable("CartesVision");
		} else if(id <= 57) {
			table = getTable("CartesPersonnage");
		} else if(id <= 61) {
			table = getTable("CartesDos");
		}
		
		String query = null;
		query = "UPDATE" + table + " SET objet = ";
		
		Connection conn = connect();
		PreparedStatement pst = conn.prepareStatement(query);
		pst.setBinaryStream(4, objectIS);
		pst.executeUpdate();
		
		return query;
	}
	

}
