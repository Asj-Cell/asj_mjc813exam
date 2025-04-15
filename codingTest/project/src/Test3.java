import java.util.Scanner;

public class Test3 {

    public static void main(String[] args) {
        String[] list ={"수성","금성","지구","화성","목성","토성","천왕성","해왕성"};
        Scanner input = new Scanner(System.in);
        System.out.print("입력: ");
        int num = input.nextInt();
        input.nextLine();
        String result = list[num-1];
        System.out.println(result);


    }
}
