package laoma;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2020/02/21.
 */

public class Student {
    private String name;
    private double score;
    private String grade;

    public Student(String name, String grade, double score) {
        this.name = name;
        this.score = score;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    static List<Student> students = Arrays.asList(
            new Student("zhangsan", "1", 91d),
            new Student("lisi", "2", 89d),
            new Student("wangwu", "1", 50d),
            new Student("zhaoliu", "2", 78d),
            new Student("sunqi", "1", 59d));

    public static void main(String[] args) {
//        students.stream()
        Instant now = Instant.now();
        System.out.println(now);
    }

}

