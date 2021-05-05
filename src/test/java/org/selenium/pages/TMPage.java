package org.selenium.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;

public class TMPage extends PageObject {

    @FindBy(xpath = "//*[@id='container']/p/a")
    private WebElementFacade createNewButton;

    @FindBy(xpath = "//*[@id='TimeMaterialEditForm']/div/div[1]/div/span[1]/span/span[1]")
    private WebElementFacade materialDropdown;

    @FindBy(xpath = "//*[@id='TypeCode_listbox']/li[2]")
    private WebElementFacade timerMaterialDropdown;

    @FindBy(id = "Code")
    private WebElementFacade inputCode;

    @FindBy(xpath = "//*[@id='Description']")
    private WebElementFacade inputDescription;

    @FindBy(xpath = "//*[@id='TimeMaterialEditForm']/div/div[4]/div/span[1]/span/input[1]")
    private WebElementFacade inputPriceTextBox;

    @FindBy(xpath = "//*[@id='Price']")
    private WebElementFacade inputPrice;

    @FindBy(xpath = "//*[@id='SaveButton']")
    private WebElementFacade saveButton;

    @FindBy(xpath = "//*[@id='tmsGrid']/div[4]/a[4]")
    private WebElementFacade lastPageButton;

    @FindBy(xpath = "//*[@data-role='pager']/span[2]")
    private WebElementFacade totalNumberCountOfItems;

    @FindBy(xpath = "//*[@id='tmsGrid']/div[3]/table/tbody/tr[last()]/td[3]")
    private WebElementFacade lastEntryDescription;

    @FindBy(xpath = "/html/body/div[3]/div/div/ul/li[5]/a")
    private WebElementFacade adminTab;

    @FindBy(xpath = "/html/body/div[3]/div/div/ul/li[5]/ul/li[3]/a")
    private WebElementFacade tm;

    @FindBy(xpath = "/html/body/div[4]/div/div/div[3]/table/tbody/tr[10]/td[5]/a[1]")
    private WebElementFacade tableEditButton;

    public void navigateToTM()
    {
        // click admin
        adminTab.click();
        waitFor(500);
        // click tm
        tm.click();
    }

    @Step
    public boolean validateAtTmPage() {
        // expect delay
        waitFor(500);
        // click create new button
        return createNewButton.isDisplayed();
    }

    @Step
    public void clickCreateButton() {
        // expect delay
        waitFor(500);
        // click create new button
        createNewButton.click();
        // expect delay
        waitFor(500);
    }

    @Step
    public void selectingTimeMaterial() {
        // select time from drop down
        materialDropdown.click();
        waitFor(500);
        timerMaterialDropdown.click();
    }

    @Step
    public void enterInputCode(String input) {
        if (input == null) {
            inputCode.sendKeys("Mar2021");
        } else {
            inputCode.sendKeys(input);
        }
    }

    @Step
    public void enterInputDescription(String description) {

        if (description == null) {
            inputDescription.sendKeys("Mar2021");
        } else {
            inputDescription.sendKeys(description);
        }
    }

    @Step
    public void inputPriceValue() {
        inputPriceTextBox.click();
        inputPrice.sendKeys("765");
    }

    @Step
    public void clickSave() {
        saveButton.click();
        waitFor(500);

    }

    @Step
    public void clickToLastPage() {

        //added this to ensure if it takes time for page to render then assert on the component that actually validates this state
        waitFor(tableEditButton);
        lastPageButton.click();
        waitFor(500);

    }

    @Step
    public boolean validateNewTMIsCreated() {
        // verify if the last row contains the record created

        // option 1
        //Assert.That(actualDescription.Text, Is.EqualTo("Mar2021"), "Test Failed");

        // option 2
        //Assert.Pass("TM created, test passed");
        //Assert.Fail("TM test failed");
        return lastEntryDescription.getText().equals("Mar2021");
    }

}