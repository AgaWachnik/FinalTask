package mystoreobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthenticationPage {
    private final WebDriver driver;

    public AuthenticationPage(WebDriver driver) {
        this.driver = driver;}

    public AccountPage loginUser(String email, String password){
        WebElement emailInput = driver.findElement(By.id("field-email"));
        WebElement passwordInput = driver.findElement(By.id("field-password"));
        WebElement signInButton = driver.findElement(By.id("submit-login"));
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        signInButton.click();
        return new AccountPage(driver);
    }
}

