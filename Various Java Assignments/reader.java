import java.io.FileInputStream;
import java.util.Scanner;
public class reader{
    public static void readData(String file) {


		Scanner scan = null; //Introducing scanner named scan as null
        FileInputStream input = null; //setting fileinputstream named input as null
        

		try {
			input = new FileInputStream(file); //setting input as fileinputstream from the file
			scan = new Scanner(input); //introducing the scanning file 
			while(scan.hasNextLine()) {
				System.out.println(scan.nextLine()); //we then print the nextline from the file with scanner
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