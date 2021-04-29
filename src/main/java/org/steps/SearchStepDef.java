package org.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pages.GoogelSearchPage;

import java.net.URISyntaxException;

public class SearchStepDef {

    private WebDriver webDriver;
    private GoogelSearchPage googelSearchPage;

    public SearchStepDef(){
        webDriver = new ChromeDriver();
        googelSearchPage = new GoogelSearchPage(webDriver);
    }

    @When("I go to {string}")
    public void iGoTo(String url) throws URISyntaxException {
        webDriver.get(url);
    }

    @And("I type {string}")
    public void iType(String searchQuery) {
        googelSearchPage.getSearchBox().sendKeys(searchQuery);

//        webDriver.findElement(By.name("q")).sendKeys(searchQuery);
    }

    @And("I hit Enter")
    public void iHitEnter() {
        webDriver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    }

    @Then("I should be shown the results from my query")
    public void iShouldBeShownTheResultsFromMyQuery() {
        try {
            webDriver.findElement(By.xpath("//*[contains(text(), 'Search Results')]"));
        } catch (NoSuchElementException e) {
            throw new AssertionError("Result Page not displayed");
        }
        webDriver.quit();
    }
}
