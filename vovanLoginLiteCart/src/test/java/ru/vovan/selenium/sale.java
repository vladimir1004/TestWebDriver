package ru.vovan.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static jdk.nashorn.internal.objects.ArrayBufferView.length;
import static org.junit.Assert.fail;

public class sale extends hz {
    private WebDriver driver;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private String baseUrl;

    @Before
    public void setUp() throws Exception {
        //driver = new FirefoxDriver();
        driver = new ChromeDriver();
        //driver = new EdgeDriver();

       //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void testSale() throws Exception {
        driver.get("http://localhost/litecart/en/");
        for (int second = 0; ; second++) {
            if (second >= 60) fail("timeout");
            try {
                if (isElementPresent(By.cssSelector("#logotype-wrapper>a>img"))) break;
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }

            WebElement blueDuck= driver.findElement(By.xpath("//a[@title='Blue Duck']//*[@class='sticker new']"));
            assert length(By.xpath("//a[@title='Blue Duck']//*[@class='sticker new']")) == 1;

            WebElement yellowDuck = driver.findElement(By.xpath("//a[@title='Yellow Duck']//*[@class='sticker sale']"));
            assert length(yellowDuck) == 1;


            WebElement grenDuck = driver.findElement(By.xpath("//a[@title='Green Duck']//*[@class='sticker new']"));
            assert length(grenDuck) == 1;

            WebElement redDuck = driver.findElement(By.xpath("//a[@title='Red Duck']//*[@class='sticker new']"));
            assert length(redDuck) == 1;

            WebElement purpleDuck = driver.findElement(By.xpath("//a[@title='Purple Duck']//*[@class='sticker new']"));
            assert length(purpleDuck) == 1;
            WebElement login= driver.findElement(By.cssSelector("name=login"));
            login.getAttribute("value");
                }

        @After
        public void tearDown () throws Exception {
            driver.quit();
            String verificationErrorString = verificationErrors.toString();
            if (!"".equals(verificationErrorString)) {
                fail(verificationErrorString);
            }
        }
    }




