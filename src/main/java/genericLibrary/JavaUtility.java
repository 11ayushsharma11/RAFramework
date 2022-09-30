package genericLibrary;

import java.util.Random;

public class JavaUtility {
	
	public int getRandomNumber()
	{
		Random r = new Random();
		int rNumber = r.nextInt(1000);
		return rNumber;
	}

}
