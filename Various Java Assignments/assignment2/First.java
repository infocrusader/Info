import java.util.Scanner;//Allows for the use of scanner without loss of generality
public class First{//Class begins


    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);//Introduces Scanner into class for use on number of entries
        int s;//declaring nature of variable needed
        System.out.println("How many grade entries are you going to do?");
        s = sn.nextInt();//Takes input from user
        do {//This allows for succession from former line of code under fulfilled conds
        Scanner im = new Scanner(System.in);//Introduces scanner into class for use on grade entries
        //Below i am declaring my variables and introducing my primary array
        String name;
        First process1 = new First();
        First process2 = new First();
        First process3 = new First();
        double []ScoreArray = new double [4];
        double Midterm;
        double Project1;
        double Project2;
        double Final;
//The lines of code below will request grade inputs from user,and the scanner will allow for it
        System.out.println("What is the name of student?");
        name = im.nextLine();
        System.out.printf("What is the midterm grade for %s?", name);
        Midterm = im.nextDouble();
        System.out.printf("What is the Project1 grade for %s?", name);
        Project1 = im.nextDouble();
        System.out.printf("What is the Project2 grade for %s?", name);
        Project2 = im.nextDouble();
        System.out.printf("What is the Final grade for %s?", name);
        Final = im.nextDouble();

        ScoreArray = process1.P1(name, Midterm, Project1, Project2, Final);
        double average = process2.P2(ScoreArray);
        process3.P3(name, average);//Here i am defining my score array,my process1.P1,processp2.P2,process3.P3
    
       s = s-1;
        } while (s > 0); }
        public static double[] P1(String name, double e, double f, double g, double h) {
        double []list = {e,f,g,h};
        return list;//Here i am stating the nature of the four variables in P1 and telling it to return result for next line of code
    }
    
    public static double P2(double list[]) {
        return ((list[0] * 0.3) + (list[1] * 0.15) + (list[2] * 0.15) + (list[3] * 0.4));//Here i am taking the respect values from the P1(using dimensions) array and multiplying by the grade weight
    }
    //Below P3 code will simply take the values calculated by the P2 method in the preceding lines of code and the if function moves it through the various grade ranges,after which it will find and print the grade
    public static void P3(String name, double average) {
        if (average < 50) {
            System.out.printf("%s is entitled to get F", name);
        }
        if ((average < 65) && (average >= 50)) {
            System.out.printf("%s is entitled to get D", name);
        }
        if  ((average < 75) && (average >= 65)) {
            System.out.printf("%s is entitled to get C", name);
        }
        if ((average < 85) && (average >= 75)) {
            System.out.printf("%s is entitled to get B", name);
        }
        if (average >= 85) {
            System.out.printf("%s is entitled to get A", name);
        }
    }//Method ends
}                            


        
        



