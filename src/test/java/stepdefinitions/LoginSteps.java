package stepdefinitions;

import io.appium.java_client.ios.IOSDriver;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.DriverManager;

import static org.junit.Assert.*;

public class LoginSteps {

    private static IOSDriver driver;

    @Given("I launch the app")
    public void launchApp() {
        driver = DriverManager.getDriver();
    }

    @When("I enter username {string} and password {string}")
    public void enterCredentials(String username, String password) {
        WebElement usernameField = driver.findElement(By.id("test-Username"));
        usernameField.sendKeys(username);

        WebElement passwordField = driver.findElement(By.id("test-Password"));
        passwordField.sendKeys(password);
    }

    @When("I tap the login button")
    public void tapLoginButton() {
        WebElement loginButton = driver.findElement(By.id("test-LOGIN"));
        loginButton.click();
    }

    @Then("I should see the products screen")
    public void verifyHomeScreen() {
        WebElement productScreen = driver.findElement(By.id("PRODUCTS"));
        assertTrue("PRODUCTS", productScreen.isDisplayed());
    }

    @Then("I quit the app")
    public void quitApp() {
        DriverManager.quitDriver();
    }

    @Then("I should see an error message {string}")
    public void verifyErrorMessage(String expectedMessage) {
        WebElement productScreen = driver.findElement(By.id(expectedMessage));
        assertTrue("Username and password do not match any user in this service.", productScreen.isDisplayed());
    }
}