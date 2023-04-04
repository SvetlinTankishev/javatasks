package university;

import java.util.List;

public class Exam {
    private String name;
    private List<Question> questions;
    private int time;

    public Exam(String name, List<Question> questions, int time) {
        this.name = name;
        this.questions = questions;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public int getTime() {
        return time;
    }
}
