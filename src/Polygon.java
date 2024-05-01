public class Polygon extends Shape {
    private Point[] points;

    public Polygon(Point[] points) {
        this.points = points;
    }

    public Polygon(Point[] points, Style style) {
        super(style);
        this.points = points;
    }

    @Override
    public String toSvg() {
        StringBuilder sb = new StringBuilder();
        sb.append("<polygon points=\"");
        for(Point point : points) {
            sb.append(point.x).append(",").append(point.y).append(" ");
        }
        sb.append("\" ").append(style.toSvg());
        return sb.toString();
    }

    public static Polygon square(Segment line, Style style) {
        double centerX = (line.getStart().getX() + line.getEnd().getX()) / 2;
        double centerY = (line.getStart().getY() + line.getEnd().getY()) / 2;
        Point center = new Point(centerX, centerY);
        Segment[] perpSegments = Segment.perpendicularSegments(line, center, line.distance()/2);
        Point[] squarePoints = new Point[4];
        squarePoints[0] = line.getStart();
        squarePoints[1] = perpSegments[1].getEnd();
        squarePoints[2] = line.getEnd();
        squarePoints[3] = perpSegments[0].getEnd();
        return new Polygon(squarePoints, style);
    }
}
