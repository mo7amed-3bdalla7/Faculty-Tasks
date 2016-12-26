package crossDissolve;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by m7md on 20/12/16.
 */
public class Gui extends JFrame {
   static JLabel imgeLabel;

    public Gui(String m) throws HeadlessException, IOException {
        imgeLabel = new JLabel();
       /* new Thread(new Runnable() {
            @Override
            public void run() {
                try {


                    Image image = ImageIO.read(new File("src/camera.bmp"));
                    ImageIcon icon = new ImageIcon(image);
                    imgeLabel.setIcon(icon);
                    Thread.sleep(1000);
                    Image image2 = ImageIO.read(new File("src/new_naran.bmp"));
                    ImageIcon icon2 = new ImageIcon(image);
                    imgeLabel.setIcon(icon2);
                    revalidate();
                    repaint();



                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();*/
        Image image = ImageIO.read(new File(m));
        ImageIcon icon = new ImageIcon(image);
        imgeLabel.setIcon(icon);

        add(imgeLabel);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(512, 512);
        setTitle("OutPut");
        setVisible(true);


    }
}
