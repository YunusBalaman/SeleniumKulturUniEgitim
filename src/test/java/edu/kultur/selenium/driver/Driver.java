package edu.kultur.selenium.driver;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

    public static WebDriver driver;

    @BeforeAll
    public static void beforeAll(){


    }

    @BeforeEach
    public void before(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com.tr/");
    }

    @AfterEach
    public void after(){

        if (driver != null) {
            driver.quit();
        }
    }

    @AfterAll
    public static void afterAll(){


    }

}
