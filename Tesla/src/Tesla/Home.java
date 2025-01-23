package Tesla;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Home {
    private WebDriver driver;
    private WebDriverWait wait;

    public Home(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }



	public void openBaseURL() {
        driver.get(Constants.BASE_URL);
        driver.manage().window().maximize();
    }

    public void searchForTSLA() {
        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(Locators.SEARCH_BOX));
        searchBox.sendKeys(Constants.SEARCH_QUERY);
    }

    public boolean selectTeslaFromDropdown() {
        List<WebElement> dropDowns = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Locators.DROPDOWN_ITEMS));
        for (WebElement item : dropDowns) {
            if (item.getText().contains("Tesla, Inc.")) {
                item.click();
                return true;
            }
        }
        return false;
    }

    public float getStockPrice() {
        WebElement stockPriceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.STOCK_PRICE));
        return Float.parseFloat(stockPriceElement.getText());
    }

    public String getPreviousClose() {
        WebElement previousCloseElement = driver.findElement(Locators.PREVIOUS_CLOSE);
        return previousCloseElement.getText();
    }

    public String getVolume() {
        WebElement volumeElement = driver.findElement(Locators.VOLUME);
        return volumeElement.getText();
    }
}

