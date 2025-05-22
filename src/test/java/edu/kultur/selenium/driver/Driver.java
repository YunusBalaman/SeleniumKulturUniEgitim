package edu.kultur.selenium.driver;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Driver {

    public static String browser = "chrome";

    public static WebDriver driver;

    @BeforeAll
    public static void beforeAll(){


    }

    @BeforeEach
    public void before(){

        switch (browser){
            case "chrome":
                driver = getChromeDriver();
                break;
            case "firefox":
                break;
            case "edge":
                break;
            default:
                Assertions.fail("browser hatalı");
        }

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

    public WebDriver getChromeDriver(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features");
        options.addArguments("--disable-blink-features=AutomationControlled");
        // options.addArguments("disable-extensions");
        options.addArguments("disable-translate");
        options.addArguments("disable-plugins");
        options.addArguments("--disable-notifications");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-popup-blocking");
        options.setExperimentalOption("excludeSwitches", List.of("enable-automation"));
        options.setExperimentalOption("useAutomationExtension",false);
        options.addArguments("--start-maximized");
        options.addArguments("--disable-web-security");
        options.addArguments("--no-proxy-server");
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        // prefs.put("intl.accept_languages", "en-GB");
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--remote-allow-origins=*");
        //options.addArguments("--headless=new");
        //options.addArguments("--app=https://www.google.com");
        //options.addArguments("--kiosk");
        //options.addArguments("--incognito");
        //   options.addArguments("--remote-debugging-port=9222");
        //   options.addArguments("--remote-debugging-address=127.0.0.1");
        return new ChromeDriver(options);
    }

}
