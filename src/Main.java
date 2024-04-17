import controller.Animator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import model.Segment;
import model.Snake;
import view.Canvas;

public class Main {
    public static void main(String[] args) {
        JFrame wnd = new JFrame("The Snake");
        Animator animator = new Animator();
        wnd.setLayout(new BorderLayout());
        wnd.add(Canvas.getInstance(), BorderLayout.CENTER);
        wnd.setSize(1066, 839);
        //java окно почему-то на 66px меньше нужного по ширине и на 89px по высоте
        //не знаю, почему, но я просто сидел и подгонял до идеала влипания змейки в стены)
        wnd.setLocation(0, 0);
        wnd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        wnd.setVisible(true);

        Segment segment_1 = new Segment(2, 2);
        Segment segment_2 = new Segment(3, 2);
        Segment segment_3 = new Segment(4, 2);
        Snake.getInstance().add(segment_1);
        Snake.getInstance().add(segment_2);
        Snake.getInstance().add(segment_3);

        wnd.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                String key = e.getKeyText(e.getKeyCode());
                if (!Snake.getInstance().isChangedDirection()) {
                    int direction = -1;
                    if (key.equals("W")){
                        direction = 0;
                    } else if (key.equals("A")){
                        direction = 1;
                    } else if (key.equals("S")){
                        direction = 2;
                    } else if (key.equals("D")){
                        direction = 3;
                    }
                    if (direction % 2 != Snake.getInstance().getDirection() % 2) {
                        Snake.getInstance().setDirection(direction);
                        Snake.getInstance().setChangedDirection(true);
                    }
                }

            }
        });
        animator.start();
    }
}