package GroupID.ATEB_PHPTravels;

import java.util.List;

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
		List<WebElement> listWebElement;
		System.out.println("@Test:seleniumTest");
		driver.manage().window().maximize();
		driver.get("https://www.phptravels.net/m-hotels");

		listWebElement = driver.findElements(By.tagName("div"));
		for (WebElement webele : listWebElement) {
			try {
				webele = webele.findElement(By.tagName("input"));
				webele.sendKeys("London, United Kingdom");
				System.out.println("found");
				break;
			} catch (Exception e) {

			}
		}
		
		listWebElement = driver.findElements(By.tagName("input"));
		for (WebElement webele : listWebElement) {
			try {
				String placeHolder = webele.getAttribute("placeholder");
				System.out.println(placeHolder);
				if (placeHolder == "Check in") {
					System.out.println("found2");
					webele.click();	
				}
			} catch (Exception e) {
				
			}
		}
		

		Thread.sleep(2000);
	}
}
