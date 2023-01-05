package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CardFundingTransfer {
  @FindBy (xpath = "//*[@class='aside__row active']/..//*[@class='aside__label main_color transfer']")
  @CacheLookup
  WebElement transfers;

  @FindBy (xpath = "//*[contains(text(),'Card Funding Transfer')]")
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

  @FindBy (xpath = "//*[contains(@id,'a64258c86a22')]")
  @CacheLookup
  WebElement creditCard;

  @FindBy (xpath = "//*[contains(@class,'currency-icon')]")
  @CacheLookup
  WebElement amountToTransfer;

  @FindBy (xpath = "//*[contains(@class,''checkbox-checkmark')]")
  @CacheLookup
  WebElement checkbox;

  @FindBy (xpath = "//*[contains(@id,'template-name')]")
  @CacheLookup
  WebElement templateName;

  @FindBy (xpath = "//*[@class='def-btn-success main_color']")
  @CacheLookup
  WebElement continueButton;

  @FindBy (xpath = "//*[contains(text(),'Confirm')]")
  @CacheLookup
  WebElement confirm;

  @FindBy (xpath = "//*[contains(text(),'')]")
  @CacheLookup
  WebElement successMessage;


  public void process (String TemplateName){
    transfers.click();
    cardFundingTransfer.click();
    debitFrom.click();
    checking.click();
    creditTo.click();
    creditCard.click();
    amountToTransfer.click();
    templateName.sendKeys(TemplateName);
    checkbox.click();
    continueButton.click();
    confirm.click();



  }
  public boolean isSuccessMessagePresent(){
    String expected= "";
  }
}
