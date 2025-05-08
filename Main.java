import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Grab!");
        System.out.print("Enter pickup location: ");
        String pickup = scanner.nextLine();

        System.out.print("Enter drop-off point: ");
        String dropOff = scanner.nextLine();

        System.out.print("Enter Distance in KM: ");
        double distance = scanner.nextDouble();

        System.out.print("Choose ride type (1 -  Grab Car | 2 Grab Bike): ");
        int choice = scanner.nextInt();

        GrabRide ride;
        if(choice == 1){
            ride  = new GrabCar(pickup, dropOff, distance);
        } else {
            ride = new GrabBike(pickup, dropOff, distance);
        }

        System.out.println("--- Booking Summary ---");
        System.out.println("Ride type: " + ride.getRideType());
        ride.showRoute();
        System.out.println("Estimated Arrival: " + ride.estimatedArrivalTime());
        System.out.println("Estimated Fare: " + ride.calculatefare());
    }
}
