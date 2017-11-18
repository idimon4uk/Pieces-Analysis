
public class Pies {
	public double x;
	public double y;
	public double z;
	private int ind;
	//information about particle
	public int getIndex(){
		return ind;
	}
	public void setIndex(int index){
		ind = index;
	}
	public Pies(int index, double x, double y, double z){
		ind = index;
		this.x = x;
		this.y = y;
		this.z = z;
	}
}
