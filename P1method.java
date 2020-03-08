public class P1method {
    
    public static double[] Met1(String name, double a, double b, double c, double d) {
        double []ar = {a,b,c,d};
        return ar;
    }

    public static double Met2(double ar[]) {
        return ((ar[0] * 0.3) + (ar[1] * 0.15) + (ar[2] * 0.15) + (ar[3] * 0.4));
    }

    public static void Met3(String name, double average) {
        if (average>=85) {
            System.out.printf("%s is entitled to get A. ", name);
        }
        if ((average<85) && (average>=75)) {
            System.out.printf("%s is entitled to get B. ", name);
        }
        if ((average<75) && (average>=65)) {
            System.out.printf("%s is entitled to get C. ", name);
        }
        if ((average<65) && (average>=50)) {
            System.out.printf("%s is entitled to get D. ", name);
        }
        if (average<50) {
            System.out.printf("%s is entitled to get F. ", name);
        }
        

    }














}