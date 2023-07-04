package desktops;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

import java.util.List;

public class DesktopsTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setUpBrowser() {

        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() throws InterruptedException {

        //Mouse hover on Desktops Tab.and click
        Thread.sleep(2000);
        WebElement desktops = driver.findElement(By.linkText("Desktops"));
        Actions actions = new Actions(driver);
        actions.moveToElement(desktops).click().build().perform();
        // Click on “Show All Desktops”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[contains(text(),'Show AllDesktops')]"));
        //Select Sort By position "Name: Z to A"
        Thread.sleep(2000);
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Name (Z - A)");
        //Verify the Product will arrange in Descending order.
        List<WebElement> products = driver.findElements(By.tagName("h4"));
        for (WebElement e : products) {
            System.out.println(e.getText());
        }

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessfully() throws InterruptedException {

        //Mouse hover on Desktops Tab.and click
        Thread.sleep(2000);
        WebElement desktops = driver.findElement(By.linkText("Desktops"));
        Actions actions = new Actions(driver);
        actions.moveToElement(desktops).click().build().perform();
        // Click on “Show All Desktops”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[contains(text(),'Show AllDesktops')]"));
        //Select Sort By position "Name: A to Z"
        Thread.sleep(2000);
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Name (A - Z)");
        // Select product “HP LP3065”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[contains(text(),'HP LP3065')]"));
        // Verify the Text "HP LP3065"
        String expectedText = "HP LP3065";
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'HP LP3065')]"));
        Assert.assertEquals("Unable to verify text.", expectedText, actualText);
        //Select Delivery Date "2022-11-30"
//        String year = "2022";
//        String month = "November";
//        String date = "30";
//        //Select year and month
//        clickOnElement(By.xpath("//i[@class='fa fa-calendar']"));
//        while (true) {
//            String monthYear = driver.findElement(By.xpath("div[class='datepicker-days']//th[class='picker-switch']")).getText();
//            String[] a = monthYear.split("");
//            String mon = a[0];
//            String yer = a[1];
//            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
//                break;
//            }else {
//                clickOnElement(By.xpath("//div[@class='datepicker-days']//th[@class='next'][contains(text(),'›')]"));
//            }
//        }
//        //Select the date
//        List<WebElement> allDates = driver.findElements(By.xpath("//div[@class='datepicker']//table//td"));
//        for (WebElement dt : allDates) {
//            if (dt.getText().equalsIgnoreCase(date)) {
//                dt.click();
//                break;
//            }
//        }

        // Select Delivery Date "2022-11-30"
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='input-option225']")).clear();
        sendTextToElement(By.xpath("//input[@id='input-option225']"), "2022-11-30");
        //Enter Qty "1” using Select class.
        Thread.sleep(2000);
        driver.findElement(By.id("input-quantity")).clear();
        sendTextToElement(By.id("input-quantity"), "1");
        //Click on “Add to Cart” button
        Thread.sleep(2000);
        clickOnElement(By.id("button-cart"));
        //Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        String expectedMessage = "Success: You have added HP LP3065 to your shopping cart!\n" + "×";
        String actualMessage = getTextFromElement(By.xpath("//div[@class = 'alert alert-success alert-dismissible']"));
        Assert.assertEquals("Unable to verify text.", expectedMessage, actualMessage);
        //Click on link “shopping cart” display into success message
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        // Verify the text "Shopping Cart"
        String expectedShoppingText = "Shopping Cart  (1.00kg)";
        String actualShoppingText = getTextFromElement(By.xpath("//div[@id='content']/h1"));
        Assert.assertEquals("Unable to verify text.", expectedShoppingText, actualShoppingText);
        //Verify the Product name "HP LP3065"
        String expectedProductName = "HP LP3065";
        String actualProductName = getTextFromElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"));
        Assert.assertEquals("Unable to verify text.", expectedProductName, actualProductName);
        // Verify the Delivery Date "2022-11-30"
        String expectedDate = "Delivery Date:2022-11-30";
        String actualDate = getTextFromElement(By.xpath("//small[contains(text(),'Delivery Date:2022-11-30')]"));
        Assert.assertEquals("Unable to verify date.", expectedDate, actualDate);
        // Verify the Model "Product 21"
        String expectedModel = "Product 21";
        String actualModel = getTextFromElement(By.xpath("//td[contains(text(),'Product 21')]"));
        Assert.assertEquals("Unable to verify model.", expectedModel, actualModel);
        // Verify the Total "$122.00"
        String expectedTotal = "$122.00";
        String actualTotal = getTextFromElement(By.xpath("//tbody/tr[1]/td[6]"));
        Assert.assertEquals("Unable to verify model.", expectedTotal, actualTotal);

    }


    @After
    public void tearDown() {

        closeBrowser();
    }

}
