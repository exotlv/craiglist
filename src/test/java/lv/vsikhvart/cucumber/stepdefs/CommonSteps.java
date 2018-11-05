package lv.vsikhvart.cucumber.stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

import lv.vsikhvart.cucumber.config.ApplicationProperties;
import lv.vsikhvart.cucumber.pageobjects.*;
import lv.vsikhvart.cucumber.util.TestDataContext;

import static lv.vsikhvart.cucumber.config.ApplicationProperties.ApplicationProperty.TEST_DATA;

public class CommonSteps {
    private CraiglistPage CraiglistPage;
    private HousingPage HousingPage;
    private TestDataContext testDataContext = TestDataContext.getInstance();

    @Given("^open craiglist webpage$")
    public void openCraiglistPage() throws Throwable {
        CraiglistPage = CraiglistPage.navigate();
    }

    @Given("^select language English$")
    public void selectLanguageEnglish() throws Throwable {
        CraiglistPage.checkLanguage();
        CraiglistPage.clickEnglish();
    }

    @And("^check filters in dropdown$")
    public void checkPricesFilterIndropdown() throws Throwable {
        HousingPage = new HousingPage();
        HousingPage.openHousingPage();
        HousingPage.checkDropdown();
    }

    @And("^check High price sorting$")
    public void checkHighPriceSorting() throws Throwable {
        HousingPage.checkHighPrice();
    }

    @And("^check Lowest price sorting$")
    public void checkLowestPriceSorting() throws Throwable {
        HousingPage.checkLowestPrice();
    }

    @And("^add predefined text in search field$")
    public void addReviewData() throws Throwable {
        HousingPage = new HousingPage();
        HousingPage.openHousingPage();
        HousingPage.addTextInSearch(ApplicationProperties.getString(TEST_DATA));
    }

    @And("^check dropdown sorting after search$")
    public void checkDropdownSortingAfterSearch() throws Throwable {
        HousingPage.checkDropdownAfterSearch();
    }
}
