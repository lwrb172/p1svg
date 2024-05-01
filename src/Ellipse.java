public class Ellipse extends Shape {
    private Point center;
    private double radiusX, radiusY;

    public Ellipse(Style style, Point center, double radiusX, double radiusY) {
        super(style);
        this.center = center;
        this.radiusX = radiusX;
        this.radiusY = radiusY;
    }

    public Ellipse(Point center, double radiusX, double radiusY) {
        this.center = center;
        this.radiusX = radiusX;
        this.radiusY = radiusY;
    }

    @Override
    public String toSvg() {
        return "<ellipse rx=\"" + radiusX + "\" ry=\"" + radiusY +
                "\" cx=\"" + center.getX() + "\" cy=\"" + center.getY() + "\" " +
                style.toSvg();
    }
}
