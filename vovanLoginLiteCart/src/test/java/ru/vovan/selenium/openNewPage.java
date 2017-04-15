package ru.vovan.selenium;

/**
 * Created by Vladimir on 15-Apr-17.
 */
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

import static org.junit.Assert.fail;

public class openNewPage {
    public WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
    }

    @Test
    public void someSimpleTest() throws InterruptedException {

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
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");

        String originalWindow = driver.getWindowHandle();
        final Set<String> oldWindowsSet = driver.getWindowHandles();
        driver.findElement(By.xpath("(//li[@id='app-']/a/span[2])[3]")).click();
        driver.findElement(By.linkText("Afghanistan")).click();
        driver.findElement(By.cssSelector("i.fa.fa-external-link")).click();
        //узнаю данные нового окна

        String newWindow = (new WebDriverWait(driver, 30))
                .until((ExpectedCondition<String>) driver -> {
                    Set<String> newWindowsSet = driver.getWindowHandles();
                    newWindowsSet.removeAll(oldWindowsSet);
                    return newWindowsSet.size() > 0 ?
                            newWindowsSet.iterator().next() : null;
                }
                );

        driver.switchTo().window(newWindow);


        System.out.println("New window title: " + driver.getTitle());
        driver.close();

        driver.switchTo().window(originalWindow);
        System.out.println("Old window title: " + driver.getTitle());

// открываем следующую ссылку
        driver.findElement(By.xpath("//td[@id='content']/form/table/tbody/tr[3]/td/a/i")).click();
        String newWindow2 = (new WebDriverWait(driver, 30))
                .until((ExpectedCondition<String>) driver -> {
                            Set<String> newWindowsSet = driver.getWindowHandles();
                            newWindowsSet.removeAll(oldWindowsSet);
                            return newWindowsSet.size() > 0 ?
                                    newWindowsSet.iterator().next() : null;
        }
                );
        driver.switchTo().window(newWindow2);
        System.out.println("New window2 title: " + driver.getTitle());
        driver.close();

        driver.switchTo().window(originalWindow);

        //и т.д.
        driver.findElement(By.xpath("//td[@id='content']/form/table/tbody/tr[6]/td/a/i")).click();
        String newWindow3 = (new WebDriverWait(driver, 30))
                .until((ExpectedCondition<String>) driver -> {
                            Set<String> newWindowsSet = driver.getWindowHandles();
                            newWindowsSet.removeAll(oldWindowsSet);
                            return newWindowsSet.size() > 0 ?
                                    newWindowsSet.iterator().next() : null;
                        }
                );
        driver.switchTo().window(newWindow3);
        System.out.println("New window3 title: " + driver.getTitle());
        driver.close();
        driver.switchTo().window(originalWindow);


        driver.findElement(By.xpath("//td[@id='content']/form/table/tbody/tr[7]/td/a[2]/i")).click();
        String newWindow4 = (new WebDriverWait(driver, 30))
                .until((ExpectedCondition<String>) driver -> {
                            Set<String> newWindowsSet = driver.getWindowHandles();
                            newWindowsSet.removeAll(oldWindowsSet);
                            return newWindowsSet.size() > 0 ?
                                    newWindowsSet.iterator().next() : null;
                        }
                );
        driver.switchTo().window(newWindow4);
        System.out.println("New window4 title: " + driver.getTitle());
        driver.close();
        driver.switchTo().window(originalWindow);

        driver.findElement(By.xpath("//td[@id='content']/form/table/tbody/tr[8]/td/a/i")).click();
        String newWindow5 = (new WebDriverWait(driver, 30))
                .until((ExpectedCondition<String>) driver -> {
                            Set<String> newWindowsSet = driver.getWindowHandles();
                            newWindowsSet.removeAll(oldWindowsSet);
                            return newWindowsSet.size() > 0 ?
                                    newWindowsSet.iterator().next() : null;
                        }
                );
        driver.switchTo().window(newWindow5);
        System.out.println("New window5 title: " + driver.getTitle());
        driver.close();
        driver.switchTo().window(originalWindow);

        driver.findElement(By.xpath("//td[@id='content']/form/table/tbody/tr[9]/td/a/i")).click();
        String newWindow6 = (new WebDriverWait(driver, 30))
                .until((ExpectedCondition<String>) driver -> {
                            Set<String> newWindowsSet = driver.getWindowHandles();
                            newWindowsSet.removeAll(oldWindowsSet);
                            return newWindowsSet.size() > 0 ?
                                    newWindowsSet.iterator().next() : null;
                        }
                );
        driver.switchTo().window(newWindow6);
        System.out.println("New window6 title: " + driver.getTitle());
        driver.close();
        driver.switchTo().window(originalWindow);

        driver.findElement(By.xpath("//td[@id='content']/form/table/tbody/tr[10]/td/a")).click();
        String newWindow7 = (new WebDriverWait(driver, 30))
                .until((ExpectedCondition<String>) driver -> {
                            Set<String> newWindowsSet = driver.getWindowHandles();
                            newWindowsSet.removeAll(oldWindowsSet);
                            return newWindowsSet.size() > 0 ?
                                    newWindowsSet.iterator().next() : null;
                        }
                );
        driver.switchTo().window(newWindow7);
        System.out.println("New window7 title: " + driver.getTitle());
        driver.close();
        driver.switchTo().window(originalWindow);
        //показываю что в ходе путешествий возвращаюсь домой на главную страницу
        System.out.println("Old window title: " + driver.getTitle());



    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}