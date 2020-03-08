public class Second{// Class beigns

    public static void main(String[] args) {//Method begims
  
  
    double array[][]={{1,2,3},{4,5,6},{7,8,9}};
    double array1[][]={{10,12,13},{14,15,16},{17,18,19}};//Defining our array type
    
  
    System.out.println("First matrix is:" + " " );//Loop for first array matrix
  
      for(int i=0; i< 3; i++){
          for (int j=0; j<3; j++){
              System.out.print(" " +array[i][j]);
          }
          System.out.println();
      }
      
    
    System.out.println("Second matrix is:"+ " ");//Loop for second array matrix
      for (int i=0; i< 3; i++){
          for(int j=0; j<3; j++){
          System.out.print(" " + array1[i][j]);
          }
      System.out.println();
      }
    System.out.println("Divide of both matrix : ");
      for(int i = 0; i < 3; i++) {//Loop for dividing both arrays
          for(int j = 0; j < 3; j++) {
          System.out.print(" "+ (4 * (array[i][j]))/(3 * (array1[i][j])));
          }
      System.out.println(" ");//Print result
      }
    }
    }//Method ends