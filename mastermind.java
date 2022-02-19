import java.util.Random;
import java.util.Scanner;

public class mastermind {

    static Scanner input = new Scanner(System.in);

    static int secret;
    static int guess;
    static int s1, s2, s3, s4;
    static int g1, g2, g3, g4;

    static int hits = 0;
    static int misses = 0;

    public static void intro(){

        System.out.println("##########################################################\n" +
                "# Let’s play the game of MasterMind.\n" +
                "# I have a four-digit secret number with pairwise distinct\n" +
                "# digits from 1 to 9 and with no appearance of 0.\n" +
                "# Your goal is to guess the secret.\n" +
                "# You have 20 rounds to find out the secret.\n" +
                "# For each valid guess, I will inform you how many hits\n" +
                "# and how many misses you have.\n" +
                "# To terminate, enter a negative number.\n" +
                "# To review your guess history, enter 0.\n" +
                "##########################################################");

    }

    public static int generateSecret(){

        Random random = new Random();

        int temp = random.nextInt(1000, 10000);

        boolean r = validSecret(temp);

        if (!r){
//            System.out.printf("The secret is NOT valid! The secret is %d\n", temp);
        } else {
//            System.out.printf("The secret is Valid! The secret is %d\n", temp);
            return temp;
        }

        return 0;

    }

    public static boolean validSecret(int secret){

        int temp = secret;

        s1 = temp/1000;
        temp %= 1000;

        s2 = temp/100;
        temp %= 100;

        s3 = temp/10;
        temp %= 10;

        s4 = temp;

        int digits[] = {s1, s2, s3, s4};

        int lastNum = digits[digits.length-1];

        if (lastNum == 0){
            return false;
        }

//        System.out.printf("The last element in the array is, %d\n", lastNum);

        for(int i = 0; i < digits.length; i++){

            for (int j = i+1; j < digits.length; j++){

                boolean compare = (digits[i] == digits[j]);
                boolean zero = (digits[i] == 0);

                boolean result = (compare || zero);

//                System.out.printf("%d, check %d. ",digits[i], digits[j]);
//                System.out.printf("Compare is: %b, while zero check is: %b. ",compare, zero);

                if (result){
//                    System.out.printf("%d, check %d is not valid: %b \n",digits[i], digits[j], result);
                    return false;
                } else {
//                    System.out.printf("%d, check %d is: %b \n",digits[i], digits[j], result);
                }
            }

        }

        return true;

    }

    public static int generateGuess(){

        System.out.print("==== Enter your guess (0 for your history): ");
        int temp = input.nextInt();

        boolean r = validGuess(temp);

        if (!r){
//            System.out.printf("The guess is NOT valid! The guess is %d\n", temp);
        } else {
//            System.out.printf("The guess is Valid! The guess is %d\n", temp);
            return temp;
        }

        return 2;

    }

    public static boolean validGuess(int guess){

        if (guess == 0 || guess == -1){
            return true;
        }

        int temp = guess;

        g1 = temp/1000;
        temp %= 1000;

        g2 = temp/100;
        temp %= 100;

        g3 = temp/10;
        temp %= 10;

        g4 = temp;

        int digits[] = {g1, g2, g3, g4};

        int lastNum = digits[digits.length-1];

        if (g1 > 9) {
            return false;
        }

        if (lastNum == 0){
            return false;
        }

//        System.out.printf("The last element in the array is, %d\n", lastNum);

        for(int i = 0; i < digits.length; i++){

            for (int j = i+1; j < digits.length; j++){

                boolean compare = (digits[i] == digits[j]);
                boolean zero = (digits[i] == 0);

                boolean result = (compare || zero);

//                System.out.printf("%d, check %d. ",digits[i], digits[j]);
//                System.out.printf("Compare is: %b, while zero check is: %b. ",compare, zero);

                if (result){
//                    System.out.printf("%d, check %d is not valid: %b \n",digits[i], digits[j], result);
                    return false;
                } else {
//                    System.out.printf("%d, check %d is: %b \n",digits[i], digits[j], result);
                }
            }

        }

        return true;

    }

    public static void compare(){

        int gArr[] = {g1, g2, g3, g4};
        int sArr[] = {s1, s2, s3, s4};

        for (int i = 0; i < sArr.length; i++){

            for (int j = 0; j <sArr.length; j++){

                if (i == j && gArr[i] == sArr[j]){
                    hits += 1;
                } else if ( i != j && gArr[i] == sArr[j]) {
                    misses += 1;
                }
            }
        }

    }

    public static void main(String[] args){

        StringBuilder history = new StringBuilder();

//        history.append(1);
//        history.append(':');
//        history.append(1234);
//        history.append("; ");
//        history.append(1);
//        history.append(" Hit(s)");
//        history.append(", ");
//        history.append(3);
//        history.append(" Miss(es)\n");
//
//        history.append(2);
//        history.append(':');
//        history.append(4587);
//        history.append("; ");
//        history.append(1);
//        history.append(" Hit(s)");
//        history.append(", ");
//        history.append(2);
//        history.append(" Miss(es)\n");

        int advance = 0;

        intro();

        boolean check = true;
        while(check){
            secret = generateSecret();

            if (secret > 0) {

                check = false;

            }

        }

        System.out.printf(".... The secret is %d ....\n", secret);

        for(int i = 1; i<=20; i+= advance) {

            hits = 0;
            misses= 0;

            advance = 1;

            System.out.printf("==== Round %d\n", i);
            guess  = generateGuess();


            if (guess == -1){

                System.out.println("==== Thank you for playing!");
                break;

            } else if( guess == 0){

                advance = 0;

                if (i < 2) {

                    System.out.println("==== The history is currently empty. Continue playing and you'll add stuff here.");

                } else {

                    System.out.println("==== This is your history: \n");
                    System.out.println(history.toString());
                }

            } else if (guess == 2){

                advance = 0;

                System.out.println("==== Enter a valid guess! A valid guess doesn't repeat any digits or have a zero.");

            }else {

                compare();

                if (hits == 4){

                    System.out.println("==== Congratulations! You’ve found it.");
                    break;

                }

                System.out.printf("%d:%d; %d Hit(s), %d Miss(es)\n", i, guess, hits, misses);

                history.append(i);
                history.append(':');
                history.append(guess);
                history.append("; ");
                history.append(hits);
                history.append(" Hit(s)");
                history.append(", ");
                history.append(misses);
                history.append(" Miss(es)\n");

                if (i == 20){

                    System.out.println("You unfortunately didn't get it. Better luck next time!");
                }

            }
        }

//        intro();

//        int guess = generateSecret();

//        System.out.printf("%d separated is: %d, %d, %d, %d \n", guess, g1, g2, g3, g4);

//        compare();
//
//        System.out.printf("Hits: %d and misses = %d", hits, misses);

//        System.out.println(history.toString());


    }
}
