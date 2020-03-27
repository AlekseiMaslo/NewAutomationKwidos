import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SelectDropdown extends BaseTests {

    @Test (enabled = false)
    public void dropDownExample() throws InterruptedException {

        driver.get("http://demo.guru99.com/test/newtours/register.php");

        Select dropdown = new Select(driver.findElement(By.cssSelector("[name='country']")));

        dropdown.selectByIndex(5);
        WebElement option = dropdown.getFirstSelectedOption();
        System.out.println(option.getText());

        List<WebElement> options = dropdown.getOptions();

        for (int i = 0; i < options.size(); i++) {
            System.out.println(options.get(i).getText());
        }

        Thread.sleep(5000);
    }

    @Test (enabled = false)
    public void checkBoxExample() throws InterruptedException {

        driver.get("http://demo.guru99.com/test/radio.html");

        WebElement checkbos = driver.findElement(By.id("vfb-6-1"));
        checkbos.click();
        Thread.sleep(2000);
        Assert.assertTrue(checkbos.isSelected());

        Thread.sleep(5000);
    }

    @Test (enabled = false)
    public void alertExample() throws InterruptedException {

        driver.get("http://demo.guru99.com/test/delete_customer.php");

        driver.findElement(By.cssSelector("[name='submit']")).click();

        System.out.println(driver.switchTo().alert().getText());

        Thread.sleep(5000);
    }

    @Test
    public void exampleClassSelectAndVerify() throws InterruptedException {

        driver.get("http://demo.guru99.com/test/newtours/register.php");

        Select dropdown = new Select (driver.findElement(By.cssSelector("[name='country']")));
        dropdown.selectByVisibleText("UNITED STATES");

        Thread.sleep(5000);

        List<WebElement> options = dropdown.getOptions();
        for (int i = 0; i < options.size(); i++) {
            System.out.println(options.get(i).getText());
            
        }


    }
}
