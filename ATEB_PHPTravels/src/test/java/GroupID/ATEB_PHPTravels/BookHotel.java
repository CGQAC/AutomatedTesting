package GroupID.ATEB_PHPTravels;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BookHotel {
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
//---------------------------------------------------------------
	@Test
	public void seleniumTest() throws InterruptedException {
		WebElement webElement;
		System.out.println("@Test:seleniumTest");
		driver.manage().window().maximize();

	}
}
