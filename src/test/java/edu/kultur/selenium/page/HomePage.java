package edu.kultur.selenium.page;

import edu.kultur.selenium.locators.IHomePage;
import edu.kultur.selenium.methods.Methods;
import static org.junit.jupiter.api.Assertions.*;

public class HomePage {

    Methods methods;

    public HomePage(){

        methods = new Methods();
    }

    public HomePage homePageControlWithoutLogin(){

        assertTrue(methods.isElementVisible(IHomePage.accountButton,10));
        assertTrue(methods.isElementVisible(IHomePage.location,10));
        assertTrue(methods.isElementVisible(IHomePage.searchTextbox,10));
        assertTrue(methods.isElementVisible(IHomePage.cart,10));
        assertTrue(methods.isElementVisible(IHomePage.orders,10));
        assertTrue(methods.isElementVisible(IHomePage.searchButton,10));
        return this;
    }

    public HomePage acceptCookie(){

        assertTrue(methods.isElementVisible(IHomePage.acceptCookies,10));
        assertTrue(methods.isElementClickable(IHomePage.acceptCookies,10));
        methods.click(IHomePage.acceptCookies);
        return this;
    }

    public HomePage hoverAccount(){

        assertTrue(methods.isElementClickable(IHomePage.accountButton,10));
        //methods.mouseOver(methods.findElement(IHomePage.accountButton));
        methods.hoverElement(IHomePage.accountButton);
        return this;
    }

    public HomePage clickSignIn(){

        assertTrue(methods.isElementVisible(IHomePage.signinButton,10));
        assertTrue(methods.isElementClickable(IHomePage.signinButton,10));
        methods.click(IHomePage.signinButton);
        return this;
    }

    public HomePage homePageControl(){

        assertTrue(methods.isElementVisible(IHomePage.username,10));
        assertTrue(methods.isElementVisible(IHomePage.location,10));
        assertTrue(methods.isElementVisible(IHomePage.searchTextbox,10));
        assertTrue(methods.isElementVisible(IHomePage.cart,10));
        assertTrue(methods.isElementVisible(IHomePage.orders,10));
        assertTrue(methods.isElementVisible(IHomePage.searchButton,10));
        return this;
    }

    public HomePage usernameControl(String username){

        assertEquals(username, methods.getText(IHomePage.username));
        return this;
    }

    public HomePage searchProduct(String productName){

        methods.sendKeys(IHomePage.searchTextbox, productName);
        methods.click(IHomePage.searchButton);
        return this;
    }

    public HomePage clickProduct(){

        assertTrue(methods.isElementVisible(IHomePage.product,10));
        assertTrue(methods.isElementClickable(IHomePage.product,10));
        methods.click(IHomePage.product);
        return this;
    }
}
