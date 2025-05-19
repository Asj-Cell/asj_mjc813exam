package q0519;

public class Account_20 {

    private String accountNumber;
    private String accountName;
    private int balance;

    public Account_20(String accountNumber, String accountName, int balance) {
        setAccountNumber(accountNumber);
        setAccountName(accountName);
        setBalance(balance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void addBalance(int balance) {
        if (1000_000 >= balance && balance > 0) {
            this.balance = this.balance + balance;
        }
    }
    public void subBalance(int balance) {
        if (this.balance - balance >= 0) {
            this.balance = this.balance - balance;
        }
    }
}
