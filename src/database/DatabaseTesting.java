package database;

import java.awt.image.BufferedImage;

/*
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
*/

public class DatabaseTesting {
    public static void main(String[] args) {
    	Table a = new Table("a");
    	a.remplirTableAllFrom("CartesLumiere");
    	System.out.println(a.toString());
    	//BufferedImage jpg = new BufferedImage(467, 652, 1);
    	
    	
    	/*
    	try {
			ByteaToCardImage.getImg(a.getList().get(5).getImg());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
    	
    	
    	
    	
    }
}

