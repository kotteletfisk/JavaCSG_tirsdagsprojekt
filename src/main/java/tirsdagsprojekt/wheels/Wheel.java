package tirsdagsprojekt.wheels;

import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;

public class Wheel
{
    protected static Geometry3D getWheel(JavaCSG csg)
    {
        Geometry3D ring = csg.flatRing3D(2, 20, 5, 80, true);
        Geometry3D torus = csg.torus3D(5, 20, 80, 80, true);

        return csg.union3D(ring, torus);
    }
}
