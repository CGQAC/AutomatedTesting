package GroupID.ATEB_DemoSite;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddUserAndLogin {
	WebDriver driver;
	
	@BeforeClass
	public static void initial() {
		System.out.println("START");
	}
	@AfterClass
	public static void end() {
		System.out.println("END");
	}
//---------------------------------------------------------------
	@Before
	public void setup() {
		System.out.println("Loading Chrome Driver...");
		System.setProperty("webdriver.chrome.driver","C:/Users/Admin/Desktop/chromedriver.exe");
		driver = new ChromeDriver();
	}
	@After 
	public void tearDown() throws InterruptedException {
		System.out.println("Closing Chrome Driver...");
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void seleniumTest() throws InterruptedException {
		WebElement webElement;
		System.out.println("@Test:seleniumTest");
		driver.manage().window().maximize();
		driver.get("http://thedemosite.co.uk/");
		//Find and click the link "3.Add a User"
		webElement = driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]"));
		webElement.click();
		Thread.sleep(1000);
		//Find the input box element for add username
		webElement = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input"));
		webElement.sendKeys("UN_selenium");

		//Find the input box element for add password
		webElement = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input"));
		webElement.sendKeys("PW_selen");

		//Find the 'save' button and click
		webElement = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input"));
		webElement.click();
	
		//Find and click the link "4.Login"
		webElement = driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]"));
		webElement.click();
		
		//Find the input box element for username
		webElement = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input"));
		webElement.sendKeys("UN_selenium");

		//Find the input box element for password
		webElement = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input"));
		webElement.sendKeys("PW_selen");

		//Find the 'Test Login' button and click
		webElement = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input"));
		webElement.click();
		
		//Find and assert '**Successful Login**'
		webElement = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"));
		assertEquals("**Successful Login**", webElement.getText());
		
	}
}
