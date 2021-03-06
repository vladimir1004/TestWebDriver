package ru.vovan.selenium;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class MyFirstTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start(){
        driver = new FirefoxDriver();
        //driver = new ChromeDriver();
        System.out.println(((HasCapabilities) driver) .getCapabilities());
        wait = new WebDriverWait(driver, 5);

    }

    @Test
    public void myFirstTest(){
        driver.get("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("rozetka.ua");
        driver.findElement(By.name("btnG")).click();
        wait.until(titleIs("rozetka.ua - Поиск в Google"));

    }

    @After
    public void stop(){
        driver.quit();
        driver=null;
    }
}