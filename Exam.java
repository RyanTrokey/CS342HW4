import java.io.*;
import java.util.*;

public class Exam
{
  private ArrayList<Question> questions;
  private ArrayList<Question> unansweredQuestions;
  private String text;
  
  public Exam()
  {
    questions = new ArrayList<Question>();
    unansweredQuestions = new ArrayList<Question>();
    return;
  }
  
  public Exam(String Text)
  {
    questions = new ArrayList<Question>();
    unansweredQuestions = new ArrayList<Question>();

    text = Text;
    return;
  }
  
  public Exam(Scanner scanner)
  {
    questions = new ArrayList<Question>();
    unansweredQuestions = new ArrayList<Question>();

    String line = scanner.nextLine();
    text = line;
    while(scanner.hasNextLine())
    {
      String line2 = scanner.nextLine();
      if(!line2.equals(""))
      {
        if(line2.equals("SAQuestion"))
        {
          SAQuestion question = new SAQuestion(scanner);
          questions.add(question);
        }
        else if(line2.equals("MCSAQuestion"))
        {
          MCSAQuestion question = new MCSAQuestion(scanner);
          questions.add(question);
        }
        else if(line2.equals("MCMAQuestion"))
        {
          MCMAQuestion question = new MCMAQuestion(scanner);
          questions.add(question);
        }
        else if(line2.equals("NumQuestion"))
        {
          NumQuestion question = new NumQuestion(scanner);
          questions.add(question);
        }
        else
        {
          //do nothing, program doesn't support anything else
        }
      }
    }
    
    return;
  }
  
  public void nameExam(String Text)
  {
    text = Text;
  }
  
  public String getExamName(){
    return text; 
  } 
  public void print()
  {
    System.out.println("\n" + text + "\n");
    
    int i = 1;
    for(Question q : questions)
    {
      System.out.print(i + ".) ");
      q.print();
      System.out.println();
      i++;
    }
    
    return;
  }
  
  public void addQuestion(Question question)
  {
    questions.add(question);
    return;
  }
  
  public void remove(int num)
  {
    if(num < 1 || num > questions.size())
    {
      System.out.println("\nInvalid question number...");
      return;
    }
    else
    {
      questions.remove(num-1);
      System.out.println("\nQuestion '" + num + "' removed...");
      return;
    }
  }
  
  public void reorderQuestions()
  {
    Collections.shuffle(questions);
    return;
  }
  
  public void reorderMCAnswers(int position)
  {
    MCQuestion mcq;
    
    if(position < 0)
    {
      for(Question q : questions)
      {
        if(q instanceof MCQuestion)
        {
          mcq = (MCQuestion)q;
          mcq.reorderAnswers();
        }
      }
    }
    else
    {
      int i = 1;
      for(Question q : questions)
      {
        if(i == position)
        {
          if(q instanceof MCQuestion)
          {
            mcq = (MCQuestion)q;
            mcq.reorderAnswers();
          }
        }
        i++;
      }
    }
    
    return;
  }
  
  public void getAnswerFromStudent(int position)
	{
	  SAQuestion saq;
	  MCSAQuestion mcsaq;
	  MCMAQuestion mcmaq;
	  NumQuestion nq;
	  Scanner checkInput = ScannerFactory.getKeyboardScanner();
	  ArrayList<Question> temp = this.questions;
	  if(getNumUnanswered() > 0){
		 
		  questions = this.unansweredQuestions;
		  unansweredQuestions.clear();
	  }
	  
		
		if(position < 0)
		{
			for(Question q : questions)
			{
				 if(q instanceof SAQuestion)
				    {
				     saq = (SAQuestion)q;
				     if(!checkInput.hasNextLine()){
				    	 unansweredQuestions.add(saq);
				     }
				     else{
				     saq.getAnswerFromStudent();
				     }
				    }
				 else if(q instanceof MCSAQuestion)
				    {
				     mcsaq = (MCSAQuestion)q;
				     if(!checkInput.hasNextLine()){
				    	 unansweredQuestions.add(mcsaq);
				     }
				     else{
				    	 mcsaq.getAnswerFromStudent();
				     }
				     
				    }
				    else if(q instanceof NumQuestion){
				    	nq = (NumQuestion)q;
				    	if(!checkInput.hasNextLine()){
				       	 unansweredQuestions.add(nq);
				        }
				    	else{
				    		nq.getAnswerFromStudent();
				    	}
				    }
				    else
				    {
				    	
				     mcmaq = (MCMAQuestion)q;
				     if(!checkInput.hasNextLine()){
				    	 unansweredQuestions.add(mcmaq);
				     }
				     else{
				    	 mcmaq.clearStudentAnswers(true);
				    	 mcmaq.getAnswerFromStudent();
				     }
				  }
			}
		}
		else
		{
			int i = 1;
			  for(Question q : questions)
			  {
			   if(i == position)
			   {
			    if(q instanceof SAQuestion)
			    {
			     saq = (SAQuestion)q;
			     if(!checkInput.hasNextLine()){
			    	 unansweredQuestions.add(saq);
			     }
			     else{
			     saq.getAnswerFromStudent();
			     }
			    }
			    else if(q instanceof MCSAQuestion)
			    {
			     mcsaq = (MCSAQuestion)q;
			     if(!checkInput.hasNextLine()){
			    	 unansweredQuestions.add(mcsaq);
			     }
			     else{
			    	 mcsaq.getAnswerFromStudent();
			     }
			     
			    }
			    else if(q instanceof NumQuestion){
			    	nq = (NumQuestion)q;
			    	if(!checkInput.hasNextLine()){
			       	 unansweredQuestions.add(nq);
			        }
			    	else{
			    		nq.getAnswerFromStudent();
			    	}
			    }
			    else
			    {
			    	
			     mcmaq = (MCMAQuestion)q;
			     if(!checkInput.hasNextLine()){
			    	 unansweredQuestions.add(mcmaq);
			     }
			     else{
			    	 mcmaq.clearStudentAnswers(true);
			    	 mcmaq.getAnswerFromStudent();
			     }
			    }
			   }
			   i++;
			  }
			  questions = temp;
		}
		
		return;
	}
  
  
  public void answerTheUnanswered(int pos){
		 ArrayList<Question> temp = unansweredQuestions;
		 unansweredQuestions.clear();
		 
		 return;
	 }
	 
