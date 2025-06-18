package after0602.q0618;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeMain {

    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String format = now.format(formatter);
        System.out.println(format);

        LocalDateTime localDateTime = now.plusHours(4);
        System.out.println("localDateTime = " + localDateTime);

        DayOfWeek dayOfWeek = now.getDayOfWeek();
        System.out.println(dayOfWeek);



    }
}
