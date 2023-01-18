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

    @FindBy(xpath = "//*[contains(@class,'ng-option ng-option-marked')]")
    @CacheLookup
    WebElement savings;

    @FindBy(xpath = "//*[@id='beneficiary-bankSwiftBic']")
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

    @FindBy(xpath ="//*[@*='customerCountry']")
    @CacheLookup
    WebElement country2;

    @FindBy(xpath = "//*[contains(text(),'United States of America')]")
    @CacheLookup
    WebElement unitedStatesOfAmerica;

    @FindBy(xpath = "//*[@id='acc-iban']")
    @CacheLookup
    WebElement accountNum;

    @FindBy(xpath = "//*[@id='ref-message']")
    @CacheLookup
    WebElement message;

    @FindBy(xpath = "//*[@id='outgoingAmountOptionsPipe']")
    @CacheLookup
    WebElement amount;

    @FindBy(xpath = "//*[@*='referenceCurrencyCode']")
    @CacheLookup
    WebElement currency;

    @FindBy(xpath = "//*[contains(text(),'USD')]")
    @CacheLookup
    WebElement usd;

    @FindBy(xpath = "//*[@class=\"def-btn-success main_color\"]")
    @CacheLookup
    WebElement continueB;

    @FindBy(xpath = "//*[@class=\"def-btn-success main_color\"]")
    @CacheLookup
    WebElement continueButton;

   @FindBy(xpath = "//*[contains(@class,'popup-message')]")
   @CacheLookup
   WebElement successMessage;

    @FindBy(xpath = "//*[@id='customer-city']")
    @CacheLookup
    WebElement city;

    private String transactionId;
    public String getTransactionId(){
        return transactionId;
    }








    public void outgoingWireTransfer(String Swift, String CustomerName, String CustomerAddress,String City, String State, String Country2,String AccountNum, String Message, String Amount, String Currency) throws InterruptedException {
        Thread.sleep(5000);
        transfers.click();
        Thread.sleep(5000);
        outgoingWireTransfer.click();
        debitForm.click();
        Thread.sleep(2000);
        savings.click();
        //Thread.sleep(5000);

       swift.sendKeys(Swift);
       // name.sendKeys();
       // address.sendKeys();
        //location.sendKeys();
      //  rtn.sendKeys();
        //customerCountry.sendKeys();
        customerName.sendKeys(CustomerName);
        customerAddress.sendKeys(CustomerAddress);
        city.sendKeys(City);
        state.sendKeys(State);
        country2.click();

        unitedStatesOfAmerica.click();

        //country2.sendKeys(Country2);

        accountNum.sendKeys(AccountNum);
        message.sendKeys(Message);
        amount.sendKeys(Amount);
        currency.click();
       // currency.sendKeys(Currency);
        usd.click();
        Thread.sleep(5000);
        continueB.click();
        Thread.sleep(5000);
        continueButton.click();

    }
      public boolean isSuccessMessagePresent(){
       String expected = "Your request has been sent for approval.";
        String actual =this.successMessage.getText();
        transactionId = actual.split("#")[1].split("\n")[0].trim();
        return (actual.contains(expected));
      }

    }


