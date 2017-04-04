package ru.vovan.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class hhh {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();


    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        //baseUrl = "http://change-this-to-the-site-you-are-testing/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      //  WebDriverWait wait = new WebDriverWait(driver,4);
        //WebElement element= wait.until(d ->d.findElement(By.xpath("//*[@id='cart']/a[2]")) );
        }

    @Test
    public void testRemove() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 10/*seconds*/);
        WebElement element = wait.until(presenceOfElementLocated(By.xpath("//*[@id='cart']/a[2]")));
        WebElement element2 = wait.until((WebDriver d) -> d.findElement(By.name("q")));

        driver.get("http://localhost/litecart/en/");
        driver.findElement(By.xpath("//img[@alt='Blue Duck']")).click();
               driver.findElement(By.name("add_cart_product")).click();




        driver.findElement(By.xpath("//img[@alt='Red Duck']")).click();
        driver.findElement(By.name("add_cart_product")).click();
        //driver.findElement(By.xpath("//img[@alt='Blue Duck']")).click();
        driver.findElement(By.xpath("//img[@alt='Green Duck']")).click();
        driver.findElement(By.name("add_cart_product")).click();
        driver.findElement(By.linkText("Checkout »")).click();
        driver.findElement(By.name("remove_cart_item")).click();
        driver.findElement(By.name("remove_cart_item")).click();
        driver.findElement(By.name("remove_cart_item")).click();
        driver.findElement(By.linkText("<< Back")).click();
        driver.get("http://localhost/litecart/en/");
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
