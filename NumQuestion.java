import java.io.*;
import java.util.*;

public class NumQuestion extends Question
{
	protected double tolerance;
	
	public NumQuestion()
	{
		return;
	}
	
	public NumQuestion(String Text, double MaxValue, double Tolerance)
	{
		super.text = Text;
		super.maxValue = MaxValue;
		tolerance = Tolerance;
		return;
	}
	
	public NumQuestion(String Text, double MaxValue, double Answer, double Tolerance)
	{
		super.text = Text;
		super.maxValue = MaxValue;
		NumAnswer answer = new NumAnswer(Answer);
		super.rightAnswer = answer;
		tolerance = Tolerance;
		return;
	}
	
	public NumQuestion(Scanner scanner)
	{
		String string = scanner.nextLine();
		double value = Double.parseDouble(string);
		string = scanner.nextLine();
		String ans =scanner.nextLine();
		double a = Double.parseDouble(ans);
		ans = scanner.nextLine();
		double tol = Double.parseDouble(ans);
		NumAnswer answer = new NumAnswer(a);
		super.text = string;
		super.maxValue = value;
		super.rightAnswer = answer;
		tolerance = tol;
		return;
	}
	
	public Answer getNewAnswer()
	{
		NumAnswer answer = new NumAnswer();
		return answer;
	}
	
	public void getAnswerFromStudent()
	{
		return;
	}
	
	public double getValue()
	{
		double value = 0.0;
		return value;
	}
	
	public void save(PrintWriter p)
	{
		p.println(super.maxValue);
		p.println(super.text);
		super.rightAnswer.save(p);
		p.println(tolerance);
		
		return;
	}
}