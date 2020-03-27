import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class RegisterAsServiceProvider extends BaseTests {

    @Test
    public void signInSuccessTest () throws InterruptedException {
        driver.get("https://kwidos.com/auth/register/contractor");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("[formcontrolname='firstName']")).sendKeys("Aleksei");
        driver.findElement(By.cssSelector("[formcontrolname='lastName']")).sendKeys("Maslo");
        driver.findElement(By.cssSelector("[formcontrolname='businessName']")).sendKeys("TestBN");
        driver.findElement(By.cssSelector("[formcontrolname='phone']")).sendKeys("8885552200");
        driver.findElement(By.cssSelector("[formcontrolname='email']")).sendKeys("alkseimaslo@gami.com");
        driver.findElement(By.cssSelector("formcontrolname='password'")).sendKeys("Kwidos123");

        driver.findElement(By.cssSelector("[class='ui-chkbox-icon ui-clickable']")).click();
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("[type='submit']")).click();


    }
}
