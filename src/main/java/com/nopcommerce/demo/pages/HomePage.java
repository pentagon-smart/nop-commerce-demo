package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends Utility {
    // All Menu (Seven menu), LoginLink, registerLink, nopcommerce logo, My account link and LogOut link locatores
    //  and create appropriate methods for it.

    @CacheLookup
    @FindBy(xpath = "//div[@class='header-menu']/child::ul[1]/li/a")
    List<WebElement> allMenu;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Register')]")
    WebElement registerButton;
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Register')]")
    WebElement verifyText;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Log in')]")
    WebElement loginLink;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Log out')]")
    WebElement actualLogoutLink;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Log out')]")
    WebElement clickLogoutBtn;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Log in')]")
    WebElement actualTextLoginLink;

    public void clickOnMenu(String menuText){
        for (WebElement menus : allMenu) {
        if (menus.getText().contains(menuText)) {
            clickOnElement(menus);
            break;
        }
    }
}
    public void clickOnRegisterButton(){
        clickOnElement(registerButton);
    }
    public String getText(){
        return getTextFromElement(verifyText);

    }
    public void clickOnLoginLink()
    {
        //Click on login link
        clickOnElement(loginLink);
    }
    public String verifyLogoutLinkText()
    {
        //Verify that LogOut link is display
        return getTextFromElement(actualLogoutLink);
    }
    public void clickOnLogoutLink()
    {
        //Click on LogOut Link
        clickOnElement(clickLogoutBtn);
    }
    public String verifyLoginLinkText()
    {
        //Verify that LogIn Link Display
        return getTextFromElement(actualTextLoginLink);
    }
}
