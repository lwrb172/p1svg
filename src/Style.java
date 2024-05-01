import java.util.Locale;

public class Style {
    public final String fillColor, strokeColor;
    public final Double strokeWidth;

    public Style(String fillColor, String strokeColor, Double strokeWidth) {
        this.fillColor = fillColor;
        this.strokeColor = strokeColor;
        this.strokeWidth = strokeWidth;
    }

    public Style() {
        this.fillColor = "none";
        this.strokeColor = "black";
        this.strokeWidth = 1.0;
    }

    public String toSvg() {
        return String.format(Locale.ENGLISH, "style=\"fill:%s;stroke:%s;stroke-width:%f\" />",
                fillColor, strokeColor, strokeWidth);
    }
}
