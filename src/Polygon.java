public class Polygon implements Shape {
    private Vec2[] vec2s;
    private Style style;

    public Polygon(Vec2[] vec2s) {
        this.vec2s = vec2s;
        this.style = new Style();
    }

    public Polygon(Vec2[] vec2s, Style style) {
        this.vec2s = vec2s;
        this.style = style;
    }

    @Override
    public String toSvg() {
        StringBuilder sb = new StringBuilder();
        sb.append("<polygon points=\"");
        for(Vec2 vec2 : vec2s) {
            sb.append(vec2.x).append(",").append(vec2.y).append(" ");
        }
        sb.append("\" ").append(style.toSvg());
        return sb.toString();
    }

    public static Polygon square(Segment line, Style style) {
        double centerX = (line.getStart().getX() + line.getEnd().getX()) / 2;
        double centerY = (line.getStart().getY() + line.getEnd().getY()) / 2;
        Vec2 center = new Vec2(centerX, centerY);
        Segment[] perpSegments = Segment.perpendicularSegments(line, center, line.distance()/2);
        Vec2[] squareVec2s = new Vec2[4];
        squareVec2s[0] = line.getStart();
        squareVec2s[1] = perpSegments[1].getEnd();
        squareVec2s[2] = line.getEnd();
        squareVec2s[3] = perpSegments[0].getEnd();
        return new Polygon(squareVec2s, style);
    }
}
