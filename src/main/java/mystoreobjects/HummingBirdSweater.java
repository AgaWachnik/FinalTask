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
        WebElement addToCartButton = driver.findElement(By.id("search_room_submit"));
        return new AddProduct(driver);
    }
}
