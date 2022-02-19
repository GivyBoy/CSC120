import java.util.Scanner;


public class Bakery {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Chad's Bakery!");
        System.out.println();
        System.out.println("Pastries are each 3.5 dollars");
        System.out.println("Coffees are each 2.5 dollars");
        System.out.println("Sandwiches are each 5 dollars");
        System.out.println("Loaves of breads are each 4 dollars");
        System.out.println();

        double pastries = 3.5, coffees = 2.5, subtotal = 0.0;
        int sandwiches = 5, lOfBread = 4;

        System.out.print("How many pastries do you need? ");
        int numOfPastries = input.nextInt();
        subtotal += (numOfPastries*pastries);
        System.out.println("Your subtotal is " + subtotal + " dollars.");
        System.out.println();

        System.out.print("How many coffees do you need? ");
        int numOfCoffees = input.nextInt();
        subtotal += (numOfCoffees*coffees);
        System.out.println("Your subtotal is " + subtotal + " dollars.");
        System.out.println();

        System.out.print("How many sandwiches do you need? ");
        int numOfSandwiches = input.nextInt();
        subtotal += (numOfSandwiches*sandwiches);
        System.out.println("Your subtotal is " + subtotal + " dollars.");
        System.out.println();

        System.out.print("How many loaves do you need? ");
        int numOfLoaves = input.nextInt();
        subtotal += (numOfLoaves*lOfBread);
        System.out.println("Your subtotal is " + subtotal + " dollars.");
        System.out.println();

        double tax = subtotal*.1;
        System.out.println("Tax is " + tax + " dollars.");
        System.out.println();

        double total = tax + subtotal;
        System.out.println("Total is " + total + " dollars.");
        System.out.println();

        System.out.println("Thank you for coming. See you soon!");

    }
}
