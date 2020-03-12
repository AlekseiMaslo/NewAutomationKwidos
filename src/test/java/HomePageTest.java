
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest  extends BaseTests{

    @Test
    public void titleTest () throws InterruptedException {
        // Go to home page https://testkwidos.tk/
        //Verify title is equal to Kwidos

        driver.get("https://kwidos.com/");
        Thread.sleep(2000);
        String title = driver.getTitle();

        Assert.assertEquals(title, "Kwidos", "Title is verified");

    }
}
