package define_bank_account;

public class BankAccount {

    private static double interestRate = 0.02;
    private static int bankAccountCount=0;

    private int id;
    private double balance = 0.0;


    public BankAccount() {
        this.id = ++bankAccountCount;
    }

    public static void setInterestRate(double interest){
        interestRate = interest;
    }

    public double getInterestRate(int years){
        return this.getBalance()*interestRate * years;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public double getBalance() {
        return this.balance;
    }

    public  void deposit(double amount){
        if(amount>0){
            this.balance += amount;
        }
    }

//    public void withdraw(double amount){
//        if (getBalance() - amount >= 0){
//            this.balance -= amount;
//        }
//    }

    @Override
    public String toString() {
        return "ID" + this.id;
    }
}
