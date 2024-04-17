package controller;

import model.AbstractFruit;
import model.Segment;
import model.Snake;
import view.Canvas;

public class Animator extends Thread {
    public Animator() {}

    @Override
    public void run() {
        while (true) {
            try {
                if (Snake.getInstance().isEatFruit()) {
//                    Segment head = Snake.getInstance().get(Snake.getInstance().size() - 1);
//                    System.out.printf(head.x + " " + head.y + " " + AbstractFruit.getInstance().getX() + " " + AbstractFruit.getInstance().getY());
                    Snake.getInstance().addHead(true);
                    AbstractFruit.setInstance(null);
                } else {
                    Snake.getInstance().addHead(false);
                }
                if (!Snake.getInstance().isDifferentElements() || !Snake.getInstance().isOnMap()) {
                    System.out.println("You lose :_(");
                    throw new InterruptedException();
                }
                Canvas.getInstance().onRepaint();

                Thread.sleep(100);
                Snake.getInstance().setChangedDirection(false);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}