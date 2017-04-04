package ru.vovan.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;
import static org.openqa.selenium.By.cssSelector;


public class webElements {
    private WebDriver driver;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private String baseUrl;
    int PageCount = 0;
    int Page2Count = 0;
    int Page3Count = 0;


    @Before
    public void setUp() throws Exception {
        //driver = new FirefoxDriver();
        driver = new ChromeDriver();
        //driver = new EdgeDriver();

         driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    @Test
    public void locationCountry() throws InterruptedException {
        driver.get("http://localhost/litecart/admin/login.php?");
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        for (int second = 0; ; second++) {
            if (second >= 60) fail("timeout");
            try {
                if (isElementPresent(By.xpath("//*[@id='sidebar']/div[1]/a/img"))) break;
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.xpath("//li[3]/a/span[2]")).click();
        driver.findElements(cssSelector("td:nth-child(5)"));
        List<WebElement> f1 = driver.findElements(cssSelector("td:nth-child(5)"));
        System.out.println(f1);


        driver.findElement(By.xpath("//li[3]/a/span[2]")).click();
        driver.findElements(cssSelector("td:nth-child(5)"));

        for (int i = 0; i <= PageCount - 1; i++) {

            driver.findElements(cssSelector("td:nth-child(5)")).get(i).click();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.navigate().back();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.findElements(cssSelector(".td:nth-child(5)"));
        }

        driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");

        driver.findElement(By.linkText("Canada")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElements(cssSelector("#table-zones>tbody>tr>td>select"));
        for (int i = 0; i <= Page2Count - 1; i++) {

            driver.findElements(cssSelector("#table-zones>tbody>tr>td>select")).get(i).click();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.navigate().back();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.findElements(cssSelector("#table-zones>tbody>tr>td>select"));
        }
        driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");

        driver.findElement(By.linkText("United States of America")).click();

        driver.findElements(cssSelector("#table-zones>tbody>tr>td>select"));
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        for (int i = 0; i <= Page3Count - 1; i++) {

        driver.findElements(cssSelector("#table-zones>tbody>tr>td>select")).get(i).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.navigate().back();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElements(cssSelector("#table-zones>tbody>tr>td>select"));


    }


}

    @After
    public void tearDown() throws Exception {
        driver.quit();
        java.lang.String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    boolean isElementPresent(By by) {
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

    private java.lang.String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            java.lang.String alertText;
            alertText = alert.getText();
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
