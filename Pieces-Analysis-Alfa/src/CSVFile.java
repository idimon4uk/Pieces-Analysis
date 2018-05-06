import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.nio.Buffer;
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
		double sumSpeed =0;
		double sumI = 0;
		try(FileOutputStream fos = new FileOutputStream(fileName+".csv"))
		{
			byte[] buffer;
			for(int i=0;i<points.size();i++){
			buffer = (points.get(i).getTime()+"").toString().getBytes();
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
			
			buffer = (points.get(i).getAvgScatering()+"").toString().getBytes();
			fos.write(buffer,0,buffer.length);
			
			buffer = ";".getBytes();
			fos.write(buffer,0,buffer.length);
			
			if(i!=0){
				sumSpeed +=(points.get(i).getAvgLength() - points.get(i-1).getAvgLength())/(points.get(i).getTime() - points.get(i-1).getTime());
				buffer = ((points.get(i).getAvgLength() - points.get(i-1).getAvgLength())/(points.get(i).getTime() - points.get(i-1).getTime())+"").toString().getBytes();
				fos.write(buffer,0,buffer.length);
				sumI++;
				
				buffer = ";".getBytes();
				fos.write(buffer,0,buffer.length);
				
			}
		//	buffer = (data.get(i).averageSize2+"").toString().getBytes();
	    //  fos.write(buffer,0,buffer.length);
			
		//	buffer = ";".getBytes();
		//	fos.write(buffer,0,buffer.length);
			
			buffer = "\n".getBytes();
			fos.write(buffer,0,buffer.length);
			}
			
			buffer = ("; ; ; ; ;"+sumSpeed/sumI+"").toString().getBytes();
			fos.write(buffer,0,buffer.length);
		}
		
		catch (Exception e) {
			System.out.println("Something wrong");
		}
		///////
		
		StringBuilder sd = new StringBuilder();
		File file = new File(fileName+".csv");
		file.exists();
		try{
		BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
			try{
				String s;
				while((s = in.readLine())!=null){
					s =s.replace('.', ',');
					sd.append(s);
					sd.append("\n");
				}
			}
			finally{
				in.close();
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		sd.toString();
		File file1 = new File(fileName+".csv");
		try{
			if(!file1.exists()){
				file1.createNewFile();
			}
			PrintWriter out = new PrintWriter(file1.getAbsoluteFile());
			try{
				out.print(sd.toString());
			}
			finally{
				out.close();
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}//// HERE
	}
}
