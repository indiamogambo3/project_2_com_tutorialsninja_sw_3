package laptopsandnotebooks;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

import java.util.List;

public class LaptopsAndNotebooksTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setUpBrowser() {

        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() throws InterruptedException {

        //Mouse hover on Laptops & Notebooks Tab.and click
        Thread.sleep(2000);
        WebElement laptops = driver.findElement(By.linkText("Laptops & Notebooks"));
        Actions actions = new Actions(driver);
        actions.moveToElement(laptops).click().build().perform();
        // Click on “Show All Laptops & Notebooks”
        Thread.sleep(2000);
        clickOnElement(By.linkText("Show AllLaptops & Notebooks"));
        //Select Sort By "Price (High > Low)"
        Thread.sleep(2000);
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Price (High > Low)");
        //Verify the Product price will arrange in High to Low order.
        List<WebElement> price = driver.findElements(By.xpath("//p[@class =  'price']"));
        for (WebElement e : price) {
            System.out.println(e.getText());
        }
    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {

        //Mouse hover on Laptops & Notebooks Tab.and click
        Thread.sleep(2000);
        WebElement laptops = driver.findElement(By.linkText("Laptops & Notebooks"));
        Actions actions = new Actions(driver);
        actions.moveToElement(laptops).click().build().perform();
        // Click on “Show All Laptops & Notebooks”
        Thread.sleep(2000);
        clickOnElement(By.linkText("Show AllLaptops & Notebooks"));
        //Select Sort By "Price (High > Low)"
        Thread.sleep(2000);
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Price (High > Low)");
        //Select Product “MacBook”
        Thread.sleep(2000);
        clickOnElement(By.linkText("MacBook"));
        // Verify the text “MacBook”
        String expectedText = "MacBook";
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'MacBook')]"));
        Assert.assertEquals("Unable to verify text.", expectedText, actualText);
        // Click on ‘Add To Cart’ button
        Thread.sleep(2000);
        clickOnElement(By.id("button-cart"));
        //Verify the message “Success: You have added MacBook to your shopping cart!”
        String expectedAddedText = "Success: You have added MacBook to your shopping cart!\n" + "×";
        String actualAddedText = getTextFromElement(By.xpath("//div[@class = 'alert alert-success alert-dismissible']"));
        Assert.assertEquals("Unable to verify text.", expectedAddedText, actualAddedText);
        //Click on link “shopping cart” display into success message
        Thread.sleep(2000);
        clickOnElement(By.linkText("shopping cart"));
        //Verify the text "Shopping Cart"
        String expectedShoppingCartText = "Shopping Cart  (0.00kg)";
        String actualShoppingCartText = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping Cart')]"));
        Assert.assertEquals("Unable to verify text.", expectedShoppingCartText, actualShoppingCartText);
        //Verify the Product name "MacBook"
        String expectedProductText = "MacBook";
        String actualProductText = getTextFromElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"));
        Assert.assertEquals("Unable to verify text.", expectedProductText, actualProductText);
        //Change Quantity "2"
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@value = '1']")).clear();
        sendTextToElement(By.xpath("//input[@value = '1']"), "2");
        // Click on “Update” Tab
        Thread.sleep(2000);
        clickOnElement(By.xpath("//i[@class ='fa fa-refresh']"));
        // Verify the message “Success: You have modified your shopping cart!”
        String expectedSuccessText = "Success: You have modified your shopping cart!\n" + "×";
        String actualSuccessText = getTextFromElement(By.xpath("//body/div[@id='checkout-cart']/div[1]"));
        Assert.assertEquals("Unable to verify text.", expectedSuccessText, actualSuccessText);
        //Verify the Total $1,204.00
        String expectedTotalText = "$1,204.00";
        String actualTotalText = getTextFromElement(By.xpath("//tbody/tr[1]/td[6]"));
        Assert.assertEquals("Unable to verify total.", expectedTotalText, actualTotalText);
        // Click on “Checkout” button
        Thread.sleep(2000);
        clickOnElement(By.linkText("Checkout"));
        // Verify the text “Checkout”
        String expectedCheckoutText = "Checkout";
        String actualCheckoutText = getTextFromElement(By.xpath("//h1[contains(text(),'Checkout')]"));
        Assert.assertEquals("Unable to verify total.", expectedCheckoutText, actualCheckoutText);
        //Verify the Text “New Customer”
        Thread.sleep(2000);
        String expectedNewCustomerText = "New Customer";
        String actualNewCustomerText = getTextFromElement(By.xpath("//h2[contains(text(),'New Customer')]"));
        Assert.assertEquals("Unable to verify total.", expectedNewCustomerText, actualNewCustomerText);
        //Click on “Guest Checkout” radio button
        Thread.sleep(2000);
        clickOnElement(By.xpath("//input[@value = 'guest']"));
        //Click on “Continue” tab
        Thread.sleep(2000);
        clickOnElement(By.id("button-account"));
        // Fill the mandatory fields
        Thread.sleep(2000);
        sendTextToElement(By.id("input-payment-firstname"), "Mukz");
        sendTextToElement(By.id("input-payment-lastname"), "Shah");
        sendTextToElement(By.id("input-payment-email"), "Mukz@gmail.com");
        sendTextToElement(By.id("input-payment-telephone"), "07745365214");
        sendTextToElement(By.id("input-payment-address-1"), "123 Best Street");
        sendTextToElement(By.id("input-payment-city"), "London");
        sendTextToElement(By.id("input-payment-postcode"), "1OF 2TH");
        selectByVisibleTextFromDropDown(By.id("input-payment-country"), "United Kingdom");
        selectByVisibleTextFromDropDown(By.id("input-payment-zone"), "Merseyside");
        // Click on “Continue” Button
        Thread.sleep(2000);
        clickOnElement(By.id("button-guest"));
        //Add Comments About your order into text area
        Thread.sleep(2000);
        sendTextToElement(By.tagName("textarea"), "Please dispatch as soon as possible.");
        //Check the Terms & Conditions check box
        Thread.sleep(2000);
        clickOnElement(By.name("agree"));
        //Click on “Continue” button
        Thread.sleep(2000);
        clickOnElement(By.id("button-payment-method"));
        // Verify the message “Warning: Payment method required!”
        String expectedWarning = "Warning: Payment method required!\n" + "×";
        String actualWarningMessage = getTextFromElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
        Assert.assertEquals("Unable to verify warning message", expectedWarning, actualWarningMessage);
    }


    @After
    public void tearDown() {

        closeBrowser();
    }
}
