import com.mjc.studyjava.ECpu;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Q0530 {

    public static void main(String[] args) throws IOException {


        ECpu[] values = ECpu.values();
        for (ECpu value : values) {
            System.out.println(value.getClass());
            System.out.println(value.ordinal());
        }
    }
}
