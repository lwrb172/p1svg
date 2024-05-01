import java.util.Locale;

public class Segment {
    private Vec2 start, end;
    private Style style;

    public Vec2 getStart() {
        return start;
    }

    public Vec2 getEnd() {
        return end;
    }

    public Segment(Vec2 start, Vec2 end) {
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

    public static Segment[] perpendicularSegments(Segment segment, Vec2 vec2) {
        double dx = segment.end.x - segment.start.x;
        double dy = segment.end.y - segment.start.y;
        return new Segment[]{
                new Segment(vec2, new Vec2(vec2.x - dy, vec2.y + dx)),
                new Segment(vec2, new Vec2(vec2.x + dy, vec2.y - dx))
        };
    }

    public static Segment[] perpendicularSegments(Segment segment, Vec2 vec2, double length) {
        double dx = ((segment.getEnd().getX() - segment.getStart().getX()) / segment.distance()) * length;
        double dy = ((segment.getEnd().getY() - segment.getStart().getY()) / segment.distance()) * length;

        return new Segment[]{
                new Segment(vec2, new Vec2(vec2.getX() - dy, vec2.getY() + dx)),
                new Segment(vec2, new Vec2(vec2.getX() + dy, vec2.getY() - dx))
        };
    }
}
