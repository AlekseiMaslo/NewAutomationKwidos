package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage (WebDriver givendriver) {
        driver = givendriver;
        wait = new WebDriverWait(driver, 5);
    }

    public WebElement findElement (String cssSelector) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
    }

    public void openLoginPage() {
        driver.get("https://kwidos.tk/auth/login");
    }

    public void enterEmail(String email) {
        findElement("#email").sendKeys(email);
    }

    public void enterPassword(String password) {
        findElement("#password").sendKeys(password);
    }

    public void clickSubmit() {
        driver.findElement(By.xpath("//*[@type='submit']")).click();
    }
}
