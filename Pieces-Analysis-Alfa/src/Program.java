
public class Program {

	public static void main(String[] args) {
		Point.setLink("/home/dima/git/Pieces-Analysis/Pieces-Analysis-Alfa/dimentions/");
		//Point a = new Point("1600000");
		//a.Analyse();
		//Point b = new Point();
		//b.Analyse();
		//Point c = new Point("run-3",2,500,1000);
		//c.Analyse();
		CSVFile file15 = new CSVFile("result15");
		CSVFile file20 = new CSVFile("result20");
		CSVFile file25 = new CSVFile("result25");
		CSVFile file30 = new CSVFile("result30");
		Point.setRange(1.5);
		for(int i=0;i<82;i++){
			file15.add(new Point("run-5",i,2500,1000));
		}
		file15.printToFile();
		
		Point.setRange(2.0);
		for(int i=0;i<82;i++){
			file20.add(new Point("run-5",i,2500,1000));
		}
		file20.printToFile();
		
		Point.setRange(2.5);
		for(int i=0;i<82;i++){
			file25.add(new Point("run-5",i,2500,1000));
		}
		file25.printToFile();
		
		Point.setRange(3.0);
		for(int i=0;i<82;i++){
			file30.add(new Point("run-5",i,2500,1000));
		}
		file30.printToFile();
	}

}
