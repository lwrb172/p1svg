import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SvgScene {
    private final List<Shape> shapes = new ArrayList<>();
    private static SvgScene instance = null;
    private List<String> defs = new ArrayList<>();
    private static int index = 0;

    public static SvgScene getInstance() {
        if(instance == null) {
            instance = new SvgScene();
        }
        return instance;
    }

    public int addFilter(String filter) {
        defs.add(String.format(filter, ++index));
        return index;
    }

    public void adShape(Shape shape) {
        shapes.add(shape);
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
            fileWriter.write("<defs>");
            for(String def : defs) {
                fileWriter.write(def + "\n");
            }
            fileWriter.write("</defs");
            for (Shape shape : shapes) {
                fileWriter.write("\t" + shape.toSvg("") + "\n");
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
