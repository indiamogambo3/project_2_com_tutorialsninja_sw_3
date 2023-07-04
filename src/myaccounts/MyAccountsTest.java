package myaccounts;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class MyAccountsTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setUpBrowser() {

        openBrowser(baseUrl);
    }

    public void selectMyAccountOptions(String option) {

        List<WebElement> registerList = driver.findElements(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li"));
        for (WebElement element : registerList) {
            if (element.getText().equals(option)) {
                element.click();
                break;
            }
        }
    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() throws InterruptedException {

        //Click on My Account Link.
        Thread.sleep(2000);
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        // Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register");
        //Verify the text “Register Account”.
        String expectedText = "Register Account";
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'Register Account')]"));
        Assert.assertEquals("Unable to verify text.", expectedText, actualText);
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() throws InterruptedException {

        //Click on My Account Link.
        Thread.sleep(2000);
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMyAccountOptions("Login");
        //Verify the text “Returning Customer”.
        String expectedText = "Returning Customer";
        String actualText = getTextFromElement(By.xpath("//h2[contains(text(),'Returning Customer')]"));
        Assert.assertEquals("Unable to verify text.", expectedText, actualText);
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {

        //Click on My Account Link.
        Thread.sleep(2000);
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        // Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register");
        //Enter First Name
        Thread.sleep(2000);
        sendTextToElement(By.id("input-firstname"), "Mukz");
        // Enter Last Name
        sendTextToElement(By.id("input-lastname"), "Shah");
        //Enter Email
        sendTextToElement(By.id("input-email"), "mukz1234@gmail.com");
        // Enter Telephone
        sendTextToElement(By.id("input-telephone"), "07125698742");
        //Enter Password
        sendTextToElement(By.id("input-password"), "Mukz123");
        // Enter Password Confirm
        sendTextToElement(By.id("input-confirm"), "Mukz123");
        //Select Subscribe Yes radio button
        clickOnElement(By.name("newsletter"));
        // Click on Privacy Policy check box
        clickOnElement(By.name("agree"));
        //Click on Continue button
        clickOnElement(By.xpath("//input[@type = 'submit']"));
        //Verify the message “Your Account Has Been Created!”
        String expectedText = "Your Account Has Been Created!";
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]"));
        Assert.assertEquals("Unable to verify text", expectedText, actualText);
        //Click on Continue button
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
        // Click on My Account Link.
        Thread.sleep(2000);
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        // Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        Thread.sleep(2000);
        selectMyAccountOptions("Logout");
        //Verify the text “Account Logout”
        String expectedLogoutText = "Account Logout";
        String actualLogoutText = getTextFromElement(By.xpath("//h1[contains(text(),'Account Logout')]"));
        Assert.assertEquals("Unable to verify text", expectedLogoutText, actualLogoutText);
        //Click on Continue button
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException {

        //Click on My Account Link.
        Thread.sleep(2000);
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        // Call the method “selectMyAccountOptions” method and pass the parameter “Login
        Thread.sleep(2000);
        selectMyAccountOptions("Login");
        // Enter Email address
        Thread.sleep(2000);
        sendTextToElement(By.id("input-email"), "mukz1234@gmail.com");
        // Enter Password
        sendTextToElement(By.id("input-password"), "Mukz123");
        //Click on Login button
        Thread.sleep(2000);
        clickOnElement(By.xpath("//input[@type = 'submit']"));
        //Verify text “My Account”
        String expectedText = "My Account";
        String actualText = getTextFromElement(By.xpath("//h2[contains(text(),'My Account')]"));
        Assert.assertEquals("Unable to verify text", expectedText, actualText);
        //Click on My Account Link.
        Thread.sleep(2000);
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        // Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        Thread.sleep(2000);
        selectMyAccountOptions("Logout");
        //Verify the text “Account Logout”
        String expectedLogoutText = "Account Logout";
        String actualLogoutText = getTextFromElement(By.xpath("//h1[contains(text(),'Account Logout')]"));
        Assert.assertEquals("Unable to verify text", expectedLogoutText, actualLogoutText);
        //Click on Continue button
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
    }


    @After
    public void tearDown() {

        closeBrowser();
    }


}
