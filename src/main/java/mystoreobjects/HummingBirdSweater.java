package mystoreobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HummingBirdSweater {
    private final WebDriver driver;

    public HummingBirdSweater(WebDriver driver) {
        this.driver = driver;}

    public AddProduct chooseProduct(){
        Select sizeDropdown = new Select(driver.findElement(By.id("group_1")));
        sizeDropdown.selectByVisibleText("M");
        WebElement productQuantity = driver.findElement(By.id("quantity_wanted"));
        productQuantity.sendKeys("5");
        WebElement addToCartButton = driver.findElement(By.cssSelector("[data-button-action=\"add-to-cart\"]"));
        addToCartButton.click();
        return new AddProduct(driver);
    }
}
