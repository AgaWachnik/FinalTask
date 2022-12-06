import mystoreobjects.AccountPage;
import mystoreobjects.AuthenticationPage;
import mystoreobjects.HomePage;
import mystoreobjects.HummingBirdSweater;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FirstTask {

    private WebDriver driver;
    private final String email = "tester@coderslab.com";
    private final String password = "tester123";

    @BeforeEach
    void setUp() {
       // System.setProperty("webdriver.chrome.driver",
         //       "src/main/resources/drivers/chromedriver");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    void registerUser() {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        AuthenticationPage authenticationPage = homePage.clickSignIn();
        AccountPage accountPage = authenticationPage.loginUser(email, password);
        accountPage.clickAddAddress();
    }
@Test
void orderSweater(){
    HomePage homePage = new HomePage(driver);
    homePage.openPage();
    AuthenticationPage authenticationPage = homePage.clickSignIn();
    AccountPage accountPage = authenticationPage.loginUser(email, password);
    accountPage.clickLogo();
    HummingBirdSweater hummingBirdSweater = homePage.chooseSweater();
}

}
