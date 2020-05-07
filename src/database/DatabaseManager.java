package database;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
	 
	 public static List<Record> remplirTableSansImage(String query) {
		 List<Record> list = new ArrayList<Record>();
		 	try (Connection connection = connect()) {
		       	 
	            //System.out.println("Connected to PostgreSQL database!");
	            Statement statement = connection.createStatement();
	            //System.out.println("Reading records...");
	            ResultSet retour = statement.executeQuery(query);
	            while (retour.next()) {
	            	list.add(new Record(retour.getString("id"), retour.getString("nom"), null, retour.getBytes("objet")));
	            }
	        } catch (SQLException e) {
	            System.err.println("Connection failure.");
	            e.printStackTrace();
	        }
		 return list;
	 }
	 
	 public static void queryInsertObject(int id, Object o) throws IOException, SQLException {
			
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
				table = QueryGenerator.getTable("CartesLumiere");
			} else if(id <= 32) {
				table = QueryGenerator.getTable("CartesTenebre");
			} else if(id <= 47) {
				table = QueryGenerator.getTable("CartesVision");
			} else if(id <= 57) {
				table = QueryGenerator.getTable("CartesPersonnage");
			} else if(id <= 61) {
				table = QueryGenerator.getTable("CartesDos");
			} else if(id <= 67) {
				table = QueryGenerator.getTable("CartesLieu");
			}
			
			String query = null;
			query = "UPDATE " + table + " SET objet = ? "
			+ " WHERE id = ? "		;
			
			Connection conn = connect();
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setBinaryStream(1, objectIS);
			pst.setInt(2, id);
			pst.executeUpdate();
	}
	
}
