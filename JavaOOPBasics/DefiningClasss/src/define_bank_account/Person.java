package define_bank_account;

import java.util.ArrayList;
import java.util.List;

class Person {

    private String name;
    private int age;
    private List<BankAccount> accounts;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.accounts = new ArrayList<>();
    }

    public Person(String name, int age, List<BankAccount> accounts) {
        this.name = name;
        this.age = age;
        this.accounts = accounts;
    }

    private double getBalance(){
        return this.accounts.stream().mapToDouble(entry ->entry.getBalance()).sum();
    }
}
