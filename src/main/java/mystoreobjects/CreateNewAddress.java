package mystoreobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateNewAddress {
    private final WebDriver driver;

    public CreateNewAddress(WebDriver driver){
        this.driver = driver;
    }

    public AddressAdded addNewAddress(String alias, String address, String city, String zip, String country, String phoneNumber){
        WebElement aliasInput = driver.findElement(By.id("field-alias"));
        WebElement addressInput = driver.findElement(By.id("field-address1"));
        WebElement cityInput = driver.findElement(By.id("field-city"));
        WebElement zipInput = driver.findElement(By.id("field-postcode"));
        WebElement countryInput = driver.findElement(By.id("field-id_country"));
        WebElement phoneNumberInput = driver.findElement(By.id("field-phone"));
        WebElement saveButton = driver.findElement(By.cssSelector("#content > div > div > form > footer > button"));

        aliasInput.sendKeys(alias);
        addressInput.sendKeys(address);
        cityInput.sendKeys(city);
        zipInput.sendKeys(zip);
        countryInput.sendKeys(country);
        phoneNumberInput.sendKeys(phoneNumber);
        saveButton.click();

        return new AddressAdded(driver);
    }
}