
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest  extends BaseTests{

    @Test
    public void titleTest () {
        // Go to home page https://testkwidos.tk/
        //Verify title is equal to Kwidos

        driver.get("https://testkwidos.tk/");

        String title = driver.getTitle();

        Assert.assertEquals(title, "Kwidos");

    }
}
