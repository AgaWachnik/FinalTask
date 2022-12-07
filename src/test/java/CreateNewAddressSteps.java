import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mystoreobjects.*;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class CreateNewAddressSteps {

    private WebDriver driver;

    private final String email = "tester@coderslab.com";
    private final String password = "tester123";

    private CreateNewAddress createNewAddress;
    private AddressAdded addressAdded;

    @Given("A browser with My Store website")
    public void openAccountPage() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
    }

    @And("Click SignIn button")
    public void clickSignIn() {
        HomePage homePage = new HomePage(driver);
        homePage.clickSignIn();
    }

    @When("the registered user enters a correct e-mail address and correct password")
    public void logIn(String email, String password) {
        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
     authenticationPage.loginUser(email, password);
    }

    @And("the user opens the Addresses feature")
    public void openAddresses() {
        AccountPage accountPage = new AccountPage(driver);
 AddressAdded addressAdded = accountPage.clickAddAddress();
 createNewAddress = addressAdded.addNewAddress();
    }

    @And("completes the form with (.*) and (.*) and (.*) and (.*) and (.*) and (.*)$")
    public void fillForm(String alias, String address, String city, String zip, String country, String phone) {
        addressAdded = createNewAddress.addNewAddress(alias, address, city, zip, country, phone);
    }

    @Then("new address is correctly saved")
    public void addressSaved (String alias, String address, String city, String zip, String country, String phone){
        String addressAsText = addressAdded.getAddressAsText();
        String[] expectedAddressDetails = {alias, address, city, zip, country, phone};
        String expectedAddress = Arrays.toString(expectedAddressDetails);
        Assertions.assertEquals(expectedAddress, addressAsText);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}