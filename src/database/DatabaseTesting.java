package database;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.scene.image.Image;

/*
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
*/

public class DatabaseTesting {
    public static void main(String[] args) throws IOException {
    	Table a = new Table("a");
    	a.remplirTableAllFrom("CartesAll");
    	System.out.println(a.toString());
    	
    	Image image = ByteaToCardImage.getJavaFXImage(a.getList().get(1).getImg());
    	System.out.println(image);
    	
    	//a.getList().get(1).getImg();
       
	}

	public BufferedImage createImageFromBytes(byte[] imageData) {
	    ByteArrayInputStream bais = new ByteArrayInputStream(imageData);
	    try {
	        return ImageIO.read(bais);
	    } catch (IOException e) {
	        throw new RuntimeException(e);
	    }
    	
    	
    	
    	
    }
}

