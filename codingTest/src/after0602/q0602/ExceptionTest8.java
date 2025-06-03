package after0602.q0602;

import java.io.IOException;

public class ExceptionTest8 {

    public static void main(String[] args) {

        try(FileWriter fw=new FileWriter("file.txt")){
            fw.write("Java");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
