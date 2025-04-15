import java.util.Scanner;

public class Test4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("입력: ");
        String input = scanner.nextLine();
        String result = new StringBuilder(input).reverse().toString();
        System.out.println("출력: "+result);
    }
}
