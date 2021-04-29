package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogelSearchPage {

    private WebDriver driver;

    @FindBy(xpath="/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")
    private WebElement searchBox;

    public GoogelSearchPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public WebElement getSearchBox() {
        return searchBox;
    }

}
