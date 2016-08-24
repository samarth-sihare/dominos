package com.bitwise.dominos.functionaltests.tests;

import com.bitwise.dominos.functionaltests.pageobject.CheckOutPage;
import com.bitwise.dominos.functionaltests.pageobject.DashboardPage;
import com.bitwise.dominos.functionaltests.pageobject.PizzasPage;
import com.bitwise.dominos.functionaltests.utilities.Utilities;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by samarthsi on 8/19/2016.
 */
public class DashboardTests {

    private WebDriver driver;
    private ExtentTest logger;
    private ExtentReports report = new ExtentReports("Test_Reports\\FunctionalTestsExtendedReports.html");
    private Utilities util;
    private DashboardPage dashboardPage;
    private CheckOutPage checkOutPage;
    private PizzasPage pizzasPage;

    @BeforeMethod(alwaysRun = true)
    public void setup(){
        driver = new FirefoxDriver();
//        driver.get("https://www.google.com");
        driver.get("http://10.30.125.95:3000/pizzas");
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        util = new Utilities();
        dashboardPage = new DashboardPage(driver);
        checkOutPage = new CheckOutPage(driver);
        pizzasPage = new PizzasPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE) {

            String screenshot_path = util.captureScrenshot(driver, result.getName());
            String image = logger.addScreenCapture(screenshot_path);
            logger.log(LogStatus.FAIL, "Test Verification Failed", image);

        }

        report.endTest(logger);
        report.flush();
        driver.quit();
    }

    @Test(enabled = true)
    public void orderFromDashboard(){
        logger = report.startTest("Verify if user is able to order pizza from Dashboard");
        dashboardPage.orderZestyChicken();
        logger.log(LogStatus.INFO, "Created an oreder with Zesty Chicken Pizza");
        //TODO add proper assertion and steps(if needed)
        assert true : "This is dummy assertuib for now";
        logger.log(LogStatus.PASS, "Test Passed");



    }

    @Test(enabled = true)
    public void orderFromPizzasPage(){
        logger = report.startTest("Verify if user is able to order pizza from Pizzas Page");
        pizzasPage.orderZestyChicken();
        logger.log(LogStatus.INFO, "Created an oreder with Zesty Chicken Pizza");
        //TODO add proper assertion and steps(if needed)
        assert false : "This is dummy assertuib for now";
        logger.log(LogStatus.PASS, "Test Passed");



    }

}
