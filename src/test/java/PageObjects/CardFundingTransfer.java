package PageObjects;

import io.cucumber.java.en.And;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;



public class CardFundingTransfer {
  @FindBy(xpath ="//*[@class='aside__row active']/..//*[@class='aside__row']/..//*[@class='aside__label main_color transfer']")
  @CacheLookup
  WebElement transfers;

  @FindBy (xpath = "//*[@class='sections-container']/..//*[contains(text(),'Card Funding Transfer')]")
  @CacheLookup
  WebElement cardFundingTransfer;

  @FindBy (xpath = "//*[contains(text(),'Select account')]")
  @CacheLookup
  WebElement debitFrom;

  //Actions action = new Actions(driver);

  @FindBy (xpath = "//*[contains(text(),'Checking')]")
  @CacheLookup
  WebElement checking;

  @FindBy (xpath = "//*[contains(text(),'Select card')]")
  @CacheLookup
  WebElement creditTo;

  @FindBy (xpath = "//*[@class='ng-dropdown-panel-items scroll-host']/..//*[@class='ng-option']")
  @CacheLookup
  WebElement creditCard;

  @FindBy (xpath = "//input[@*='outgoingAmount']")
  @CacheLookup
  WebElement amountToTransfer;


  @FindBy (xpath = "//*[@class='def-btn-success main_color']")
  @CacheLookup
  WebElement continueButton;

  @FindBy (xpath = "//*[@class='def-btn-success main_color']")
  @CacheLookup
  WebElement confirm;

  @FindBy (xpath = "//*[@class='success-popup']")
  @CacheLookup
  WebElement successMessage;
  private  String transactionID;
  public String getTransactionID() {
    return transactionID;

  }


  public void process(String AmountToTransfer) throws InterruptedException {
    Thread.sleep(5000);
    transfers.click();
    Thread.sleep(5000);
    cardFundingTransfer.click();
    debitFrom.click();
    checking.click();
    creditTo.click();
    creditCard.click();
    amountToTransfer.sendKeys(AmountToTransfer);
    Thread.sleep(5000);
    continueButton.click();
    Thread.sleep(5000);
    confirm.click();



  }
  public boolean isSuccessMessagePresent(){
    String expected= "Your request has been sent for approval";
    String actual= this.successMessage.getText();

     transactionID=actual.split("#")[1].split("\n")[0].trim();

    return (expected.equals(actual));
  }

}
