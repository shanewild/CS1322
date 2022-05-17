import java.util.ArrayList;
import java.util.Scanner;
class Question{
    private String text;
    private String answer;
    private int difficulty;
//    private int questionno;
//    private static int nextquestionno=0;
Question(String text, String answer, int difficulty){
    this.text=text;
    this.answer=answer;
    this.difficulty=difficulty;
//    questionno=nextquestionno;
}

    public String getText() {
        return text;
    }

    public String getAnswer() {
        return answer;
    }
}
class Quiz{
    Scanner scan= new Scanner(System.in);
    ArrayList<Question> myQuiz= new ArrayList<Question>(5);
    public void add_question(){
        String text, answer;
        int difficulty;
        System.out.println("What is the question Text?");
        text=scan.nextLine();
        System.out.println("What is the answer?");
        answer=scan.nextLine();
        System.out.println("How Difficult (1-3)?");
        difficulty=scan.nextInt();
        scan.nextLine();
        Question question=new Question(text,answer,difficulty);
        myQuiz.add(question);
    }
    public void remove_Question(){
        int questionremove;
        System.out.println("Choose the question to remove?");
        for (Question x : myQuiz){
            System.out.println(x.getText());
        }
        questionremove=scan.nextInt();
        scan.nextLine();
        myQuiz.remove(questionremove);
    }
    public  void modify_Question(){
        int questionreplace;
        String text, answer;
        int difficulty;

        for (Question x : myQuiz){
            System.out.println(x.getText());
        }
        System.out.println("Choose the question to modify?");
        questionreplace=scan.nextInt();
        scan.nextLine();
        System.out.println("What is the question Text?");
        text= scan.nextLine();
        System.out.println("What is the answer?");
        answer=scan.nextLine();
        System.out.println("How Difficult (1-3)?");
        difficulty=scan.nextInt();
        scan.nextLine();
        Question question= new Question(text,answer,difficulty);
        myQuiz.set(questionreplace,question);
    }
    public void give_quiz() {
String userInput;
int grade=0;
        for (Question x : myQuiz) {
            System.out.println(x.getText());
            userInput= scan.nextLine();
            if (userInput.equals(x.getAnswer())){
                System.out.println("Correct");
                grade++;
            }
            else{
                System.out.println("Incorrect");
            }
        }
        System.out.println("You got "+grade+" out of "+myQuiz.size());
    }
}
public class Lab3 {
    public static void main(String[] Args){
int userInput=0;
Quiz q1= new Quiz();
Scanner scan=new Scanner(System.in);
do {
    System.out.println("1. Add a question to the quiz\n" +
            "2. Remove a question from the quiz\n" +
            "3. Modify a question in the quiz\n" +
            "4. Take the quiz\n" +
            "5. Quit");
    userInput=scan.nextInt();
    switch (userInput) {
        case 1:
            q1.add_question();
            break;
        case 2:
            q1.remove_Question();
            break;
        case 3:
            q1.modify_Question();
            break;
        case 4:
            q1.give_quiz();
            break;
    }
}while (userInput!=5);
    }
}
