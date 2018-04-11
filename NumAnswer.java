import java.io.*;
import java.util.*;

public class NumAnswer extends Answer
{
	protected double answer;
	
	public NumAnswer()
	{
		return;
	}
	
	public NumAnswer(double Answer)
	{
		answer = Answer;
	}
	
	public NumAnswer(Scanner scanner)
	{
		return;
	}
	
	public void print()
	{
		System.out.println(answer);
		return;
	}
	
	public double getCredit(Answer rightAnswer)
	{
		double credit = 0.0;
		return credit;
	}
	
	public void save(PrintWriter p)
	{
		return;
	}
}