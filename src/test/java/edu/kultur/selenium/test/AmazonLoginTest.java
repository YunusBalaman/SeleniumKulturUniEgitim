package edu.kultur.selenium.test;

import edu.kultur.selenium.driver.Driver;
import edu.kultur.selenium.page.HomePage;
import org.junit.jupiter.api.Test;

public class AmazonLoginTest extends Driver {



    @Test
    public void loginTest(){

        HomePage homePage = new HomePage();
        homePage.homePageControl();
        homePage.acceptCookie();
        homePage.hoverAccount();
    }


}
