import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mystoreobjects.*;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class CreateNewAddressSteps {

    private WebDriver driver;

    private final String email = "tester@coderslab.com";
    private final String password = "tester123";

    private HomePage homePage;
    private AuthenticationPage authenticationPage;
    private AccountPage accountPage;
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
        authenticationPage = homePage.clickSignIn();
    }

    @When("the registered user enters a correct e-mail address and correct password")
    public void logIn(String email, String password) {
      accountPage = authenticationPage.loginUser(email, password);
    }

    @And("the user opens the Addresses feature")
    public void openAddresses() {
        createNewAddress = accountPage.clickAddAddress();
    }

    @And("completes the form with (.*) and (.*) and (.*) and (.*) and (.*) and (.*)$")
    public void fillForm(String alias, String address, String city, String code, String country, String phone) {
        addressAdded = createNewAddress.addNewAddress(alias, address, city, code, country, phone);
    }

    @Then("new address is correctly saved")
    public void addressSaved (){

    }
}