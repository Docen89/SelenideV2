package resources;

import static com.codeborne.selenide.impl.Html.text;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoqaPage1 {

  public WebDriver driver;

  public DemoqaPage1(WebDriver driver) {
    PageFactory.initElements(driver, this);
    this.driver = driver;
  }

  /**
   * Выбор карточки на начальной странице
   */
  @FindBy(xpath = "//div[@class='category-cards']/div[position()=1]")
  private WebElement elements;
  /**
   * Выбор в карточке элемента из списка
   */
  @FindBy(xpath = "//li[@id='item-0']")
  private WebElement textBox;
  /**
   * определение поля ввода имени пользователя
   */
  @FindBy(xpath = "//input[@id='userName']")
  private WebElement userName;
  /**
   * определение поля ввода адреса email
   */
  @FindBy(xpath = "//input[@id='userEmail']")
  private WebElement userEmail;
  /**
   * определение поля ввода текущего адреса
   */
  @FindBy(xpath = "//textarea[@id='currentAddress']")
  private WebElement currentAddress;
  /**
   * определение поля ввода постоянного адреса
   */
  @FindBy(xpath = "//textarea[@id='permanentAddress']")
  private WebElement permanentAddress;
  /**
   * определение кнопки ввода информации
   */
  @FindBy(xpath = "//button[@id='submit']")
  private WebElement buttonSubmit;

  /**
   * определение карточки  Alerts, Frame & Windows
   */
  @FindBy(xpath = "//div[@class='category-cards']/div[position()=3]")
  private WebElement alertsFrameWindows;

  /**
   * определение карточки  Browser Windows
   */
  @FindBy(xpath = "//span[text()='Browser Windows']")
  private WebElement browserWindows;

  /**
   * определение кнопки New Tab
   */
  @FindBy(xpath = "//button[text()='New Tab']")
  private WebElement buttonNewTab;

  /**
   * определение заголовка на 2 вкладке
   */
  @FindBy(xpath = "//h1[@id='sampleHeading']")
  private WebElement sampleHeading;


  /**
   * метод для клика по карточка elements
   */
  public void clickElements() {
    elements.click();
  }

  /**
   * метод для клика по карточка elements
   */
  public void clickTextbox() {
    textBox.click();
  }

  /**
   * метод для ввода имени пользователя
   */
  public void inputUserName(String Name) {
    userName.sendKeys(Name);
  }

  /**
   * метод для ввода email
   */
  public void inputUserEmail(String Email) {
    userEmail.sendKeys(Email);
  }

  /**
   * метод для ввода текущего адреса
   */
  public void inputCurrentAddress(String curAddress) {
    currentAddress.sendKeys(curAddress);
  }

  /**
   * метод для ввода постоянного  адреса
   */
  public void inputPermanentAddress(String perAddress) {
    permanentAddress.sendKeys(perAddress);
  }

  /**
   * метод для осуществления нажатия кнопки входа в аккаунт
   */
  public void clickSubmitBtn() {
    buttonSubmit.click();
  }

  /**
   * метод для осуществления клика по карточке alertsFrameWindows
   */
  public void clickAlertsFrameWindows() {
    alertsFrameWindows.click();
  }


  /**
   * метод для осуществления клика  BrowserWindows
   */
  public void clickBrowserWindows() {
    browserWindows.click();
  }


  /**
   * метод для осуществления клика по кнопке NewTab
   */
  public void clickButtonNewTab() {
    buttonNewTab.click();
  }

  /**
   * метод для осуществления скоролла до кнопки
   */

  public void clickScrollSubmitBtn() {
    WebElement button = driver.findElement(By.xpath("//button[@id='submit']"));
    new Actions(driver)
        .scrollToElement(button)
        .perform();
  }

  /**
   * открытие новой вкладки
   */
  public void openNewPage() {
    Object[] windowHandles = driver.getWindowHandles().toArray();
    driver.switchTo().window((String) windowHandles[1]);
  }

  /**
   * проверка по тексту
   */
  public void openSampleHeading() {
    String textNewPage = driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText();
    assertEquals("This is a sample page", textNewPage);
  }

  /**
   * закрытие браузера
   */
  public void closeBrowser() {
    driver.quit();
  }

  /**
   * проверка имени
   */
  public void checkName() {
    String textName = driver.findElement(By.xpath("//p[@id='name']")).getText();
    assertEquals("Name:Taras", textName);
  }

  /**
   * проверка почты
   */
  public void checkEmail() {
    String textEmail = driver.findElement(By.xpath("//p[@id='email']")).getText();
    assertEquals("Email:test@bk.ru", textEmail);
  }
}
