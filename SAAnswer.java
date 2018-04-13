import java.io.*;
import java.util.*;

public class SAAnswer extends Answer
{
  protected String text;
  
  public SAAnswer(String Text){
    text = Text;
    return;
  }
  
  public SAAnswer(Scanner scanner){
    return;
  }
  
  public void print() {
    System.out.println(text);
    return;
  }
  
  public double getCredit(Answer rightAnswer){
    if (this.text.equals(((SAAnswer)rightAnswer).text)){
      return 1.0;
    }
    return 0.0;
  }
  public void save(PrintWriter p){
    p.println(text);
  }
  public void saveStudentAnswers(PrintWriter p){
    p.println(text);
  }
}