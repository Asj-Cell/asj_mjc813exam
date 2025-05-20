package q0519;

public class BankApplication {

    Account_20[] accountList = new Account_20[100];
    private int count = 0;

    public void addAccount(String accountNumber, String accountName, int balance) {
        accountList[count] = new Account_20(accountNumber, accountName, balance);
        count++;
    }


    public int getCount() {
        return count;
    }

    public void toList() {
        for (int i = 0; i < count; i++) {
            System.out.println(accountList[i].getAccountNumber() + "  " + accountList[i].getAccountName() + "  " + accountList[i].getBalance());

        }
    }


public void addBalance(String accountNumber, int balance) {
    for (int i = 0; i < count; i++) {
        if (accountList[i].getAccountNumber().equals(accountNumber)) {
            accountList[i].addBalance(balance);
        }
    }

}

public void subBalance(String accountNumber, int balance) {
    for (int i = 0; i < count; i++) {
        if (accountList[i].getAccountNumber().equals(accountNumber)) {
            accountList[i].subBalance(balance);
            System.out.println("출금이 성공 되었습니다.");
        }
    }

}
}

