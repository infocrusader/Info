import java.util.*;
public class First { // Class Begins
    public static void main(String[] args) { //Method begins
    System.out.println("Welcome to the seat reservation system"); //
        char[][] seats = new char [8][6];// Row and Column values
        ArrayList<String> reservedSeats = new ArrayList<>();
        // Below is the loop for arrangement and conformation of table array
        for (int i=0;i<8;i++){
            seats[i][0] = 'A';
            seats[i][1] = 'B';
            seats[i][2] = 'C';
            seats[i][3] = 'D';
            seats[i][4] = 'E';
            seats[i][5] = 'F';
    }
    Scanner console = new Scanner(System.in);// Introducing scanner to method
    int filled = 0;
    printSeats(seats);
    System.out.println("Enter seat (e.g. 1A) or zero to quit the program.");//Request data from user
    String input = console.nextLine();//Scans
    while ((filled <48) &&(input.length() >0)) {// While loop for Row and Column credentials
            int row = input.charAt(0) - '1';
            int col = input.charAt(1) - 'A';
            if (row<0 || row>8 || col<0 || col>6) {//Cond for error message
                System.out.println("Input error. Enter seat to assign (e.g., '1A'), " + 
                    "or zero to quit."); 
                input = console.nextLine(); 
                //Below is loop for marking the selected seat
            } else {
                if (seats[row][col] != 'X') {
                    seats[row][col] = 'X';
                    filled++;
                    System.out.println();
                printSeats(seats);
            }
 
            if (filled < 48) { 
                System.out.println("Enter seat to assign (e.g., '1A'), " + 
                    "or zero to quit:"); 
                input = console.nextLine(); //This will run when all seats are not yet filled
            } 
        }
    }
        System.out.println("Final seat assignments: "); 
        printSeats(seats); 
    }
    private static void printSeats(char[][] seats) {
        for (int i = 0; i < seats.length; i++) { 
            System.out.println((i + 1) + "   " + 
                seats[i][0] + seats[i][1] + seats[i][2] + " " +
                seats[i][3] + seats[i][4] + seats[i][5]); //Counting no of seats left
            }
            
        }
    } //Method ends