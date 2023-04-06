package structural_patterns.adapter;

public class Client {
    public static void main(String[] args) {
        RoundHole roundHole = new RoundHole(5);
        RoundPeg roundPeg = new RoundPeg(5);
        if (roundHole.fits(roundPeg)) {
            System.out.println("Round peg r5 fits round hole r5.");
        }
        SquarePeg smallSquarePeg = new SquarePeg(2);
        SquarePeg largeSquarePeg = new SquarePeg(20);
        SquarePegAdapter squarePegAdapter = new SquarePegAdapter(smallSquarePeg);
        SquarePegAdapter largeSquarePegAdapter = new SquarePegAdapter(largeSquarePeg);
        if (roundHole.fits(squarePegAdapter)) {
            System.out.println("Square peg w2 fits round hole r5.");
        }
        if (!roundHole.fits(largeSquarePegAdapter)) {
            System.out.println("Square peg w20 does not fit round hole r5.");
        }
    }
}
