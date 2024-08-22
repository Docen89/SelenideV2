

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import resources.DemoqaPage1;

public class DemoqaTest {

  public static DemoqaPage1 demoqaPage1;

  @BeforeEach
  public void setup() {
    WebDriverManager.chromedriver().setup();
    //создание экземпляра драйвера
    WebDriver driver = new ChromeDriver();
    demoqaPage1 = new DemoqaPage1(driver);
    //окно разворачивается на полный экран
    driver.manage().window().setSize(new Dimension(1920, 1080));
    //получение ссылки на страницу входа из файла настроек
    driver.get(ConfProperties.getProperty("startpage"));
  }

  @Test
  @DisplayName("Проверка заполнения полей userName,userEmail,currentAddress,permanentAddress")
  public void DemoqaTest_1() {
    demoqaPage1.clickElements();
    //кликаем по карточке elements
    demoqaPage1.clickTextbox();
    //кликаем по карточке Textbox
    demoqaPage1.inputUserName(ConfProperties.getProperty("Name"));
    demoqaPage1.inputUserEmail(ConfProperties.getProperty("Email"));
    demoqaPage1.inputCurrentAddress(ConfProperties.getProperty("CurAddress"));
    demoqaPage1.inputPermanentAddress(ConfProperties.getProperty("PerAddress"));
    demoqaPage1.clickScrollSubmitBtn();
    demoqaPage1.clickSubmitBtn();
    demoqaPage1.checkEmail();
    demoqaPage1.checkName();
  }

  @Test
  @DisplayName("Открытие новой вкладки")
  public void DemoqaTest_2() {
    demoqaPage1.clickAlertsFrameWindows();
    demoqaPage1.clickBrowserWindows();
    demoqaPage1.clickBrowserWindows();
    demoqaPage1.clickButtonNewTab();
    demoqaPage1.openNewPage();
    demoqaPage1.openSampleHeading();
  }

  @AfterEach
  public void tearDown() {
    demoqaPage1.closeBrowser();
  }
}

