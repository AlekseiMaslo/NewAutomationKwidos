
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

    public class HWTestForLoginTest {
    @Test
    void test1 () throws InterruptedException {
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

        driver.quit();
    }

    @Test
    void test2 () throws InterruptedException {
        //2. Login Wrong credentials (not existing email)
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
        WebElement alert = driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
        Assert.assertTrue(alert.isDisplayed());

        driver.quit();
    }

    @Test
        void test3 () throws InterruptedException {
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
        WebElement emailRequired = driver.findElement(By.xpath("//div[contains(text(), 'Email is required')]"));
        WebElement passwordRequired = driver.findElement(By.xpath("//div[contains(text(), 'Password is required')]"));
        Assert.assertTrue(passwordRequired.isDisplayed());
        Assert.assertTrue(emailRequired.isDisplayed());

        driver.quit();
    }
}
