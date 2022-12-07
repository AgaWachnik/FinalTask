package mystoreobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddProduct {
    private final WebDriver driver;

    public AddProduct(WebDriver driver) {
        this.driver = driver;}

    public ShoppingCart clickCheckout(){
        WebElement checkoutButton = driver.findElement(By.cssSelector("blockcart-modal > div > div > div.modal-body > div > div.col-md-7 > div > div > a"));
        checkoutButton.click();
        return new ShoppingCart(driver);
    }
}
