import java.util.Scanner;
public class P1 {
    public static void main(String [] args) {
        Scanner sn = new Scanner(System.in);
        int s;
        System.out.println("How many grade entries are you going to do?");
        s = sn.nextInt();
        do {

         Scanner sc = new Scanner(System.in);
         Deneme method1 = new Deneme();
         Deneme method2 = new Deneme();
         Deneme method3 = new Deneme();
         String name;
         double Midterm;
         double Project1;
         double Project2;
         double Final;
         double []myArray = new double [4];

         System.out.println("What is the name of the student?");
         name = sc.nextLine();
         System.out.printf("What is the score of Midterm for %s? ", name);
         Midterm = sc.nextDouble();
         System.out.printf("What is the score of Project1 for %s? ", name);
         Project1 = sc.nextDouble();
         System.out.printf("What is the score of Project2 for %s? ", name);
         Project2 = sc.nextDouble();
         System.out.printf("What is the score of Final for %s? ", name);
         Final = sc.nextDouble();

         myArray = method1.Met1(name, Midterm, Project1, Project2, Final);
         double average = method2.Met2(myArray);
         method3.Met3(name, average);

         s=s-1;
        } while (s>0);






















    }

}