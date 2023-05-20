class Vehicle {//Here we are creating our class
    //Below will define our variable types
    private String brand_name;
    private String model_name;
    private boolean country;
    private int year;
    private double engine;
    private double price;
    private String type;
    private boolean accident;
    //Here we are creating a set method
    public Vehicle(String i, String j, boolean k, int L, double m, double n, String o, boolean p) {
        brand_name = i;
        model_name = j;
        country = k;
        year = L;
        engine = m;
        price = n;
        type = o;
        accident = p;
    }

    //Here we are creating a get method
    public String getbrand_name()                                       {return brand_name;}
    public String getmodel_name()                                       {return model_name;}
    public boolean getcountry()                                         {return country;}
    public int getyear()                                                {return year;}
    public double getengine()                                           {return engine;}
    public double getprice()                                            {return price;}
    public String gettype()                                             {return type;}
    public boolean getaccident()                                        {return accident;}

}
//Below we create a method that calculates annaul tax
public class First {
    public static double tax(boolean x, int y, double z) {
        double a = 10; double b = 20; double c = 30;
        if (x) {a = a * 1.2;}
        else {a = a * 1.5;}
        if (y>2019) {
            b = b * (y - 2019);
        }
        else if (y<=2019) {
            b = b * 1.2;
        } 
        c = c * z;
        return (200 + a + b + c);

    }
    //Below we create a method that calculates insurance
    public static double ins(double x, String y, int z, boolean q) {
        double a=10; double b=20; double c=30; int d;
        a = a * (x / 1000);
        if (y.equals("Common")) {
            b = b * 1.2;
        }
        else if (y.equals("Luxurious")) {
            b = b * 1.5;
        }
        else if (y.equals("Commercial")) {
            b = b * 1.8;
        }

        if (z > 2019) {
            b = b * (z - 2019);
        }
        else if (z <= 2019) {
            b = b * 1.3;
        }
        if (q) { d = 10;
        }
        else { d = 5; 
        }
        
        return (600 + a + b + c + d);
    }
//Below we have created a test class to recall and execute our earlier code
    public static void main(String[] args) {
        First test = new First();
        Vehicle F1 = new Vehicle("HONDA","Q7",true,2005,4,54000,"Common",false);
        Vehicle F2 = new Vehicle("MERC","E350",true,1999,5,60000,"Commercial",true);
        Vehicle F3 = new Vehicle("Rolls-Royce","Phantom",false,2005,8,550000,"Luxury",false);
        double FIR = test.tax(F1.getcountry(),F1.getyear(),F1.getengine());
        double FGR = test.ins(F1.getprice(),F1.gettype(),F1.getyear(),F1.getaccident());
        double FIR2 = test.tax(F2.getcountry(),F2.getyear(),F2.getengine());
        double FGR2= test.ins(F2.getprice(),F2.gettype(),F2.getyear(),F2.getaccident());
        double FIR3 = test.tax(F3.getcountry(),F3.getyear(),F3.getengine());
        double FGR3 = test.ins(F3.getprice(),F3.gettype(),F3.getyear(),F3.getaccident());
        //Compile and run code
        System.out.println("The yearly tax of the following vehicle: " + F1.getbrand_name() + " " + F1.getmodel_name() + " is " + FIR + " Turkish Lira,furthermore the Insurance is " + FGR + " Turkish Lira.");
        System.out.println("The yearly tax of the following vehicle: " + F2.getbrand_name() + " " + F2.getmodel_name() + " is " + FIR2 + " Turkish Lira,futhermore the Insurance is " + FGR2 + " Turkish Lira.");
        System.out.println("The yearly tax of the following vehicle: " + F3.getbrand_name() + " " + F3.getmodel_name() + " is " + FIR3 + " Turkish Lira,furthermore the Insurance is " + FGR3 + " Turkish Lira.");
        
    }
}

