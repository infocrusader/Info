package pro;

import edu.princeton.cs.algs4.In;
/**
 * @author Osama Zidan 
 * @author Sadiq Tijjani Umar 
 * @author Ahmad Youssef 
 * @author Zahit Kaya 
 * 
 */

public class project {
	
	
	//Euclid distance
	public static double[] distance(double [][]unsorted,double [] x) {
		double [] distances=new double [unsorted.length];
		for(int i=1;i<unsorted.length;i++) {
			//calculating distances
				distances[i]=Math.sqrt((Math.pow(unsorted[i][0]-x[0], 2)+Math.pow(unsorted[i][1]-x[1], 2)+Math.pow(unsorted[i][2]-x[2], 2)+Math.pow(unsorted[i][3]-x[3], 2)+Math.pow(unsorted[i][4]-x[4], 2)));
			
		}
		
		return distances;
		
	}

	 
	 static double [][] selectedItems(String [] data,int k,double [] x) {
		 // CONVERTING 1D STRING ARRAY TO 2D DOUBLE ARRAY 
		 double [][]unsorted=new double [data.length][5];
		 for(int i=1;i<data.length;i++) {
				int a=0;
				int b=1;
				int c=0;
				
				for(int s=0;s<data[i].length()-1;s++) {
					if(data[i].substring(s,b).equals(",")) {
						unsorted[i][a]=Double.valueOf(data[i].substring(c,s));
						c=b;
						a++;
						
					}

					if(a==4) {
						unsorted[i][4]=Double.valueOf(data[i].substring(s+1,s+2));
					}
					
					b++;
					
				}
			}
		 
		 
		 // for select k times 
		 double [][] selected=new double[k+1][5]; 
         
         int size=0; // SIZE OF y=1 array;
         
			for(int i=1;i<unsorted.length;i++) {
				//for calculate number of y=1;
				if(unsorted[i][4]==1.0)size++;
			}
			// sorted 2D array
         double [][] sorted=new double[size][5];
         
         //y=1 selected array
         double  [][] yes1 = new double [unsorted.length][5];
         for(int i=1;i<size;i++) {
        	
				for(int z=0;z<5;z++) {
					
					if(unsorted[i][4]==1.0) {
						yes1[i][z]=unsorted[i][z];
						
						
					}
				}
				
			
			
         }
         //Adding distances of all items into an 1D array
         double [] dissorted=new double[size];
			Merge m=new Merge();
			for(int i=1;i<size;i++) {
				dissorted[i]=distance(yes1,x)[i];
			}
			//sorting distances
			m.Sort(dissorted);
			//Now distances are sorted
			
         for(int i=1;i<size;i++) {
				for(int z=1;z<size;z++) {
					// sorting 2D array by using sorted distances
					if(dissorted[i]==distance(yes1,x)[z] && yes1[i][4]==1.0) {
						sorted[i][0]=unsorted[z][0];
						sorted[i][1]=unsorted[z][1];
						sorted[i][2]=unsorted[z][2];
						sorted[i][3]=unsorted[z][3];
						sorted[i][4]=unsorted[z][4];
					}
				
			}
				
		 
	    
		
		
		}
              // to select items k times
		 for(int i=1;i<k+1;i++) {
                	for(int z=0;z<5;z++) {
                		selected[i][z]=sorted[i][z];
                		System.out.print(selected[i][z]+" ");
                	}
                	System.out.print(" with distance:  ");
                	System.out.printf("% .15f", dissorted[i]); 
                	System.out.println();
                }
		 return selected;
	 }
	 
	 
	 //MAIN
	 
	 public static void main(String[] args) {
			In in = new In("C:\\Users\\user\\Desktop\\ders\\cmpe 211\\Project_211\\src\\data.txt");
			String[] data = in.readAllLines();
	
			 double [] x= {4.454466621195594,2.922061487005003,3.19079261209446,2.2842495787578914,1};
			 selectedItems(data,5,x); 
			 //unsorted is our data
			 //5 is k(number of items)
			 //x is a compering array 
			 
			 
			 
			

}
	 }
