import university.*;

import java.util.ArrayList;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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

        try {
            // Get the private answerQuestion method of the Student class
            Method method = Student.class.getDeclaredMethod("answerQuestion", Question.class);

            // Make the method accessible
            method.setAccessible(true);

            // Call the method on the student object with a new Question object
            int answer = (int) method.invoke(student, new Question("What is 2+2", 4));

            System.out.println("Answer: " + answer);

        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}