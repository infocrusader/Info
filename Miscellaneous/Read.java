import java.io.FileInputStream;
import java.util.Scanner;
public class Read{
    public static void readData(String file) {
		Scanner scan = null; //creating scanner named scan as null
		FileInputStream input = null; //creating fileinputstream named input as null
		try {
			input = new FileInputStream(file); //input becomes fileinputstream from the file
			scan = new Scanner(input); //scanning file 
			while(scan.hasNextLine()) {
				System.out.println(scan.nextLine()); //printing nextline from file with scanner
			}
		}
		catch(Exception e) { //general exception
			
		}
	}
	public static void main(String[] args) {
		readData("data1.txt"); //reading data1
		readData("data2.txt"); //reading data2
	}
}