import java.util.Scanner; 
public class Part2 {

    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in); 
        int first; 
        int second; 
        double third; 
        Part2 method = new Part2(); 
        System.out.println("What is the column number?"); 
        first = sc.nextInt(); 
        System.out.println("What is the row number?"); 
        second = sc.nextInt(); 
        System.out.println("What is the multiplication factor?"); 
        third = sc.nextDouble(); 
        method.Method(first, second, third); 

    }
    public static void Method(int column, int row, double mf) { 
        for (int i=1; i<=row; i++) { 
            for (int y=1; y<=column; y++) { 
                double calc; 
                calc = (i * y * mf); 
                System.out.printf(" %.1f", calc); 
            } 
            System.out.println(); 
        } 
    } 
} 