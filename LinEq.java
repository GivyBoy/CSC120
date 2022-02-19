import java.util.Scanner;

public class LinEq {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.println("This program solves a system of linear equations: ");
        System.out.println("ax + by = p, cx + dy = q");

        System.out.print("Enter a, b, and p: ");
        double a = input.nextInt();
        double b = input.nextInt();
        double p = input.nextInt();

        System.out.print("Enter c, d, and q: ");
        double c = input.nextInt();
        double d = input.nextInt();
        double q = input.nextInt();

        double det = a*d - b*c;

        double x = (d*p - b*q)/det;
        double y = (a*q - c*p)/det;


        System.out.println("The solution is x = " + x + ", y = " + y);

    }
}
