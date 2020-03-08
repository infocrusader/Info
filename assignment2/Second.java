import java.util.Scanner; //Allow for the use of scanner without loss of generality
public class Second { //Class begins

    public static void main(String [] args) {
        Scanner im = new Scanner(System.in);//This introduces the scanner into method
        Second process = new Second();
        //Declaring variables
        int primary; 
        int secondary; 
        double tetiary; 
        //Here we will write the request statements and allow for inputs of row,colomn and multiplication number variables.
      System.out.println("What will be the column number?"); 
        primary = im.nextInt(); 
        System.out.println("What will be the row number?"); 
        secondary = im.nextInt(); 
        System.out.println("What will be the multiplication element?"); 
        tetiary = im.nextDouble(); 
        process.Method(primary, secondary, tetiary); 

    }
    //Below is the double for loop for the arrangement,conformation and structure of the resulting stacked arrays(Table)
    public static void Method(int column, int row, double me) { 
        for (int i=1; i<=row; i++) { 
            for (int j=1; j<=column; j++) { 
                double calc; 
                calc = (i * j * me); 
                System.out.printf(" %.1f", calc); 
            } 
            System.out.println(); 
        } 
    } //Method ends
} 