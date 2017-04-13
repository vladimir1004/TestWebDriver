package ru.vovan.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

//import java.lang.Object executeScript(java.lang.String script,
//      java.lang.Object... args);


public class countryNewWindows {
    private WebDriver driver;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private String baseUrl;


   // private final Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);




    @Before
    public void setUp() throws Exception {
        //driver = new FirefoxDriver();
        driver = new ChromeDriver();
        //driver = new EdgeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10/*seconds*/);

      //WebElement element = wait.until(ExpectedCondition.presenceOfElementLocated(By.name("q")));
        WebElement element2 = wait.until((WebDriver d) -> d.findElement(By.name("q")));

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


    }


    @Test
    public void widowsCountry() throws InterruptedException {
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

        //иду на страницу Country
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.xpath(".//*[@id='content']/form/table/tbody/tr[2]/td[7]/a/i")).click();
        driver.findElement(By.xpath(".//*[@id='content']/form/table[1]/tbody/tr[2]/td/a/i")).click();


        // Получаем список открытых окон и расспечатываем
               System.out.println("old Window =" + driver.getWindowHandle());
        driver.getCurrentUrl();
               System.out.println("currentWindow =" + driver.getCurrentUrl());

               //открываем новое окно с помощью executeScript

        ((JavascriptExecutor) driver).executeScript("window.open()");

       // расспечатываем количество окон открытых

        System.out.println("how many windows =" + driver.getWindowHandles());
        String originalWindow = driver.getWindowHandle();
       // String newWindoe =  driver.get("https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2");
        //WebElement newWindow = driver.findElement(By.linkText("https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2"));
        //driver.switchTo().window(driver.getWindowHandles([1]);
        driver.get("https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2");
        System.out.println("currentWindow New  =" + driver.getCurrentUrl());

       // wait(driver.get("http://localhost/litecart/admin/?app=countries&doc=countries")),10);


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

   /** private java.lang.String closeAlertAndGetItsText() {
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
    }*/


    public void waitUntilIsLoadedCustomTime(WebElement element, int time) {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }

