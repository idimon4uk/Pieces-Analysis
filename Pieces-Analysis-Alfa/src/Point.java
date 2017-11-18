import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Point {
	ArrayList<couple_Pies> couple;
	ArrayList<Pies> Particle;
	ArrayList<Claster> agregates;
	double range = 3.5E-8;
	static String link = "";
	private double time=0;
	double avgWidth;
	int numAgregats;
	double avgLength;
	public static void setLink(String Link){
		link = Link;
	}
	public Point(String fileName){//FFANS constructor
		Particle = fillFFans_standart(fileName);
		couple = findCouple();
		agregates = clasterForm();
		time = Double.parseDouble(fileName);
	}
	public Point(String fileName, int delta, int numPieses,double deltaTime){//Espresso-FFANS constructor
		Particle = fillFromLog(fileName,delta,numPieses);
		couple = findCouple();
		agregates = clasterForm();
		time = deltaTime * delta;
	}
	public Point(){//ManualFilling for Testing
		Particle = fillTest();
		couple = findCouple();
		agregates = clasterForm();
	}
	public ArrayList<Pies> fillFFans_standart(String fileName){
		String textDat = "";
		String[] part;
		try {
			Scanner fileDat = new Scanner(new File(link+fileName+".dat"));
			textDat = fileDat.useDelimiter("\\A").next();
			fileDat.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		part = textDat.split(" ");
//Clean Up string
		ArrayList <Pies> Particle = new ArrayList<Pies>();
		try{
	    int j = 0;
		for(int i=1;i<textDat.length();i+=16,j++)
		{
			Particle.add(new Pies(j,Double.parseDouble(part[(i+4)]),Double.parseDouble(part[(i+5)]),Double.parseDouble(part[(i+6)])));
		}
		}
		catch (Exception e) {
			
		}
		return Particle;
	}
	public ArrayList<couple_Pies> findCouple(){
		ArrayList <couple_Pies> arr = new ArrayList<couple_Pies>();
	
		for(int i=0;i<Particle.size()-1;i++)
		{
			for(int j = i+1;j<Particle.size();j++)
			{
				if(Math.sqrt(Math.pow(Particle.get(i).x-Particle.get(j).x, 2)+Math.pow(Particle.get(i).y-Particle.get(j).y, 2)+Math.pow(Particle.get(i).z-Particle.get(j).z, 2))<=range)
				{
					arr.add(new couple_Pies(i, j,Particle.get(i).x,Particle.get(i).y,Particle.get(i).z,Particle.get(j).x,Particle.get(j).y,Particle.get(j).z));
				}
			}
		}
		return arr;
	}
	public ArrayList<Claster> clasterForm(){
		ArrayList<Claster> clasters = new ArrayList<Claster>();
		ArrayList <ArrayList<Pies>> Piese = new ArrayList<ArrayList<Pies>>();
		try{
		while(couple.size()!=0)
		{
			boolean isSorted = false;
			for(int i=0;i<couple.size();i++)
			{
				ArrayList<Pies> intList = new ArrayList<Pies>();
				intList.add((couple.get(0).m));
				intList.add((couple.get(0).n));
				couple.remove(0);
				isSorted = false;
				while(!isSorted)
				{	
					isSorted = true;		
					for(int j = 0;j<couple.size();j++)
					{
						isSorted = true;
						for(int k = 0;k<intList.size();k++)
						{
						//	System.out.println(i+"  "+j+"   "+k+"value = "+ arr.get(j).m + "  "+arr.get(j).n + "  "+intList.get(k));
							if(couple.get(j).m.getIndex()==intList.get(k).getIndex())
							{
								isSorted = false;
								boolean isRepeat = false;
								for(int l = 0;l<intList.size();l++)
								{
									if(couple.get(j).n.getIndex()==intList.get(l).getIndex())
									{
											isRepeat = true;
											break;
									}
								}
								if(!isRepeat)
								{
									intList.add(couple.get(j).n);
								}
								couple.remove(j);
								j=-1;
								break;
							}
							if(couple.get(j).n.getIndex()==intList.get(k).getIndex())
							{
								isSorted = false;
								boolean isRepeat = false;
								for(int l = 0;l<intList.size();l++)
								{
									if(couple.get(j).m.getIndex()==intList.get(l).getIndex())
									{
											isRepeat = true;
											break;
									}
								}
								if(!isRepeat)
								{
									intList.add(couple.get(j).m);
								}
								couple.remove(j);
								j=-1;
								break;
							}
						}
					}
				}
				Piese.add(intList);
			}
		}

		for(int i=0;i<Piese.size();i++)
		{
			clasters.add(new Claster());
			for(int j = 0;j<Piese.get(i).size();j++)
			{
				clasters.get(i).add(Piese.get(i).get(j));
				System.out.print(Piese.get(i).get(j).getIndex()+"   ");
			}
			System.out.println();
		}
		}
		catch(Exception e)
		{
			
		}
		return clasters;
		
	}
	public void Analyse(){
		numAgregats = agregates.size();
		double sumWidth = 0;
		double sumLength =0;
		for(int i =0;i<agregates.size();i++){
			sumWidth+= agregates.get(i).Analys();
			sumLength+=agregates.get(i).size();
		}
		avgWidth = sumWidth/numAgregats;
		avgLength =Particle.size()/(agregates.size()+(Particle.size()-sumLength)) ;
		System.out.println("Num of pieses = "+Particle.size()+" num of agregates = "+numAgregats+" avgLen = "+avgLength+" pieses, avgWidth = "+ avgWidth);
	}
	public ArrayList<Pies> fillTest(){
		ArrayList<Pies> test = new ArrayList<Pies>();
		test.add(new Pies(0,0,0,0));
		test.add(new Pies(1,0,0,3.3E-8));
		test.add(new Pies(2,0,0,6.6E-8));
		test.add(new Pies(3,0,0,9.9E-8));
		test.add(new Pies(4,0,0,13.2E-8));
		test.add(new Pies(5,0,3.3E-8,0));
		test.add(new Pies(6,0,6.6E-8,0));
		test.add(new Pies(7,3.3E-8,0,3.3E-8));
		
		test.add(new Pies(8,1,0,0));
		test.add(new Pies(9,1,0,3.3E-8));
		test.add(new Pies(10,1,0,6.6E-8));
		test.add(new Pies(11,1,0,9.9E-8));
		test.add(new Pies(12,1,0,13.2E-8));
		return test;
	}
	public ArrayList<Pies> fillFromLog(String fileName, int delta, int numPies){
		String textDat = "";
		String[] part;
		try {
			Scanner fileDat = new Scanner(new File(link+fileName+".log"));
			textDat = fileDat.useDelimiter("\\A").next();
			fileDat.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		part = textDat.split(";");
		//Clean Up string
				ArrayList <Pies> Particle = new ArrayList<Pies>();
				try{
			    int j = 0;
				for(int i=4*delta*numPies+1+delta;i<(4*(delta+1)*numPies)/*textDat.length()*/;i+=4,j++)
				{
					Particle.add(new Pies(j,Double.parseDouble(part[(i+1)]),Double.parseDouble(part[(i+2)]),Double.parseDouble(part[(i+3)])));
					System.out.println(Particle.get(j).getIndex()+";x = "+Particle.get(j).x+";y = "+Particle.get(j).y+";z = "+Particle.get(j).z);
				}
				}
				catch (Exception e) {
				e.printStackTrace();	
				}
		
		return Particle;
	}
	public double getTime(){
		return time;
	}
	public int getNumPies(){
		return numAgregats;
	}
	public double getAvgWidth(){
		return avgWidth;
	}
	public double getAvgLength(){
		return avgLength;
	}
}
