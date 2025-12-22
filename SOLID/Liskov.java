package SOLID;

import java.util.ArrayList;
import java.util.List;

interface DipositOnly{
    void deposit(double amount);
}
interface WithdrawOnly extends DipositOnly{
    void withdraw(double amount);
} 

class SavingsAccount implements WithdrawOnly{
    private double balance;
    public SavingsAccount(){
        balance=0;
    }
    @Override
    public void deposit(double amount){
        //logic to diposit amount
        balance += amount;
        System.out.println("deposit amoutn from saving Account "+ amount);
    }
    @Override
    public void withdraw(double amount){
        balance-=amount;
        System.out.println("deposit amoutn from saving Account "+ amount);
    }
}

class CurrentAccount implements WithdrawOnly{
    private double balance;
    public CurrentAccount(){
        balance=0;
    }
    @Override
    public void deposit(double amount){
        //logic to diposit amount
        balance += amount;
        System.out.println("deposit amoutn from CurrentAccount Account "+ amount);
    }
    @Override
    public void withdraw(double amount){
        balance-=amount;
        System.out.println("deposit amoutn from CurrentAccount Account "+ amount);
    }
}

class FixedTermAccount implements DipositOnly{
    private double balance;
    public FixedTermAccount(){
        balance=0;
    }
    @Override
    public void deposit(double amount){
        //logic to diposit amount
        balance += amount;
        System.out.println("deposit amoutn from FixedTermAccount Account "+ amount);
    }
}

class BankClient{
    List<DipositOnly> dipositOnlies=new ArrayList<>(); 
    List<WithdrawOnly> withdrawOnlies=new ArrayList<>(); 

    public BankClient( List<DipositOnly> _dipositOnlies,List<WithdrawOnly> _withdrawOnlies){
        this.dipositOnlies=_dipositOnlies;
        this.withdrawOnlies=_withdrawOnlies;
    }

    public void processTransactions() {
        for (WithdrawOnly acc : withdrawOnlies) {
            acc.deposit(1000);
            acc.withdraw(500);
        }
        for (DipositOnly acc : dipositOnlies) {
            acc.deposit(5000);
        }
    }
}
public class Liskov {
    public static void main(String[] args) {
        List<DipositOnly>dipositOnlies=new ArrayList<>();
        List<WithdrawOnly>withdrawOnlies=new ArrayList<>();

        dipositOnlies.add(new FixedTermAccount());
        withdrawOnlies.add(new CurrentAccount());
        withdrawOnlies.add(new SavingsAccount());

        BankClient client=new BankClient(dipositOnlies, withdrawOnlies);
        client.processTransactions();
    }
}
