public class SolidFilledPolygon extends Polygon {
    private String color;

    public SolidFilledPolygon(Vec2[] vec2s, String color) {
        super(vec2s);
        this.color = color;
    }

    @Override
    public String toSvg(String parameters) {
        String fill = "fill=\"" + color + "\" " + parameters + "\"";
        return super.toSvg(fill);
    }
}
