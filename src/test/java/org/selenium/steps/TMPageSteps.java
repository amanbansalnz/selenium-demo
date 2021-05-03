package org.selenium.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.selenium.pages.LoginPage;
import org.selenium.pages.TMPage;

public class TMPageSteps {

    LoginPage loginPage = new LoginPage();
    TMPage tmPage = new TMPage();

    @Given("I am logged in")
    public void givenIAmLoggedIn() {
        loginPage.login(null,null);
    }

    @Given("I am at the TMPage")
    public void givenIAmAtTheTmpage() {
        tmPage.navigateToTM();
        boolean isAtTmPage = tmPage.validateAtTmPage();
        Assert.assertTrue(isAtTmPage);
    }

    @When("I click the create new button")
    public void whenIClickTheCreateNewButton() {
        tmPage.clickCreateButton();
    }

    @When("I enter the details for the new TM")
    public void whenIEnterTheDetailsForTheNewTm() {
        tmPage.selectingTimeMaterial();
        tmPage.enterInputCode(null);
        tmPage.enterInputDescription(null);
        tmPage.inputPriceValue();
    }

    @When("Click save button")
    public void whenClickSaveButton() {
        tmPage.clickSave();
    }

    @When("I click the last page button")
    public void whenIClickTheLastPageButton() {
        tmPage.clickToLastPage();
    }

    @Then("Validate the TM is created")
    public void thenValidateTheTmIsCreated() {
        boolean isCreated = tmPage.validateNewTMIsCreated();
        Assert.assertTrue(isCreated);
    }
}
