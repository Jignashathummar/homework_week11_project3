package testsuite;
/**
 * 2. Create the package ‘testsuite’ and create the
 * following class inside the ‘testsuite’ package.
 * 1. LoginTest
 * 3. Write down the following test into ‘LoginTest’ class
 * 1. userSholdLoginSuccessfullyWithValidCredentials
 * * Enter “tomsmith” username
 * * Enter “SuperSecretPassword!” password
 * * Click on ‘LOGIN’ button
 * * Verify the text “Secure Area”
 * 2. verifyTheUsernameErrorMessage
 * * Enter “tomsmith1” username
 * * Enter “SuperSecretPassword!” password
 * * Click on ‘LOGIN’ button
 * * Verify the error message “Your username
 * is invalid!”
 * 3. verifyThePasswordErrorMessage
 * * Enter “tomsmith” username
 * * Enter “SuperSecretPassword” password
 * * Click on ‘LOGIN’ button
 * * Verify the error message “Your password
 * is invalid!”
 */

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void openBrowser() {
        openBrowser(baseUrl);
    }

    /**
     * * Enter “tomsmith” username
     * * Enter “SuperSecretPassword!” password
     * * Click on ‘LOGIN’ button
     * * Verify the text “Secure Area”
     */
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.className("radius")).click();
        Assert.assertEquals("User should successfully login with valid credentials ","Secure Area", driver.findElement(By.xpath("//h2[text()=' Secure Area']")).getText());
        driver.findElement(By.xpath("//i[@class='icon-2x icon-signout']")).click();
    }

    /**
     * verifyTheUsernameErrorMessage
     * * Enter “tomsmith1” username
     * * Enter “SuperSecretPassword!” password
     * * Click on ‘LOGIN’ button
     * * Verify the error message “Your username
     * is invalid!”
     */
    @Test
    public void verifyTheUsernameErrorMessage(){
        driver.findElement(By.id("username")).sendKeys("tomsmith1");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.className("radius")).click();
        Assert.assertEquals("Verify invalid username error message","Your username is invalid!\n" +
                "×", driver.findElement(By.xpath("//div[contains(text(), 'Your username is invalid!')]")).getText());
    }

    /**
     * verifyThePasswordErrorMessage
     * * Enter “tomsmith” username
     * * Enter “SuperSecretPassword” password
     * * Click on ‘LOGIN’ button
     * * Verify the error message “Your password
     * is invalid!”
     */
    @Test
    public void verifyThePasswordErrorMessage() {
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");
        driver.findElement(By.className("radius")).click();
        Assert.assertEquals("Verify invalid password error message","Your password is invalid!\n" +
                "×", driver.findElement(By.xpath("//div[contains(text(), 'Your password is invalid!')]")).getText());
    }

    @After
    public void teBrowser() {
        closeBrowser();
    }
}
