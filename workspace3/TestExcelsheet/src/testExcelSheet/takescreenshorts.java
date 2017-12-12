package testExcelSheet;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class takescreenshorts {

	public takescreenshorts(String nameOfScreenShort, WebDriver driver) {
		try{
			Thread.sleep(3000);
		}catch(Exception e){
			System.out.println("Error is:"+e.getMessage());
		}
		TakesScreenshot Screenshorts = (TakesScreenshot)driver;
		File Source = Screenshorts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(Source, new File("./Screenshort/"+nameOfScreenShort+"_img.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
