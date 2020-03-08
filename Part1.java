class Vehicle {
    private String brand_name;
    private String model_name;
    private boolean country;
    private int year;
    private double engine;
    private double price;
    private String type;
    private boolean accident;
    
    public Vehicle(String a, String b, boolean c, int d, double e, double f, String g, boolean h) {
        brand_name = a;
        model_name = b;
        country = c;
        year = d;
        engine = e;
        price = f;
        type = g;
        accident = h;
    }
    public String getbrand_name() {return brand_name;}
    public String getmodel_name() {return model_name;}
    public boolean getcountry() {return country;}
    public int getyear() {return year;}
    public double getengine() {return engine;}
    public double getprice() {return price;}
    public String gettype() {return type;}
    public boolean getaccident() {return accident;}

}
public class Part1 {
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
    public static double ins(double x, String y, int z, boolean q) {
        double a=10; double b=20; double c=30; int d;
        a = a * (x / 1000);
        if (y.equals("Common")) {
            b = b * 1.2;
        }
        else if (y.equals("Luxury")) {
            b = b * 1.5;
        }
        else if (y.equals("Commercial")) {
            b = b * 1.8;
        }

        if (z>2019) {
            b = b * (z - 2019);
        }
        else if (z<=2019) {
            b = b * 1.3;
        }
        if (q) { d = 10;
        }
        else { d = 5; 
        }
        
        return (600 + a + b + c + d);
    }

    public static void main(String[] args) {
        Part1 take = new Part1();
        Vehicle v1 = new Vehicle("Audi","Q7",true,2005,4,54000,"Common",false);
        Vehicle v2 = new Vehicle("BMW","x5",true,1999,5,60000,"Commercial",true);
        Vehicle v3 = new Vehicle("Bugatti","Veyron",false,2005,8,550000,"Luxury",false);
        double ver = take.tax(v1.getcountry(),v1.getyear(),v1.getengine());
        double sig = take.ins(v1.getprice(),v1.gettype(),v1.getyear(),v1.getaccident());
        double ver2 = take.tax(v2.getcountry(),v2.getyear(),v2.getengine());
        double sig2= take.ins(v2.getprice(),v2.gettype(),v2.getyear(),v2.getaccident());
        double ver3 = take.tax(v3.getcountry(),v3.getyear(),v3.getengine());
        double sig3 = take.ins(v3.getprice(),v3.gettype(),v3.getyear(),v3.getaccident());
        
        System.out.println("Annual tax of the vehicle " + v1.getbrand_name() + " " + v1.getmodel_name() + " is " + ver + " TL, Insurance is " + sig + " TL.");
        System.out.println("Annual tax of the vehicle " + v2.getbrand_name() + " " + v2.getmodel_name() + " is " + ver2 + " TL, Insurance is " + sig2 + " TL.");
        System.out.println("Annual tax of the vehicle " + v3.getbrand_name() + " " + v3.getmodel_name() + " is " + ver3 + " TL, Insurance is " + sig3 + " TL.");
        
    }
}