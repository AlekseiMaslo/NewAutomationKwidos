
import org.testng.annotations.Test;

public class HWAccessTest extends BaseTests {
    @Test
    public void accessTest () {
        //Ticket 3. Automate Sign Up scenarios
        //1. Sign Up Success. (Please make sure you can run your Sign Up test more than 2 times !)
        //2. Sign Up Wrong credentials (not existing email)
        //3. Sign Up Empty credentials
        //
        //Link for Sign up page:
        //
        //https://testkwidos.tk/auth/register/contractor

        driver.get("https://testkwidos.tk/auth/register/contractor");


        //search for login and password boxes
        //and fill it out

    }
}
