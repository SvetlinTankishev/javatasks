package university;

import java.util.List;
import java.util.Random;

public class Student {
    private String name;
    private int age;
    private String academicMajor;
    private List<String> academicSubjects;

    public Student(String name, int age, String academicMajor, List<String> academicSubjects) {
        this.name = name;
        this.age = age;
        this.academicMajor = academicMajor;
        this.academicSubjects = academicSubjects;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAcademicMajor() {
        return academicMajor;
    }

    public List<String> getAcademicSubjects() {
        return academicSubjects;
    }

    public int answerQuestion(Question question) {
        Random rand = new Random();
        int answer = rand.nextInt(5) + 1;
        return answer;
    }
}
