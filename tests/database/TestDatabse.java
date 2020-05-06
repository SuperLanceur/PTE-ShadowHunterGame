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
		System.gc();
		System.out.println("=====Fin du test=====\n\n\n");
	}
	
	@Test
	void testDBConnexion() {
		try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ShadowHunterDatabase", "shManager", "shadowhunter1234")) { //notre utilisateur que l'on utilisera (:
	       	 
            System.out.println("Connected to PostgreSQL database!");
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
	}
	
	@Test
	void getEntireTableCartesLumiere() {
		System.out.println("Test getEntireTableCartesLumiere");
		t.fillList(QueryGenerator.AllFrom("CartesLumiere"));
		Assert.assertFalse(t.isEmpty());
	}
	
	@Test
	void getEntireTableCartesTenebre() {
		System.out.println("Test getEntireTableCartesTenebre");
		t.fillList(QueryGenerator.AllFrom("CartesTenebre"));
		Assert.assertFalse(t.isEmpty());
	}
	
	@Test
	void getEntireTableCartesVision() {
		System.out.println("Test getEntireTableCartesVision");
		t.fillList(QueryGenerator.AllFrom("CartesVision"));
		Assert.assertFalse(t.isEmpty());
	}
	
	@Test
	void getEntireTableCartesPersonnage() {
		System.out.println("Test getEntireTableCartesPersonnage");
		t.fillList(QueryGenerator.AllFrom("CartesPersonnage"));
		Assert.assertFalse(t.isEmpty());
	}
	
	@Test
	void getEntireTableCartesDos() {
		System.out.println("Test getEntireTableCartesDos");
		t.fillList(QueryGenerator.AllFrom("CartesDos"));
		Assert.assertFalse(t.isEmpty());
	}
	
	@Test
	void getEntireTableCartesAll() {
		System.out.println("Test getEntireTableCartesAll");
		t.fillList(QueryGenerator.AllFrom("CartesAll"));
		Assert.assertFalse(t.isEmpty());
	}
	
}
