package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
@Listeners(TestNGListenerExample.class)
public class LoginTest {
   WebDriver driver;
   XSSFWorkbook Workbook;
   XSSFSheet sheet1;
//	public static void main(String[] args) throws InterruptedException {
//		LoginTest lt=new LoginTest();
//		lt.setup();
//		lt.login();
//		lt.teardown();
//	}
	@BeforeMethod
	public void setup() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver","E:\\java projects\\simlilearn\\chromedriver.exe");
	    driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(6000,TimeUnit.MILLISECONDS);
		driver.get("http://www.simplilearn.com/");
        Thread.sleep(2000);
        FileInputStream fis=new FileInputStream("exceldata.xlsx");
        Workbook=new XSSFWorkbook(fis);
        sheet1=Workbook.getSheetAt(0);

	}
	@Test
	@Parameters({"uname","pwd"})
	public void login(String usernameval,String Paasword) {
		WebElement loginlink=driver.findElement(By.linkText("Log in"));
		loginlink.click();
		WebElement username=driver.findElement(By.name("user_login"));
        usernameval=sheet1.getRow(0).getCell(0).getStringCellValue();
		username.sendKeys(usernameval);
		WebElement pwd=driver.findElement(By.name("user_pwd"));
		Paasword=sheet1.getRow(0).getCell(0).getStringCellValue();
		pwd.sendKeys(Paasword);
		WebElement loginbutton=driver.findElement(By.name("btn_login"));
		WebElement check=driver.findElement(By.className("rememberMe"));
		check.click();
		loginbutton.click();
		WebElement errormsg = driver.findElement(By.id("msg_box"));

		String actError = errormsg.getText();
		String expError = "The email or password you have entered is invalid.";

//		if(actError.equals(expError)) {
//			System.out.println("sucess");
//		}else {
//			System.out.println("Failed");
//		}
		Assert.assertEquals(actError,expError);
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
