package edu.kultur.selenium.page;

import edu.kultur.selenium.locators.IHomePage;
import edu.kultur.selenium.methods.Methods;
import static org.junit.jupiter.api.Assertions.*;

public class HomePage {

    Methods methods;

    public HomePage(){

        methods = new Methods();
    }

    public void homePageControl(){

        assertTrue(methods.isElementVisible(IHomePage.accountButton,10));
        assertTrue(methods.isElementVisible(IHomePage.location,10));
        assertTrue(methods.isElementVisible(IHomePage.searchTextbox,10));
        assertTrue(methods.isElementVisible(IHomePage.cart,10));
        assertTrue(methods.isElementVisible(IHomePage.orders,10));
    }

    public void acceptCookie(){

        assertTrue(methods.isElementVisible(IHomePage.acceptCookies,10));
        assertTrue(methods.isElementClickable(IHomePage.acceptCookies,10));
        methods.click(IHomePage.acceptCookies);
    }

    public void hoverAccount(){

        assertTrue(methods.isElementClickable(IHomePage.accountButton,10));
        methods.hoverElement(IHomePage.accountButton);
    }

    public void clickSignIn(){

        assertTrue(methods.isElementVisible(IHomePage.signinButton,10));
        assertTrue(methods.isElementClickable(IHomePage.signinButton,10));
        methods.click(IHomePage.signinButton);
    }
}
