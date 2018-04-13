import java.io.*;
import java.util.*;

public class ExamGrader{
 public static void main(String[] args){
   int action = 0;
  
  int count = 0;
  
  int inputCheck = 0;
  
  int printCheck = 0;
  
  Scanner s = ScannerFactory.getKeyboardScanner();
  
  String input = s.nextLine();

  
  Exam exam = new Exam();
  //LOOP
  while(action != 7) {
  inputCheck = 0;
   if(action == 1) {
    System.out.println("\nAction 'LOAD EXAM' selected...\n");
    
    try {
     System.out.print("Enter the file name with extension : ");

     Scanner scanner = ScannerFactory.getKeyboardScanner();

     File file = new File(scanner.nextLine());

     scanner = new Scanner(file);
   
     exam = new Exam(scanner);
     
     System.out.println("\nExam CREATED...");
     
     printCheck = 1;
    }
    catch(Exception ex)
    {
     System.out.println("SOMETHING WENT WRONG WITH THE FILE...");
    }
    
   }
   else if(action == 5)
   {
    System.out.println("\nAction 'PRINT EXAM' selected...\n");
    
    if(printCheck == 1)
     exam.print();
    else
     System.out.println("Exam not created yet, please try again.");
    
   }
   else if(action == 7)
   {
    System.out.println("\nAction 'QUIT' selected...\n");
    
    System.out.println("Quitting...");
   }
   else
   {
    System.out.println("\nSorry... Invalid action selected.");
   }
   
   System.out.print("\nPlease enter another action to take: ");
   
   s = ScannerFactory.getKeyboardScanner();
   
   input = s.nextLine();
  
  System.out.println("DONE...");
  
  return;
 }
 }
}