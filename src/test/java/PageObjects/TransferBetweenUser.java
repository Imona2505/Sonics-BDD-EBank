package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import static Utilities.Hooks.driver;
import static io.restassured.RestAssured.given;

public class TransferBetweenUser {
    @FindBy(xpath ="//*[@class='aside__row active']/..//*[@class='aside__row']/..//*[@class='aside__label main_color transfer']")
    @CacheLookup
    WebElement Transfers;

    @FindBy(xpath = "//*[@class='sections-container']/..//*[contains(text(),'Transfer Between Users')]")
    @CacheLookup
    WebElement TransferBetweenUsers;

    @FindBy(xpath = " //*[@class='ng-select-container']")
    @CacheLookup
    WebElement SelectAccount;

    @FindBy(xpath = " //*[@class='ng-option ng-option-marked']/..//*[@class='select-value']")
    @CacheLookup
    WebElement SelectCheckingAccount;

    @FindBy(xpath = "//*[@id='username']" )
    @CacheLookup
    WebElement UserName;

    @FindBy(xpath = "//*[@id='account']")
    @CacheLookup
    WebElement AccountNumber;

    @FindBy(xpath="//input[@*='outgoingAmount']")
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



    private String transactionId;

    public String getTransactionId() {
        return transactionId;
    }


    public void TransferBetweenUser(String Username, String Account, String Amount) throws InterruptedException {
        Thread.sleep(5000);
        Transfers.click();
        Thread.sleep(5000);
        TransferBetweenUsers.click();
        SelectAccount.click();
        SelectCheckingAccount.click();
        UserName.sendKeys(Username);
        AccountNumber.sendKeys(Account);
        Thread.sleep(1000);
        AmountToTransfer.sendKeys(Amount);
        Thread.sleep(2000);
        ContinueButton.click();
        Thread.sleep(2000);
        ConfirmButton.click();

    }
    public boolean isSuccessMessagePopUp(){
        String expected = "Your request has been sent for approval.";
        String actual = this.SuccessMessage.getText();
         transactionId=actual.split("#")[1].split("\n")[0].trim();

         return (expected.equals(actual));
    }
}
