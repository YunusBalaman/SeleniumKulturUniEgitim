package edu.kultur.selenium.locators;

import org.openqa.selenium.By;

public interface ILoginPage {

    By email = By.id("ap_email_login");
    By continueButton = By.id("continue");
    By password = By.id("ap_password");
    By signInButton = By.id("signInSubmit");
}
