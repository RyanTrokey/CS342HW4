import java.io.*;
import java.util.*;

public class ExamBuilder
{
	public static void main(String[] args)
	{
		System.out.println();
		
		System.out.print("Program by: Ryan Trokey\nNetid: rtroke2\nUIN: 668614398\n\n");
		
		System.out.print("Welcome to the Exam Builder, Instructor.\n\nBelow is a list of options for you to create, load and modify \nan exam as you wish.\n\n");
		
		System.out.print("1.) Load a saved Exam from a file\n2.) Add questions interactively\n3.) Remove questions interactively\n4.) Reorder questions, and/or answers\n5.) Print the Exam, to the screen or to a file suitable for hard-copy printing\n6.) Save the Exam\n7.) Quit\n\n");
		
		System.out.print("Please enter the action you would like to take\nby entering a number 1-7: ");
		
		int action = 0;
		
		int count = 0;
		
		int inputCheck = 0;
		
		int printCheck = 0;
		
		Scanner s = ScannerFactory.getScanner();
		
		String input = s.nextLine();
		
		while(inputCheck == 0)
		{
			try
			{
				action = Integer.parseInt(input);
				inputCheck = 1;
			}
			catch(Exception ex)
			{
				System.out.print("\nInvalid input. Please enter a number 1-7: ");
				s = ScannerFactory.getScanner();
				input = s.nextLine();
			}
		}
		
		Exam exam = new Exam();
		
		while(action != 7)
		{
			
			inputCheck = 0;
			
			if(action == 1)
			{
				
				System.out.println("\nAction 'LOAD EXAM' selected...\n");
				
				try
				{
					System.out.print("Enter the file name with extension : ");

					Scanner scanner = ScannerFactory.getScanner();

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
			else if(action == 2)
			{
				System.out.println("\nAction 'ADD QUESTION' selected...\n");
				System.out.println("Please enter '1' to add a short answer question\nPlease enter '2' to add a multiple choice single answer question\nPlease enter '3' to add a multiple choice multiple answer question\nPlease enter '4' to add a NumQuestion question");
				s = ScannerFactory.getScanner();
				input = s.nextLine();
				action = Integer.parseInt(input);
				
				if(action == 1)
				{
					System.out.print("\nFirst, enter the question to be added to the exam: ");
					s = ScannerFactory.getScanner();
					String question = s.nextLine();
					
					System.out.print("\nSecond, enter the value of the question in '0.0' format: ");
					s = ScannerFactory.getScanner();
					String val = s.nextLine();
					double value = Double.parseDouble(val);
					
					System.out.print("\nThird, enter the answer to the question: ");
					s = ScannerFactory.getScanner();
					String answer = s.nextLine();
					SAQuestion q = new SAQuestion(question, value, answer);
					exam.addQuestion(q);
					
					System.out.println("\nShort Answer question ADDED...");
					printCheck = 1;
				}
				else if(action == 2)
				{
					System.out.print("\nFirst, enter the question to be added to the exam: ");
					s = ScannerFactory.getScanner();
					String question = s.nextLine();
					
					System.out.print("\nSecond, enter the value of the question in '0.0' format: ");
					s = ScannerFactory.getScanner();
					String val = s.nextLine();
					double value = Double.parseDouble(val);
					
					System.out.print("\nThird, enter 5 total answers for the question, 1 at a time.\nAfter entering each answer, enter the credit to be given if that answer were to be selected.\n");
					System.out.print("\nFor example: If the question was 'What color is the sky?'\nOne answer entered in would look like this:\nblue\n1.0\n");
					
					ArrayList<String> answers = new ArrayList<String>();
					ArrayList<Double> values = new ArrayList<Double>();
					
					for(int i=0; i<5; i++)
					{
						s = ScannerFactory.getScanner();
						String ans = s.nextLine();
						s = ScannerFactory.getScanner();
						val = s.nextLine();
						double v = Double.parseDouble(val);
						answers.add(ans);
						values.add(v);
					}
					
					MCSAQuestion q = new MCSAQuestion(question, value, answers, values);
					exam.addQuestion(q);
					
					System.out.println("\nMultiple Choice Single Answer question ADDED...");
					printCheck = 1;
				}
				else if(action == 3)
				{
					System.out.print("\nFirst, enter the question to be added to the exam: ");
					s = ScannerFactory.getScanner();
					String question = s.nextLine();
					
					System.out.print("\nSecond, enter the value of the question in '0.0' format: ");
					s = ScannerFactory.getScanner();
					String val = s.nextLine();
					double value = Double.parseDouble(val);
					
					System.out.print("\nThird, enter 5 total answers for the question, 1 at a time.\nAfter entering each answer, enter the credit to be given if that answer were to be selected.\n");
					System.out.print("\nFor example: If the question was 'What color is the sky?'\nOne answer entered in would look like this:\nblue\n1.0\n");
					
					ArrayList<String> answers = new ArrayList<String>();
					ArrayList<Double> values = new ArrayList<Double>();
					
					for(int i=0; i<5; i++)
					{
						s = ScannerFactory.getScanner();
						String ans = s.nextLine();
						s = ScannerFactory.getScanner();
						val = s.nextLine();
						double v = Double.parseDouble(val);
						answers.add(ans);
						values.add(v);
					}
					
					System.out.print("\nFourth, enter the base credit to be given for this question in '0.0' format: ");
					s = ScannerFactory.getScanner();
					val = s.nextLine();
					double baseCredit = Double.parseDouble(val);
					
					MCMAQuestion q = new MCMAQuestion(question, value, baseCredit, answers, values);
					exam.addQuestion(q);
					
					System.out.println("\nMultiple Choice Multiple Answer question ADDED...");
					printCheck = 1;
				}
				else if(action == 4)
				{
					System.out.print("\nFirst, enter the question to be added to the exam: ");
					s = ScannerFactory.getScanner();
					String question = s.nextLine();
					
					System.out.print("\nSecond, enter the value of the question in '0.0' format: ");
					s = ScannerFactory.getScanner();
					String val = s.nextLine();
					double value = Double.parseDouble(val);
					
					System.out.print("\nThird, enter the answer to the question: ");
					s = ScannerFactory.getScanner();
					String answer = s.nextLine();
					double ans = Double.parseDouble(answer);
					
					System.out.print("\nFourth, enter the tolerance: ");
					s = ScannerFactory.getScanner();
					String tol = s.nextLine();
					double tolerance = Double.parseDouble(tol);
					NumQuestion q = new NumQuestion(question, value, ans, tolerance);
					exam.addQuestion(q);
					
					System.out.println("\nNumQuestion question ADDED...");
					printCheck = 1;
				}
				else
				{
					System.out.println("\nInvalid choice...Sending you back to main action selecter.");
				}
				
			}
			else if(action == 3)
			{
				System.out.println("\nAction 'REMOVE QUESTION' selected...\n");
				
				if(printCheck == 1)
				{
					System.out.println("\nHere are all of the questions on the Exam: \n");
					exam.print();
					System.out.print("\nEnter which question number you would like to remove: ");
					s = ScannerFactory.getScanner();
					input = s.nextLine();
					int num = Integer.parseInt(input);
					exam.remove(num);
				}
				else
				{
					System.out.println("Exam not created yet, please try again.");
				}
			}
			else if(action == 4)
			{
				System.out.println("\nAction 'REORDER QUESTIONS/ANSWERS' selected...\n");
				
				System.out.print("\nEnter 1 to reorder the questions, 2 to reorder the questions and answers, or 3 to reorder the answers of a specific question: ");
				
				s = ScannerFactory.getScanner();
				input = s.nextLine();
				int num = Integer.parseInt(input);
				
				if(num == 1)
				{
					exam.reorderQuestions();
				}
				else if(num == 2)
				{
					exam.reorderQuestions();
					exam.reorderMCAnswers(-1);
				}
				else if(num == 3)
				{
					System.out.print("\nEnter the question number in which you would like to reorder the answers: ");
					s = ScannerFactory.getScanner();
					input = s.nextLine();
					num = Integer.parseInt(input);
					exam.reorderMCAnswers(num);
				}
				else
				{
					System.out.println("\nInvalid choice...Bringing you back to main action selecter.");
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
			else if(action == 6)
			{
				System.out.println("\nAction 'SAVE EXAM' selected...\n");
				
				/*try
				{
					System.out.print("\nEnter the name of the file you would like to save to with extension: ");
					s = ScannerFactory.getScanner();
					File saveFile = new File(s.nextLine());
					PrintWriter p = new PrintWriter(saveFile);
					exam.save(p);
					p.close();
				}
				catch(Exception ex)
				{
					System.out.println("\nERROR WITH FILE...");
				}*/
				
				
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
			
			s = ScannerFactory.getScanner();
			
			input = s.nextLine();
			
			while(inputCheck == 0)
			{
				try
				{
					action = Integer.parseInt(input);
					inputCheck = 1;
				}
				catch(Exception ex)
				{
					System.out.print("Invalid input. Please enter a number 1-7: ");
					s = ScannerFactory.getScanner();
					input = s.nextLine();
				}
			}
			
		}
		
		System.out.println("DONE...");
		
		return;
	}
}