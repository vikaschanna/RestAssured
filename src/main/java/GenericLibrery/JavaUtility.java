package GenericLibrery;

import java.util.Random;

public class JavaUtility {
	public int generateRandomNo() {
		Random ran = new Random();
		int randomNo = ran.nextInt(500);
		return randomNo;
	}
}
