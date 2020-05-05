package database;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

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
    	
    	//a.getList().get(1).getImg()
    	
    	
    	BufferedImage image = ImageIO.read( new ByteArrayInputStream( a.getList().get(1).getImg() ) );
    	ImageIO.write(image, "JPG", new File("filename.jpg"));
    	
    	/*
    	 * PreparedStatement ps = conn.prepareStatement("SELECT img FROM images WHERE imgname = ?");
ps.setString(1, "myimage.gif");
ResultSet rs = ps.executeQuery();
while (rs.next()) {
    byte[] imgBytes = rs.getBytes(1); OR  byte []out = (byte[])(rs.getObject(1));
    // use the data in some way here
}
rs.close();
ps.close();*/
    	
    	
    	
    	
    }
}

