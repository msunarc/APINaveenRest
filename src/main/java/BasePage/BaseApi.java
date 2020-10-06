package BasePage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseApi {
	//for not to hard code status
	public int RESPONSE_STATUS_CODE_200=200;
	public int RESPONSE_STATUS_CODE_401=401;
	public int RESPONSE_STATUS_CODE_400=400;
	public static int RESPONSE_STATUS_CODE_201=201;
	public int RESPONSE_STATUS_CODE_500=500;

	public Properties prop;
	public BaseApi(){
		try {
			prop=new Properties();
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+".\\src\\main\\java\\qaconfig\\config.properties");
		
		prop.load(fis);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
			
		}
		catch(IOException e) {
			e.printStackTrace();
	
		}
		
		}

}
