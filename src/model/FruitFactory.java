package model;

import java.awt.*;
import java.util.Random;

public class FruitFactory {
    public FruitFactory () {}

    private static class Apple extends AbstractFruit {
        public Apple(int x, int y) {
            setColor(Color.RED);
            setX(x);
            setY(y);
        }
    }

    public void createApple(int x, int y) {
        AbstractFruit.setInstance(new Apple(x, y));
    }

    private static class Pear extends AbstractFruit {
        public Pear(int x, int y) {
            setColor(Color.YELLOW);
            setX(x);
            setY(y);
        }
    }

    public void createPear(int x, int y) {
        AbstractFruit.setInstance(new Pear(x, y));
    }

    private static class Orange extends AbstractFruit {
        public Orange(int x, int y) {
            setColor(Color.ORANGE);
            setX(x);
            setY(y);
        }
    }

    public void createOrange(int x, int y) {
        AbstractFruit.setInstance(new Orange(x, y));
    }

    public void createFruit () {
        Random random = new Random();
        boolean flag;
        int x, y;
        do {
            flag = false;
            x = random.nextInt(20);
            y = random.nextInt(15);
            for (int i = 0; i < Snake.getInstance().size() - 1; i++) {
                if (x == Snake.getInstance().get(i).x && y == Snake.getInstance().get(i).y) {
                    flag = true;
                    break;
                }
            }
        } while (flag);
        int type = random.nextInt(3);
        switch (type) {
            case 0:
                createApple(x, y);
                break;
            case 1:
                createPear(x, y);
                break;
            case 2:
                createOrange(x, y);
                break;
        }
    }
}
