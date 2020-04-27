package database;

/*
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
*/

public class DatabaseTesting {
    public static void main(String[] args) {
        /*
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ShadowHunterDatabase", "shManager", "shadowhunter1234")) { //notre utilisateur que l'on utilisera (:
 
            System.out.println("Connected to PostgreSQL database!");
            Statement statement = connection.createStatement();
            System.out.println("Reading records...");
            System.out.printf("%-20.30s  %-30.30s  %-30.30s%n", "id", "nom", "image");
            ResultSet resultSet = statement.executeQuery(QueryGenerator.AllFrom("CartesAll"));
            //ResultSet resultSet = statement.executeQuery(QueryGenerator.WithId("CartesAll", 15));
            //ResultSet resultSet = statement.executeQuery(QueryGenerator.WithName("CartesAll", "Vision Cupide"));
            while (resultSet.next()) {
                System.out.printf("%-20.30s  %-30.30s  %-20.30s%n", resultSet.getString("id"), resultSet.getString("nom"), resultSet.getBytes("image")); //resultSet.getBytes("image"));
            }
 
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
        */
    	
    	Table a = new Table("a");
    	a.remplirTable("CartesLumiere");
    	try {
			ByteaToCardImage.getImg(a.getList().get(5).getImg());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	
    	
    }
}

