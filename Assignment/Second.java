import java.util.Scanner; //Here we are importing the java scanner

public class Second {

public static void main(String [] args){

    Scanner tp = new Scanner(System.in); //here we are defining the scanner as tp
    Method mtd = new Method(); //here we are defining the method as mtd
    Method2 mtd2 = new Method2(); //here we are defining the second method as mtd2

    int limit; //here we are stating that the limit number be an integer
    int speed; //here we are stating that the speed also be an integer

    System.out.println("What is the speed limit?"); //This is the first question the program will ask user
    limit = tp.nextInt(); //This line of code allows for input from the user

    System.out.println("What is the speed?"); //This is the second question the program will ask user
    speed = tp.nextInt(); //This line of code allows for input from the user

    //Next i will write the code for the sentence statements with the help of the methods

    if (limit >= speed) {
        System.out.println("Thanks for following the rules."); //When the users speed is greater than or equal to the speed limit,this code wiull be printed
    }
    if ((limit < speed) && ((((speed - limit) * 100) / speed) <= 10)) {
        System.out.println("Please, pay attention to the rules"); //when the user's speed is lower than speed limit and it's exceed amount is lower or equal than 10%, it will run the former code
    } 
    if ((((speed - limit) * 100) / speed) > 10) {
        System.out.printf("You need to pay %.2f. \n", mtd.Method(limit, speed)); //when the exceeded amount of the user speed is higher than 10%, use 2 digit method and look for the following condition
        if ((((speed - limit) * 100) / speed) >= 10) {
        System.out.println("Your driver license is being taken away for " + mtd2.Method2(limit, speed) + " months." ); //When the exceeded amount of the user speed is greater than or equal to 10%, use method to print the given sentence after which you will make the number for 2 digits then look for the following condition
        }
        if ((((speed - limit) * 100) / speed) >= 45) {
            System.out.println("You will spend " + ((((speed - limit) * 100) / speed) / 45) + " years in prison without cash bail."); //When the exceeded amount of the user speed is greater than or equal to 45%, print the given line then make necessary calculations
        }
    }

    


} //MAIN METHOD ENDS
} // CLASS ENDS