package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import static Utilities.Hooks.driver;

public class OpeningHomePage {
    @FindBy( xpath = ".//*[contains(@formcontrolname,\"email\")]")
     @CacheLookup
    WebElement login;

    @FindBy(xpath = ".//*[contains(@formcontrolname,\"password\")]")
            @CacheLookup
            WebElement password;

    @FindBy(xpath = "//*[@class='controls__logout']/..//*[contains(text(),'Log Out')]")
          @CacheLookup
            WebElement logOut;

    @FindBy(xpath = "//*[@class='controls']/..//*[contains(text(),'Sign In')]")
            @CacheLookup
            WebElement signin;



    String url = "https://demo.ebanq.com/";

    public void homepage(){
        driver.get(url);
    }

    public void loginwith(String Username, String Password){
        login.sendKeys(Username);
        password.sendKeys(Password);
        signin.click();
    }
    public boolean isLogOutButtonPresent() {

        String expected = "Log Out";
        String actual = this.logOut.getText();
        return (expected.equals(actual));

    }
}
