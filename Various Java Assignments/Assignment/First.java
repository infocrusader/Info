import java.util.Scanner; 
public class First {
    public static double weightposs(String unit, double value) {
        if (unit.equals("metric")) {
            return value * 2.20462;
        }
        else {
            return value * 0.453592;
        }
    }
    public static double heightposs(String unit, double value) {
        if (unit.equals("metric")) {
            return value * 39.3701;
        }
        else {
            return value * 0.0254;
        }
    }
    public static void main(String [] args) {
        Scanner im = new Scanner(System.in);
        First met1 = new First();
        First met2 = new First();

        String first;
        String second;
        Double third;
        System.out.println("Do you want to convert weight or height?");
        first = im.nextLine();

        System.out.println("metric unit or imperial unit?");
        second = im.nextLine();

        if (first.equals("weight") && (second.equals("metric"))) {
            System.out.println("Please enter the weight value in kilograms.");
        }
        if (first.equals("weight") && (second.equals("imperial"))) {
            System.out.println("Please enter the weight value in pounds.");
        }
        if (first.equals("height") && (second.equals("metric"))) {
            System.out.println("Please enter the height value in meters.");
        }
        if (first.equals("height") && (second.equals("imperial"))) {
            System.out.println("Please enter the height value in inches.");
        }

        third = im.nextDouble();

        if (first.equals("weight") && second.equals("metric")) {
            System.out.printf("Your weight in kilograms %.2f is equal to %.2f in pounds", third, met1.weightposs(second, third)); 
        }
        if (first.equals("weight") && second.equals("imperial")) {
            System.out.printf("Your weight in pounds %.2f is equal to %.2f in kilograms", third, met1.weightposs(second, third)); 
        }
        if (first.equals("height") && second.equals("metric")) {
            System.out.printf("Your height in meters %.2f is equal to %.2f in inches", third, met2.heightposs(second, third)); 
        }
        if (first.equals("height") && second.equals("imperial")) {
            System.out.printf("Your height in inches %.2f is equal to %.2f in meters", third, met2.heightposs(second, third)); 
        }
    }
}