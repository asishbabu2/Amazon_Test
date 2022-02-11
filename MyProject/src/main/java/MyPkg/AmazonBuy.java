package MyPkg;

import java.util.Scanner;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonBuy {
	WebDriver driver;
	static WebDriverWait wait;

	@BeforeClass
	@Parameters("url")
	public void driverInstance(String url) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		Scanner sc = new Scanner(System.in);
		System.out.println("-----------------------------------");
		System.out.println("Select a browser");
		System.out.println("1.Google Chrome");
		System.out.println("2.Mozilla Firefox");
		System.out.println("3.Microsoft Edge");
		int brwoser = sc.nextInt();
		switch (brwoser) {
		case 1:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
			driver.navigate().to(url);
			break;
		case 2:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.navigate().to(url);
			break;
		case 3:
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.navigate().to(url);
			break;
		default:
			System.out.println("Invalid Browser");
			System.exit(0);
		}

		wait = new WebDriverWait(driver, 20);
	}

	@Test
	@Parameters("Item")
	public void addToCart(String Item) {
		Actions actions = new Actions(driver);
		WebElement we = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='twotabsearchtextbox']")));
		actions.click(we).perform();
		WebElement we1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='twotabsearchtextbox']")));
		we1.sendKeys(Item);
		WebElement we2 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='nav-search-submit-button']")));
		we2.click();
		WebElement we3 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//*[text()='Apple iPhone 12 (128GB) - Black'])[3]")));
		we3.click();
		String handle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		handles.remove(handle);
		String newhandle1 = handles.iterator().next();
		driver.switchTo().window(newhandle1);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement we4 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='add-to-cart-button']")));
		js.executeScript("arguments[0].scrollIntoView();", we4);
		we4.click();

	}

	@AfterClass
	public void stop() {
		driver.quit();
	}
}
