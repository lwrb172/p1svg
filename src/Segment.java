import java.util.Locale;

public class Segment {
    private Point start, end;

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    public Segment(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public double distance() {
        return Math.sqrt(Math.pow((end.x - start.x), 2) + Math.pow((end.y - start.y), 2));
    }

    public String toSvg() {
        return String.format(Locale.ENGLISH, "<line x1=\"%f\" y1=\"%f\" x2=\"%f\" y2=\"%f\" style=\"stroke:red;stroke-width:2\" />",
                start.x, start.y, end.x, end.y);
    }

    public static Segment[] perpendicularSegments(Segment segment, Point point) {
        double distanceX = segment.end.x - segment.start.x;
        double distanceY = segment.end.y - segment.start.y;
        return new Segment[]{
                new Segment(point, new Point(point.x - distanceY, point.y + distanceX)),
                new Segment(point, new Point(point.x + distanceY, point.y - distanceY))};
    }
}
