package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class TransferBetweenAccounts {
    @FindBy(xpath ="//*[@class='aside__row active']/..//*[@class='aside__row']/..//*[@class='aside__label main_color transfer']")
    @CacheLookup
    WebElement Transfers;

    @FindBy(xpath = "//*[@class='sections-container']/..//*[contains(text(),'Transfer Between Accounts')]")
    @CacheLookup
    WebElement TransferBetweenAccounts;

    @FindBy(xpath = " //*[@class='ng-select-container']")
    @CacheLookup
    WebElement SelectAccount;


    @FindBy(xpath = " //*[@class='ng-option ng-option-marked']/..//*[@class='select-value']")
    @CacheLookup
    WebElement SelectCheckingAccount;


    @FindBy(xpath = " //*[@class='ng-select-container']")
    @CacheLookup
    WebElement SelectAccount1;

    @FindBy(xpath = " //*[@class='ng-option ng-option-marked']/..//*[@class='select-value']")
    @CacheLookup
    WebElement SelectCheckingAccount1;


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


    public boolean TransferBetweenAccounts(String Account, String Account1, String Amount) throws InterruptedException {
        Thread.sleep(5000);
        Transfers.click();
        Thread.sleep(5000);
        TransferBetweenAccounts.click();
        SelectAccount.click();
        SelectCheckingAccount.click();
        SelectAccount1.click();
        SelectCheckingAccount1.click();
        AmountToTransfer.click();
        ContinueButton.click();
        ConfirmButton.click();




            String expected = "Your request has been sent for approval.";
            String actual = this.SuccessMessage.getText();
            return (expected.equals(actual));
        }


    public void isSuccessMessagePopUp() {

    }
}