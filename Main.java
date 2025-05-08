import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        DeliveryService[] deliveries = new DeliveryService[3];

        for (int i = 0; i <deliveries.length; i++){
            System.out.print("\nEnter details for delivery #:" + (i +1));
            System.out.print("Enter distance (km): ");
            double distance = scanner.nextDouble();

            System.out.print("Enter weight: ");
            double weight = scanner.nextDouble();

            System.out.print("Choose ride type (1 -  Standard Delivery | 2 Express Delivery): ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                deliveries[i] = new StandardDelivery(distance, weight);
            }else if (choice == 2) {
                deliveries[i] = new ExpressDelivery(distance, weight);
            }else {
                System.out.println("Invalid choice. Defaulting to standard.");
                deliveries[i] = new StandardDelivery(distance, weight);
            }

            System.out.println("--- Delivery Summary ---");
            for(DeliveryService delivery : deliveries){
                System.out.println("Service Type: " + delivery.getServiceType());
                delivery.printBasicInfo();
                double cost = delivery.totalCost();
                System.out.println("Total cost: " + cost);
            }
        }
    }
}
