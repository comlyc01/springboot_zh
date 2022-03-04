package com.timing.thread;

public class Immutable {

    public final double x;
    public final double y;

    public Immutable(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Immutable{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public static void main(String[] args) {
        Immutable immutable = new Immutable(0.23, 3.112);
        System.out.println("immutable = " + immutable);
    }

}
