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

    @FindBy(xpath = " //*[@class='ng-value-container']")
    @CacheLookup
    WebElement selectAccount;


    @FindBy(xpath = " //*[@class='ng-option ng-option-marked']/..//*[@class='select-value']")
    @CacheLookup
    WebElement selectCheckingAccount;


    @FindBy(xpath = " //*[contains(@class,'large ng-select ng-select-single ng-select-opened ng-select-bottom')]']")
    @CacheLookup
    WebElement selectsavingAccount;


    @FindBy(xpath = " //*[contains(@id,'ad376c0f8a6d')]')]']")
    @CacheLookup
    WebElement savingAccount;



    @FindBy(xpath="//input[@*='outgoingAmount']")
    @CacheLookup
    WebElement amountToTransfer;

    @FindBy(xpath=" //*[@class='def-btn-success main_color']")
    @CacheLookup
    WebElement  continueButton;

    @FindBy(xpath=" //*[@class='def-btn-success main_color']")
    @CacheLookup
    WebElement confirmButton;

    @FindBy(xpath = " //*[@class='success-popup']")
    @CacheLookup
    WebElement successMessage;


    public void TransferBetweenAccounts(String Account, String Account1, String Amount) throws InterruptedException {
        Thread.sleep(5000);
        Transfers.click();
        Thread.sleep(5000);
        TransferBetweenAccounts.click();
        selectAccount.click();
        selectCheckingAccount.click();
        Thread.sleep(5000);
        selectsavingAccount.click();
        savingAccount.click();
        Thread.sleep(5000);
        amountToTransfer.sendKeys();
        Thread.sleep(2000);
        continueButton.click();
        Thread.sleep(2000);
        confirmButton.click();


    }



    public boolean isSuccessMessagePopUp() {
        String expected = "Your request has been sent for approval.";
        String actual = this.successMessage.getText();
        return(actual.contains(expected));
    }

    }
