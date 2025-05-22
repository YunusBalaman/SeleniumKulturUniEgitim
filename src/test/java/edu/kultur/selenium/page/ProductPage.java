package edu.kultur.selenium.page;

import edu.kultur.selenium.locators.IHomePage;
import edu.kultur.selenium.locators.IProductPage;
import edu.kultur.selenium.methods.Methods;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductPage {

    Methods methods;

    public ProductPage(){

        methods = new Methods();
    }

    public void productPageControl(){

        assertTrue(methods.isElementVisible(IProductPage.productTitle,10));
        assertTrue(methods.isElementVisible(IProductPage.productPrice,10));
    }

    public String getProductTitle(){

        return methods.getText(IProductPage.productTitle);
    }

    public String getProductPrice(){

        return methods.getText(IProductPage.productPrice);
    }
}
