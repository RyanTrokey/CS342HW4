import java.io.*;
import java.util.*;

public abstract class MCAnswer extends Answer
{
  protected String text;
  protected double creditIfSelected;
  
  protected MCAnswer()
  {
    return;
  }
  
  protected MCAnswer(String Text, double CreditIfSelected)
  {
    text = Text;
    creditIfSelected = CreditIfSelected;
    return;
  }
  
  public MCAnswer(Scanner scanner)
  {
    return;
  }
  
  public void print()
  {
    System.out.println(text);
    return;
  }
  
  public double getCredit(Answer rightAnswer){
    MCAnswer answerTemp = (MCAnswer)rightAnswer;
    if (text.equals(answerTemp.text)){
      return creditIfSelected;
    }
    return 0;
  }
  
  public void save(PrintWriter p)
  {
    p.println(creditIfSelected + " " + text);
    return;
  }
  
  public void  saveStudentAnswers(PrintWriter p){
    if (creditIfSelected > 0){
      p.println(creditIfSelected);
      p.println(text);
    }
  }
  
}