

class Coord {
	double x;
	double y;
	public Coord(double x_, double y_){
		x = x_;
		y = y_;
	}
}
public class Scattering {
	private static double scatFunc1(double x) {
		return x;
	}
	private static double scatFunc2(double x) {
		return x;
	}
	public static double calc (double x) {
		if (x > 1) {
			return scatFunc1(x);
		}
		else {
			return scatFunc2(x);
		}
	}
}
