import java.util.Random;

class Solution {
    private final double r, x, y;
    private final Random rnd = new Random();

    public Solution(double radius, double x_center, double y_center) {
        this.r = radius;
        this.x = x_center;
        this.y = y_center;
    }

    public double[] randPoint() {
        double d = r * Math.sqrt(rnd.nextDouble());
        double a = 2 * Math.PI * rnd.nextDouble();
        return new double[]{x + d * Math.cos(a), y + d * Math.sin(a)};
    }
}