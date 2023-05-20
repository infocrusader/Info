import java.util.Scanner;
public class As4p2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        for (int i=1; i<=3; i++) {
            String which;
            if (i==1) {which = "first";}
            else if (i==2) which = "second";
            else which = "third";

        Part1 call = new Part1();

        System.out.printf("Give the brand name property of the %s vehicle.", which);
        String a = sc.next();
        System.out.printf("Give the model name property of the %s vehicle.", which);
        String b = sc.next();
        System.out.printf("If the %s vehicle is domestic enter true, else false.", which);
        boolean c = sc.nextBoolean();
        System.out.printf("Give the year property of the %s vehicle.", which);
        int d = sc.nextInt();
        System.out.printf("Give the engine property of the %s vehicle.", which);
        double e = sc.nextDouble();
        System.out.printf("Give the price property of the %s vehicle.", which);
        double f = sc.nextDouble();
        System.out.printf("Give the type property of the %s vehicle.", which);
        String g = sc.next();
        System.out.printf("If the %s vehicle has any accident history enter true, else false.", which);
        boolean h = sc.nextBoolean();
        
        double annualtax = call.tax(c,d,e);
        double insurance = call.ins(f,g,d,h);
        
        System.out.println("Properties of vehicle " + i + " are" + " " + a + " , " + b + " , " + c + " , " + d + " , " + e + " , " + f + " , " + g + " , " + h);
        System.out.printf("Annual tax of the %s vehicle is %.2f TL, Insurance of the i vehicle is  %.2f + TL.", which, annualtax,insurance);
        
        }
    }
}