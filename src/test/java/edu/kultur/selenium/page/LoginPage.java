package edu.kultur.selenium.page;


import edu.kultur.selenium.locators.ILoginPage;
import edu.kultur.selenium.methods.Methods;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPage {

    Methods methods;

    public LoginPage(){

        methods = new Methods();
    }

    public void loginPageControl(){

        assertTrue(methods.isElementVisible(ILoginPage.email,10));
        assertTrue(methods.isElementVisible(ILoginPage.continueButton,10));
        Assertions.assertTrue(methods.getCurrentUrl().startsWith("https://www.amazon.com.tr/ap/signin"), "");
    }

    public void signInEmail(String email){

        methods.sendKeys(ILoginPage.email, email);
        assertTrue(methods.isElementClickable(ILoginPage.continueButton,10));
        methods.click(ILoginPage.continueButton);
    }

    public void signInPassword(String password){

        assertTrue(methods.isElementVisible(ILoginPage.password,10));
        assertTrue(methods.isElementVisible(ILoginPage.signInButton,10));
        methods.sendKeys(ILoginPage.password, password);
        assertTrue(methods.isElementClickable(ILoginPage.signInButton,10));
        methods.click(ILoginPage.signInButton);
        methods.waitBySeconds(3);
    }



}
