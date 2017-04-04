package ru.vovan.selenium;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class newPrise {
    private WebDriver driver;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private String baseUrl;

    @Before
    public void setUp() {//throws Exception {
        //driver = new FirefoxDriver();
        driver = new ChromeDriver();
        //driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void newPriseTest() {
        driver.get("http://localhost/litecart/en/");
        //получаю атрибуты цены и цвет утки до открытия и расспечатываю
        WebElement sale1 = driver.findElement(By.cssSelector("strong.campaign-price"));

        String color1 = driver.findElement(By.cssSelector("strong.campaign-price")).getCssValue("color");
        System.out.println("color1=" + color1);

        sale1.getAttribute("outerText");
        System.out.println("sale1="+  sale1.getAttribute("outerText"));

        WebElement oldSale1 =driver.findElement(By.cssSelector("s.regular-price"));
        oldSale1.getAttribute("outerText");
        System.out.println("oldSale1=" + oldSale1.getAttribute("outerText"));

        WebElement nameSale1= driver.findElement(By.xpath(".//*[@id='box-campaigns']/div/ul/li/a[1]/div[2]"));
        nameSale1.getAttribute("textContent");
        System.out.println("nameSale1=" + nameSale1.getAttribute("outerText"));

        driver.findElement(By.xpath(".//*[@id='box-campaigns']/div/ul/li/a[1]/div[2]")).click();

        //получаю атрибуты и цвет утки после открытия товара
        WebElement sale2 = driver.findElement(By.cssSelector("strong.campaign-price"));
        sale2.getAttribute("outerText");
        System.out.println("sale2=" + sale2.getAttribute("outerText"));

        String color2 = driver.findElement(By.cssSelector("strong.campaign-price")).getCssValue("color");
        System.out.println("color2=" + color2);

        WebElement oldSale2=driver.findElement(By.cssSelector("s.regular-price"));
        oldSale2.getAttribute("outerText");
        System.out.println("oldSale2=" + oldSale2.getAttribute("outerText"));

        WebElement nameSale2= driver.findElement(By.xpath(".//*[@id='box-product']/div[1]/h1"));
        nameSale2.getAttribute("textContent");
        System.out.println("nameSale2=" + nameSale2.getAttribute("textContent"));

//согласно проведенным тестам все ок!!!!!!!



    }


    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
       if (!"".equals(verificationErrorString)) {
         fail(verificationErrorString);
       }
    }
}

