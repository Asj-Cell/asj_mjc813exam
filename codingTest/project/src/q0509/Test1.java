package q0509;

import java.util.Scanner;

public class Test1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int deposit = 0;

        while (true) {
            System.out.println("====================================");
            System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
            System.out.println("====================================");

            System.out.print("선택> ");
            int selectNum = scanner.nextInt();

            switch (selectNum) {
                case 1:
                    System.out.print("예금액> ");
                    deposit = scanner.nextInt();
                    break;
                case 2:
                    System.out.print("출금액>");
                    int withdraw = scanner.nextInt();
                    if (deposit - withdraw < 0) {
                        System.out.println("잔액이 부족합니다. 현재 잔액: " + deposit);
                    }
                    deposit = deposit - withdraw;
                    break;
                case 3:
                    System.out.println("잔고> " + deposit);
                    break;
                case 4:
                    System.out.println("프로그램을 종료합니다.");
                    break;
                default:
                    System.out.println("1~4 사이에 숫자를 입력해주세요.");
            }
            if (selectNum == 4) {
                break;
            }

        }
    }
}
