package database;

/**
 * @author James Thompson
 * @source https://gist.github.com/jamesthompson/3344090
 * @date 08/12/2012 
 **/

import java.io.ByteArrayInputStream;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javafx.scene.image.Image;
import javax.imageio.ImageIO;
import java.awt.image.*;
import java.io.ByteArrayOutputStream;

public class ByteaToCardImage {
	
	public static Image getJavaFXImage(byte[] rawPixels) {
		//public Image getJavaFXImage(byte[] rawPixels, int width, int height) {
	    ByteArrayOutputStream out = new ByteArrayOutputStream();
	    try {
	        ImageIO.write((RenderedImage) createBufferedImage(rawPixels, 467, 652), "png", out);
	        //ImageIO.write((RenderedImage) createBufferedImage(rawPixels, width, height), "png", out);
	        out.flush();
	        } catch (IOException ex) {
	        }
	    ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
	    return new javafx.scene.image.Image(in);
	    }
	
	private static BufferedImage createBufferedImage(byte[] pixels, int width, int height) {
	    SampleModel sm = getIndexSampleModel(width, height);
	    DataBuffer db = new DataBufferByte(pixels, width*height, 0);
	    WritableRaster raster = Raster.createWritableRaster(sm, db, null);
	    IndexColorModel cm = getDefaultColorModel();
	    BufferedImage image = new BufferedImage(cm, raster, false, null);
	    return image;
	}
	
	private static SampleModel getIndexSampleModel(int width, int height) {
	    IndexColorModel icm = getDefaultColorModel();
	    WritableRaster wr = icm.createCompatibleWritableRaster(1, 1);
	    SampleModel sampleModel = wr.getSampleModel();
	    sampleModel = sampleModel.createCompatibleSampleModel(width, height);
	    return sampleModel;
	}
	
	private static IndexColorModel getDefaultColorModel() {
	    byte[] r = new byte[256];
	    byte[] g = new byte[256];
	    byte[] b = new byte[256];
	    for(int i=0; i<256; i++) {
	       r[i]=(byte)i;
	       g[i]=(byte)i;
	       b[i]=(byte)i;
	    }
	    IndexColorModel defaultColorModel = new IndexColorModel(8, 256, r, g, b);
	    return defaultColorModel;
	}
}