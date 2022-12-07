package mystoreobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderDetails {
    private final WebDriver driver;

    public OrderDetails(WebDriver driver) {
        this.driver = driver;
    }



    public OrderConfirmation orderSteps(){
        //Czy ma czekać pomiędzy klikami?
        //WebElement clickAddress = driver.findElement(By.name("id_address_delivery"));
        WebElement continueButton = driver.findElement(By.name("confirm-addresses"));
       // clickAddress.click();
        continueButton.click();
        //WebElement clickDelivery = driver.findElement(By.id("delivery_option_1"));
        WebElement confirmDeliveryPresta = driver.findElement(By.name("confirmDeliveryOption"));
        //clickDelivery.click();
        confirmDeliveryPresta.click();
        WebElement payByCheck = driver.findElement(By.id("payment-option-1"));
        WebElement agreeTerms = driver.findElement(By.id("conditions_to_approve[terms-and-conditions]"));
        WebElement placeOrderButton = driver.findElement(By.cssSelector("#payment-confirmation > div.ps-shown-by-js > button"));

        payByCheck.click();
        agreeTerms.click();
        placeOrderButton.click();

        return new OrderConfirmation(driver);

    }


}
