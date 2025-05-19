package q0519;

public class Account_19 {

    private int money;
    private String accountNumber;
    private String accountName;

    private static final int MIN_BALANCE=0;
    private static final int MAX_BALANCE = 1000_000;

    public Account_19(String accountNumber, String accountName) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        if (MIN_BALANCE < money && money < MAX_BALANCE) {
            this.money = money;
        }
    }

    public void addMoney(int plusMoney) {
        if (MIN_BALANCE < plusMoney && plusMoney < MAX_BALANCE) {
            this.money = this.money+plusMoney;
        }
    }

    public void subMoney(int minusMoney) {
        if (this.money - minusMoney >= 0) {
            this.money = this.money - minusMoney;
        }
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
