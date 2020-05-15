package database;

import java.sql.Connection;
import java.sql.DriverManager;
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
	
	public static String selectId(int id) {
		String table = "";
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
		}else if(id <= 67) {
			table = getTable("CartesLieu");
		}
		return "SELECT * FROM " + table + " WHERE id = " + id;
	}
	 
	
}
