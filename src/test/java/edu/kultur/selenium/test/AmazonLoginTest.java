package edu.kultur.selenium.test;

import edu.kultur.selenium.driver.Driver;
import edu.kultur.selenium.page.HomePage;
import edu.kultur.selenium.page.LoginPage;
import org.junit.jupiter.api.Test;

public class AmazonLoginTest extends Driver {



    @Test
    public void loginTest(){

        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        homePage.homePageControl();
        homePage.acceptCookie();
        homePage.hoverAccount();
        homePage.clickSignIn();
        loginPage.loginPageControl();
        loginPage.signInEmail("amazonAccountEmail");
        loginPage.signInPassword("Password");
    }


}
