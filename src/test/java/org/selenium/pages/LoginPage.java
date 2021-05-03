package org.selenium.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;

@DefaultUrl("http://horse.industryconnect.io/Account/Login?ReturnUrl=%2f")
public class LoginPage extends PageObject {

    @FindBy(id = "UserName")
    private WebElementFacade username;

    @FindBy(name = "Password")
    private WebElementFacade password;

    @FindBy(xpath = "//*[@id='loginForm']/form/div[3]/input[1]")
    private WebElementFacade loginButton;

    @FindBy(xpath = "/html/body/div[4]/div/div/section/form/div[1]/ul/li")
    private WebElementFacade loginErrorMessage;

    @FindBy(xpath = "//*[@id='logoutForm']/ul/li/a")
    private WebElementFacade ifLoggedIn;


    @Step
    public void enterGivenUsernameAndPassword(String usernameValue, String passwordValue) {
        try {
            waitFor(username);

            if (usernameValue != null) {
                System.out.println("enterUsername " + usernameValue);

                username.sendKeys(usernameValue);
            } else {
                System.out.println("enterUsername " + "hari");

                username.sendKeys("hari");
            }


            if (passwordValue != null) {

                System.out.println("passwordValue " + passwordValue);
                // enter password
                password.sendKeys(passwordValue);
            } else {

                System.out.println("passwordValue " + "123123");
                // enter default password
                password.sendKeys("123123");

            }


        } catch (Exception msg) {
            Assert.fail("Test failed at login page");
        }
    }

    @Step
    public void login(String usernameValue, String passwordValue) {
        navigateToLoginPage();
        enterGivenUsernameAndPassword(usernameValue, passwordValue);
        clickLoginButton();
        validateLoggedInSuccessfully();
    }

    @Step
    public void navigateToLoginPage() {
        this.open();
    }

    @Step
    public boolean validateThaYouAreLoginPage() {
        return loginButton.isDisplayed();
    }

    @Step
    public void clickLoginButton() {
        loginButton.click();
    }

    @Step
    public boolean validateLoggedInSuccessfully() {

        waitFor(ifLoggedIn);

        if (ifLoggedIn.getText().equals("Hello hari!")) {
            System.out.println("Logged in successfully, test passed");
            return true;
        } else {
            System.out.println("Login failed, test failed");
            return false;
        }

    }

    @Step
    public boolean validateNotLoggedIn() {
        waitFor(loginErrorMessage);
        return loginErrorMessage.isDisplayed();
    }


}