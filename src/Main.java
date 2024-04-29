public class Main {
    public static void main(String[] args) {
        Point a = new Point(0, 1);
        Point b = new Point(3, 1);
        Segment seg1 = new Segment(a, b);
        System.out.println(seg1.distance());

        System.out.println(seg1.toSvg());

        Polygon pol1 = new Polygon(new Point[]{a, b});
        System.out.println(pol1.toSvg());
    }
}