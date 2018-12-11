package GroupID.ATEB_PHPTravels;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

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
//		driver.get("https://www.phptravels.net/hotels/search/united-kingdom/london/11-12-2018/13-12-2018/3/0");

		Actions action = new Actions(driver);
		
		listWebElement = driver.findElements(By.tagName("div"));
		for (WebElement webele : listWebElement) {
			try {
				webele = webele.findElement(By.tagName("input"));
				webele.sendKeys("London");
				System.out.println("found1");
				Thread.sleep(1000);
				action.sendKeys(Keys.TAB).perform();
				Thread.sleep(1000);
				action.sendKeys("11/12/2018").perform();
				System.out.println("found2");
				Thread.sleep(1000);
				action.sendKeys(Keys.TAB).perform();
				Thread.sleep(1000);
				action.sendKeys("13/12/2018").perform();
				System.out.println("found3");
				break;
			} catch (Exception e) {

			}
		}

		
		webElement = driver.findElement(By.id("travellersInput"));
		webElement.click();
		webElement = driver.findElement(By.id("adultPlusBtn"));
		webElement.click();
		Thread.sleep(2000);
		webElement.submit();
		Thread.sleep(2000);

		int i = 1;
		listWebElement = driver.findElements(By.className("row"));
		for (WebElement webele : listWebElement) {
			try {
				webele = webele.findElement(By.tagName("a"));
//				webele.getAttribute("title");
				System.out.println(Integer.toString(i)+": " + webele.getAttribute("title"));
				i++;
			} catch (Exception e) {
				
			}
		}
		Thread.sleep(2000);
	}
}
