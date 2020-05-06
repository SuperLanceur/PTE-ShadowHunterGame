package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
	
	private final static String url = "jdbc:postgresql://localhost:5432/ShadowHunterDatabase";
    private final static String user = "shManager";
    private final static String password = "shadowhunter1234";

	 public static Connection connect() throws SQLException {
	        return DriverManager.getConnection(url, user, password);
	   }
	 
	 public static List<Record> remplirTable(String query) {
		 List<Record> list = new ArrayList<Record>();
		 	try (Connection connection = connect()) {
		       	 
	            //System.out.println("Connected to PostgreSQL database!");
	            Statement statement = connection.createStatement();
	            //System.out.println("Reading records...");
	            ResultSet retour = statement.executeQuery(query);
	            while (retour.next()) {
	            	list.add(new Record(retour.getString("id"), retour.getString("nom"), retour.getBytes("image"), retour.getBytes("objet")));
	            }
	        } catch (SQLException e) {
	            System.err.println("Connection failure.");
	            e.printStackTrace();
	        }
		 return list;
	 }
	
}
