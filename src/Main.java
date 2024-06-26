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
//        SvgScene scene = new SvgScene();
//        scene.addShape(star);
//        scene.addShape(sixSides);
//        scene.addShape(threeSides);
//        Style style2 = new Style("cyan", "pink", 6.0);
//        scene.addShape(Polygon.square(seg1, style2));
////        scene.save("out.html");
//        Style style3 = new Style("lime", "violet", 5.0);
//        Style style4 = new Style("black", "blue", 5.0);
//        Ellipse ellipse1 = new Ellipse(style3, new Vec2(155, 50), 30, 15);
//        Ellipse ellipse2 = new Ellipse(style4, new Vec2(100, 220), 60, 30);
//        System.out.println(ellipse1.toSvg());
//        scene.addShape(ellipse1);
//        scene.addShape(ellipse2);
//        scene.save("out.html");
        //lab3
        Shape star = new Polygon(
                new Vec2[]{
                        new Vec2(100, 10), new Vec2(40, 198),
                        new Vec2(190, 78), new Vec2(10, 78),
                        new Vec2(160, 198)
                });
        Shape ellipse = new Ellipse(new Vec2(100, 220), 60, 30);

        star = new SolidFillShapeDecorator(star, "pink");
//        star = new GradientFillShapeDecorator.Builder()
//                .setShape(star).addStop(0, "pink").addStop(0.5, "purple").addStop(1, "green").build();
        star = new TransformationDecorator.Builder()
                .translate(new Vec2(50, 50))
                .rotate(-27, new Vec2(0, 0))
                .scale(new Vec2(0.85, 0.85))
                .build(star);
        star = new DropShadowDecorator(star);

        ellipse = new SolidFillShapeDecorator(ellipse, "yellow");
        ellipse = new TransformationDecorator.Builder()
                .rotate(10, new Vec2(100, 220))
                .build(ellipse);
        ellipse = new DropShadowDecorator(ellipse);

        SvgScene scene = SvgScene.getInstance();
        scene.addShape(star);
        scene.addShape(ellipse);
        scene.save("out.html");
    }
}