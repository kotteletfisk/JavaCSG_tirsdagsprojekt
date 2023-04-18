package tirsdagsprojekt;

import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;
import org.abstractica.javacsg.JavaCSGFactory;

public class Main
{
    public static void main(String[] args)
    {
        JavaCSG csg = JavaCSGFactory.createDefault();

        Geometry3D body = CarBody.getCarBody(csg);

        Geometry3D front = CarFront.getCarFront(csg);

        Geometry3D cyl2 = csg.cylinder3D(2, 80, 80, false);
        Geometry3D horiCyl2 = csg.rotate3DY(csg.degrees(90)).transform(cyl2);
        Geometry3D horiCyl2Mov = csg.translate3D(-40, -10, -16).transform(horiCyl2);
        Geometry3D horiCyl3Mov = csg.translate3D(-40, -80, -16).transform(horiCyl2);

        Geometry3D vehicle = csg.union3D(body, front);

        csg.view(vehicle, 1);
    }
}
