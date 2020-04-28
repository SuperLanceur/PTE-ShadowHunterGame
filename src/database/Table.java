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
	
	public Table(String JavaTableName) {
		this.name = JavaTableName;
	}
	
	public void remplirTable(String DatabaseTableName) {
		try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ShadowHunterDatabase", "shManager", "shadowhunter1234")) { //notre utilisateur que l'on utilisera (:
       	 
            System.out.println("Connected to PostgreSQL database!");
            Statement statement = connection.createStatement();
            System.out.println("Reading records...");
            ResultSet retour = statement.executeQuery(QueryGenerator.AllFrom(DatabaseTableName));
            while (retour.next()) {
            	Record r = new Record(retour.getString("id"), retour.getString("nom"), retour.getBytes("image"));
            	list.add(r);
            	System.out.printf("%-20.30s  %-30.30s  %-20.30s%n", retour.getString("id"), retour.getString("nom"), retour.getBytes("image"));
            }

        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Record> getList() {
		return list;
	}
	


	
	
	
}
