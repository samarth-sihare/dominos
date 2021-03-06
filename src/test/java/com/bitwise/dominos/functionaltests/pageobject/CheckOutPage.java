package com.bitwise.dominos.functionaltests.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by samarthsi on 8/24/2016.
 */
public class CheckOutPage {

    @FindBy(css = "b.pizzaName")
    private WebElement firstOrderedPizzaName;

    @FindBy(css = "pizza-checkout > button")
    private WebElement placeOrderBtn;

    public CheckOutPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public boolean getPizzaName(String pizzaName){
        return firstOrderedPizzaName.getText().equals(pizzaName);
    }

    public void placePizzaOrder(){
        placeOrderBtn.click();
    }
}
