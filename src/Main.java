public class Main {
    public static void main(String[] args) {
        //lab1
        Point a = new Point(50, 50);
        Point b = new Point(100, 50);
        Segment seg1 = new Segment(a, b);
        System.out.println(seg1.distance());

        System.out.println(seg1.toSvg());

        Polygon pol1 = new Polygon(new Point[]{a, b});
        System.out.println(pol1.toSvg());
        //lab2
        Style style1 = new Style("black", "red", 5.0);
        Polygon star = new Polygon(
                new Point[]{
                        new Point(100, 10), new Point(40, 198),
                        new Point(190, 78), new Point(10, 78),
                        new Point(160, 198)}
                , style1
        );
        Polygon sixSides = new Polygon(
                new Point[]{
                        new Point(15, 1.5), new Point(25.8, 7.7),
                        new Point(25.8, 20.2), new Point(15, 26.5),
                        new Point(4.2, 20.2), new Point(4.2, 7.7)}
                , new Style("yellow", "orange", 2.0)
        );
        Polygon threeSides = new Polygon(
                new Point[]{
                        new Point(25, 2.5), new Point(37.5,47.5),
                        new Point(12.5, 47.5)
                }
        );
        SvgScene scene = new SvgScene();
        scene.addPolygon(star);
        scene.addPolygon(sixSides);
        scene.addPolygon(threeSides);
        Style style2 = new Style("cyan", "pink", 6.0);
        scene.addPolygon(Polygon.square(seg1, style2));
        scene.save("out.html");
    }
}