package Tesla;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Actions {
	private WebDriver driver;
	private WebDriverWait wait;
	private Home home;

	@BeforeClass
	public void setUp() {

		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		home = new Home(driver, wait);
	}

	@Test
	public void testTeslaStockAnalysis() throws InterruptedException {
		home.openBaseURL();
		home.searchForTSLA();
		Thread.sleep(2000);

		boolean teslaFound = home.selectTeslaFromDropdown();
		Assert.assertTrue(teslaFound, "Tesla Inc. dropdown item not found.");

		float stockPrice = home.getStockPrice();
		Assert.assertTrue(stockPrice > Constants.STOCK_PRICE_THRESHOLD,
				"Stock price is not above $200. Actual price: " + stockPrice);

		System.out.println("Stock price is above $200: " + stockPrice);

		String previousClose = home.getPreviousClose();
		String volume = home.getVolume();

		System.out.println("Previous Close: " + previousClose);
		System.out.println("Volume: " + volume);
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
