import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;
import org.abstractica.javacsg.JavaCSGFactory;

public class Test
{
	public static void main(String[] args) {
		JavaCSG csg = JavaCSGFactory.createDefault();
		Geometry3D plate = csg.box3D(180, 180, 5, false);

		// Inner walls along x-axis
		Geometry3D wallx = csg.box3D(180, 20, 10, false);
		Geometry3D wallx1 = csg.translate3D(0, -30, 0).transform(wallx);
		Geometry3D wallx2 = csg.translate3D(0, 30, 0).transform(wallx);

		// Inner walls along y-axis
		Geometry3D wally = csg.box3D(20, 180, 10, false);
		Geometry3D wally1 = csg.translate3D(-30, 0, 0).transform(wally);
		Geometry3D wally2 = csg.translate3D(30, 0, 0).transform(wally);

		// Outer walls
		Geometry3D wallOx = csg.box3D(10, 180, 10, false);
		Geometry3D wallOxTop = csg.translate3D(-85, 0, 0).transform(wallOx);
		Geometry3D wallOxBot = csg.translate3D(85, 0, 0).transform(wallOx);

		Geometry3D wallOy = csg.box3D(180, 10, 10, false);
		Geometry3D wallOyTop = csg.translate3D(0, -85, 0).transform(wallOy);
		Geometry3D wallOyBot = csg.translate3D(0, 85, 0).transform(wallOy);

		Geometry3D board = csg.union3D(plate, wallx1, wallx2, wally1, wally2, wallOxTop, wallOxBot, wallOyTop, wallOyBot);

		csg.view(board);
	}
}
