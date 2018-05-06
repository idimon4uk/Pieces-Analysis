
public class Program {
	public static void main(String[] args) {
		//Point.setLink("/home/dima/git/Pieces-Analysis/Pieces-Analysis-Alfa/dimentions/");
		CSVFile file1 = new CSVFile("4");
		CSVFile file2 = new CSVFile("complex_result2");
		Point.setRange(3.5E-8);
        	Point.setLink("/home/dima/git/Pieces-Analysis/Pieces-Analysis-Alfa/dimentions/"+1+"/");
        	for(int i =1;i<11;i++){
        		file1.add(new Point((""+1000*i)));
        	}
        	for(int i =1;i<11;i++){
        		file1.add(new Point((""+10000*i)));
        	}
        	int timeFile = 0;
        	for(int i = 1;i<10;i++){
        		for(int j =1;j<11;j++){
        			timeFile = (100000*i) + (10000*j);
        			file1.add(new Point((""+timeFile)));
        		}
        	}
//        	Point.setLink("/home/dima/git/Pieces-Analysis/Pieces-Analysis-Alfa/dimentions/"+2+"/");
//        	for(int i =1;i<11;i++){
//        		file2.add(new Point((""+1000*i)));
//        	}
//        	for(int i =1;i<11;i++){
//        		file2.add(new Point((""+10000*i)));
//        	}
//        	timeFile = 0;
//        	for(int i = 1;i<10;i++){
//        		for(int j =1;j<11;j++){
//        			timeFile = (100000*i) + (10000*j);
//        			file2.add(new Point((""+timeFile)));
//        		}
//        	}
        	
        file1.printToFile();
//        file2.printToFile();
	}

}
