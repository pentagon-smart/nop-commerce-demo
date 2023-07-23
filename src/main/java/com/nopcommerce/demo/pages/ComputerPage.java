package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ComputerPage extends Utility {
    //Comuters text, DesktopsLink, NotebooksLink, SoftwareLink Locators
    //  and create appropriate methods for it.

    @CacheLookup
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']")
    WebElement computerText;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Desktops']")
    WebElement desktop;

    public String getComputerText(){
        return getTextFromElement(computerText);
    }
    public void mouseHoverAndClickOnDesktopMenu(){
        mouseHoverTwo(computerText,desktop);
    }


}
