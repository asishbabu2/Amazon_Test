package MyPkg;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AmazonBuy {
		WebDriver driver;

		@BeforeClass
		public void driverInstance() {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			String URL = "https://www.amazon.in/";
			driver.navigate().to(URL);
		}
		@Test(description = "Add a product to cart")
		@Parameters("Item")
		public void addToCart(String Item) throws InterruptedException {
			Actions actions = new Actions(driver);
			WebElement we = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
			actions.click(we).perform();
			driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(Item);
			driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
			driver.findElement(By.xpath("(//*[text()='Apple iPhone 12 (64GB) - White'])[3]")).click();
			String handle = driver.getWindowHandle();
			Set<String> handles = driver.getWindowHandles();
			handles.remove(handle);
			String newhandle = handles.iterator().next();
			driver.switchTo().window(newhandle);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement we1 = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
			js.executeScript("arguments[0].scrollIntoView();", we1);
			we1.click();
			Thread.sleep(5000);
		}

		@AfterClass
		public void close() {
			driver.quit();
		}
	}

}
