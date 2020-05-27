package java8;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2019/12/02.
 */

public class Student {
    String name;
    double score;
    String grade;

    public Student(String name,  String grade, double score) {
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
}

