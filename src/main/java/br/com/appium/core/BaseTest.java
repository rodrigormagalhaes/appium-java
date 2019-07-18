package br.com.appium.core;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class BaseTest {

    @Rule
    public TestName testName = new TestName();

    @After
    public void tearDown() {
        takeScreenshot();
        DriverFactory.getDriver().resetApp();
    }

    @AfterClass
    public static void finalizarClasse() {
        DriverFactory.killDriver();
    }

    public void takeScreenshot() {
        File screenshot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("target/screenshots/"+ testName.getMethodName() +".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
