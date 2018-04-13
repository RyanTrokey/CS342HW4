import java.io.*;
import java.util.*;

public class ExamGrader
{
  public static void main(String[] args) throws IOException{
    System.out.println();
    
    Scanner scan = ScannerFactory.getKeyboardScanner();
    System.out.print("Enter the exam name with extension : ");
    String inputExam = scan.nextLine();
    
    System.out.print("Enter the answer name with extension : ");
    String inputAnswer = scan.nextLine();
    
    File fileAnswer = new File(inputAnswer);
    Scanner scannerAnswer = new Scanner(fileAnswer);
    String studentInfo = scannerAnswer.nextLine();
    String examName = scannerAnswer.nextLine();
    System.out.println(examName);
    if (inputExam == null || inputExam.isEmpty()){
         inputExam = examName;
    }
    else if (!examName.equals(inputExam)){
      System.out.println("This exam does not match with these answers");
      return;
    }
    
    Exam exam = new Exam();
    File fileExam = new File(inputExam);
    Scanner scannerExam = new Scanner(fileExam);
    exam = new Exam(scannerExam);
    
    exam.restoreStudentAnswers(scannerAnswer);
    exam.reportQuestionValues();
    
    //File studentAnswerFile = new File(studentInfo + "_score.csv");
          //PrintWriter  = new PrintWriter(saveFile);
  }
}