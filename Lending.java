public class Lending {
    protected  String id;
    protected  String client;
    protected  String loancode;
    protected  int loanamount;
    protected  int loanterms;
    protected  int Interest;
    protected  int payment;
    protected  int balance;

    public Lending(String id,String client, String loancode, int loanamount, int loanterms, int payment, int Interest, int balance){
        this.id = id;
        this.client = client;
        this.loancode = loancode;
        this.loanamount = loanamount;
        this.loanterms = loanterms;
        this.Interest = Interest;
        this.payment = payment;
        this.balance = balance;
    }

    public Lending(String string, String string2, int int1, double double1, double d, int int2, int int3) {
    }

}