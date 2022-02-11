package MyPkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonHomePage {
	WebDriver driver;
	WebDriverWait wait;

	public AmazonHomePage(WebDriver driver) {
		this.driver = driver;
	}

	By searchbox = By.xpath("//input[@id='twotabsearchtextbox']");
	By searchbutton = By.xpath("//input[@id='nav-search-submit-button']");
	By product = By.xpath("(//*[text()='Apple iPhone 12 (128GB) - Black'])[3]");

	public void SearchInAmazon(String search) {
		wait = new WebDriverWait(driver, 20);
		Actions actions = new Actions(driver);
		WebElement we1 = wait.until(ExpectedConditions.visibilityOfElementLocated(searchbox));
		actions.click(we1).perform();

		WebElement we2 = wait.until(ExpectedConditions.visibilityOfElementLocated(searchbox));
		we2.sendKeys(search);
		WebElement we3 = wait.until(ExpectedConditions.visibilityOfElementLocated(searchbutton));
		we3.click();
	}

	public void selectProduct() {
		wait = new WebDriverWait(driver, 20);
		WebElement we4 = wait.until(ExpectedConditions.visibilityOfElementLocated(product));
		we4.click();
	}
}
