package mystoreobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {
    private final WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;}

    public CreateNewAddress clickAddAddress(){
        WebElement addFirstAddress = driver.findElement(By.id("address-link"));
        addFirstAddress.click();
        return new CreateNewAddress(driver);
    }

    public void clickLogo(){
        WebElement logoMyStore = driver.findElement(By.className("logo img-fluid"));
        logoMyStore.click();
        new HomePage(driver);
    }
}
