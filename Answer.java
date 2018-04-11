import java.io.*;
import java.util.*;

public abstract class Answer{
  protected Answer()
  {
    return;
  }
  public Answer(Scanner scanner){
    return;
  }
  public abstract void print();
  public abstract double getCredit(Answer rightAnswer);
  public abstract void save(PrintWriter p);
}