import java.util.*;

public class ScannerFactory
{
	private static Scanner scanner = null;
	
	public static Scanner getScanner()
	{
		if(scanner == null)
			scanner = new Scanner(System.in);
		
		return scanner;
	}
	
	public void finalize()
	{
		scanner.close();
		return;
	}
}