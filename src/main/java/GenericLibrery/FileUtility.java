package GenericLibrery;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * This Class is used to fetch the data from Property file
 * @author Vikas S
 *
 */
public class FileUtility {
	
	/**
	 * This method is used to read the data from property file
	 * @author Vikas S
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromPropertyFile(String key) throws Throwable {
		FileInputStream fis = new FileInputStream(IConstantsLibrery.FilePath);
		Properties pObj = new Properties();
		pObj.load(fis);
		String value = pObj.getProperty(key);
		return value;
	}
}
