import java.io.*;
import java.util.*;

public abstract class MCQuestion extends Question
{
	protected ArrayList<MCAnswer> answers;
	
	protected MCQuestion()
	{
		return;
	}
	
	protected MCQuestion(String Text, double MaxValue)
	{
		super(Text, MaxValue);
		answers = new ArrayList<MCAnswer>();
		return;
	}
	
	protected MCQuestion(Scanner scanner)
	{
		return;
	}
	
	public void print()
	{
		super.print();
		
		int i = 1;
		for(MCAnswer a : answers)
		{
			if(i == 1)
				System.out.print("A. ");
			else if(i == 2)
				System.out.print("B. ");
			else if(i == 3)
				System.out.print("C. ");
			else if(i == 4)
				System.out.print("D. ");
			else
				System.out.print("E. ");
			a.print();
			i++;
		}
		
		return;
	}
	
	public void addAnswer(MCAnswer answer)
	{
		answers.add(answer);
		return;
	}
	
	public void reorderAnswers()
	{
		Collections.shuffle(answers);
	}
	
	public double getValue(MCAnswer answer)
	{
		double score = 0.0;
		
		return score;
	}
	
	public void save(PrintWriter p)
	{
		return;
	}
	
}