import java.io.*;
import java.util.*;

public class MCMAQuestion extends MCQuestion
{
  protected ArrayList<Answer> studentAnswer;
  public double baseCredit;
  
  public MCMAQuestion(String Text, double MaxValue, double BaseCredit)
  {
    super(Text, MaxValue);
    studentAnswer = new ArrayList<Answer>();
    baseCredit = BaseCredit;
    return;
  }
  
  public MCMAQuestion(String Text, double MaxValue, double BaseCredit, ArrayList<String> ans, ArrayList<Double> val)
  {
    super.text = Text;
    super.maxValue = MaxValue;
    super.answers = new ArrayList<MCAnswer>();
    for(int i=0; i<5; i++)
    {
      Answer answer = new MCMAAnswer(ans.get(i), val.get(i));
      super.answers.add((MCMAAnswer)answer);
    }
    return;
  }
  
  public MCMAQuestion(Scanner scanner)
  {
    super.answers = new ArrayList<MCAnswer>();
    studentAnswer = new ArrayList<Answer>();
    String string = scanner.nextLine();
    double value = Double.parseDouble(string);
    string = scanner.nextLine();
    String base = scanner.nextLine();
    double baseCred = Double.parseDouble(base);
    String numAnswers = scanner.nextLine();
    int numAnswer = Integer.parseInt(numAnswers);
    super.text = string;
    super.maxValue = value;
    baseCredit = baseCred;
    
    for(int i=0; i<numAnswer; i++)
    {
      String ans = scanner.nextLine();
      int index = ans.indexOf(" ");
      String credit = ans.substring(0, index);
      ans = ans.substring(index + 1);
      double cred = Double.parseDouble(credit);
      MCMAAnswer answer = new MCMAAnswer(ans, cred);
      super.answers.add(answer);
    }
    
    return;
  }
  
  public Answer getNewAnswer()
  {
    Answer answer = new MCMAAnswer("", 0.0);
    return answer;
  }
  
  public Answer getNewAnswer(String text, double creditIfSelected)
  {
    Answer answer = new MCMAAnswer(text, creditIfSelected);
    return answer;
  }
  
  public void getAnswerFromStudent()
  {
    print();
    System.out.println();
    
    Scanner input = ScannerFactory.getKeyboardScanner();
    
    String s = input.nextLine();
    
    while(!s.equals("done"))
    {
      char c = Character.toUpperCase(s.charAt(0));
      int choice = c - 'A';
      studentAnswer.add(answers.get(choice));
      s = input.nextLine();
    }
    
    System.out.println();
    
    for(Answer a : studentAnswer)
    {
      MCAnswer mc = (MCAnswer)a;
      System.out.println(mc.text);
    }
    
    return;
  }
  
  public double getValue() {
    double points = 0.0;
    for (int i = 0; i < studentAnswer.size(); i++){
      points += super.getValue((MCAnswer)studentAnswer.get(i));
    }
    points = ((points + baseCredit) * maxValue);
    return points;
  }
  
  public void save(PrintWriter p)
  {
    p.println(super.maxValue);
    p.println(super.text);
    p.println(baseCredit);
    p.println(super.answers.size());
    
    for(int i=0; i<super.answers.size(); i++)
    {
      super.answers.get(i).save(p);
    }
    
    return;
  }
  public void saveStudentAnswers(PrintWriter p) {
    p.println(studentAnswer.size());
    for(Answer answer : studentAnswer) {
      ((MCMAAnswer)answer).saveStudentAnswers(p);
    }
  } 
  
  public void restoreStudentAnswers(Scanner scan){
    String answerLookup = scan.nextLine();
    if (answerLookup.equals("MCMAAnswer")){
      int range = Integer.parseInt(scan.nextLine());
      int temp = 0;
      for (temp = 0; temp < range; temp++){
        answerLookup = scan.nextLine();
        for(Answer answer : studentAnswer) {
          if (answer.equals(answerLookup)){
            studentAnswer.add(answer);
          }
        }
      }
    }
  }
}