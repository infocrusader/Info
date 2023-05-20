



import edu.princeton.cs.algs4.In;


public class project {
	
	
	//Euclid distance
	public static double[] distance(double [][]unsorted,double [] x) {
		double [] distances=new double [unsorted.length];
		for(int i=1;i<unsorted.length;i++) {
			
				distances[i]=Math.sqrt((Math.pow(unsorted[i][0]-x[0], 2)+Math.pow(unsorted[i][1]-x[1], 2)+Math.pow(unsorted[i][2]-x[2], 2)+Math.pow(unsorted[i][3]-x[3], 2)+Math.pow(unsorted[i][4]-x[4], 2)));
			
		}
		
		return distances;
		
	}
	 static void printArray(double[] arr) 
	    { 
	        int n = arr.length; 
	        for (int i=0; i<n; ++i) 
	            System.out.println(arr[i] + " "); 
	      
	    }
	 
	 static double [][] selectedItems(double [][] unsorted,int k,double [] x) {
         double [][] selected=new double[k+1][5]; 
         int size=0; // SIZE OF AGE=1;
			for(int i=1;i<unsorted.length;i++) {
				if(unsorted[i][4]==1.0)size++;
			}
         double [][] sorted=new double[size][5];
         double  [][] yes1 = new double [unsorted.length][5];
         for(int i=1;i<size;i++) {
				for(int z=0;z<5;z++) {
					if(unsorted[i][4]==1.0) {
						yes1[i][z]=unsorted[i][z];	
					}
				}
         }
         double [] dissorted=new double[size];
			Merge m=new Merge();
			for(int i=1;i<size;i++) {
				dissorted[i]=distance(yes1,x)[i];
			}
			m.Sort(dissorted);
			
         for(int i=1;i<size;i++) {
				for(int z=1;z<size;z++) {
					if(dissorted[i]==distance(yes1,x)[z] && yes1[i][4]==1.0) {
						sorted[i][0]=unsorted[z][0];
						sorted[i][1]=unsorted[z][1];
						sorted[i][2]=unsorted[z][2];
						sorted[i][3]=unsorted[z][3];
						sorted[i][4]=unsorted[z][4];
					}
				
			}
				
		 
	    
		
		
		}
 
		 for(int i=1;i<k+1;i++) {
                	for(int z=0;z<5;z++) {
                		selected[i][z]=sorted[i][z];
                		System.out.print(selected[i][z]+" ");
                	}
                	System.out.print(" with distance:  "+dissorted[i]);
                	System.out.println();
                }
		 return selected;
	 }
	 
	 
	 //MAIN
	 
	 public static void main(String[] args) {
			In in = new In("C:\\Users\\user\\Desktop\\ders\\cmpe 211\\Project_211\\src\\data.txt");
			String[] data = in.readAllLines();
			String [][]data2=new String [data.length][5];	
			double [] x= {4.454466621195594,2.9220614870050037,3.1907926120944246,2.2842495787578914,1};
		// READING THE DATA FILE AS 2D ARRAY
			for(int i=1;i<data.length;i++) {
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
			//converting data2 to double
		    double [][] unsorted=new	double [data2.length][5];
			
			 for(int i=1;i<data2.length-1;i++) {
				for(int k=0;k<5;k++) {
				unsorted[i][k]=Double.valueOf(data2[i][k]);		
				}
			} 
			 selectedItems(unsorted,5,x); 
			 //WRITING AN ARRAY ONLY y=1
		/*	double  [][] yes1 = new double [unsorted.length][5];
			int size=0; // SIZE OF AGE=1;
			for(int i=1;i<unsorted.length;i++) {
				if(unsorted[i][4]==1.0)size++;
			}
			for(int i=1;i<size;i++) {
				for(int k=0;k<5;k++) {
					if(unsorted[i][4]==1.0) {
						yes1[i][k]=unsorted[i][k];	
					}
				//	System.out.print(age1[i][k]+" ");	
				}
				// System.out.println();
				
			} */
			
			
		 
			 //PRINT OF UNSORTED DISTANCES
			/* for(int i=1;i<unsorted.length;i++) {
				System.out.println((distance(unsorted,x)[i]));
			} */
			
			//SORTING
		/*	double [] dissorted=new double[size];
			Merge m=new Merge();
			for(int i=1;i<size;i++) {
				dissorted[i]=distance(yes1,x)[i];
			}
			m.Sort(dissorted);
		//    printArray(dissorted); */
			//
		/*	double [][] sorted=new double[size][5];
		
			for(int i=1;i<size;i++) {
				for(int k=1;k<size;k++) {
					if(dissorted[i]==distance(yes1,x)[k] && yes1[i][4]==1.0) {
						sorted[i][0]=unsorted[k][0];
						sorted[i][1]=unsorted[k][1];
						sorted[i][2]=unsorted[k][2];
						sorted[i][3]=unsorted[k][3];
						sorted[i][4]=unsorted[k][4];
					}
				
			}
				
		 
	    
		
			
	
		} */
			
			/*
			for(int i=1;i<size;i++) {
				for(int k=0;k<5;k++) {
					System.out.print(sorted[i][k]+" ");
				}
				System.out.print(" with distance : "+dissorted[i]);
				System.out.println();
			} */
			
			
			
			
	

	



}}
