package tirsdagsprojekt;

import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;
import org.abstractica.javacsg.JavaCSGFactory;

public class CarFront
{
    protected static Geometry3D getCarFront(JavaCSG csg)
    {
        Geometry3D cone = csg.cone3D(40, 30, 20, 80, false);
        Geometry3D horiCone = csg.rotate3DX(csg.degrees((-90))).transform(cone);

        Geometry3D sphere = csg.sphere3D(15, 80, true);
        Geometry3D horiSphere = csg.translate3D(0, 20, 0).transform(sphere);

        Geometry3D horiSphereDiff = csg.difference3D(horiCone, horiSphere);

        Geometry3D torus = csg.torus3D(5, 25, 80, 80, true);
        Geometry3D rotTorus = csg.rotate3DX(csg.degrees((90))).transform(torus);
        Geometry3D movTorus = csg.translate3D(0, 20, 0).transform(rotTorus);

        return csg.union3D(horiSphereDiff, movTorus);
    }
}
