package edu.kultur.selenium.page;

import edu.kultur.selenium.methods.Methods;
import static org.junit.jupiter.api.Assertions.*;

public class HomePage {

    Methods methods;

    public HomePage(){

        methods = new Methods();
    }

    public void homePageControl(){

        assertTrue(methods.isElementVisible("id","nav-link-accountList",10));
        assertTrue(methods.isElementVisible("id","sp-cc-accept",10));
    }

    public void acceptCookie(){

        assertTrue(methods.isElementClickable("id","sp-cc-accept",10));
        methods.waitBySeconds(2);
        methods.click("id","sp-cc-accept");
    }

    public void hoverAccount(){

        assertTrue(methods.isElementClickable("id","nav-link-accountList",10));
        methods.hoverElement("id","nav-link-accountList");
        methods.waitBySeconds(5);
    }
}
