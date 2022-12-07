package mystoreobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {
    private final WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;}

    public AddressAdded clickAddAddress(){
        WebElement addFirstAddress = driver.findElement(By.id("addresses-link"));
        addFirstAddress.click();
        return new AddressAdded(driver);
    }

    public void clickLogo(){
        WebElement logoMyStore = driver.findElement(By.id("_desktop_logo"));
        logoMyStore.click();
        new HomePage(driver);
    }
}
