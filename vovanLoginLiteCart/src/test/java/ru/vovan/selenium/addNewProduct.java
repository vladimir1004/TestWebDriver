package ru.vovan.selenium;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

    public class addNewProduct {
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
        public void testAddProdukt() throws Exception {
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
            driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog");
            driver.findElement(By.xpath("(//li[@id='app-']/a/span[2])[2]")).click();
            driver.findElement(By.linkText("Add New Product")).click();

            driver.findElement(By.name("name[en]")).sendKeys("Nikolay");

            driver.findElement(By.name("code")).sendKeys("12345");
            driver.findElement(By.xpath("(//input[@name='categories[]'])[2]")).click();
            new Select(driver.findElement(By.name("default_category_id"))).selectByVisibleText("Rubber Ducks");
            driver.findElement(By.xpath("(//input[@name='product_groups[]'])[2]")).click();

            driver.findElement(By.name("quantity")).sendKeys("1");

            new Select(driver.findElement(By.name("quantity_unit_id"))).selectByVisibleText("-- Select --");
            new Select(driver.findElement(By.name("quantity_unit_id"))).selectByVisibleText("pcs");

            String fileName = "E:\foto life\20151020_180226.jpg";
            File file = new File(fileName);
            new File("20151020_180226.jpg").getAbsolutePath();
            System.out.println(new File("20151020_180226.jpg").getAbsolutePath());
            driver.findElement(By.name("new_images[]")).sendKeys("E:\\JAVA video\\QA1\\Github\\TestWebDriver\\vovanLoginLiteCart\\20151020_180226.jpg");

            driver.findElement(By.name("date_valid_from")).sendKeys("2017-04-01");

            driver.findElement(By.name("date_valid_to")).sendKeys("2018-04-30");
            driver.findElement(By.linkText("Information")).click();
            new Select(driver.findElement(By.name("manufacturer_id"))).selectByVisibleText("ACME Corp.");

            driver.findElement(By.name("keywords")).sendKeys("Sea");
            driver.findElement(By.name("short_description[en]")).sendKeys("Sea is well");
            driver.findElement(By.name("head_title[en]")).sendKeys("Mediterranean Sea");
            driver.findElement(By.name("meta_description[en]")).sendKeys("Sea");
            driver.findElement(By.linkText("Prices")).click();
            driver.findElement(By.name("purchase_price")).sendKeys("1");


            new Select(driver.findElement(By.name("purchase_price_currency_code"))).selectByVisibleText("US Dollars");
            driver.findElement(By.name("gross_prices[USD]")).sendKeys("12345");
            driver.findElement(By.name("gross_prices[EUR]")).sendKeys("24567");
            driver.manage().timeouts().implicitlyWait(5,TimeUnit.MILLISECONDS);
            driver.findElement(By.name("save")).click();

            for (int second = 0;; second++) {
                if (second >= 60) fail("timeout");
                try { if (isElementPresent(By.name("save"))) break;
                } catch (Exception e) {}
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


