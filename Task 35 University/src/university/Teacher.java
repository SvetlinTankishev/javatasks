package university;

import java.util.List;
import java.util.Random;

public class Teacher {
    private String name;
    private String academicTitle;
    private List<Exam> exams;

    public Teacher(String name, String academicTitle, List<Exam> exams) {
        this.name = name;
        this.academicTitle = academicTitle;
        this.exams = exams;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public void giveExam(Student student) {
        // Choose a random exam from the list of prepared exams
        Random rand = new Random();
        Exam exam = this.exams.get(rand.nextInt(this.exams.size()));

        // Administer the exam to the student
        for (Question question : exam.getQuestions()) {
            int answer = student.answerQuestion(question);
            if (answer == question.getCorrectAnswer()) {
                System.out.println("Correct answer!");
            } else {
                System.out.println("Wrong answer!");
            }
        }
    }
}
