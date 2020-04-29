package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestDatabse {
	
	Table t;
	
	@BeforeEach
	private void initialize() {
		System.out.println("=====Initialisation du test=====");
		t = new Table("Table de Test");
	}
	
	@AfterEach
	private void free() {
		System.out.println("=====Fin du test=====\n\n\n");
	}
	
	@Test
	private void testDBConnexion() {
		try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ShadowHunterDatabase", "shManager", "shadowhunter1234")) { //notre utilisateur que l'on utilisera (:
	       	 
            System.out.println("Connected to PostgreSQL database!");
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
	}
	
	@Test
	private void getEntireTableCartesLumiere() {
		t.remplirTableAllFrom("CartesLumiere");
		Assert.assertFalse(t.isEmpty());
	}
}
