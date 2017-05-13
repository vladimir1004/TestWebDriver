package com.telran.pages;

import org.junit.Before;
import org.openqa.selenium.WebDriver;

/**
 * Sample page
 */
public class HomePage extends Page {


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
