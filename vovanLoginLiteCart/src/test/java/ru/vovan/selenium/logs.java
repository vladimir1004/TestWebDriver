package ru.vovan.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.fail;


public class logs {
    private WebDriver driver;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private String baseUrl;
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());


    @Before
    public void setUp()  {
        //performance for log
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
        cap.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);

        //driver = new FirefoxDriver();
        driver = new ChromeDriver(cap);
        //driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


    }
    @Test
    public void logs1(){

        driver.get("http://localhost/litecart/admin/login.php?");
        //first variant
        System.out.println( driver.manage().logs().getAvailableLogTypes());
        driver.manage().logs().get("performance").forEach(l ->System.out.println(l) );
        //second variant
        //for (LogEntry l : driver.manage().logs().get("browser").getAll()) {
          //  System.out.println(l);
        }



    @Test
    public void logs()  {
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
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1)");
        driver.findElement(By.linkText("Blue Duck")).click();
        //запускаю разные логи
        Log.info("Go navigate new link " );
        System.out.println( driver.manage().logs().getAvailableLogTypes());
        driver.manage().logs().get("browser").forEach(l ->System.out.println(l) );
        driver.manage().logs().get("browser").filter(Level.ALL);
        System.out.println(driver.manage().logs().get("browser").filter(Level.ALL));

        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1)");

        driver.findElement(By.linkText("Green Duck")).click();
        Log.info("Open Gren Duck " );
        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1)");
        driver.findElement(By.linkText("Nikolay")).click();
        Log.info("Open Nikolay " );
        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1)");
        driver.findElement(By.linkText("Purple Duck")).click();
        Log.info("open Purple Duck " );
        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1)");
        driver.findElement(By.linkText("Yellow Duck")).click();
        Log.info("open Yellow Duck " );
        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1)");
    }


        @After
        public void tearDown () throws Exception {
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
    public static class LogLog4j {

// Initialize Log4j log s

        //  private static Logger Log = Logger.getLogger(LogLog4j.class.getName());//

        // This is to print log for the beginning of the test case, as we usually run so many test cases as a test suite

        public static void startTestCase(String sTestCaseName) {

            Log.info("****************************************************************************************");

            Log.info("****************************************************************************************");

            Log.info("$$$$$$$$$$$$$$$$$$$$$                 " + sTestCaseName + "       $$$$$$$$$$$$$$$$$$$$$$$$$");

            Log.info("****************************************************************************************");

            Log.info("****************************************************************************************");

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

