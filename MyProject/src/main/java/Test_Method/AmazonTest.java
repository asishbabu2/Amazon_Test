package Test_Method;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import MyPkg.AmazonHomePage;
import MyPkg.AmazonProductPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonTest {

	WebDriver driver;
	AmazonHomePage objectrepo;

	@BeforeClass
	@Parameters("url")
	public void driverInstance1(String url) {
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
	}

	@Test
	@Parameters("search")
	public void HomePageOperation1(String search) {
		AmazonHomePage page1 = new AmazonHomePage(driver);
		page1.SearchInAmazon(search);
	}

	@Test
	public void HomePageOperation2() {
		objectrepo = new AmazonHomePage(driver);
		objectrepo.selectProduct();
	}

	@Test
	public void addToCartOperation() {
		AmazonProductPage page2 = new AmazonProductPage(driver);
		page2.addToCart();
	}

	@AfterClass
	public void driverInstance2() {
		driver.quit();
	}
}
