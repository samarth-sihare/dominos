package com.bitwise.dominos.functionaltests.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by samarthsi on 8/23/2016.
 */
public class DashboardPage {

    private WebDriver driver;

    @FindBy(linkText = "Dashboard")
    private WebElement dashboardBtn;

    @FindBy(linkText = "PIZZAS")
    private WebElement pizzasBtn;

    @FindBy(partialLinkText = "Zesty Chicken")
    private WebElement zestyChickenPizza;

    @FindBy(xpath = "//button[2]")
    private WebElement saveBtn;

    @FindBy(css = "h3")
    private WebElement dashboardHeading;


    public DashboardPage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void orderZestyChicken(){
        dashboardBtn.click();
        //TODO More steps to be added
//        zestyChickenPizza.click();
//        saveBtn.click();
//        pizzasBtn.click();

    }

    public Boolean isOnDashboardPage(){
        return dashboardHeading.isDisplayed();
    }


}
