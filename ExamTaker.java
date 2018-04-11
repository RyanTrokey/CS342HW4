import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class ExamTaker {
	private static Exam currentExam;
	private Scanner sc;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String studentName;
		String uin;
		
	}
	
	public static void printInfo(){
		System.out.println();
	}
	public static void loadExamFile(Scanner s){
		File examFile = new File("ExamDataFile.txt");
		try {
			s = new Scanner(examFile);
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
		currentExam = new Exam(s);
	}
	
	public static void parseStudentAnswer(){
		
		
		File file2 = new File ("StudentAnswerDataFile.txt");
		try
		{
		  PrintWriter printWriter = new PrintWriter(file2);
		  currentExam.saveStudentAnswers(printWriter);
		  printWriter.close();
		}
		catch (FileNotFoundException ex)
		{
		  System.out.println("error");
		}
	}
}
