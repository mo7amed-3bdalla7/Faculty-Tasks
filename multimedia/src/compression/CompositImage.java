/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compression;

/**
 *
 * @author mohamed
 */
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class CompositImage {
public static BufferedImage combined;
    
//    public static void main(String[] args) throws FileNotFoundException, IOException {
//               //File is = new File("src/m.jpg");
//               // load source images
//BufferedImage image = ImageIO.read(new File("src/", "cat.png"));
//BufferedImage overlay = ImageIO.read(new File("src/", "forest.png"));
//
//// create the new image, canvas size is the max. of both image sizes
//int w = Math.max(image.getWidth(), overlay.getWidth());
//int h = Math.max(image.getHeight(), overlay.getHeight());
//BufferedImage combined = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
//
//// paint both images, preserving the alpha channels
//Graphics g = combined.getGraphics();
//g.drawImage(overlay, 10, -70, null);
//g.drawImage(image, 200, 180, null);
//
//// Save as new image
//ImageIO.write(combined, "png", new File("src/", "combined.png"));
//
//    }
    
    public static void diplay(String f1 ,String f2) throws IOException{
    
BufferedImage image = ImageIO.read(new File(f1));
BufferedImage overlay = ImageIO.read(new File(f2));

// create the new image, canvas size is the max. of both image sizes
int w = Math.max(image.getWidth(), overlay.getWidth());
int h = Math.max(image.getHeight(), overlay.getHeight());
 combined = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

// paint both images, preserving the alpha channels
Graphics g = combined.getGraphics();
g.drawImage(overlay, 10, -100, null);
g.drawImage(image, 200, 280, null);

// Save as new image
ImageIO.write(combined, "png", new File("src/", "combined.png"));

    }
}
