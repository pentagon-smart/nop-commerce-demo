package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class BuildYourOwnComputerPage extends Utility {
    //Build your own computer Text, Processor Drop Down, Ram drop down,
    //  HDD radios, os radio, software check boxes, Add To Card button, "The product has been added to your shopping cart"
    //  message locators and it's actions

    @CacheLookup
    @FindBy(xpath = "//h2[@class='product-title']//a[normalize-space()='Build your own computer']")
    WebElement buildYourOwnComputer;

    @CacheLookup
    @FindBy(xpath = "//select[@id='product_attribute_1']")
    WebElement processor;
    @CacheLookup
    @FindBy(xpath = "//select[@id='product_attribute_2']")
    WebElement ram;
    @CacheLookup
    @FindBy(xpath = "//input[@id='product_attribute_3_7']")
    WebElement hdd;
    @CacheLookup
    @FindBy(xpath = "//input[@id='product_attribute_4_9']")
    WebElement os;
    @CacheLookup
    @FindBy(xpath = "//label[contains(text(),'Total Commander [+$5.00]')]")
    WebElement totalCommander;
    @CacheLookup
    @FindBy(xpath = "//button[@id='add-to-cart-button-1']")
    WebElement addToCartLink;
    @CacheLookup
    @FindBy(xpath = "//p[@class='content']")
    WebElement productMessage;

    public void clickOnBuildYourOwnComputer(){
        clickOnElement(buildYourOwnComputer);
    }
    public void selectProcessor(String value){
        selectByValueFromDropDown(processor, value);
    }
    public void selectRam(String value){
        selectByValueFromDropDown(ram,value);
    }

    public void selectHDD(String text){
        clickOnElement1(hdd,text);
    }
    public void selectOs(String text){
        clickOnElement1(os,text);
    }
    public void clickOnTotalCommander(String text){
        clickOnElement1(totalCommander,text);
    }
    public void clickOnAddToCartLink(){
        clickOnElement(addToCartLink);
    }
    public String getProductMessage(){
        return getTextFromElement(productMessage);

    }
}
