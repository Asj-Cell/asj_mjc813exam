package q0519;

import java.util.Scanner;

public class BankApplicationMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankApplication bankApplication = new BankApplication();

        while (true) {
            System.out.println("=======================================================");
            System.out.println("1. 계좌 생성 | 2. 계좌목록 | 3. 예금 | 4. 출금 | 5. 종료");
            System.out.print("선택> ");
            int selectNum = scanner.nextInt();

            scanner.nextLine();

            if (selectNum == 1) {
                createAccount(scanner, bankApplication);
            } else if (selectNum == 2) {
                accountList(bankApplication);
            } else if (selectNum == 3) {
                deposit(scanner, bankApplication);
            } else if (selectNum == 4) {
                withdraw(scanner, bankApplication);
            } else if (selectNum == 5) {
                System.out.println("프로그램 종료");
                break;
            }

        }


    }

    private static void createAccount(Scanner scanner, BankApplication bankApplication) {
        System.out.println("============");
        System.out.println("계좌 생성");
        System.out.println("============");

        System.out.print("계좌 번호: ");
        String accountNumber = scanner.nextLine();

        System.out.print("계좌주: ");
        String accountName = scanner.nextLine();

        System.out.print("초기입금액: ");
        int balance = scanner.nextInt();
        scanner.nextLine();

        if (bankApplication.getCount() < 100) {
            bankApplication.addAccount(accountNumber, accountName, balance);
            System.out.println("결과: 계좌가 생성되었습니다.");
        } else {
            System.out.println("결과: 더 이상 계좌를 생성 할 수 없습니다.");
        }
    }

    private static void accountList(BankApplication bankApplication) {
        System.out.println("============");
        System.out.println("계좌 목록");
        System.out.println("============");
        bankApplication.toList();
    }

    private static void deposit(Scanner scanner, BankApplication bankApplication) {
        System.out.println("============");
        System.out.println("예금");
        System.out.println("============");

        System.out.print("계좌 번호: ");
        String accountNumber = scanner.nextLine();

        System.out.print("예금액: ");
        int balance = scanner.nextInt();
        scanner.nextLine();
        bankApplication.addBalance(accountNumber, balance);
    }

    private static void withdraw(Scanner scanner, BankApplication bankApplication) {
        System.out.println("============");
        System.out.println("출금");
        System.out.println("============");

        System.out.print("계좌 번호: ");
        String accountNumber = scanner.nextLine();

        System.out.print("출금액: ");
        int balance = scanner.nextInt();
        scanner.nextLine();
        bankApplication.subBalance(accountNumber, balance);
    }
}

