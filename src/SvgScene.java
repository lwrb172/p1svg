import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SvgScene {
    private List<Shape> shapes = new ArrayList<>();
    private static SvgScene instance;
    private List<String> defs = new ArrayList<>();
    private static int index = 0;

    private SvgScene() {};

    public static SvgScene getInstance() {
        if(instance == null) {
            instance = new SvgScene();
        }
        return instance;
    }

    public int addFilter(String filter) {
        defs.add(String.format(filter, ++index));
//        System.out.println(defs);
        return index;
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void save(String path) {
        try {
            FileWriter fileWriter = new FileWriter(path);
//            System.out.println(defs);
            fileWriter.write("<HTML>");
            fileWriter.write("<body>");
            fileWriter.write(
                    String.format(Locale.ENGLISH,
                            "<svg height=\"%f\" width=\"%f\" xmlns=\"http://www.w3.org/2000/svg\">\n",
                            1000.0, 1000.0)
            );
            fileWriter.write("<defs>\n");
            for(String def : defs) {
                fileWriter.write(def + "\n");
//                System.out.println(def);
            }
//            System.out.println(defs);
            fileWriter.write("</defs>\n");
            for (Shape shape : shapes) {
                fileWriter.write("\t" + shape.toSvg("") + "\n");
            }
            fileWriter.write("</svg>");
            fileWriter.write("</body>");
            fileWriter.write("</HTML>");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}