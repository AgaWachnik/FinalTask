package mystoreobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HummingBirdSweater {
    private final WebDriver driver;

    public HummingBirdSweater(WebDriver driver) {
        this.driver = driver;}

    public AddProduct chooseProduct

    {
        WebElement sizeDropdown = driver.findElement(By.cssSelector("[data-toggle=\"dropdown\"]"));
        WebElement sizeM = driver.findElement(By.cssSelector("[data-id-hotel=\"1\"]"));
        WebElement addToCartButton = driver.findElement(By.id("search_room_submit"));
        return new AddProduct(driver);
    }
}
