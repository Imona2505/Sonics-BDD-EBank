package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import static Utilities.Hooks.driver;
public class TransferBetweenUser {
    @FindBy(xpath ="//*[@class='aside__row active']")
    @CacheLookup
    WebElement Transfers;

    @FindBy(xpath = "//*[contains(text(),'transfer-between-users')]")
    @CacheLookup
    WebElement TransferBetweenUsers;

    @FindBy(xpath = " //*[@class='ng-select-container']")
    @CacheLookup
    WebElement SelectAccount;

    @FindBy(xpath = " //*[@id='a14eea40aabb']")
    @CacheLookup
    WebElement SelectCheckingAccount;

    @FindBy(xpath = "//*[@id='username']" )
    @CacheLookup
    WebElement UserName;

    @FindBy(xpath = "//*[@id='account']")
    @CacheLookup
    WebElement AccountNumber;

    @FindBy(xpath=" //*[@class='native-input amount ng-pristine ng-invalid with-currency ng-touched']")
    @CacheLookup
    WebElement AmountToTransfer;

    @FindBy(xpath=" //*[@class='def-btn-success main_color']")
    @CacheLookup
    WebElement  ContinueButton;

    @FindBy(xpath=" //*[@class='def-btn-success main_color']")
    @CacheLookup
    WebElement ConfirmButton;
    @FindBy(xpath = " //*[@class='success-popup']")
    @CacheLookup
    WebElement SuccessMessage;


    public void TransferBetweenUser(String Username, String Account, String Amount){
        Transfers.click();
        TransferBetweenUsers.click();
        SelectAccount.click();
        SelectCheckingAccount.click();
        UserName.sendKeys(Username);
        AccountNumber.sendKeys(Account);
        AmountToTransfer.sendKeys(Amount);
        ContinueButton.click();
        ConfirmButton.click();

    }
    public boolean isSuccessMessagePopUp(){
        String expected = "Your request has been sent for approval.";
        String actual = this.SuccessMessage.getText();
                return (expected.equals(actual));
    }
}
