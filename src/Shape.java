public abstract class Shape {
    protected Style style;

    public Shape(Style style) {
        this.style = style;
    }

    protected Shape() {
        this.style = new Style();
    }

    public abstract String toSvg();
}
