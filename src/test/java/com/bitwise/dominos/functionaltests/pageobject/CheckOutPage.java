package com.bitwise.dominos.functionaltests.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by samarthsi on 8/24/2016.
 */
public class CheckOutPage {

    private WebDriver driver;

    public CheckOutPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}
