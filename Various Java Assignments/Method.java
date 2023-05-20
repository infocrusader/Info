public class Method { //Our first method for Part2

    public double metod(double limit, double speed) { //declaring speed limit and speed as double and to create number as double
        if (((((speed - limit) * 100) / speed) > 10) && ((((speed - limit) * 100) / speed) <= 20)) { 
            return (100 + ((speed - limit) * 1.25)); //if the given condition is true, return the given calculation as answer
        }
        if (((((speed - limit) * 100) / speed) > 20) && ((((speed - limit) * 100) / speed) <= 40)) {
            return (200 + ((speed - limit) * 2.50)); //if the given condition is true, return the given calculation as answer
        }
        else { //if two of the conditions at the top are false, return the given calculation
            return (300 + ((speed - limit) * 5.00));
        }
    } //End method
    
} //End class