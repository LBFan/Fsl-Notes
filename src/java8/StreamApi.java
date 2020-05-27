package java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2019/12/02.
 */

public class StreamApi {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(new Student[] {
                new Student("zhangsan", "1", 91d),
                new Student("lisi", "2", 89d),
                new Student("wangwu", "1", 50d),
                new Student("zhaoliu", "2", 78d),
                new Student("sunqi", "1", 59d)});

        List<String> above90Names = students.stream().filter(t -> t.getScore() > 90)
                .peek(System.out::println).map(Student::getName).collect(Collectors.toList());


        String result = Stream.of("abc","􏴚􏴛老马","hello") .collect(Collectors.joining(",", "[", "]"));
        System.out.println(result);

        Map<String, List<Student>> groups = students.stream().collect(Collectors.groupingBy(Student::getGrade));
        Map<String, Long> gradeCountMap = students.stream().collect(Collectors.groupingBy(Student::getGrade, counting()));
        System.out.println(above90Names.toString());
    }


}

