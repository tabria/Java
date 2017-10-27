package define_bank_account;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, BankAccount> accounts = new HashMap<>();

        while(true){
            String[] commands = reader.readLine().split("\\s+");
            String action = commands[0];
            if ("End".equals(action)){
                break;
            }
            switch(action){
                case "Create":
                    createBankAccount(accounts);
                    break;
                case "Deposit":
                    accountDeposit(Integer.valueOf(commands[1]), accounts, Double.valueOf(commands[2]));
                    break;
                case "SetInterest":
                    setAccountInterest(Double.valueOf(commands[1]));
                    break;
                case "GetInterest":
                    getAccountInterest(Integer.valueOf(commands[1]), accounts, Integer.valueOf(commands[2]));
                    break;
//                case "Withdraw":
//                    accountWithdraw(id, accounts, Double.valueOf(commands[2]));
//                    break;
//                case "Print":
//                    printStatus(id, accounts);
//                    break;
            }
        }
    }

    private static void setAccountInterest(double newRate) {
            BankAccount.setInterestRate(newRate);
    }

    private static void getAccountInterest(int id, Map<Integer, BankAccount> accounts, int years) {
        if (accounts.containsKey(id)){
            BankAccount currentAccount = accounts.get(id);
            System.out.printf("%.2f%n", currentAccount.getInterestRate(years));
        } else {
            System.out.println("Account does not exist");
        }
    }


    private static void  accountDeposit(int id, Map<Integer, BankAccount> accounts, double amount) {
        if (accounts.containsKey(id)){
            BankAccount currentAccount = accounts.get(id);
            currentAccount.deposit(amount);
            accounts.put(id, currentAccount);
            System.out.printf("Deposited %.0f to %s%n", amount, currentAccount);
        } else {
            System.out.println("Account does not exist");
        }
    }

    private static void createBankAccount(Map<Integer, BankAccount> accounts) {
            BankAccount bankAcc = new BankAccount();
            accounts.put(bankAcc.getId(), bankAcc);
            System.out.printf("Account %s created%n", bankAcc);

    }
//    private static void printStatus(int id, Map<Integer, BankAccount> accounts) {
//        if (accounts.containsKey(id)){
//            BankAccount currentAccount = accounts.get(id);
//            System.out.printf("Account %s, balance %.2f%n", currentAccount, currentAccount.getBalance());
//        } else {
//            System.out.println("Account does not exist");
//        }
//    }

//    private static void accountWithdraw(int id, Map<Integer, BankAccount> accounts, Double amount) {
//        if (accounts.containsKey(id)){
//            BankAccount currentAccount = accounts.get(id);
//            double a = currentAccount.getBalance();
//            if (currentAccount.getBalance() - amount >= 0){
//                currentAccount.withdraw(amount);
//                accounts.put(id, currentAccount);
//            } else {
//                System.out.println("Insufficient balance");
//            }
//        } else {
//            System.out.println("Account does not exist");
//        }
//    }

}



