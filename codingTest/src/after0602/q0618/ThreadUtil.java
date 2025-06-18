package after0602.q0618;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ThreadUtil {

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

    public static void log(Object o) {

        LocalTime now = LocalTime.now();
        String format = now.format(formatter);
        System.out.printf("%s [%9s] %s\n",format,Thread.currentThread().getName(),o);


    }
}

