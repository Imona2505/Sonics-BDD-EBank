package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Utilities.Hooks.driver;
import static Utilities.Hooks.wait;

public class IncomingWireTransfer {
 String url = "https://demo.ebanq.com/";

 public void homepage(){
     driver.get(url);
 }

    @FindBy( xpath = ".//*[contains(@formcontrolname,\"email\")]")
    @CacheLookup
    WebElement username;

    @FindBy(xpath = ".//*[contains(@formcontrolname,\"password\")]")
    @CacheLookup
    WebElement password;

    @FindBy(xpath = "//*[@class='controls']/..//*[contains(text(),'Sign In')]")
    @CacheLookup
    WebElement signInButton;

    @FindBy(xpath = "//*[@class='aside__row active']/..//*[@class='aside__row']/..//*[@class='aside__label main_color transfer']")
    @CacheLookup
    WebElement transfer;

    @FindBy(xpath = "//*[@class='section main_color']/..//*[contains(text(),'Incoming Wire Transfer')]")
    @CacheLookup
    WebElement incomingWireTransfer;

    @FindBy(xpath = "//*[contains(text(),'EBQEMI2A')]")
    @CacheLookup
    WebElement successMessage;

    public void LogIn(String Username, String Password){
        username.sendKeys(Username);
        password.sendKeys(Password);
        signInButton.click();
    }
    public void sideRowTransfer() throws InterruptedException {
        Thread.sleep(5000);
        transfer.click();
        Thread.sleep(5000);
        incomingWireTransfer.click();
    }
    public boolean isSuccessMessagePresent(){
        String expected = "EBQEMI2A";
       // wait.until(ExpectedConditions.textToBe(By.xpath("///*[@class='fields']/..//*[contains(text(),'EBQEMI2A')]"),expected));
        String actual= this.successMessage.getText();
        return (expected.equals(actual));
    }
}
