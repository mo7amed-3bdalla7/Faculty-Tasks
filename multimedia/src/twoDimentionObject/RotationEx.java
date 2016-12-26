package twoDimentionObject;

/**
 * Created by mohamed on 12/21/2016.
 */

import javax.swing.*;
import java.awt.*;

class Surface2 extends JPanel {

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setPaint(new Color(150, 150, 150));
        g2d.fillRect(20, 20, 80, 50);
        g2d.translate(180, -50);
        g2d.rotate(Math.PI/4);
        g2d.fillRect(80, 80, 80, 50);

        g2d.dispose();
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
}

public class RotationEx extends JFrame {

    public RotationEx() {

        initUI();
    }

    public void initUI() {

        setTitle("Rotation");

        add(new Surface2());

        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    public static void main(String[] args) {

                RotationEx ex = new RotationEx();
                ex.setVisible(true);

    }
}