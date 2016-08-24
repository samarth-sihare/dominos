package com.bitwise.dominos.functionaltests.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

/**
 * Created by samarthsi on 8/23/2016.
 */
public class Utilities {

    public String captureScrenshot(WebDriver driver, String screenshotName){


        try{

            TakesScreenshot ts = (TakesScreenshot)driver;
            File source = ts.getScreenshotAs(OutputType.FILE);

            String dest = "C:\\Screenshots\\"+screenshotName+".png";

            File destination = new File(dest);
            FileUtils.copyFile(source, destination);

            System.out.println("Screenshot Taken");

            return dest;

        } catch (Exception e){

            System.out.println("Exception while taking screenshot"+e.getMessage());
            return e.getMessage();

        }


    }
}
