import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import mystoreobjects.*;
import org.apache.commons.io.FileUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

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
void orderSweater() throws IOException {
    HomePage homePage = new HomePage(driver);
    homePage.openPage();
    AuthenticationPage authenticationPage = homePage.clickSignIn();
    AccountPage accountPage = authenticationPage.loginUser(email, password);
    accountPage.clickLogo();
    HummingBirdSweater hummingBirdSweater = homePage.chooseSweater();
    AddProduct addProduct = hummingBirdSweater.chooseProduct();
    ShoppingCart shoppingCart = addProduct.clickCheckout();
    OrderDetails orderDetails = shoppingCart.proceedToCheckout();
    OrderConfirmation orderConfirmation = orderDetails.orderSteps();

    //Screenshot
    Date currentDate = new Date();
    String screenshotFileName = currentDate.toString().replace(" ", "-").replace(":", "-");
    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(screenshot, new File(".//screenshots/" + screenshotFileName + ".png"));

}


}
