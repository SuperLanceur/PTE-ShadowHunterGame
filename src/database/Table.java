package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Table {
	
	private String name;
	private List<Record> list = new ArrayList<Record>();
	
	public Table() {
		this.name = "";
	}
	
	public Table(String JavaTableName) {
		this.name = JavaTableName;
	}

	public void fillList(String query) {
		this.list = DatabaseManager.remplirTable(query);
	}
	
	public void remplirTableQuery(String query) {
		try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ShadowHunterDatabase", "shManager", "shadowhunter1234")) { //notre utilisateur que l'on utilisera (:
	       	 
            //System.out.println("Connected to PostgreSQL database!");
            Statement statement = connection.createStatement();
            //System.out.println("Reading records...");
            ResultSet retour = statement.executeQuery(query);
            while (retour.next()) {
            	list.add(new Record(retour.getString("id"), retour.getString("nom"), null, retour.getBytes("objet")));
            }

        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
	}

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected List<Record> getList() {
		return list;
	}
	
	public String toString() {
		return this.getList().toString();
	}
	
	protected boolean isEmpty() {
		return list.isEmpty();
	}
	


	
	
	
}
