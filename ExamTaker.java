import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class ExamTaker {
	private static Exam currentExam;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> positions = new ArrayList<Integer>();
		String studentName;
		String uin;
		Scanner sc;
		int numQuestions = currentExam.getNumQuestions();
		sc = ScannerFactory.getKeyboardScanner();
		System.out.println("Enter Student name, then press enter and type UIN");
		studentName = sc.nextLine();
		uin = sc.nextLine();
		loadExamFile();
		
		answerRoutine(numQuestions, positions);
		saveAnswerInfo(studentName, uin);
		
	}
	
	public static void printInfo(){
		System.out.println("Work by Boris Pisabaj, bpisabaj, 673046056");
	}
	public static void loadExamFile(){
		Scanner sc = ScannerFactory.getKeyboardScanner();
		Scanner s;
		String examName;
		File examFile;
		System.out.println("What exam file do you want to load?");
		examName = sc.nextLine();
		examFile = new File(examName);
		while(!examFile.exists()){
			System.out.println("Sorry, file specified does not exist");
			System.out.println("What exam file do you want to load?");
			examName = sc.nextLine();
			examFile = new File(examName);
		}
		
		try {
			s = new Scanner(examFile);
			currentExam = new Exam(s);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void gettingAllAnswers(int numQuestions){
		for(int i = 0; i < currentExam.getNumQuestions();i++){
			currentExam.getAnswerFromStudent(i);
		}
	}
	
	public static void reAnswering(ArrayList<Integer> pos){
		if(pos.isEmpty()){
			return;
		}
		for(int i: pos){
			currentExam.getAnswerFromStudent(i);
		}
	}
	public static ArrayList<Integer> specifyQuestionsToRetry(ArrayList<Integer> pos){
		
		Scanner sc = ScannerFactory.getKeyboardScanner();
		String tempPos = "-";
		System.out.println("Enter questions to re answer. Type 'done' when...you're done");
		tempPos = sc.nextLine();
		while(!tempPos.equalsIgnoreCase("done")){
			pos.add(Integer.parseInt(tempPos));
		}
		return pos;
	}
	
	
	
	public static ArrayList<Integer> determineRetry(ArrayList<Integer> pos){
		Scanner sc = ScannerFactory.getKeyboardScanner();
		ArrayList<Integer> newPos = new ArrayList<Integer>();
		System.out.println("Do you want to re answer any questions");
		if((sc.nextLine()).equalsIgnoreCase("yes")){
			newPos = specifyQuestionsToRetry(pos);
		}
		else{
			System.out.println("Very well, will continue with exam");
			return newPos;
		}
		return newPos;
	}
	
	
	 public static int determineUnansweredQuestions(){
		 int totalUnanswered = currentExam.getNumUnanswered();
		 Scanner sc = ScannerFactory.getKeyboardScanner();
		 if(totalUnanswered > 0){
			 System.out.println("You left " + totalUnanswered + " Questions unanswered. Would you like to try to answer them?");
			 if(sc.nextLine().equalsIgnoreCase("Yes")){
				 gettingAllAnswers(totalUnanswered);
			 }
			 else{
				 return 0;
			 }
		 }
		 return 1;
		 
	 }
	 
	 

	 public static boolean answerRoutine(int numQuestions, ArrayList<Integer> pos){
		 Scanner sc = ScannerFactory.getKeyboardScanner();
		 ArrayList<Integer> ourPos = new ArrayList<Integer>();
		 int unansweredFlag = 0;
		 gettingAllAnswers(numQuestions);
		 unansweredFlag = determineUnansweredQuestions();
		 while(unansweredFlag > 0){
			 unansweredFlag = determineUnansweredQuestions();
		 }
		 
		 ourPos = determineRetry(pos);
		 while(ourPos.size() > 0){
			 reAnswering(ourPos);
			 ourPos = determineRetry(ourPos);
		 }
		 
		 return false;
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
