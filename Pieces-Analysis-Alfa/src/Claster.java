import java.util.ArrayList;

public class Claster {
	double r =0;//3E-8; //radius of sphere
	ArrayList<Pies> claster = new ArrayList<Pies>();
	public void add(Pies pies){
		claster.add(pies);
	}
	public double Analys(){
		return S(claster.get(getInd(true)),claster.get(getInd(false)));
	}
	public double S(Pies a, Pies b){
		double d = radius(a,b);
		return Math.PI*Math.pow(((d)+r), 2);
	}
	private double radius(Pies a , Pies b){
		return Math.sqrt(Math.pow(Math.abs(a.x-b.x), 2)+Math.pow(Math.abs(a.y-b.y), 2))/2;
	}
	public double heigh(Pies a, Pies b){
		return Math.sqrt(Math.pow(Math.abs(a.x-b.x), 2)+Math.pow(Math.abs(a.z-b.z), 2));
	}
	public double S_Full(){
		return 2*Math.PI*radius(claster.get(getInd(true)),claster.get(getInd(false)))*heigh(claster.get(getIndHeigh(true)),claster.get(getIndHeigh(false)));
	}
	private int getIndHeigh(boolean isPiesA){
		int ind1 =0;
		int ind2 =0;
		double range = 0;
	//	System.out.println("==================================================");
		for(int i=0;i<claster.size();i++){
			for(int j =i;j<claster.size();j++){
		//		System.out.println(i+" "+j);
		//		System.out.println(Math.pow(Math.abs(claster.get(i).x-claster.get(j).x), 2)+Math.pow(Math.abs(claster.get(i).y-claster.get(j).y), 2));
				if(range < Math.sqrt(Math.pow(Math.abs(claster.get(i).x-claster.get(j).x), 2)+Math.pow(Math.abs(claster.get(i).z-claster.get(j).z), 2))){
					ind1 = i;
					ind2 = j;
					range = Math.sqrt(Math.pow(Math.abs(claster.get(i).x-claster.get(j).x), 2)+Math.pow(Math.abs(claster.get(i).z-claster.get(j).z), 2));
		//		    System.out.println(range);
		//		    System.out.println(ind1 +" ++ "+ind2);
				}
			}
		}
		if(isPiesA){
			return ind1;
		}
		else{
			return ind2;
		}
	}
	private int getInd(boolean isPiesA){
		int ind1 =0;
		int ind2 =0;
		double range = 0;
	//	System.out.println("==================================================");
		for(int i=0;i<claster.size();i++){
			for(int j =i;j<claster.size();j++){
		//		System.out.println(i+" "+j);
		//		System.out.println(Math.pow(Math.abs(claster.get(i).x-claster.get(j).x), 2)+Math.pow(Math.abs(claster.get(i).y-claster.get(j).y), 2));
				if(range < Math.sqrt(Math.pow(Math.abs(claster.get(i).x-claster.get(j).x), 2)+Math.pow(Math.abs(claster.get(i).y-claster.get(j).y), 2))){
					ind1 = i;
					ind2 = j;
					range = Math.sqrt(Math.pow(Math.abs(claster.get(i).x-claster.get(j).x), 2)+Math.pow(Math.abs(claster.get(i).y-claster.get(j).y), 2));
		//		    System.out.println(range);
		//		    System.out.println(ind1 +" ++ "+ind2);
				}
			}
		}
		if(isPiesA){
			return ind1;
		}
		else{
			return ind2;
		}
	}
    public int size(){
    	return claster.size();
    }
}
