import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public void write(String fileName1,String fileName2,String fileName3) {
	
	list<String> data1 = null;
	list<String> data2 = null;
	
	try {
		data1 = Files.readAllLines(Paths.get(fileNmae1));
		data2= Files.readAllLines(Paths.get(fileName2));
	}
	catch(IOException e) {
		e.printStackTrace();
	}
	
	list<String> results = new ArrayList<>();
	
	results.add("ID,Name.Q_Average,Midterm,Final,Department");
	
	data1.remove(0);
	data2.remove(0);
	
	
	for(String dat1 : data1) {
		String[] s = dat1.split(",");
		for(String dat2 : data2) {
			String[] g = dat2.split(",");
			
			if(Object.equals(s[0],g[0])) {
				double doub = ((Double.parseDouble(g[1]) + Double.parseDouble(g[2]) + Double.parseDouble(g[3])) / 3);
				String str = String.format("%.1f",doub);
				results.add(s[0] + "," + s[1] + "," + str + "," + g[4] + "," + g[5] + "," + s[3]);
			}
		}
	}
	
	try {
		Files.write(Paths.get(fileName3),results);
	}
	catch(IOExcpetion e) {
		e.printStackTrace();
	}
})