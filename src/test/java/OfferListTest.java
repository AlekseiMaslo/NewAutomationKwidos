
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class OfferListTest extends BaseTests{

    @Test
    public void offerListSizeTest () throws InterruptedException {

        driver.get("https://testkwidos.tk/offer/search");

        Thread.sleep(2000);

        driver.findElement(By.xpath("//label[contains(text(),'Service Type')]/../p-multiselect")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//label[contains(text(), '3D Capture')]")).click();
        Thread.sleep(2000);

        List<WebElement> serviceTypeCards = driver.findElements(By.cssSelector("[class*='service-type-flex']"));
        Thread.sleep(2000);
        for(WebElement element: serviceTypeCards){
            System.out.println(element.getText());
            Assert.assertEquals(element.getText(), "3D Capture");
        }

    }
}
