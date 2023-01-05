package PageObjects;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;

public class OutgoingWireTransfer {


    @FindBy(xpath = "//*[@class='aside__row active']/..//*[@class='aside__row']/..//*[@class='aside__label main_color transfer']")
    @CacheLookup
    WebElement transfers;

    @FindBy(xpath = "//*[contains(text(),'Outgoing Wire Transfer')]")
    @CacheLookup
    WebElement outgoingWireTransfer;

    @FindBy(xpath = "//*[contains(text(),'Select account')]")
    @CacheLookup
    WebElement debitForm;

    @FindBy(xpath = "//*[@class='ng-option ng-option-marked']/..//*[@class='select-value']")
    @CacheLookup
    WebElement savings;

    @FindBy(xpath = "//*[@class='input-container__label required']/..//*[@class='native-input bic-input ng-pristine ng-invalid ng-touched']")
    @CacheLookup
    WebElement swift;

    @FindBy(xpath = "//*[contains(@id,'beneficiary-bankName')]")
    @CacheLookup
    WebElement name;

    @FindBy(xpath = "//*[contains(@id,'beneficiary-address')]")
    @CacheLookup
    WebElement address;

    @FindBy(xpath = "//*[@id='beneficiary-location']")
    @CacheLookup
    WebElement location;

    @FindBy(xpath = " //*[@class='select-container-simple select-container native-select error-field']/..//*[@class='ng-placeholder']")
    @CacheLookup
    WebElement country;

    @FindBy(xpath = " //*[@id='beneficiary-aba-rtn']")
    @CacheLookup
    WebElement rtn;

    @FindBy(xpath = " //*[@id='customer-name']")
    @CacheLookup
    WebElement customerName;

    @FindBy(xpath = " //*[@id='customer-address']")
    @CacheLookup
    WebElement customerAddress;

    @FindBy(xpath = " //*[@id='customer-city']")
    @CacheLookup
    WebElement customerCountry;

    @FindBy(xpath = " //*[@id='customer-state-prov-region']")
    @CacheLookup
    WebElement state;

    @FindBy(xpath ="//*[@class='simple ng-select ng-select-single ng-select-searchable ng-untouched ng-pristine ng-invalid ng-select-opened ng-select-bottom']/..//*[@class='ng-placeholder']")
    @CacheLookup
    WebElement country2;

    @FindBy(xpath = "//*[@id='acc-iban']")
    @CacheLookup
    WebElement accountNum;

    @FindBy(xpath = "//*[@id='ref-message']")
    @CacheLookup
    WebElement message;

    @FindBy(xpath = "//*[@id='outgoingAmountOptionsPipe']")
    @CacheLookup
    WebElement amount;

    @FindBy(xpath = "//*[@id='beneficiary-country-code']")
    @CacheLookup
    WebElement currency;

    @FindBy(xpath = "//*[@class=\"def-btn-success main_color\"]")
    @CacheLookup
    WebElement continueB;

    @FindBy(xpath = "//*[@class=\"def-btn-success main_color\"]")
    @CacheLookup
    WebElement continueButton;

    @FindBy(xpath = "//*[contains(@class,'popup-message')]")
    @CacheLookup
    WebElement successMessage;









    public void outgoingWireTransfer(String Swift, String CustomerName, String CustomerAddress, String State, String Country2,String AccountNum, String Message, String Amount, String Currency) throws InterruptedException {
        Thread.sleep(5000);
        transfers.click();
        Thread.sleep(5000);
        outgoingWireTransfer.click();
        debitForm.click();
        savings.click();
       swift.sendKeys();
       // name.sendKeys();
       // address.sendKeys();
        //location.sendKeys();
      //  rtn.sendKeys();
        //customerCountry.sendKeys();
        customerName.sendKeys();
        customerAddress.sendKeys();
        state.sendKeys();
        country2.sendKeys();
        accountNum.sendKeys();
        message.sendKeys();
        amount.sendKeys();
        currency.sendKeys();
        continueB.click();
        continueButton.click();

    }
      public boolean isSuccessMessagePresent(){
        String expected = "Your request has been sent for approval.";
        String actual =this.successMessage.getText();
        return (expected.equals(actual));
      }
}
