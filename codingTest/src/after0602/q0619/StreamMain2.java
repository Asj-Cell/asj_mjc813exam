package after0602.q0619;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMain2 {

    public static void main(String[] args) {
        List<Student> tempStudents = List.of(
                new Student("name0", 80, 20),
                new Student("name1", 90, 19),
                new Student("name2", 70, 33),
                new Student("name3", 99, 24),
                new Student("name4", 60, 15),
                new Student("name5", 20, 60)
        );

        List<Student> students = new ArrayList<>(tempStudents);
        Double result1 = students.stream()
                .filter(student -> student.getAge() > 15)
                .map(Student::getScore)
                .collect(Collectors.averagingInt(n -> n));
        System.out.println(result1);


        double result2 = students.stream()
                .filter(student -> student.getAge() > 15)
                .mapToInt(Student::getScore)
                .average()
                .orElse(0.0);
        System.out.println(result2);
        Optional<Integer> i1 = Optional.of(1);
        Optional<Integer> empty = Optional.empty();
        Optional<Integer> i2 = Optional.ofNullable(10);
        System.out.println();

        Integer iii = i2.orElse(5);

        Optional<Integer> run = run();
        System.out.println(run);

        IntStream range = IntStream.rangeClosed(1, 5);
        OptionalDouble average = range.average();
        System.out.println("average = " + average);

        List<Student> collect = students.stream()
                .collect(Collectors.toList());

//        students.stream()
//                .collect();

        String str = " ";
        str.startsWith(")");
        str.endsWith("(");

    }
    public static Optional<Integer> run() {
        return Optional.ofNullable(null);
    }
}
