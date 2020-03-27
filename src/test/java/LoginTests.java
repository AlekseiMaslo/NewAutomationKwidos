
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTests {
    @Test
    void loginSuccessTest() {
        //1. Login Success.

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.enterEmail("alekseimaslo@gmail.com");
        loginPage.enterPassword("Kwidos123");
        loginPage.clickSubmit();
        WebElement verifiedUserName = driver.findElement(By.xpath("//*[contains (text(), 'Aleksei')]"));
        Assert.assertTrue(verifiedUserName.isDisplayed());


    }

    @Test
    void loginWrongCredentialsTest() {
        //2. Login Wrong credentials (not existing email)
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.enterEmail("WrongAlekseimaslo@gmail.com");
        loginPage.enterPassword("Kwidos123");
        loginPage.clickSubmit();
        String alert = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
        Assert.assertEquals(alert, "Username or password is incorrect");


    }

    @Test
    void emptyCredentialsTest() {
        //3. Login Empty credentials

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.enterEmail("");
        loginPage.enterPassword("");
        loginPage.clickSubmit();
        String emailRequired = driver.findElement(By.xpath("//div[@class='help-block' and contains(text(), 'Email')]")).getText();
        String passwordRequired = driver.findElement(By.xpath("//div[@class='help-block' and contains(text(), 'Password')]")).getText();
        Assert.assertEquals(emailRequired, "Email is required");
        Assert.assertEquals(passwordRequired, "Password is required");

    }

}
