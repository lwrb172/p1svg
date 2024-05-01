public class Ellipse implements Shape {
    private Vec2 center;
    private double radiusX, radiusY;
    private Style style;

    public Ellipse(Style style, Vec2 center, double radiusX, double radiusY) {
        this.style = style;
        this.center = center;
        this.radiusX = radiusX;
        this.radiusY = radiusY;
    }

    public Ellipse(Vec2 center, double radiusX, double radiusY) {
        this.style = new Style();
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
