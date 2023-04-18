package tirsdagsprojekt.wheels;

import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;
import org.abstractica.javacsg.JavaCSGFactory;

public class Main
{
    public static void main(String[] args)
    {
        JavaCSG csg = JavaCSGFactory.createDefault();

        Geometry3D axis = Axis.getAxis(csg);

        Geometry3D wheel = Wheel.getWheel(csg);

        csg.view(axis, 2);
        csg.view(wheel, 3);
    }
}
