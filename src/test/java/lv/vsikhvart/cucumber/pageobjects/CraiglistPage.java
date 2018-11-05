package lv.vsikhvart.cucumber.pageobjects;


import lv.vsikhvart.cucumber.config.ApplicationProperties;
import lv.vsikhvart.cucumber.core.WebElementHelper;
import lv.vsikhvart.cucumber.pageobjects.base.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static lv.vsikhvart.cucumber.config.ApplicationProperties.ApplicationProperty.APP_URL;

public class CraiglistPage extends Page {

    @FindBy(xpath = "//a[@href='?lang=en&setlang=1']")
    private WebElement english;

    @FindBy(xpath = "//div[@class='housing'] //span[contains(text(), 'housing')]")
    private WebElement housing;

    @FindBy(xpath = "//a[@title='show newest matches first']")
    private WebElement newest;


    public static CraiglistPage navigate() {
        WebElementHelper.navigateToPage(ApplicationProperties.getString(APP_URL));
        return new CraiglistPage();
    }

    public void checkLanguage() {
        WebElementHelper.waitForVisibility(english);
    }

    public void clickEnglish () throws InterruptedException {
        WebElementHelper.click(english);
        WebElementHelper.waitForVisibility(housing);
    }

}
