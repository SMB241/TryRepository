public abstract class LendingManager {
    private LendingManager dbManager;
    static int Interest;
    static String client;
    static String loancode;
    static int loanamount;
    static int payment;
    static int balance;
    
    

    public LendingManager(LendingManager dbManager){
        this.dbManager = dbManager;
    }

    public String getLoanCode(){
        return loancode;
    }

    public String getClient(){
        return client;
    }

    public int getLoanAmount(){
        return loanamount;
    }

    public int getPayment(){
        return payment;
    }

    public int getInterest(){
        return Interest;
    }

    public int getBalance(){
        return balance;
    }

    public void printInfo(){
        System.out.println("");
    }
    
}