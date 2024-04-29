public class Polygon {
    private Point[] points;

    public Polygon(Point[] points) {
        this.points = points;
    }

    public Polygon(Polygon src) {
        this.points = new Point[src.points.length];
        for (int i = 0; i < src.points.length; ++i) {
            this.points[i] = new Point(src.points[i].x, src.points[i].y);
        }
    }

    public String toSvg() {
        StringBuilder sb = new StringBuilder();
        sb.append("<polygon points=\"");
        for(Point point : points) {
            sb.append(point.x).append(",").append(point.y).append(" ");
        }
        sb.append("\" ").append("style=\"fill:lime;stroke:purple;stroke-width:3\" />");
        return sb.toString();
    }
}
