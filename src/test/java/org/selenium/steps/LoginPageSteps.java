package org.selenium.steps;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.selenium.pages.LoginPage;

public class LoginPageSteps {

//    @Steps
    LoginPage loginPage = new LoginPage();

    @Given("I am at the login page")
    public void givenIAmAtTheLoginPage() {
        loginPage.navigateToLoginPage();
    }

    @Given("I validate that I am at the login page")
    public void givenIValidateThatIAmAtTheLoginPage() {
        boolean validateThaYouAreLoginPage = loginPage.validateThaYouAreLoginPage();
        Assert.assertTrue(validateThaYouAreLoginPage);
    }

    @When("I enter valid creds")
    public void whenIEnterValidCreds() {
        loginPage.enterGivenUsernameAndPassword(null, null);
    }

    @When("I click the login button")
    public void whenIClickTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("I should be logged in successfully")
    public void thenIShouldBeLoggedInSuccessfully() {
        boolean loggedInSuccessfully = loginPage.validateLoggedInSuccessfully();
        Assert.assertTrue(loggedInSuccessfully);
    }

    @When("I login with username '$username'")
    public void whenILoginWithUsernameName(String username) {
        loginPage.enterGivenUsernameAndPassword(username, null);
    }

    @Then("I should be not logged in")
    public void thenIShouldBeNotLoggedIn() {
        boolean isNotLoggedIn = loginPage.validateNotLoggedIn();
        Assert.assertTrue(isNotLoggedIn);
    }

    @When("I login with <username> and with <password>")
    public void whenILoginWithUsernameAndWithPassword(@Named("username") String username, @Named("password") String password) {
        loginPage.enterGivenUsernameAndPassword(username, password);
    }
}
