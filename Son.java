import java.util.Scanner; 
public class Son {
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
        Scanner sc = new Scanner(System.in);
        Son met1 = new Son();
        Son met2 = new Son();

        String first;
        String second;
        Double third;
        System.out.println("Are you willing to convert weight or height?");
        first = sc.nextLine();

        System.out.println("Will it be for metric unit or imperial unit?");
        second = sc.nextLine();

        if (first.equals("weight") && (second.equals("metric"))) {
            System.out.println("Please provide the weight information in kgs.");
        }
        if (first.equals("weight") && (second.equals("imperial"))) {
            System.out.println("Please provide the weight information in pounds.");
        }
        if (first.equals("height") && (second.equals("metric"))) {
            System.out.println("Please provide the height information in meters.");
        }
        if (first.equals("height") && (second.equals("imperial"))) {
            System.out.println("Please provide the height information in inches.");
        }

        third = sc.nextDouble();

        if (first.equals("weight") && second.equals("metric")) {
            System.out.printf("Your weight in kgs %.2f is equal to %.2f in pounds.", third, met1.weightposs(second, third)); 
        }
        if (first.equals("weight") && second.equals("imperial")) {
            System.out.printf("Your weight in pounds %.2f is equal to %.2f in kgs.", third, met1.weightposs(second, third)); 
        }
        if (first.equals("height") && second.equals("metric")) {
            System.out.printf("Your height in meters %.2f is equal to %.2f in inches.", third, met2.heightposs(second, third)); 
        }
        if (first.equals("height") && second.equals("imperial")) {
            System.out.printf("Your height in inches %.2f is equal to %.2f in meters.", third, met2.heightposs(second, third)); 
        }
    }
}