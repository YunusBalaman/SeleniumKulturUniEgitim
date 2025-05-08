package edu.kultur.selenium.methods;

import edu.kultur.selenium.driver.Driver;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class Methods {

    WebDriver driver;
    FluentWait<WebDriver> fluentWait;
    long timeout = 10;
    long pollingEvery = 450;


    public Methods(){

        this.driver = Driver.driver;
        fluentWait = setFluentWait(timeout, pollingEvery);
    }

    public FluentWait<WebDriver> setFluentWait(long timeout, long pollingEvery){

        return new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofMillis(pollingEvery))
                .ignoring(NoSuchElementException.class);
    }

    // id   name  class  cssSelector  xpath

    public WebElement findElement(String type, String value){

        By by = getBy(type, value);
        return driver.findElement(by);
    }

    public WebElement findElementWait(String type, String value){

        By by = getBy(type, value);
        return fluentWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void click(String type, String value){

        findElementWait(type, value).click();;
    }

    public void sendKeys(String type, String value, String text){

        findElementWait(type, value).sendKeys(text);
    }

    public String getText(String type, String value){

       return findElementWait(type, value).getText();
    }

    public String getAttribute(String type, String value, String attribute){

        return findElementWait(type, value).getDomAttribute(attribute);
    }

    public void navigateBack(){

        driver.navigate().back();
    }

    public void navigateForward(){

        driver.navigate().forward();
    }

    public void navigateTo(String url){

        driver.navigate().to(url);
    }

    public void hoverElement(String type, String value) {

        WebElement webElement = findElementWait(type, value);
        new Actions(driver).moveToElement(webElement).build().perform();
    }

    public boolean isElementVisible(String type, String value, long timeout){

        By by = getBy(type, value);
        try {
            setFluentWait(timeout, pollingEvery).until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean isElementClickable(String type, String value, long timeout){

        By by = getBy(type, value);
        try {
            setFluentWait(timeout, pollingEvery).until(ExpectedConditions.elementToBeClickable(by));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public void waitBySeconds(long seconds){

        waitByMilliseconds(seconds * 1000);
    }

    public void waitByMilliseconds(long timeMillis){

        try {
            Thread.sleep(timeMillis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public By getBy(String type, String value){

        By by = null;
        switch (type){
            case "id":
                by = By.id(value);
                break;
            case "name":
                by = By.name(value);
                break;
            case "class":
                by = By.className(value);
                break;
            case "css":
                by = By.cssSelector(value);
                break;
            case "xpath":
                by = By.xpath(value);
                break;
            default:
                Assertions.fail(type + " element tipi hatalı");
        }
        return by;
    }


}
