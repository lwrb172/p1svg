import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SvgScene {
    private final List<Polygon> polygons = new ArrayList<>();

    public void addPolygon(Polygon polygon) {
        polygons.add(polygon);
    }

    public void save(String path) {
        try {
            FileWriter fileWriter = new FileWriter(path);
            fileWriter.write("<HTML>");
            fileWriter.write("<body>");
            fileWriter.write(
                    String.format(Locale.ENGLISH,
                            "<svg height=\"%f\" width=\"%f\" xmlns=\"http://www.w3.org/2000/svg\">\n",
                            1000.0, 1000.0)
            );

            for (Polygon polygon : polygons) {
                fileWriter.write("\t" + polygon.toSvg() + "\n");
            }

            fileWriter.write("</svg>");
            fileWriter.write("</body>");
            fileWriter.write("</HTML>");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
