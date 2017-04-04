package ru.vovan.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class hz {
    private WebDriver driver;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private String baseUrl;

    @Before
    public void setUp() throws Exception {
       //driver = new FirefoxDriver();
        driver = new ChromeDriver();
        //driver = new EdgeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void testHz() throws Exception {
        driver.get("http://localhost/litecart/admin/login.php?");
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.xpath("//*[@id='sidebar']/div[1]/a/img"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        driver.findElement(By.xpath("//span[.='Appearence']")).click();
        assertTrue(isElementPresent(By.xpath("//span[.='Appearence']")));

        driver.findElement(By.cssSelector("#doc-template > a > span.name")).click();
        assertTrue(isElementPresent(By.cssSelector("#doc-template > a > span.name")));

        driver.findElement(By.cssSelector("#doc-logotype > a > span.name")).click();
        assertTrue(isElementPresent(By.cssSelector("#doc-logotype > a > span.name")));

        driver.findElement(By.xpath("//span[.='Catalog']")).click();
        assertTrue(isElementPresent(By.xpath("//span[.='Catalog']")));

        driver.findElement(By.cssSelector("#doc-product_groups > a > span.name")).click();
        assertTrue(isElementPresent(By.cssSelector("#doc-product_groups > a > span.name")));

        driver.findElement(By.cssSelector("#doc-option_groups > a > span.name")).click();
        assertTrue(isElementPresent(By.cssSelector("#doc-option_groups > a > span.name")));

        driver.findElement(By.cssSelector("#doc-manufacturers > a > span.name")).click();
        assertTrue(isElementPresent(By.cssSelector("#doc-manufacturers > a > span.name")));

        driver.findElement(By.cssSelector("#doc-suppliers > a > span.name")).click();
        assertTrue(isElementPresent(By.cssSelector("#doc-suppliers > a > span.name")));

        driver.findElement(By.cssSelector("#doc-delivery_statuses > a > span.name")).click();
        assertTrue(isElementPresent(By.cssSelector("#doc-delivery_statuses > a > span.name")));

        driver.findElement(By.cssSelector("#doc-sold_out_statuses > a > span.name")).click();
        assertTrue(isElementPresent(By.cssSelector("#doc-sold_out_statuses > a > span.name")));

        driver.findElement(By.cssSelector("#doc-quantity_units > a > span.name")).click();
        assertTrue(isElementPresent(By.cssSelector("#doc-quantity_units > a > span.name")));

        driver.findElement(By.cssSelector("#doc-csv > a > span.name")).click();
        assertTrue(isElementPresent(By.cssSelector("#doc-csv > a > span.name")));

        driver.findElement(By.xpath("//li[3]/a/span[2]")).click();
        assertTrue(isElementPresent(By.xpath("//li[3]/a/span[2]")));

        driver.findElement(By.xpath("//li[4]/a/span[2]")).click();
        assertTrue(isElementPresent(By.xpath("//li[4]/a/span[2]")));

        driver.findElement(By.xpath("//li[5]/a/span[2]")).click();
        assertTrue(isElementPresent(By.xpath("//li[5]/a/span[2]")));

        driver.findElement(By.cssSelector("#doc-csv > a > span.name")).click();
        assertTrue(isElementPresent(By.cssSelector("#doc-csv > a > span.name")));

        driver.findElement(By.cssSelector("#doc-newsletter > a > span.name")).click();
        assertTrue(isElementPresent(By.cssSelector("#doc-newsletter > a > span.name")));


        driver.findElement(By.xpath("//li[6]/a/span[2]")).click();
        assertTrue(isElementPresent(By.xpath("//li[6]/a/span[2]")));


        driver.findElement(By.xpath("//li[7]/a/span[2]")).click();
        assertTrue(isElementPresent(By.xpath("//li[7]/a/span[2]")));

        driver.findElement(By.cssSelector("#doc-storage_encoding > a > span.name")).click();
        assertTrue(isElementPresent(By.cssSelector("#doc-storage_encoding > a > span.name")));

        driver.findElement(By.xpath("//li[8]/a/span[2]")).click();
        assertTrue(isElementPresent(By.xpath("//li[8]/a/span[2]")));

        driver.findElement(By.cssSelector("#doc-customer > a > span.name")).click();
        assertTrue(isElementPresent(By.cssSelector("#doc-customer > a > span.name")));

        driver.findElement(By.cssSelector("#doc-shipping > a > span.name")).click();
        assertTrue(isElementPresent(By.cssSelector("#doc-shipping > a > span.name")));

        driver.findElement(By.cssSelector("#doc-payment > a > span.name")).click();
        assertTrue(isElementPresent(By.cssSelector("#doc-payment > a > span.name")));

        driver.findElement(By.cssSelector("#doc-order_total > a > span.name")).click();
        assertTrue(isElementPresent(By.cssSelector("#doc-order_total > a > span.name")));

        driver.findElement(By.cssSelector("#doc-order_success > a > span.name")).click();
        assertTrue(isElementPresent(By.cssSelector("#doc-order_success > a > span.name")));

        driver.findElement(By.cssSelector("#doc-order_action > a > span.name")).click();
        assertTrue(isElementPresent(By.cssSelector("#doc-order_action > a > span.name")));

        driver.findElement(By.xpath("//li[9]/a/span[2]")).click();
        assertTrue(isElementPresent(By.xpath("//li[9]/a/span[2]")));

        driver.findElement(By.cssSelector("#doc-order_statuses > a > span.name")).click();
        assertTrue(isElementPresent(By.cssSelector("#doc-order_statuses > a > span.name")));

        driver.findElement(By.xpath("//li[10]/a/span[2]")).click();
        assertTrue(isElementPresent(By.xpath("//li[10]/a/span[2]")));
        driver.findElement(By.xpath("//li[11]/a/span[2]")).click();
        assertTrue(isElementPresent(By.xpath("//li[11]/a/span[2]")));


        driver.findElement(By.cssSelector("#doc-most_sold_products > a > span.name")).click();
        assertTrue(isElementPresent(By.cssSelector("#doc-most_sold_products > a > span.name")));

        driver.findElement(By.cssSelector("#doc-most_shopping_customers > a > span.name")).click();
        assertTrue(isElementPresent(By.cssSelector("#doc-most_shopping_customers > a > span.name")));

        driver.findElement(By.xpath("//li[12]/a/span[2]")).click();
        assertTrue(isElementPresent(By.xpath("//li[12]/a/span[2]")));

        driver.findElement(By.cssSelector("#doc-defaults > a > span.name")).click();
        assertTrue(isElementPresent(By.cssSelector("#doc-defaults > a > span.name")));

        driver.findElement(By.cssSelector("#doc-general > a > span.name")).click();
        assertTrue(isElementPresent(By.cssSelector("#doc-general > a > span.name")));

        driver.findElement(By.cssSelector("#doc-listings > a > span.name")).click();
        assertTrue(isElementPresent(By.cssSelector("#doc-listings > a > span.name")));

        driver.findElement(By.cssSelector("#doc-images > a > span.name")).click();
        assertTrue(isElementPresent(By.cssSelector("#doc-images > a > span.name")));

        driver.findElement(By.cssSelector("#doc-checkout > a > span.name")).click();
        assertTrue(isElementPresent(By.cssSelector("#doc-checkout > a > span.name")));

        driver.findElement(By.cssSelector("#doc-advanced > a > span.name")).click();
        assertTrue(isElementPresent(By.cssSelector("#doc-advanced > a > span.name")));

        driver.findElement(By.cssSelector("#doc-security > a > span.name")).click();
        assertTrue(isElementPresent(By.cssSelector("#doc-security > a > span.name")));

        driver.findElement(By.xpath("//li[13]/a/span[2]")).click();
        assertTrue(isElementPresent(By.xpath("//li[13]/a/span[2]")));
        driver.findElement(By.xpath("//li[14]/a/span[2]")).click();
        assertTrue(isElementPresent(By.xpath("//li[14]/a/span[2]")));

        driver.findElement(By.cssSelector("#doc-tax_rates > a > span.name")).click();
        assertTrue(isElementPresent(By.cssSelector("#doc-tax_rates > a > span.name")));

        driver.findElement(By.xpath("//li[15]/a/span[2]")).click();
        assertTrue(isElementPresent(By.xpath("//li[15]/a/span[2]")));

        driver.findElement(By.cssSelector("#doc-scan > a > span.name")).click();
        assertTrue(isElementPresent(By.cssSelector("#doc-scan > a > span.name")));

        driver.findElement(By.linkText("CSV Import/Export")).click();
        assertTrue(isElementPresent(By.linkText("CSV Import/Export")));

        //driver.findElement(By.cssSelector("name=login"));


        driver.findElement(By.xpath("//li[16]/a/span[2]")).click();
        assertTrue(isElementPresent(By.xpath("//li[16]/a/span[2]")));
        driver.findElement(By.xpath("//li[17]/a/span[2]")).click();
        assertTrue(isElementPresent(By.xpath("//li[17]/a/span[2]")));
        driver.get("http://localhost/litecart/en/");
        for (int second = 0; ; second++) {
            if (second >= 60) fail("timeout");
            try {
                if (isElementPresent(By.cssSelector("#logotype-wrapper>a>img"))) break;
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }

    }



    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
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
