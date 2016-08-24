package com.bitwise.dominos.functionaltests.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by samarthsi on 8/24/2016.
 */
public class PizzasPage {

    private WebDriver driver;

    @FindBy(linkText = "PIZZAS")
    private WebElement pizzasBtn;


    public PizzasPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void orderZestyChicken() {

        pizzasBtn.click();
        //TODO More steps to be added

    }
}
