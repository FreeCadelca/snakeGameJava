package model;

public class Segment {
    public int x;
    public int y;

    public Segment(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Segment copy() {
        return new Segment(this.x, this.y);
    }
}
