import java.io.FileOutputStream;
import java.util.ArrayList;

public class CSVFile {
	String fileName;
	ArrayList<Point> points;
	public CSVFile(String fileName){
		this.fileName = fileName;
		points = new ArrayList<Point>();
	}
	public void add(Point point){
		points.add(point);
		points.get(points.size()-1).Analyse();
	}
	public void printToFile(){
		try(FileOutputStream fos = new FileOutputStream(fileName+".csv"))
		{
			for(int i=0;i<points.size();i++)
			{
			byte[] buffer = (points.get(i).getTime()+"").toString().getBytes();
			fos.write(buffer,0,buffer.length);
			
			buffer = ";".getBytes();
			fos.write(buffer,0,buffer.length);
			
			buffer = (points.get(i).getNumPies()+"").toString().getBytes();
			fos.write(buffer,0,buffer.length);
			
			buffer = ";".getBytes();
			fos.write(buffer,0,buffer.length);
			
			buffer = (points.get(i).getAvgLength()+"").toString().getBytes();
			fos.write(buffer,0,buffer.length);
			
			buffer = ";".getBytes();
			fos.write(buffer,0,buffer.length);
			
			buffer = (points.get(i).getAvgWidth()+"").toString().getBytes();
			fos.write(buffer,0,buffer.length);
			
			buffer = ";".getBytes();
			fos.write(buffer,0,buffer.length);
			
			buffer = (points.get(i).getAvgS()+"").toString().getBytes();
			fos.write(buffer,0,buffer.length);
			
			buffer = ";".getBytes();
			fos.write(buffer,0,buffer.length);
		//	buffer = (data.get(i).averageSize2+"").toString().getBytes();
	    //  fos.write(buffer,0,buffer.length);
			
		//	buffer = ";".getBytes();
		//	fos.write(buffer,0,buffer.length);
			
			buffer = "\n".getBytes();
			fos.write(buffer,0,buffer.length);
			}
		
		}
		catch (Exception e) {
			System.out.println("Something wrong");
		}
	}
}
