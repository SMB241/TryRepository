package loginObjectOriented;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DatabaseManager dbManager = new DatabaseManager();
        LoginManager loginManager = new LoginManager(dbManager);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n --- MENU---");
            System.out.println("1. Adduser Credential");
            System.out.println("2. Test Login");
            System.out.println("3. Search and edit login");
            System.out.println("4. Delete user");
            System.out.println("5. Exit program");
            System.out.print("Select an option (1-5):");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter new username:");
                    String newUser = scanner.nextLine();
                    System.out.print("Enter new pasword:");
                    String newPass = scanner.nextLine();

                    boolean added =dbManager.addUser(newUser, newPass);
                    if (added) {
                        System.out.println("User successfully added.");
                    }else{
                        System.out.println("Failed to add user.");
                    }
                    break;
            
                case "2":
                    loginManager.startLoginProcess();
                    break;
                    case"3":
                    System.out.print("Enter new username:");
                String username = scanner.nextLine();
                boolean search =dbManager.searchUser(username);
                    if (search) {
                        System.out.print("User found. Enter new password to update:");
                        String pass = scanner.nextLine();
                    dbManager.updateUser(username,pass);
                    System.out.println("Password updated successfully.");
                    }else{
                        System.out.println("user not found.");
                    }
                    break;
                case "4":
                System.out.print("Enter username:");
                String User = scanner.nextLine();
                boolean deleted =dbManager.deleteUser(User);
                    if (deleted) {
                        System.out.println("User successfully deleted.");
                    }else{
                        System.out.println("user not found.");
                    }
                    break;
                case"5":
                System.out.println("Exiting program. Goodbye!");
                scanner.close();
                return;
                default:
                System.out.println("invalid option. Please choose(1-5)");
            }
        }
    }
    
}
