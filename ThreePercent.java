public class ThreePercent extends Lending {

    public ThreePercent(String id, String client, String loancode, int loanamount, int loanterms, int payment, int Interest,
            int balance) {
        super(id, client, loancode, loanamount, loanterms, payment, Interest, balance);
    }

    public int calculateInterest(){
         return balance = balance + (loanamount * (Interest/100));
    }
}

