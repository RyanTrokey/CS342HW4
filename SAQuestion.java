import java.io.*;
import java.util.*;

public class SAQuestion extends Question
{
  public SAQuestion(String Text, double MaxValue){
    super(Text, MaxValue);
    return;
  }
  
  public SAQuestion(String Text, double MaxValue, String Answer){
    super.text = Text;
    super.maxValue = MaxValue;
    SAAnswer answer = new SAAnswer(Answer);
    super.rightAnswer = answer;
    return;
  }
  
  public SAQuestion(Scanner scanner){
    String string = scanner.nextLine();
    double value = Double.parseDouble(string);
    string = scanner.nextLine();
    String ans = scanner.nextLine();
    SAAnswer answer = new SAAnswer(ans);
    super.text = string;
    super.maxValue = value;
    super.rightAnswer = answer;
    return;
  }
  
  public Answer getNewAnswer(){
    SAAnswer answer = new SAAnswer("");
    return answer;
  }
  
  public Answer getNewAnswer(String text){
    SAAnswer answer = new SAAnswer(text);
    return answer;
  }
  
  public void getAnswerFromStudent(){
    print();
    System.out.println();
    Scanner input = ScannerFactory.getKeyboardScanner();
    String s = input.nextLine();
    SAAnswer answer = new SAAnswer(s);
    studentAnswer = answer;
    SAAnswer sa = (SAAnswer)studentAnswer;
    System.out.println(sa.text);
    return;
  }
  
  public double getValue()
  {
    double val = 0.0;
    
    SAAnswer s = (SAAnswer)studentAnswer;
    SAAnswer r = (SAAnswer)rightAnswer;
    
    if(s.text.equals(r.text))
      val = maxValue;
    
    System.out.println("SA: " + val);  
    return val;
  }
  
  public void save(PrintWriter p){
    p.println(maxValue);
    p.println(text);
    SAAnswer ans = (SAAnswer)rightAnswer;
    super.rightAnswer.save(p);
    return;
  }
  public void saveStudentAnswers(PrintWriter p){
    p.println("SAAnswer");
    SAAnswer ans = (SAAnswer)studentAnswer;
    p.println(ans.text);
  }
  
  public void restoreStudentAnswers(Scanner scan){
    String answerLookup = scan.nextLine();
    if (answerLookup.equals("SAAnswer")){
      studentAnswer = getNewAnswer(scan.nextLine());
    }
  }
}