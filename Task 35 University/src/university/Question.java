package university;

public class Question {
    private String question;
    private int correctAnswer;

    public Question(String question, int correctAnswer) {
        this.question = question;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}