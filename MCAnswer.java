import java.io.*;
import java.util.*;

public abstract class MCAnswer extends Answer
{
	protected String text;
	protected double creditIfSelected;
	
	protected MCAnswer()
	{
		return;
	}
	
	protected MCAnswer(String Text, double CreditIfSelected)
	{
		text = Text;
		creditIfSelected = CreditIfSelected;
		return;
	}
	
	public MCAnswer(Scanner scanner)
	{
		return;
	}
	
	public void print()
	{
		System.out.println(text);
		return;
	}
	
	public double getCredit(Answer rightAnswer)
	{
		return creditIfSelected;
	}
	
	public void save(PrintWriter p)
	{
		p.println(creditIfSelected + " " + text);
		return;
	}
	
}