import java.util.Locale;

public class Segment {
    private Point start, end;
    private Style style;

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    public Segment(Point start, Point end) {
        this.start = start;
        this.end = end;
        this.style = new Style();
    }

    public double distance() {
        return Math.sqrt(Math.pow((end.x - start.x), 2) + Math.pow((end.y - start.y), 2));
    }

    public String toSvg() {
        String svg =  String.format(Locale.ENGLISH, "<line x1=\"%f\" y1=\"%f\" x2=\"%f\" y2=\"%f\" ",
                start.x, start.y, end.x, end.y);
        return svg + style.toSvg();
    }

    public static Segment[] perpendicularSegments(Segment segment, Point point) {
        double dx = segment.end.x - segment.start.x;
        double dy = segment.end.y - segment.start.y;
        return new Segment[]{
                new Segment(point, new Point(point.x - dy, point.y + dx)),
                new Segment(point, new Point(point.x + dy, point.y - dx))
        };
    }

    public static Segment[] perpendicularSegments(Segment segment, Point point, double length) {
        double dx = ((segment.getEnd().getX() - segment.getStart().getX()) / segment.distance()) * length;
        double dy = ((segment.getEnd().getY() - segment.getStart().getY()) / segment.distance()) * length;

        return new Segment[]{
                new Segment(point, new Point(point.getX() - dy, point.getY() + dx)),
                new Segment(point, new Point(point.getX() + dy, point.getY() - dx))
        };
    }
}
