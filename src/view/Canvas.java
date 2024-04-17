package view;

import model.AbstractFruit;
import model.Segment;
import model.Snake;

import javax.swing.*;
import java.awt.*;

public class Canvas extends JPanel {
    private static Canvas instance = null;


    private Canvas() {
        super(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int c = Snake.getInstance().getDimension();
        g.setColor(Color.CYAN);
        for (Segment segment : Snake.getInstance()) {
            g.fillRoundRect(c * segment.x, c * segment.y, c, c, c / 2, c / 2);
        }
        Segment head = Snake.getInstance().get(Snake.getInstance().size() - 1).copy();
        g.setColor(new Color(140, 255, 98, 255));
        g.fillRoundRect(c * head.x, c * head.y, c, c, c / 2, c / 2);
        g.setColor(AbstractFruit.getInstance().getColor());
        g.fillOval(c * AbstractFruit.getInstance().getX(), c * AbstractFruit.getInstance().getY(), c, c);
    }

    public void onRepaint() {
        repaint();
    }

    public static Canvas getInstance() {
        if (instance == null)
            instance = new Canvas();
        return instance;
    }
}
