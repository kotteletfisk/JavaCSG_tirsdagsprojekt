package tirsdagsprojekt.wheels;

import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;
import org.abstractica.javacsg.JavaCSGFactory;

public class Axis
{
    protected static Geometry3D getAxis(JavaCSG csg)
    {
        Geometry3D cyl2 = csg.cylinder3D(2, 80, 80, false);
        return csg.rotate3DY(csg.degrees(90)).transform(cyl2);
    }
}
