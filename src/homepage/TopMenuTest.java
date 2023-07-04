package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setUpBrowser() {

        openBrowser(baseUrl);
    }

    public void selectMenu(String menu) {

        driver.findElement(By.linkText(menu)).click();
    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {

        //Mouse hover on “Desktops” Tab and click
        mouseHoverAndClickOnElement(By.linkText("Desktops"));
        // call selectMenu method and pass the menu = “Show All Desktops”
        selectMenu("Show AllDesktops");
        // Verify the text ‘Desktops’
        String expectedText = "Desktops";
        String actualText = getTextFromElement(By.xpath("//h2[contains(text(),'Desktops')]"));
        Assert.assertEquals("Unable to verify text.", expectedText, actualText);
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {

        //Mouse hover on “Laptops & Notebooks” Tab and click
        mouseHoverAndClickOnElement(By.linkText("Laptops & Notebooks"));
        //call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        selectMenu("Show AllLaptops & Notebooks");
        //Verify the text ‘Laptops & Notebooks’
        String expectedText = "Laptops & Notebooks";
        String actualText = getTextFromElement(By.xpath("//h2[contains(text(),'Laptops & Notebooks')]"));
        Assert.assertEquals("Unable to verify text.", expectedText, actualText);
    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {

        //Mouse hover on “Components” Tab and click
        mouseHoverAndClickOnElement(By.linkText("Components"));
        //call selectMenu method and pass the menu = “Show All Components”
        selectMenu("Show AllComponents");
        //Verify the text ‘Components’
        String expectedText = "Components";
        String actualText = getTextFromElement(By.xpath("//h2[contains(text(),'Components')]"));
        Assert.assertEquals("Unable to verify text.", expectedText, actualText);
    }


    @After
    public void tearDown() {

        closeBrowser();
    }


}
