package ru.vovan.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.fail;
// большое спасибо хочется сказать разаработчикам Selenium IDE  за их супер программу!!!!!!!

public class MyFirstTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start(){
        driver = new EdgeDriver();
        //wait = new WebDriverWait(driver, 10);
    }



    @Test
    public void myFirstTest() throws InterruptedException {
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
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @After
    public void stop(){
        driver.quit();
        driver=null;
    }
}