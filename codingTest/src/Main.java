import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.SortedMap;

import static java.lang.System.*;

public class Main {
    public static void main(String[] args) throws Exception {
        String str = "쀍";
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        out.println(Arrays.toString(bytes));

        String result = new String(bytes,StandardCharsets.UTF_16);
        out.println(result);



        Path path = Path.of("./Test.dat");
        if (Files.notExists(path)) {
            Files.createFile(path);
        }

    }
}
