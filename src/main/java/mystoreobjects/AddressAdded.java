package mystoreobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class AddressAdded {
    private WebDriver driver;
    private List<WebElement> addresses = driver.findElements(By.className("address-body"));
    public AddressAdded(WebDriver driver){
        this.driver = driver;
    }

    public CreateNewAddress addNewAddress() {
        WebElement addAnotherAddress = driver.findElement(By.className("material-icons"));
        addAnotherAddress.click();
        return new CreateNewAddress(driver);
    }

    public String getAddressAsText(){
        WebElement address = addresses.get(addresses.size() -1);
        String[] addressDetails = address.getText().split("\n");
        return Arrays.toString(addressDetails);
    }
}


