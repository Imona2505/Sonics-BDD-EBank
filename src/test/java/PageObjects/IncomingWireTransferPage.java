package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class IncomingWireTransferPage {
    @FindBy(xpath = "//*[@class='ng-value-container']")
    @CacheLookup
    WebElement account;
    @FindBy(xpath = "//*[@class='ng-option ng-option-marked']/..//*[contains(text(),'EBQ11113487654')]")
    @CacheLookup
    WebElement accountSelection;
    @FindBy(xpath = "//*[@class='bottom']/..//*[@class='def-btn-cancel']/..//*[@class='def-btn-success main_color']")
    @CacheLookup
    WebElement continueButton;

    public void process() throws InterruptedException {
        account.click();
        accountSelection.click();
        Thread.sleep(2000);
        continueButton.click();
    }

}
