package lv.vsikhvart.cucumber.pageobjects;


import lv.vsikhvart.cucumber.core.WebElementHelper;
import lv.vsikhvart.cucumber.pageobjects.base.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HousingPage extends Page {

    @FindBy(xpath = "//div[@class='dropdown dropdown-sort dropdown-arrows']")
    private WebElement dropdown;

    @FindBy(xpath = "//a[@title='sort by price, lowest to highest']")
    private WebElement priceLow;

    @FindBy(xpath = "//a[@title='sort by price, highest to lowest']")
    private WebElement priceHigh;

    @FindBy(xpath = "//a[@title='show newest matches first']")
    private WebElement newest;

    @FindBy(xpath = "//a[@class=\'hhh\']//span[@class=\'txt\']")
    private WebElement clickHousing;

    @FindBy(xpath = "//a[@class='result-image gallery']//span[@class='result-price'][contains(text(),'€1100')]")
    private WebElement highPriceSorting;

    @FindBy(xpath = "//a[@class='result-image gallery']//span[@class='result-price'][contains(text(),'€299')]")
    private WebElement lowestPriceSorting;

    @FindBy(xpath = "//input[@id='query']")
    private WebElement searchField;

    @FindBy(xpath = "//span[@class='icon icon-search']")
    private WebElement searchIcon;

    @FindBy(xpath = "//a[@title='show most relevant matches first']")
    private WebElement relevant;

    @FindBy(xpath = "//a[@title='show upcoming open houses']")
    private WebElement upcoming;

    public void openHousingPage() throws InstantiationException {
        WebElementHelper.click(clickHousing);
        WebElementHelper.waitForVisibility(newest);
    }

    public void checkDropdown() {
        WebElementHelper.waitForVisibility(newest);
        WebElementHelper.click(dropdown);
        WebElementHelper.waitForVisibility(newest);
        WebElementHelper.waitForVisibility(priceLow);
        WebElementHelper.waitForVisibility(priceHigh);
        WebElementHelper.click(dropdown);
    }

    public void checkHighPrice() {
        WebElementHelper.click(dropdown);
        WebElementHelper.waitForVisibility(priceHigh);
        WebElementHelper.click(priceHigh);
        WebElementHelper.waitForVisibility(highPriceSorting);
    }

    public void checkLowestPrice() {
        WebElementHelper.click(dropdown);
        WebElementHelper.waitForVisibility(priceLow);
        WebElementHelper.click(priceLow);
        WebElementHelper.waitForVisibility(lowestPriceSorting);
    }

    public void addTextInSearch(String text) {
        WebElementHelper.waitForVisibility(searchField);
        WebElementHelper.sendKeys(searchField, text);
        WebElementHelper.click(searchIcon);
    }

    public void checkDropdownAfterSearch() {
        WebElementHelper.waitForVisibility(dropdown);
        WebElementHelper.click(dropdown);
        WebElementHelper.waitForVisibility(newest);
        WebElementHelper.waitForVisibility(priceLow);
        WebElementHelper.waitForVisibility(priceHigh);
        WebElementHelper.waitForVisibility(relevant);
        WebElementHelper.waitForVisibility(upcoming);
    }

}

