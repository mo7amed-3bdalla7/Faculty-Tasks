package twoDimentionObject;

/**
 * Created by mohamed on 12/21/2016.
 */

import javax.swing.*;
import java.awt.*;

class Surface extends JPanel {

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setPaint(new Color(150, 150, 150));
        g2d.fillRect(20, 20, 80, 50);
        g2d.translate(150, 50);
        g2d.fillRect(20, 20, 80, 50);
        g2d.dispose();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
}

public class TranslationEx extends JFrame {

    public TranslationEx() {
        initUI();
    }

    public void initUI() {

        add(new Surface2());

        setTitle("Translation");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                TranslationEx ex = new TranslationEx();
                ex.setVisible(true);
            }
        });
    }
}