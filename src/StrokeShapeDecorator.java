public class StrokeShapeDecorator extends ShapeDecorator {
    private String color;
    private double width;

    public StrokeShapeDecorator(Shape decoratedShape, String color, double width) {
        super(decoratedShape);
        this.color = color;
        this.width = width;
    }

    @Override
    public String toSvg(String parameters) {
        String stroke = "stroke=\"" + color + "\" stroke-width=\"" + width + "\"";
        if (!parameters.isEmpty()) {
            parameters += " ";
        }
        parameters += stroke;
        return decoratedShape.toSvg(parameters);
    }
}
