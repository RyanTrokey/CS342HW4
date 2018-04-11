import java.io.*;
import java.util.*;

public class SAAnswer extends Answer
{
	protected String text;
	
	public SAAnswer(String Text)
	{
		text = Text;
		return;
	}
	
	public SAAnswer(Scanner scanner)
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
		double cred = 0.0;
		return cred;
	}
	
	public void save(PrintWriter p)
	{
		p.println(text);
		return;
	}
	
}