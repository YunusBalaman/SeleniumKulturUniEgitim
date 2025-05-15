package edu.kultur.selenium.locators;

import org.openqa.selenium.By;

public interface IHomePage {

    By accountButton = By.id("nav-link-accountList");
   // By acceptCookies = By.id("sp-cc-accept");
    By acceptCookies = By.xpath("//input[(@aria-label='Kabul et' or @aria-label='Accept') and contains(@class,'a-button-input')]/parent::span");
    By signinButton = By.className("nav-action-signin-button");
    By searchTextbox = By.id("twotabsearchtextbox");
    By location = By.id("nav-global-location-popover-link");
    By orders = By.id("nav-orders");
    By cart = By.id("nav-cart");
}
