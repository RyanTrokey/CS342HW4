import java.io.*;
import java.util.*;

public class ExamGrader
{
  public static void main(String[] args) throws IOException{
    System.out.println();
    int uploadCheck = 0;
    
    int examCheck = 0;
    
    Scanner scan = ScannerFactory.getKeyboardScanner();
    System.out.println("Exam");
    String inputExam = scan.nextLine();
    
    System.out.println("Answer");
    String inputAnswer = scan.nextLine();
    
    File fileAnswer = new File(inputAnswer);
    Scanner scannerAnswer = new Scanner(fileAnswer);
    
    List<String> list = new ArrayList<String>();
    while (scannerAnswer.hasNextLine()) {
      list.add(scannerAnswer.nextLine());
    }
    
    System.out.println(list.get(1));
    if (inputExam == null || inputExam == " "){
      inputExam = list.get(1);
      System.out.println(inputExam);
    }
    else if (!list.get(1).equals(inputExam)){
      System.out.println("This exam does not match with these answers");
    }
    
    Exam exam = new Exam();
    File fileExam = new File(inputExam);
    Scanner scannerExam = new Scanner(fileExam);
    exam = new Exam(scannerExam);
    
    exam.restoreStudentAnswers(scannerAnswer);
    exam.reportQuestionValues();
  }
}