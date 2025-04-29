package loginObjectOriented;
import java.util.Scanner;


public class LoginManager {
    private DatabaseManager dbManager;
    private static final int MAX_ATTEMPS = 3;

    public LoginManager(DatabaseManager dbManager){
        this.dbManager = dbManager;
    }
    public boolean login(String username,String password){
        return dbManager.authenticatUser(username, password);
    }
    public void startLoginProcess(){
        Scanner scanner = new Scanner(System.in);
    
        int attemptCount = 0;
        while(attemptCount < MAX_ATTEMPS){
            System.out.print("Enter username: ");
            String inputUsername =  scanner.nextLine();

            System.out.print("Enter password: ");
            String inputPassword =  scanner.nextLine();

            if(login(inputUsername, inputPassword)){
                System.out.println("Login successful!");
                return;
            }else{
                attemptCount ++;
                System.out.println("Invalid username or  password.Attemps remaining: "+ (MAX_ATTEMPS -attemptCount)+"\n");
            }
        }
        System.out.println("Terminated. Too many failed attemps.");
      
   
    }
}
