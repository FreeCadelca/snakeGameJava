package model;

import java.awt.*;

public abstract class AbstractFruit {
    private static final FruitFactory fruitFactory = new FruitFactory();
    private static AbstractFruit instance = null;

    public static void setInstance(AbstractFruit instance) {
        AbstractFruit.instance = instance;
    }

    public static AbstractFruit getInstance() {
        if (instance == null)
            fruitFactory.createFruit();
        return instance;
    }

    public static Color color;
    private static int x;
    private static int y;

    public int getX() {
        return x;
    }

    public static void setX(int x) {
        AbstractFruit.x = x;
    }

    public int getY() {
        return y;
    }

    public static void setY(int y) {
        AbstractFruit.y = y;
    }

    public Color getColor() {
        return color;
    }

    public static void setColor(Color color) {
        AbstractFruit.color = color;
    }
}
