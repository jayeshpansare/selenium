package testExcelSheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class excelsheet {
	static WebDriver driver;
	private TakesScreenshot TakesScreenShot;
	
	public static void main(String[] args){
		// TODO Auto-generated method stub
	}

	@Test
	public void Checklink(){
		
		setBrowser browser = new setBrowser();
		
		browser.chorm(driver);
		
		driver = new ChromeDriver();
		
		driver.get("http://uksdesigns.com/ad/index1.html");
		
		List <WebElement> getlinks = driver.findElements(By.tagName("a"));
		System.out.println("No of links found:"+getlinks.size());
		
		takescreenshorts screenshort = new takescreenshorts("takescreen", driver); 
		
		for(int i=0; i<= getlinks.size(); i++){
			WebElement elemnet = getlinks.get(i);
			String link =elemnet.getAttribute("href");
			Verifylinks verify = new Verifylinks(link);
			
		}
	}
	
	
	
	/* @Test
	public void astart(){
		String exePath = "C:\\Users\\jayesh\\Desktop\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		
		driver = new ChromeDriver();
		driver.get("http://localhost/wordpressdemo/wp-admin");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	 @Test(dataProvider="login")
	 public void login(String username, String password, String Errormsg){
		
		
		driver.findElement(By.id("user_login")).sendKeys(username);
		driver.findElement(By.id("user_pass")).sendKeys(password);		
		driver.findElement(By.id("wp-submit")).click();
		
		TakesScreenshot Screenshorts = (TakesScreenshot)driver;
		File Source = Screenshorts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(Source, new File("./Screenshort/"+username+"_"+password+"_img.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try{
			String getErrorMessage = driver.findElement(By.id("login_error")).getText();
			try{
				Thread.sleep(3000);
			}catch(Exception e){
				
			}
			
			Assert.assertEquals(getErrorMessage, Errormsg);
		}catch(Exception e){
			System.out.println("Login");
		}
				
	}
	
	
	
	 @DataProvider(name="login")
	public Object[][] passdata(){
		
		Exceldata getExcelFile = new Exceldata("C:\\Users\\jayesh\\Desktop\\logindata.xlsx");
		int lastRowCount = getExcelFile.getTotalRow(0);
		
		Object[][] data = new Object[lastRowCount][3];
		
		for(int i=0; i<lastRowCount;i++){
			
			data[i][0] = getExcelFile.getData(0, i, 0);
			data[i][1] = getExcelFile.getData(0, i, 1);
			data[i][2] = getExcelFile.getData(0, i, 2);
		}

		return data;
		
	} */
	

	@AfterTest
	public void closebrowser(){
		driver.close();
	}
}
