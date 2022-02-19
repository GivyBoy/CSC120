import java.util.Scanner;

public class Comparison {

    public static final String ORDER = "%s %.2f\n";

    public static void takeoutMax(double h, String xh, double i, String xi){

        double m;

        if (h > i) {m = h;} else {m = i;};

        if (h == m){
            System.out.printf(ORDER, xh, h);
            System.out.printf(ORDER, xi, i);
        } else {
            System.out.printf(ORDER, xi, i);
            System.out.printf(ORDER, xh, h);
        }

    }

    public static void takeoutMax(double e, String xe, double f, String xf, double g, String xg) {

        double m;

        if (e > f && e > g) {
            m = e;
        }
        else if (f > e && f > g){
            m = f;
        } else {
            m = g;
        }

        if (e == m){
            System.out.printf(ORDER, xe, e);
            takeoutMax(f, xf, g, xg);
        } else if (f == m){
            System.out.printf(ORDER, xf, f);
            takeoutMax(e, xe, g, xg);
        } else {
            System.out.printf(ORDER, xg, g);
            takeoutMax(e, xe, f, xf);
        }

    }

    public static void takeoutMax(double a, String xa, double b, String xb, double c, String xc, double d, String xd) {

        double m;

        if (a > b && a > c && a > d) {
            m = a;
        }
        else if (b > a && b > c && b > d){
            m = b;
        } else if (c > a && c > b && c > d){
            m = c;
        } else {
            m = d;
        }

        if (a == m){
            System.out.printf(ORDER, xa, a);
            takeoutMax(b, xb, c, xc, d, xd);
        } else if (b == m){
            System.out.printf(ORDER, xb, b);
            takeoutMax(a, xa, c, xc, d, xd);
        } else if (c == m){
            System.out.printf(ORDER, xc, c);
            takeoutMax(a, xa, b, xb, d, xd);
        } else {
            System.out.printf(ORDER, xd, d);
            takeoutMax(a, xa, b, xb, c, xc);
        }
    }

    public static void main(String args []){

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the details (Make, mileage, gas) for car 1 here: ");
        String c1_make = input.next();
        double c1_mileage = input.nextDouble();
        double c1_gas = input.nextDouble();

        System.out.print("Enter the details (Make, mileage, gas) for car 2 here: ");
        String c2_make = input.next();
        double c2_mileage = input.nextDouble();
        double c2_gas = input.nextDouble();

        System.out.print("Enter the details (Make, mileage, gas) for car 3 here: ");
        String c3_make = input.next();
        double c3_mileage = input.nextDouble();
        double c3_gas = input.nextDouble();

        System.out.print("Enter the details (Make, mileage, gas) for car 4 here: ");
        String c4_make = input.next();
        double c4_mileage = input.nextDouble();
        double c4_gas = input.nextDouble();

        // mpg calculations

        double c1_mpg = c1_mileage/c1_gas;
        double c2_mpg = c2_mileage/c2_gas;
        double c3_mpg = c3_mileage/c3_gas;
        double c4_mpg = c4_mileage/c4_gas;


        System.out.println();
        System.out.println("MPG");
        takeoutMax(c1_mpg, c1_make, c2_mpg, c2_make, c3_mpg, c3_make, c4_mpg, c4_make);

        System.out.println();
        System.out.println("Mileage");
        takeoutMax(c1_mileage, c1_make, c2_mileage, c2_make, c3_mileage, c3_make, c4_mileage, c4_make);

        System.out.println();
        System.out.println("GAS");
        takeoutMax(c1_gas, c1_make, c2_gas, c2_make, c3_gas, c3_make, c4_gas, c4_make);
    }
}

// Toyota 23300 1005
// Honda 25400 1009
// BMW 35000 3000
// Ford 45000 3530