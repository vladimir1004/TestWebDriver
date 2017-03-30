package ru.vovan.selenium;




import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;




    public class createAccount {
        private WebDriver driver;
        private String baseUrl;
        private boolean acceptNextAlert = true;
        private StringBuffer verificationErrors = new StringBuffer();

        @Before
        public void setUp() throws Exception {
            driver = new ChromeDriver();
            baseUrl = baseUrl;
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }

        @Test
        public void testCreateAccount() throws Exception {
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
            driver.get("http://localhost/litecart/en/");
            driver.findElement(By.linkText("New customers click here")).click();
            driver.findElement(By.name("tax_id")).clear();
            driver.findElement(By.name("tax_id")).sendKeys("1234567");
            driver.findElement(By.name("company")).clear();
            driver.findElement(By.name("company")).sendKeys("Las Vegas");
            driver.findElement(By.name("firstname")).clear();
            driver.findElement(By.name("firstname")).sendKeys("Vladimir");
            driver.findElement(By.name("lastname")).clear();
            driver.findElement(By.name("lastname")).sendKeys("Karakis");
            driver.findElement(By.name("address1")).clear();
            driver.findElement(By.name("address1")).sendKeys("Roberto Badgo");
            driver.findElement(By.name("address2")).clear();
            driver.findElement(By.name("address2")).sendKeys("Lunacharskogo");
            driver.findElement(By.name("postcode")).clear();
            driver.findElement(By.name("postcode")).sendKeys("76543210");
            driver.findElement(By.name("postcode")).clear();
            driver.findElement(By.name("postcode")).sendKeys("7654321");
            driver.findElement(By.name("postcode")).clear();
            driver.findElement(By.name("postcode")).sendKeys("765432");
            driver.findElement(By.name("postcode")).clear();
            driver.findElement(By.name("postcode")).sendKeys("76543");
            driver.findElement(By.name("city")).clear();
            driver.findElement(By.name("city")).sendKeys("Las Vegas");
            driver.findElement(By.xpath("//*[@id='create-account']/div/form/table/tbody/tr[5]/td[1]/span[2]/span[1]/span/span[2]")).click();
            driver.findElement(By.className("select2-search__field")).sendKeys("United States"+ Keys.ENTER);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            new Select(driver.findElement(By.cssSelector("select[name=\"zone_code\"]"))).selectByVisibleText("Texas");
            driver.findElement(By.name("email")).clear();
            driver.findElement(By.name("email")).sendKeys("0975059299v@gmail.com");
            driver.findElement(By.name("phone")).clear();
            driver.findElement(By.name("phone")).sendKeys("+972542251200");
            driver.findElement(By.name("password")).clear();
            driver.findElement(By.name("password")).sendKeys("54321");
            driver.findElement(By.name("confirmed_password")).clear();
            driver.findElement(By.name("confirmed_password")).sendKeys("54321");
            driver.findElement(By.name("accept_cookies")).click();
            driver.findElement(By.name("create_account")).click();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.findElement(By.linkText("Logout")).click();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.findElement(By.name("email")).clear();
            driver.findElement(By.name("email")).sendKeys("0975059299v@gmail.com");
            driver.findElement(By.name("password")).clear();
            driver.findElement(By.name("password")).sendKeys("54321");
            driver.findElement(By.name("login")).click();
            driver.findElement(By.linkText("Logout")).click();
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


