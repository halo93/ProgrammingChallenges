package structural_patterns.adapter;

public class SquarePeg {
    private double width;

    public SquarePeg(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public double getArea() {
        return Math.pow(width, 2);
    }
}
