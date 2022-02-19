import java.util.Scanner;
import java.lang.Math;

public class BallReach {

    public static final double earth_g = 9.807;
    public static final double moon_g = 1.620;

    public static void message (String m){

        System.out.printf("........ %s ........\n", m);
    }

    public static void compute (double angle_rad, double speed_adj, double height, double gravity){


        double height_adj = Math.max(0,height);
        double vrt_speed = Math.sin(angle_rad) * speed_adj;
        double hor_speed = Math.cos(angle_rad) * speed_adj;

        double t_nought = vrt_speed / gravity;
        double h_nought = 0.5*gravity*(t_nought*t_nought);
        double h_one = h_nought + height_adj;
        double t_one = Math.sqrt(((2*h_one)/gravity));
        double t_two = t_nought+t_one;

        double horTravelDistance = hor_speed*t_two;


        myPrint("Height of the cliff", height_adj, "m");
        myPrint("Horizontal Speed", hor_speed, "m/h");
        myPrint("Initial vertical speed", vrt_speed, "m/h");
        myPrint("Gravity", gravity, "m/s^2");
        myPrint("Upward travel time", t_nought, "s");
        myPrint("Upward travel distance", h_nought, "m");
        myPrint("Downward travel time", t_one, "s");
        myPrint("Upward travel distance", h_one, "m");
        myPrint("Total travel time", t_two, "s");
        myPrint("Total travel distance", horTravelDistance, "m");

    }

    public static void myPrint (String name, double value, String unit) {

        System.out.printf("%25s:%,15.4f %s\n", name, value, unit);
    }


    public static void main (String args[]){

        Scanner input = new Scanner(System.in);

        message ("Distance Calculation");

        System.out.print("Enter angle (degree): ");
        double angle = input.nextDouble();
        System.out.print("Enter speed (m/s): ");
        double speed = input.nextDouble();
        System.out.print("Enter height (m): ");
        double height = input.nextDouble();

        double max = Math.max(1, angle);
        double min = Math.min(max, 89);
        double angle_rad = Math.toRadians(min);
        double speed_adj = Math.max(0,speed);

        message ("On the Earth");
        compute(angle_rad, speed_adj, height, earth_g);

        message ("On the Moon");
        compute(angle_rad, speed_adj, height, moon_g);


    }

}
