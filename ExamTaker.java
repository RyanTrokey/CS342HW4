import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class ExamTaker {
	private static Exam currentExam;
	private static Scanner sc;
	private static ArrayList<Question> unansweredQuestions;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String studentName;
		String uin;
		unansweredQuestions = new ArrayList<Question>();
		sc = new Scanner(System.in);
		System.out.println("Enter Student name, then press enter and type UIN");
		studentName = sc.nextLine();
		uin = sc.nextLine();
		loadExamFile();
		gettingAllAnswers();
		saveAnswerInfo(studentName, uin);
		
	}
	
	public static void printInfo(){
		System.out.println("Work by Boris Pisabaj, bpisabaj, 673046056");
	}
	public static void loadExamFile(){
		Scanner s;
		File examFile = new File("ExamDataFile.txt");
		try {
			s = new Scanner(examFile);
			currentExam = new Exam(s);
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
		
	}
	
	public static void gettingAllAnswers(){
		int pos = 0;
		for(int i = 0; i < currentExam.getNumberQuestions();i++){
			currentExam.getAnswerFromStudent(i);
		}
	}
	
	public static void saveAnswerInfo(String student, String uin){
		
		
		File file2 = new File ("StudentAnswerDataFile.txt");
		try
		{
		  PrintWriter printWriter = new PrintWriter(file2);
		  printWriter.println(student + ", UIN: " + uin);
		  printWriter.println(currentExam.getExamName());
		  
		  currentExam.saveStudentAnswers(printWriter);
		  printWriter.close();
		}
		catch (FileNotFoundException ex)
		{
		  System.out.println("error");
		}
	}
}
