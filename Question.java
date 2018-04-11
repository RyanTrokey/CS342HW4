import java.io.*;
import java.util.*;

public abstract class Question
{
	protected String text;
	protected Answer rightAnswer;
	protected Answer studentAnswer;
	protected double maxValue;
	
	public abstract Answer getNewAnswer();
	public abstract void getAnswerFromStudent();
	public abstract double getValue();
	public abstract void save(PrintWriter p);
	
	protected Question()
	{
		return;
	}
	
	protected Question(String Text, double MaxValue)
	{
		text = Text;
		maxValue = MaxValue;
		rightAnswer = studentAnswer = null;
		return;
	}
	
	public Question(Scanner scanner)
	{
		return;
	}
	
	public void print()
	{
		System.out.println(text);
		return;
	}
	
	public void setRightAnswer(Answer ans)
	{
		rightAnswer = ans;
		return;
	}
	
	public double getMaxValue()
	{
		return maxValue;
	}
	
	public void saveStudentAnswers(PrintWriter p)
	{
		return;
	}
	
	public void restoreStudentAnswers(Scanner scanner)
	{
		return;
	}
	
}










































