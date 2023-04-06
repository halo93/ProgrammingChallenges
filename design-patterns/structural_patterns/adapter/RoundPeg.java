package structural_patterns.adapter;

public class RoundPeg {
    private double radius;

    protected RoundPeg() {
    }

    public RoundPeg(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}
