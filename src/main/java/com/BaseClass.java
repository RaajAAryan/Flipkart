package com;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseClass {
    public static AndroidDriver driver;
    public AppiumDriverLocalService service;

    @BeforeSuite
    public void startServer() {
        File f = new File("C:\\Users\\USER\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
        service = new AppiumServiceBuilder()
                        .withAppiumJS(f)
                        .withIPAddress("127.0.0.1")
                        .usingPort(4723)
                        .withTimeout(Duration.ofSeconds(300))
                        .build();
        service.start();
    }

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("automationName", "uiautomator2");
        dc.setCapability("deviceName", "POCO M4 PRO");
        dc.setCapability("platformName", "android");
        dc.setCapability("UDID", "8HKZLB5PZTV44XYX");
        dc.setCapability("unlockType", "pin");
        dc.setCapability("unlockKey", "2580");
        dc.setCapability("browserName", "chrome");

     //   URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(dc);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterSuite
    public void stopServer() {
        service.stop();
    }
}
