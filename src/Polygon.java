public class Polygon {
    private Point[] points;
    private Style style;

    public Polygon(Point[] points) {
        this.points = points;
        this.style = new Style();
    }

    public Polygon(Point[] points, Style style) {
        this.points = points;
        this.style = style;
    }

    public String toSvg() {
        StringBuilder sb = new StringBuilder();
        sb.append("<polygon points=\"");
        for(Point point : points) {
            sb.append(point.x).append(",").append(point.y).append(" ");
        }
        sb.append("\" ").append(style.toSvg());
        return sb.toString();
    }
}
