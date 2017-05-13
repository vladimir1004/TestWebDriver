package ru.vovan.selenium;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

//import org.testng.annotations.*;

//import static org.testng.Assert.*;

public class tt {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testLoginPositive() throws Exception {
        driver.get("http://www.lufthansa.com/online/portal/lh/il/homepage");
        driver.findElement(By.xpath("//a[@id='header-profile-toggle']/span")).click();
        for (int second = 0; ; second++) {
            if (second >= 60) fail("timeout");
            try {
                if (isElementPresent(By.xpath("//a[@id='header-profile-toggle']/span"))) break;
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }

        driver.findElement(By.id("lluserid")).click();
        for (int second = 0; ; second++) {
            if (second >= 60) fail("timeout");
            try {
                if (isElementPresent(By.id("lluserid"))) break;
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }
        driver.findElement(By.id("lluserid")).clear();
        driver.findElement(By.id("lluserid")).sendKeys("stas9141");
        driver.findElement(By.id("llpassword")).click();
        for (int second = 0; ; second++) {
            if (second >= 60) fail("timeout");
            try {
                if (isElementPresent(By.id("llpassword"))) break;
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }
        driver.findElement(By.id("llpassword")).clear();
        driver.findElement(By.id("llpassword")).sendKeys("Tyndra5125$");
        driver.findElement(By.id("ll-btn")).click();
        assertEquals(driver.findElement(By.xpath("//a[@id='header-profile-toggle']/span")).getText(), "Prof. Stas DobromilskyiOpen menu entry using the Enter, Space or Arrow down key");
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}

