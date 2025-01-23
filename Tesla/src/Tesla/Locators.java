package Tesla;

import org.openqa.selenium.By;

public class Locators {
    public static final By SEARCH_BOX = By.id("ybar-sbq");
    public static final By DROPDOWN_ITEMS = By.xpath("//ul[contains(@class, 'modules-module_list__hi5kT')]/li");
    public static final By STOCK_PRICE = By.xpath("//div[contains(@class,'container yf-1tejb6')]/div/span");
    public static final By PREVIOUS_CLOSE = By.xpath("//fin-streamer[@data-field='regularMarketPreviousClose']");
    public static final By VOLUME = By.xpath("//fin-streamer[@data-field='regularMarketVolume']");
}

