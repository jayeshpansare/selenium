package testExcelSheet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class setBrowser {

	public void chorm(WebDriver driver) {
		// TODO Auto-generated method stub
		String exePath = "C:\\Users\\jayesh\\Desktop\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		
	}

}
