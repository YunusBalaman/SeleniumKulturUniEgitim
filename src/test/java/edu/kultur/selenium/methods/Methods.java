package edu.kultur.selenium.methods;

import edu.kultur.selenium.driver.Driver;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class Methods {

    WebDriver driver;
    FluentWait<WebDriver> fluentWait;
    long timeout = 10;
    long pollingEvery = 450;
    JavascriptExecutor jsDriver;

    public Methods(){

        this.driver = Driver.driver;
        fluentWait = setFluentWait(timeout, pollingEvery);
        jsDriver = (JavascriptExecutor) driver;
    }

    public FluentWait<WebDriver> setFluentWait(long timeout, long pollingEvery){

        return new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofMillis(pollingEvery))
                .ignoring(NoSuchElementException.class);
    }

    // id   name  class  cssSelector  xpath.txt

    public WebElement findElement(By by){

        return driver.findElement(by);
    }

    public WebElement findElementWait(By by){

        return fluentWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void click(By by){

        findElementWait(by).click();
    }

    public void sendKeys(By by, String text){

        findElementWait(by).sendKeys(text);
    }

    public String getText(By by){

       return findElementWait(by).getText();
    }

    public String getAttribute(By by, String attribute){

        return findElementWait(by).getDomAttribute(attribute);
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

    public String getCurrentUrl(){

        return driver.getCurrentUrl();
    }

    public void hoverElement(By by) {

        //new Actions(driver).keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
        WebElement webElement = findElementWait(by);
        new Actions(driver).moveToElement(webElement).build().perform();
    }

    public boolean isElementVisible(By by, long timeout){

        try {
            setFluentWait(timeout, pollingEvery).until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean isElementClickable(By by, long timeout){

        try {
            setFluentWait(timeout, pollingEvery).until(ExpectedConditions.elementToBeClickable(by));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public void scrollElement(WebElement webElement){

        jsDriver.executeScript("arguments[0].scrollIntoView();", webElement);
    }

    public void scrollIntoViewIfNeeded(WebElement webElement){

        jsDriver.executeScript("arguments[0].scrollIntoViewIfNeeded();", webElement);
    }

    public void scrollElementCenter(WebElement webElement){

        jsDriver.executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'});",
                webElement);
    }

    public void scrollPage(int scrollY){

        jsDriver.executeScript("window.scrollBy(0," + scrollY + ")");
    }

    public void clickByCoordinate(int x, int y){

        jsDriver.executeScript("document.elementFromPoint("+ x + "," + y +").click();");
    }

    public void clickByWebElementCoordinate(WebElement webElement){

        jsDriver.executeScript("var element = arguments[0];" +
                "var box = element.getBoundingClientRect();\n" +
                "var clientX = box.left + (box.width / 2);\n" +
                "var clientY = box.top + (box.height / 2);" +
                "document.elementFromPoint(clientX,clientY).click();", webElement);
    }

    public void clickByWebElementCoordinate(WebElement webElement, int x, int y){
        jsDriver.executeScript("var element = arguments[0];" +
                "var box = element.getBoundingClientRect();\n" +
                "var clientX = box.left + ((box.width * " + x + ") / 100);\n" +
                "var clientY = box.top + ((box.height * " + y + ") / 100);" +
                "document.elementFromPoint(clientX,clientY).click();", webElement);
    }

    public void clickByElement(WebElement webElement){

        jsDriver.executeScript("arguments[0].click();", webElement);
    }

    public Object getValue(WebElement webElement){

        String script = "return arguments[0].value;";
        return jsDriver.executeScript(script,webElement);
    }

    public void focusElement(WebElement webElement){

        jsDriver.executeScript("arguments[0].focus();", webElement);
    }

    public void mouseOver(WebElement webElement){

        jsDriver.executeScript("var evObj = document.createEvent('MouseEvents');"
                + "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
                + "arguments[0].dispatchEvent(evObj);", webElement);
    }

    public void mouseOut(WebElement webElement){

        jsDriver.executeScript("var evObj = document.createEvent('MouseEvents');"
                + "evObj.initMouseEvent(\"mouseout\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
                + "arguments[0].dispatchEvent(evObj);", webElement);
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
            case "xpath.txt":
                by = By.xpath(value);
                break;
            default:
                Assertions.fail(type + " element tipi hatalı");
        }
        return by;
    }



}
