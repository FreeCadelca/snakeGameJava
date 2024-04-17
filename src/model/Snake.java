package model;

import java.util.ArrayList;

public class Snake extends ArrayList<Segment> {
    protected static Snake instance = null;

    final int dimension = 50;

    private int direction = 3;
    private boolean changedDirection = false;

    public void addHead(boolean isEaten) {
        Segment newHeadSegment = this.get(this.size() - 1).copy();
        if (direction == 0) {
            newHeadSegment.y--;
        } else if (direction == 1) {
            newHeadSegment.x--;
        } else if (direction == 2) {
            newHeadSegment.y++;
        } else if (direction == 3) {
            newHeadSegment.x++;
        }
        this.add(newHeadSegment);
        if (!isEaten) {
            removeTail();
        }
    }

    public void removeTail(){
        this.remove(0);
    }

    public boolean isDifferentElements() {
        int len = this.size();
        Segment head = this.get(this.size() - 1).copy();
        for (int i = 0; i < len - 2; i++) {
            if (head.x == this.get(i).x && head.y == this.get(i).y) {
                return false;
            }
        }
        return true;
    }

    public boolean isOnMap() {
        Segment head = this.get(this.size() - 1).copy();
        return head.x >= 0 && head.x <= 20 && head.y >= 0 && head.y <= 15;
    }

    public boolean isEatFruit() {
        Segment willHeadSegment = this.get(this.size() - 1).copy();
        if (direction == 0) {
            willHeadSegment.y--;
        } else if (direction == 1) {
            willHeadSegment.x--;
        } else if (direction == 2) {
            willHeadSegment.y++;
        } else if (direction == 3) {
            willHeadSegment.x++;
        }

        return willHeadSegment.x == AbstractFruit.getInstance().getX() && willHeadSegment.y == AbstractFruit.getInstance().getY();
    }

    public static Snake getInstance() {
        if (instance == null) instance = new Snake();
        return instance;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public boolean isChangedDirection() {
        return changedDirection;
    }

    public void setChangedDirection(boolean changedDirection) {
        this.changedDirection = changedDirection;
    }

    public int getDimension() {
        return dimension;
    }
}
