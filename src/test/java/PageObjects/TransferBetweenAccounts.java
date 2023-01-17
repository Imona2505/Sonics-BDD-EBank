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


    @FindBy(xpath = "//*[@class='ng-select-container']")
    @CacheLookup
    WebElement selectSavingAccount;


    @FindBy(xpath = "//*[@class='ng-dropdown-panel-items scroll-host']/..//*[contains(text(),'EBQ11223487456')]")
    @CacheLookup
    WebElement savingAccount;

    @FindBy(xpath="//input[@*='outgoingAmount']")
    @CacheLookup
    WebElement amountToTransfer;

    @FindBy(xpath= "//*[@class='def-btn-success main_color']")
    @CacheLookup
    WebElement continueButton;

    @FindBy(xpath= "//*[@class='def-btn-success main_color']")
    @CacheLookup
    WebElement confirmButton;

    @FindBy(xpath = "//*[@class='success-popup']/..//*[contains(text(),'Your request has been sent for approval.')]")
    @CacheLookup
    WebElement successMessage;


    private String transactionId;

    public String getTransactionId() {
        return transactionId;
    }

    public void transferBetweenAccounts(String Amount) throws InterruptedException {
        Thread.sleep(5000);
        Transfers.click();
        Thread.sleep(5000);
        TransferBetweenAccounts.click();
        selectAccount.click();
        selectCheckingAccount.click();
        selectSavingAccount.click();
        savingAccount.click();
        amountToTransfer.sendKeys(Amount);
        Thread.sleep(3000);
        continueButton.click();
        Thread.sleep(3000);
        confirmButton.click();


    }

    public boolean isSuccessMessagePopUp() {
        String expected = "Your request has been sent for approval.";
        String actual = this.successMessage.getText();
        transactionId=actual.split("#")[1].split("\n")[0].trim();

        return (expected.equals(actual));
    }
    }
