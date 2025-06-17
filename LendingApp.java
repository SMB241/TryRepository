import java.sql.*;
import java.util.List;
import java.util.Scanner;


public class LendingApp {
    static String url = "jdbc:mysql://localhost:3306/javadatabase";
    static String dbUser = "root";
    static String dbPassword = "";

    public static void main(String[] args) throws SQLException {
        try(Connection conn =DriverManager.getConnection(url,dbUser, dbPassword);
        Scanner scanner = new Scanner(System.in)) {
            LendingDatabase db = new LendingDatabase(conn);
            
            while(true){
                System.out.println("LENDING TRANSACTION");
                System.out.println("------------------------------");
                System.out.println("1. Loan Transaction");
                System.out.println("2. Payment");
                System.out.println("3. Display");
                System.out.println("4. Exit");
                System.out.println();
                System.out.print("Choose an option: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Enter Loan Code: ");
                        String loancode = scanner.nextLine();

                        System.out.print("Enter Client Name: ");
                        String client = scanner.nextLine();

                        System.out.print("Enter Loan amount: ");
                        int loanamount = Integer.parseInt(scanner.nextLine());
                        double loaninterest = 0;
                        int realInterest = 0;
                        if (loanamount <= 5000) {
                            loaninterest = .03;
                            realInterest = 3;
                        } else if (loanamount <= 10000) {
                            loaninterest = .05;
                            realInterest = 5;
                        } else if (loanamount <= 15000) {
                            loaninterest = .07;
                            realInterest = 7;
                        } else if (loanamount > 5000) {
                            loaninterest = .10;
                            realInterest = 10;
                        }

                        System.out.print("Enter Terms of payment: ");
                        int loanterms = Integer.parseInt(scanner.nextLine());

                        boolean added = db.addLoan(loancode, client, loanamount, loanterms, realInterest);

                        if(added){
                            List<Lending> clients = db.printLoans();
                            System.out.println();
                            break;
                        } else {
                            System.out.println("Cannot add, loan already exists!");
                            break;
                        }
                        
                    case 2:
                        System.out.println();
                        System.out.print("Enter Loan Code: ");
                        System.out.println();


                    case 3: 
                        
                    break;
                    }
                }
            }
        }
    }

