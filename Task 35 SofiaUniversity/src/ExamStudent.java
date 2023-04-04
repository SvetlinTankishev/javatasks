import university.*;

import java.util.ArrayList;

public class ExamStudent {
    public static void main(String[] args) {
        Student student = new Student("John", 20, "Computer Science", new ArrayList<>());
        Teacher teacher = new Teacher("Dr. Smith", "Professor", new ArrayList<>());
        Exam exam = new Exam("Math", new ArrayList<Question>(), 60);
        Question question = new Question("What is 2+2", 4);

        student.getAcademicSubjects().add("Math");
        student.getAcademicSubjects().add("Physics");

        exam.getQuestions().add(question);

        teacher.getExams().add(exam);

        teacher.giveExam(student);
    }
}