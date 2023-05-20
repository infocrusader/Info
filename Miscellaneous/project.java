import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdStats;

public class project {
	
	public static void main(String[] args) {
		In in = new In("C:\\Users\\user\\Desktop\\ders\\cmpe 211\\Project_211\\src\\data.txt");
		String[] data = in.readAllLines();
		System.out.println(data[1].substring(1,2));
		String [][]data2=new String [data.length-1][5];
		System.out.println(data.length);
		
		for(int i=1;i<data.length-1;i++) {
			int a=0;
			int b=1;
			int c=0;
			for(int k=0;k<data[i].length()-1;k++) {
				if(data[i].substring(k,b).equals(",")) {
					data2[i][a]=data[i].substring(c,k);
					c=b;
					a++;
				}
				if(a==4) {
					data2[i][4]=data[i].substring(k+1,k+2);
				}
				
				b++;
				
			}
		}
	    System.out.println(data2[1][0]);
	    System.out.println(data2[1][1]);
	    System.out.println(data2[1][2]);
	    System.out.println(data2[1][3]);
	    System.out.println(data2[1][4]);
	    System.out.println(data2[2][0]);
	    System.out.println(data2[2][1]);
	    System.out.println(data2[2][2]);
	    System.out.println(data2[2][3]);
	    System.out.println(data2[2][4]);

		
	
	}
	



}