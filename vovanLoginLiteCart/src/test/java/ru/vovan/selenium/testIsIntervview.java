package ru.vovan.selenium;

import org.junit.*;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class testIsIntervview {
    List list = new ArrayList<String>();
    WebDriver driver;


    @BeforeClass
    public static void fool(){
        System.out.println("fool");

    }

    @AfterClass
    public static void foo2(){
        System.out.println("foo2");
    }
    @Before
    public void setUp(){
        System.out.println("setUp");
    }



    @After
    public void tearDown(){
        System.out.println("tearDown");
    }
    @Test
    public void testListEmpty(){
       assertTrue(list.isEmpty());
               System.out.println("test ListISEmpty");
    }




}
