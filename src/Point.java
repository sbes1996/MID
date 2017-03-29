/**
 * Class modeling a Point in a Cartesian system
 * @author hadrien
 */
public class Point {

    protected static final double epsilon = 1e-12;

    /**
     * x-coordinate of the point in a Cartesian representation
     */
    protected double x;

    /**
     * y-coordinate of the point in a Cartesian representation
     */
    protected double y;

    /**
     * Constructor by the given of x/y coordinates of the point
     * @param xx x-coordinate of the point
     * @param yy y-coordinate of the point
     */
    public Point(double xx, double yy) {
        this.x = xx;
        this.y = yy;
    }

    /**
     * @return the x-coordinate
     */
    public double getX() {
        return x;
    }

    /**
     * @return the y-coordinate
     */
    public double getY() {
        return y;
    }

    /**
     * Translates the point following the direction vector (dx,dy)
     * @param dx x-coordinate of the translation vector
     * @param dy y-coordinate of the translation vector
     */
    public void translater(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    /**
     * @param p another point
     * @return the euclidian distance bewteen this point and the given p
     */
    public double distance(Point p) {
        double xd = (p.x - x);
        double yc = (p.y - y);
        return Math.sqrt(xd*xd + yc*yc);
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        if (Math.abs(point.x-x) > epsilon) return false;
        if (Math.abs(point.y-y) > epsilon) return false;
        return true;
    }

    /**
     * @return a string representation of the Point
     */
    public String toString() {
        return "(" + x + " " + y + ")";
    }

}