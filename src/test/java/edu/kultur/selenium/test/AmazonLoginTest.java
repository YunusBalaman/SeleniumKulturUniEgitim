package edu.kultur.selenium.test;

import edu.kultur.selenium.driver.Driver;
import edu.kultur.selenium.page.HomePage;
import edu.kultur.selenium.page.LoginPage;
import edu.kultur.selenium.page.ProductPage;
import org.junit.jupiter.api.Test;

public class AmazonLoginTest extends Driver {

    HomePage homePage;
    LoginPage loginPage;
    ProductPage productPage;

    @Test
    public void loginTest(){

        page();
        homePage.homePageControlWithoutLogin()
                .acceptCookie() //
                .hoverAccount() //
                .clickSignIn(); //
        loginPage.loginPageControl();
        loginPage.signInEmail("email");
        loginPage.signInPassword("password");
        homePage.homePageControl()
                .usernameControl("username")
                .searchProduct("iphone")
                .clickProduct(); //
        productPage.productPageControl();
        System.out.println(productPage.getProductTitle());
        System.out.println(productPage.getProductPrice());
    }

    public void page(){

        homePage = new HomePage();
        loginPage = new LoginPage();
        productPage = new ProductPage();
    }


}