  public int getNumUnanswered(){
		return unansweredQuestions.size();
	}
  
  public double getValue()
  {
    double score = 0.0;
    
    for(Question q : questions)
    {
      score += q.getValue();
    }
    
    return score;
  }
  
  public void reportQuestionValues()
  {
    int i = 1;
    double score = 0.0;
    double totalScore = 0.0;
    
    System.out.println("The value of each question on the test and the overall test value is as follows:\n");
    
    for(Question q : questions)
    {
      score = q.getMaxValue();
      //System.out.println("Question " + i + " is worth " + score + " points.");
      System.out.println("Question " + i + ". Total points you scored:" + q.getValue() + "\n Total points possible:" + score);
      totalScore += score;
      i++;
    }
    
    System.out.println("The total value of the test is " + totalScore + " points.");
    return;
  }
  
  public int getNumQuestions()
  {
    return questions.size();
  }
  
  public void save(PrintWriter p)
  {
    p.println(text);
    
    for (int i=0; i < questions.size(); i++)
    {
      if(questions.get(i) instanceof MCSAQuestion)
      {
        p.println("MCSAQuestion");
        questions.get(i).save(p);
      }
      else if(questions.get(i) instanceof MCMAQuestion)
      {
        p.println("MCMAQuestion");
        questions.get(i).save(p);
      }
      else if(questions.get(i) instanceof SAQuestion)
      {
        p.println("SAQuestion");
        questions.get(i).save(p);
      }
      else if(questions.get(i) instanceof NumQuestion)
      {
        p.println("NumQuestion");
        questions.get(i).save(p);
      }
      else
      {
        //shouldn't be anything else
      }
      
    }
    
    return;
  }
  
  public void saveStudentAnswers(PrintWriter p)
  {
    p.println(text);
    for (int i=0; i < questions.size(); i++)
    {
      if(questions.get(i) instanceof MCSAQuestion)
      {
        questions.get(i).saveStudentAnswers(p);
      }
      if(questions.get(i) instanceof MCMAQuestion)
      {
        questions.get(i).saveStudentAnswers(p);
      }
      if(questions.get(i) instanceof SAQuestion)
      {
        questions.get(i).saveStudentAnswers(p);
      }
      if(questions.get(i) instanceof NumQuestion)
      {
        questions.get(i).saveStudentAnswers(p);
      }
    }
    return;
  }
  
  public void restoreStudentAnswers(Scanner scanner){
    for (int i=0; i < questions.size(); i++)
    {
      if(questions.get(i) instanceof MCSAQuestion)
      {
        questions.get(i).restoreStudentAnswers(scanner);
      }
      if(questions.get(i) instanceof MCMAQuestion)
      {
        questions.get(i).restoreStudentAnswers(scanner);
      }
      if(questions.get(i) instanceof SAQuestion)
      {
        questions.get(i).restoreStudentAnswers(scanner);
      }
      if(questions.get(i) instanceof NumQuestion)
      {
        questions.get(i).restoreStudentAnswers(scanner);
      }
    }
    return;
  }
  
}
