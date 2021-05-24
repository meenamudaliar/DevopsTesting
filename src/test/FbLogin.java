package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FbLogin {
	 WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		FbLogin fb=new FbLogin();
		fb.setup();
		fb.login();
		//fb.signup();
	}
	public void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","E:\\java projects\\simlilearn\\chromedriver.exe");
	    driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(6000,TimeUnit.MILLISECONDS);
		driver.get("http://www.facebook.com/");
        Thread.sleep(2000);

	}
	public void login() {
//		WebElement loginlink=driver.findElement(By.linkText("Log in"));
//		loginlink.click();
//		WebElement username=driver.findElement(By.xpath("//input[@name='email']"));
//
//		username.sendKeys("meena.akshaya18@gmail.com");
//		WebElement pwd=driver.findElement(By.xpath("//input[@name='pass']"));
//
//		pwd.sendKeys("akshaya18");
//		WebElement loginbutton=driver.findElement(By.xpath("//*[@name='login']"));
//		WebElement check=driver.findElement(By.className("rememberMe"));
//		check.click();
		//loginbutton.click();
		
//		WebElement errormsg = driver.findElement(By.id("msg_box"));
//
//		String actError = errormsg.getText();
//		String expError = "The email or password you have entered is invalid.";
//
//		if(actError.equals(expError)) {
//			System.out.println("sucess");
//		}else {
//			System.out.println("Failed");
//		}
		  WebElement username = driver.findElement(By.cssSelector("input#email"));
		  username.sendKeys("meena.akshaya");
	        WebElement password = driver.findElement(By.cssSelector("input#pass"));
	        password.sendKeys("abcd");
	        WebElement loginbutton = driver.findElement(By.cssSelector("button[name=login]"));
				
	}
	public void signup() {
		WebElement text1=driver.findElement(By.xpath("//*[contains(text(),'connect')]"));
		
		WebElement createbutton=driver.findElement(By.xpath("//*[text()='Create New Account']"));
		createbutton.click();
		
		WebElement fname=driver.findElement(By.xpath("//input[@name='lastname']"));
		fname.sendKeys("Meena");
		WebElement lname=driver.findElement(By.xpath("//input[@name='lastname']"));
		lname.sendKeys("Mudaliar");
		WebElement DayDropDown=driver.findElement(By.xpath("//*[@title='Day']"));
		WebElement MonthDropDown=driver.findElement(By.xpath("//*[@title='Month']"));
		WebElement YearDropDown=driver.findElement(By.xpath("//*[@title='Year']"));
		Select day=new Select(DayDropDown);
		day.selectByVisibleText("18");
		day.selectByIndex(17);
		day.selectByValue("18");
		Select month=new Select(MonthDropDown);
		month.selectByVisibleText("Jul");
		month.selectByIndex(7);
		
		Select year=new Select(YearDropDown);
		year.selectByVisibleText("1993");
		year.selectByIndex(31);
		year.selectByValue("1993");
		WebElement gender=driver.findElement(By.xpath("//input[@type='radio' and @value='1']"));
	gender.click();
	System.out.println(text1.getText());
	
	}
}
