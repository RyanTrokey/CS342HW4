import java.io.*;
import java.util.*;

public class ExamGrader
{
  public static void main(String[] args) throws IOException{
    System.out.println();
    int uploadCheck = 0;
    
    int examCheck = 0;
    
    Scanner scan = ScannerFactory.getKeyboardScanner();
    System.out.print("Enter the exam name with extension : ");
    String inputExam = scan.nextLine();
    
    System.out.print("Enter the answer name with extension : ");
    String inputAnswer = scan.nextLine();
    
    File fileAnswer = new File(inputAnswer);
    Scanner scannerAnswer = new Scanner(fileAnswer);
    
    List<String> list = new ArrayList<String>();
    while (scannerAnswer.hasNextLine()) {
      list.add(scannerAnswer.nextLine());
    }
    
    System.out.println(list.get(1));
    if (inputExam == null || inputExam.isEmpty()){
         inputExam = list.get(1);
    }
    else if (!list.get(1).equals(inputExam)){
      System.out.println("This exam does not match with these answers");
      return;
    }
    
    Exam exam = new Exam();
    File fileExam = new File(inputExam);
    Scanner scannerExam = new Scanner(fileExam);
    exam = new Exam(scannerExam);
    
    exam.restoreStudentAnswers(scannerAnswer);
    exam.reportQuestionValues();
  }
}