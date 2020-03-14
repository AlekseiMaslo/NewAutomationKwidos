
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

    public class HWTestForLoginTest {
    @Test
    void loginSuccessTest() throws InterruptedException {
        //1. Login Success.
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://kwidos.com/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class='glyphicon glyphicon-log-in']/../p")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("email")).sendKeys("alekseimaslo@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Kwidos123!");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        Thread.sleep(2000);
        WebElement verifiedUserName = driver.findElement(By.xpath("//*[contains (text(), 'aleksei')]"));
        Assert.assertTrue(verifiedUserName.isDisplayed());

        driver.quit();
    }

    @Test
    void loginWrongCredentialsTest() throws InterruptedException {
        //2. Login Wrong credentials (not existing email)
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://kwidos.com/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class='glyphicon glyphicon-log-in']/../p")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("email")).sendKeys("1alekseimaslo@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Kwidos123!");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        Thread.sleep(2000);
        WebElement alert = driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
        Assert.assertEquals(alert, "Username or password is incorrect");

        driver.quit();
    }

    @Test
        void emptyCredentialsTest() throws InterruptedException {
        //3. Login Empty credentials
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://kwidos.com/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class='glyphicon glyphicon-log-in']/../p")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("email")).sendKeys("");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        Thread.sleep(2000);
        WebElement emailRequired = driver.findElement(By.cssSelector("input#email + div"));
        WebElement passwordRequired = driver.findElement(By.cssSelector("input#password + div"));
        Assert.assertEquals(emailRequired, "Email is required");
        Assert.assertEquals(passwordRequired, "Password is required");

        driver.quit();
    }
}
