package mystoreobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private final WebDriver driver;

    private final String URL = "https://mystore-testlab.coderslab.pl/index.php";


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage openPage(){
        driver.get(URL);
        return this;
    }

    public AuthenticationPage clickSignIn(){
        WebElement signInButton = driver.findElement(By.className("user-info"));
        signInButton.click();
        return new AuthenticationPage(driver);
    }

    public HummingBirdSweater chooseSweater(){
        WebElement photoSweater = driver.findElement(By.cssSelector("#content > section > div > div:nth-child(2) > article > div > div.product-description > h3 > a"));
        photoSweater.click();
        return new HummingBirdSweater(driver);
    }
}
