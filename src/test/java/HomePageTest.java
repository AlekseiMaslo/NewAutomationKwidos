import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest {

    @Test
    public void titleTest () {
        // Go to home page https://testkwidos.tk/
        //Verify title is equal to Kwidos

        WebDriver driver = new ChromeDriver();
        driver.get("https://testkwidos.tk/");
        driver.manage().window().maximize();

        String title = driver.getTitle();

        Assert.assertEquals(title, "Kwidos");

        driver.quit();
    }
}
