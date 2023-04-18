package tirsdagsprojekt;

import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;
import org.abstractica.javacsg.JavaCSGFactory;

public class CarBody
{
    protected static Geometry3D getCarBody(JavaCSG csg)
    {
        Geometry3D cyl = csg.cylinder3D(40, 100, 80, false);
        Geometry3D horiCyl = csg.rotate3DX(csg.degrees((90))).transform(cyl);

        Geometry3D sphere = csg.sphere3D(20, 80, false);
        Geometry3D movSphere = csg.translate3D(0, -70, 10).transform(sphere);

        Geometry3D cyl2 = csg.cylinder3D(2.5, 80, 80, false);
        Geometry3D horiCyl2 = csg.rotate3DY(csg.degrees(90)).transform(cyl2);
        Geometry3D horiCyl2Mov = csg.translate3D(-40, -10, -16).transform(horiCyl2);
        Geometry3D horiCyl3Mov = csg.translate3D(-40, -80, -16).transform(horiCyl2);

        return csg.difference3D(horiCyl, movSphere, horiCyl2Mov, horiCyl3Mov);
    }
}
