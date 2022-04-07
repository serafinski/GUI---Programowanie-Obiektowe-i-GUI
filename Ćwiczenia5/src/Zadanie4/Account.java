package Zadanie4;

public class Account {
    private long balance;

    //klasycznie konstruktor
    public Account(long balance) {
        this.balance = balance;
    }

    //getter
    public long getBalance() {
        return balance;
    }

    //setter
    public void setBalance(long balance) {
        this.balance = balance;
    }
}
