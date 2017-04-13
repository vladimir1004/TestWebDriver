package ru.vovan.selenium;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.fail;

public class recycleBin {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private WebDriverWait wait;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testRemove() throws Exception {

        driver.get("http://localhost/litecart/en/");
        driver.findElement(By.xpath("//img[@alt='Blue Duck']")).click();
        driver.findElement(By.name("add_cart_product")).click();
        for (int second = 0; ; second++) {
            if (second >= 60) fail("timeout");
            try {
                if (isElementPresent(By.name("add_cart_product"))) break;
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }


        driver.findElement(By.xpath("//img[@alt='Red Duck']")).click();
        for (int second = 0; ; second++) {
            if (second >= 60) fail("timeout");
            try {
                if (isElementPresent(By.xpath("//img[@alt='Red Duck']"))) break;
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }


        driver.findElement(By.name("add_cart_product")).click();

        for (int second = 0; ; second++) {
            if (second >= 60) fail("timeout");
            try {
                if (isElementPresent(By.name("add_cart_product"))) break;
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }
        // driver.wait(1500);


        driver.findElement(By.xpath("//img[@alt='Green Duck']")).click();
        for (int second = 0; ; second++) {
            if (second >= 60) fail("timeout");
            try {
                if (isElementPresent(By.xpath("//img[@alt='Green Duck']"))) break;
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }

        driver.findElement(By.name("add_cart_product")).click();
        for (int second = 0; ; second++) {
            if (second >= 60) fail("timeout");
            try {
                if (isElementPresent(By.name("add_cart_product"))) break;
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }
        // driver.wait(1500);
        driver.findElement(By.linkText("Checkout »")).click();

        driver.findElement(By.xpath(".//*[@id='box-checkout-cart']/ul/li[1]/a/img")).click();
        // driver.wait();
        //driver.wait(1500);

        driver.findElement(By.xpath(".//*[@id='box-checkout-cart']/ul/li[2]/a/img")).click();
        driver.findElement(By.name("remove_cart_item")).click();
        for (int second = 0; ; second++) {
            if (second >= 60) fail("timeout");
            try {
                if (isElementPresent(By.name("remove_cart_item"))) break;
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }
        driver.findElement(By.xpath(".//*[@id='box-checkout-cart']/ul/li[3]/a/img")).click();
        driver.findElement(By.name("remove_cart_item")).click();
        for (int second = 0; ; second++) {
            if (second >= 60) fail("timeout");
            try {
                if (isElementPresent(By.name("remove_cart_item"))) break;
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }
        driver.findElement(By.linkText("<< Back")).click();
        driver.get("http://localhost/litecart/en/");
        //driver.wait(1500);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
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



