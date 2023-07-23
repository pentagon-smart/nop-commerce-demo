package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class RegisterPageTest extends BaseTest {

    HomePage homePage;
    RegisterPage registerPage;
    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod(alwaysRun = true)
    public void inIT(){

        homePage = new HomePage();
        registerPage= new RegisterPage();

    }

    public void verifyUserShouldNavigateToRegisterPageSuccessfully(){
        // Click on Register Link
        homePage.clickOnRegisterButton();

        //   Verify "Register" text
        softAssert.assertEquals(homePage.getText(),"Register","Register is not displayed");
    }
    public void verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory(){
        //Click on Register Link
        homePage.clickOnRegisterButton();

        //Click on "REGISTER" button
        registerPage.clickOnRegisterButton();

        //Verify the error message "First name is required."
        softAssert.assertEquals(registerPage.verifyTextFirstName(),"First name is required.","First name text not found");

        //Verify the error message "Last name is required."
        softAssert.assertEquals(registerPage.verifyTextLastName(),"Last name is required.","Last name required message not found");

        //Verify the error message "Email is required."
        softAssert.assertEquals(registerPage.verifyTextEmail(),"Email is required.","Email required message not display");

        //Verify the error message "Password is required."
        softAssert.assertEquals(registerPage.verifyTextPassword(),"Password is required.","Password required message not found");

        //Verify the error message "Password is required."
        softAssert.assertEquals(registerPage.verifyTextConfirmPassword(),"Password is required.","Confirm Password required message not found");
        softAssert.assertAll();
    }
    public void VerifyThatUserShouldCreateAccountSuccessfully(){
        //Click on Register Link
        homePage.clickOnRegisterButton();

        //Select gender "Female"
        registerPage.selectGender("Female");

        //Enter firstname
        registerPage.enterFirstName("Poonam");

        //Enter lastname
        registerPage.enterLastName("Ramavat");

        //Select day
        registerPage.selectDay("26");

        //Select month
        registerPage.selectMonth("June");

        //Select year
        registerPage.selectYear("1991");

        //Enter email
        registerPage.enterEmail("poonam123@gmail.com");

        //Enter password
        registerPage.enterPassword("Poonam789");

        //Enter Confirm Password
        registerPage.enterConfirmPassword("poonam789");

        //Click on "REGISTER" button
        registerPage.clickOnRegisterButton();

        //Verify message "Your registration completed"
        softAssert.assertEquals(registerPage.verifyRegisterTextCompleted(),"Your registration completed","Your registration is not completed");
        softAssert.assertAll();
    }
    }
}
