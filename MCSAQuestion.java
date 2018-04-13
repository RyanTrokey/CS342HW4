import java.io.*;
import java.util.*;

public class MCSAQuestion extends MCQuestion
{
  public MCSAQuestion(String Text, double MaxValue)
  {
    super(Text, MaxValue);
    return;
  }
  
  public MCSAQuestion(String Text, double MaxValue, ArrayList<String> ans, ArrayList<Double> val)
  {
    super.text = Text;
    super.maxValue = MaxValue;
    super.answers = new ArrayList<MCAnswer>();
    for(int i=0; i<5; i++)
    {
      MCSAAnswer answer = new MCSAAnswer(ans.get(i), val.get(i));
      super.answers.add(answer);
    }
    return;
  }
  
  public MCSAQuestion(Scanner scanner)
  {
    super.answers = new ArrayList<MCAnswer>();
    String string = scanner.nextLine();
    double value = Double.parseDouble(string);
    string = scanner.nextLine();
    String numAnswers = scanner.nextLine();
    int numAnswer = Integer.parseInt(numAnswers);
    super.text = string;
    super.maxValue = value;
    
    for(int i=0; i<numAnswer; i++)
    {
      String ans = scanner.nextLine();
      int index = ans.indexOf(" ");
      String credit = ans.substring(0, index);
      ans = ans.substring(index + 1);
      double cred = Double.parseDouble(credit);
      MCSAAnswer answer = new MCSAAnswer(ans, cred);
      super.answers.add(answer);
    }
  }
  
  public Answer getNewAnswer()
  {
    MCSAAnswer answer = new MCSAAnswer("", 0.0);
    return answer;
  }
  
  public Answer getNewAnswer(String text, double creditIfSelected)
  {
    MCSAAnswer answer = new MCSAAnswer(text, creditIfSelected);
    return answer;
  }
  
  public void getAnswerFromStudent()
  {
    print();
    System.out.println();
    
    Scanner input = ScannerFactory.getKeyboardScanner();
    
    String s = input.nextLine();
    
    char c = Character.toUpperCase(s.charAt(0));
    
    int choice = c - 'A';
    
    studentAnswer = answers.get(choice);
    
    MCAnswer mc = (MCAnswer)studentAnswer;
    
    System.out.println(mc.text);
    
    return;
  }
  
  public double getValue(){
    double val = 0.0;
    
    MCSAAnswer a = (MCSAAnswer)studentAnswer;
    
    val = a.creditIfSelected * maxValue;
    
    System.out.println("MCSA: " + val);
    
    return val;
  }
  
  public void save(PrintWriter p){
    p.println(maxValue);
    super.save(p);
  }
  public void saveStudentAnswers(PrintWriter writingData){
    MCSAAnswer tempstudent = (MCSAAnswer)studentAnswer;
    writingData.println(tempstudent.text + "\n");
  }
  
  public void restoreStudentAnswers(Scanner scan){
    String answerLookup = scan.nextLine();
    System.out.println(answerLookup);
    if (answerLookup.equals("MCSAAnswer")){
      answerLookup = scan.nextLine();
      for(Answer answer : studentAnswer) {
        if (answer.equals(answerLookup)){
          studentAnswer = answer;
        }
      }
    }
  }
}