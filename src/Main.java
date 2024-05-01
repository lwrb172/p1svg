public class Main {
    public static void main(String[] args) {
//        //lab1
//        Vec2 a = new Vec2(50, 50);
//        Vec2 b = new Vec2(100, 50);
//        Segment seg1 = new Segment(a, b);
//        System.out.println(seg1.distance());
//
//        System.out.println(seg1.toSvg());
//
//        Polygon pol1 = new Polygon(new Vec2[]{a, b});
////        System.out.println(pol1.toSvg());
//        //lab2
//        Style style1 = new Style("black", "red", 5.0);
//        Polygon star = new Polygon(
//                new Vec2[]{
//                        new Vec2(100, 10), new Vec2(40, 198),
//                        new Vec2(190, 78), new Vec2(10, 78),
//                        new Vec2(160, 198)}
//                , style1
//        );
//        Polygon sixSides = new Polygon(
//                new Vec2[]{
//                        new Vec2(15, 1.5), new Vec2(25.8, 7.7),
//                        new Vec2(25.8, 20.2), new Vec2(15, 26.5),
//                        new Vec2(4.2, 20.2), new Vec2(4.2, 7.7)}
//                , new Style("yellow", "orange", 2.0)
//        );
//        Polygon threeSides = new Polygon(
//                new Vec2[]{
//                        new Vec2(25, 2.5), new Vec2(37.5,47.5),
//                        new Vec2(12.5, 47.5)
//                }
//        );
        SvgScene scene = new SvgScene();
//        scene.adShape(star);
//        scene.adShape(sixSides);
//        scene.adShape(threeSides);
//        Style style2 = new Style("cyan", "pink", 6.0);
//        scene.adShape(Polygon.square(seg1, style2));
////        scene.save("out.html");
//        Style style3 = new Style("lime", "violet", 5.0);
//        Style style4 = new Style("black", "blue", 5.0);
//        Ellipse ellipse1 = new Ellipse(style3, new Vec2(155, 50), 30, 15);
//        Ellipse ellipse2 = new Ellipse(style4, new Vec2(100, 220), 60, 30);
//        System.out.println(ellipse1.toSvg());
//        scene.adShape(ellipse1);
//        scene.adShape(ellipse2);
//        scene.save("out.html");
        //lab3
        SolidFilledPolygon pol1 = new SolidFilledPolygon(
                new Vec2[]{
                        new Vec2(50, 5), new Vec2(75, 95),
                        new Vec2(35, 95)}, "blue");
        scene.adShape(pol1);
        scene.save("out.html");
    }
}