package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.BuildYourOwnComputerPage;
import com.nopcommerce.demo.pages.ComputerPage;
import com.nopcommerce.demo.pages.DesktopsPage;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import resources.testdata.TestData;


@Listeners(CustomListeners.class)
public class ComputerPageTest extends BaseTest {


    ComputerPage computerPage;
    HomePage homePage;
    DesktopsPage desktopsPage;
    BuildYourOwnComputerPage buildYourOwnComputerPage;

    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod(alwaysRun = true)
    public void inIT(){
        computerPage = new ComputerPage();
        homePage = new HomePage();
        desktopsPage = new DesktopsPage();
        buildYourOwnComputerPage = new BuildYourOwnComputerPage();
    }

    @Test
    public void verifyUserShouldNavigateToComputerPageSuccessfully(){
        //Click on Computer tab
        homePage.clickOnMenu("Computer");
        //   Verify "Computer" text
        softAssert.assertEquals(computerPage.getComputerText(),"Computers","Computer text not found");
        softAssert.assertAll();
    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully(){
        //Click on Computer tab
        homePage.clickOnMenu("Computer");
        //   Click on Desktops link
        computerPage.mouseHoverAndClickOnDesktopMenu();
        //   Verify "Desktops" text
        softAssert.assertEquals(desktopsPage.getDesktopsText(),"Desktops","Desktop text not found");
        softAssert.assertAll();
    }

    @Test(dataProvider = "datails", dataProviderClass = TestData.class)
    public void  VerifyThatUserShouldBuildYouOwnComputerAndAddThemToCartSuccessfully(String processor, String ram,
                                                                                     String hdd, String os, String software){
    // Click on Computer tab
        homePage.clickOnMenu("Computer");
        //   Click on Desktops link
        computerPage.mouseHoverAndClickOnDesktopMenu();
        //   Click on product name "Build your own computer"
        buildYourOwnComputerPage.clickOnBuildYourOwnComputer();

        //   Select processor "processor"
        buildYourOwnComputerPage.selectProcessor(processor);
        //   Select RAM "ram"
        buildYourOwnComputerPage.selectRam(ram);
        //   Select HDD "hdd"
        buildYourOwnComputerPage.selectHDD(hdd);
        //   Select OS "os"
        buildYourOwnComputerPage.selectOs(os);
        //   Select Software "software"
        buildYourOwnComputerPage.clickOnTotalCommander(software);

        //   Click on "ADD TO CART" Button
        buildYourOwnComputerPage.clickOnAddToCartLink();
        //   Verify message "The product has been added to your shopping cart"

        softAssert.assertEquals(buildYourOwnComputerPage.getProductMessage(),"The product has been added to your shopping cart","Expected text not found");
        softAssert.assertAll();
    }
}
