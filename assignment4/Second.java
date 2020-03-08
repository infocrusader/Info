import java.util.Scanner;//We introduce the scanner to our program
public class Second {//Declare and opem class
    public static void main(String[] args) {//Method begins
        Scanner im = new Scanner(System.in);
        //Below we create loop for assigning our three objects
        for (int i=1; i<=3; i++) {
            String direct;
            if (i==1) {direct = "Primary";}
            else if (i==2) direct = "Secondary";
            else direct = "Tetiary";

        Second get = new Second();//Allows for new inputs in program
        //Below we will prompt the user for needed variables and the scanner will receive them
        System.out.printf("Please provide brand name of the %s vehicle.", direct);
        String n = im.next();
        System.out.printf("Please provide model name of the %s vehicle.", direct);
        String m = im.next();
        System.out.printf("In the case the %s vehicle is domestic, please enter true otherwise enter false.", direct);
        boolean z = im.nextBoolean();
        System.out.printf("Please provide the production year of the %s vehicle.", direct);
        int y = im.nextInt();
        System.out.printf("Please provide the engine capacity of the %s vehicle.", direct);
        double e = im.nextDouble();
        System.out.printf("Please provide the price of the %s vehicle.", direct);
        double p = im.nextDouble();
        System.out.printf("Please provide the type of the %s vehicle.", direct);
        String t = im.next();
        System.out.printf("In the case %s vehicle has ever been in an accident,please enter true otherwise enter false false.", direct);
        boolean a = im.nextBoolean();
        
        double Yearlytax = get.tax(z,y,e);//Define Yearlytax variable
        double insurance = get.ins(p,t,y,a);//Define Yearlytax variable
        //Compile and run code
        System.out.println(" The properties of the given vehicle " + i + " are" + " " + n + " , " + m + " , " + z + " , " + y + " , " + e + " , " + p + " , " + t + " , " + a);
        System.out.printf("The yearly tax of the %s vehicle is %.2f Turkish Lira,futhermore the Insurance of the vehicle is  %.2f + Turkish Lira.", direct, Yearlytax,insurance);
        
        }
    }
}