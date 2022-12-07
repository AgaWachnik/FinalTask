package mystoreobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCart {
    private final WebDriver driver;

    public ShoppingCart(WebDriver driver) {
        this.driver = driver;
    }

    public OrderDetails proceedToCheckout() {
        WebElement proceedButton = driver.findElement(By.cssSelector("#main > div > div.cart-grid-right.col-xs-12.col-lg-4 > div.card.cart-summary > div.checkout.cart-detailed-actions.js-cart-detailed-actions.card-block > div > a"));
        proceedButton.click();
        return new OrderDetails(driver);
    }
}


