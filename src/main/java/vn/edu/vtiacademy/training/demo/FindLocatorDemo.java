package vn.edu.vtiacademy.training.demo;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import vn.edu.vtiacademy.training.utils.keywords.WebUI;

public class FindLocatorDemo {

  public static final String DANTRI_URL = "https://dantri.com.vn";

  public static final String VNEXPRESS_URL = "https://vnexpress.net/";

  public static final String SITEDEMO_URL = "https://demoqa.com/";

  public static final String PNL_SECTIONS = "xpath://div[@class='category-cards']//div[1]//div[1]//div[2]//input[name()='svg']";

  public static final String LNK_SECTIONS = "tag:a";

  public static final String LBL_FORMS = "//div[@class='home-body']//div[2]//div[1]//div[2]//*[name()='svg']";

  public static final String LBL_PRACTICE_FORM = "//span[normalize-space()='Practice Form']";

  public static final String TXT_FIRST_NAME = "id:firstName";

  public static void main(String[] args) throws InterruptedException {
//    System.setProperty("webdriver.chrome.driver", "/Users/kengzone/training-workspace/VTI_AT-20230524_Selenium/AutomationFramework/drivers/chromedriver");
//    ChromeOptions options = new ChromeOptions();
//    options.addArguments("--remote-allow-origins=*");
//    WebDriver driver = new ChromeDriver(options); // Khởi tạo sever: localhost:port, mở trình duyệt
//    driver.get("https://dantri.com.vn"); // nhập địa chỉ website vào url textbox trên trình duyệt
//    driver.manage().window().maximize();
//    Thread.sleep(5000);
//    driver.findElement(By.xpath("//li[@class='has-child']//a[contains(text(),'Xã hội')]")).click();
//    Thread.sleep(5000);
//    driver.findElement(By.xpath("//a[contains(text(),'Công an tìm các chủ xe từng bị \"làm khó\" tại 14 tr')]")).click();
//    Thread.sleep(5000);
//    driver.close();

    WebUI webUI = new WebUI();
    webUI.openBrowser("Chrome", SITEDEMO_URL);
    Thread.sleep(5000);
    //webUI.getTitle();
    //webUI.waitFor(ExpectedConditions.titleContains("DEMOQA"), 10);
    webUI.maximizeWindow();
    Thread.sleep(5000);
    webUI.findElement(PNL_SECTIONS);
    Thread.sleep(5000);
    List<WebElement> elements = webUI.findElements(LNK_SECTIONS);
    for(int i = 0; i < elements.size(); i++){
      System.out.println(webUI.getElementText(elements.get(i)));
    }
    Thread.sleep(5000);
    webUI.clickElement(LBL_FORMS);
    Thread.sleep(5000);
    webUI.clickElement(LBL_PRACTICE_FORM);
    Thread.sleep(5000);
    webUI.setText(TXT_FIRST_NAME, "Nhat Thai");
    Thread.sleep(2000);
    webUI.sendKeys(TXT_FIRST_NAME, Keys.chord(Keys.SHIFT, Keys.HOME, Keys.BACK_SPACE));
    Thread.sleep(2000);
//    webUI.setText(By.xpath("//input[@id='lastName']"), "Nguyen");
//    Thread.sleep(2000);
//    webUI.setText(By.xpath("//input[@id='userEmail']"), "abc@gmail.com");
//    Thread.sleep(2000);
//    webUI.getElementText(By.xpath("//input[@id='userEmail']"));
//    Thread.sleep(2000);
//    webUI.setText(By.xpath("//input[@id='userNumber']"), "098765");
//    Thread.sleep(2000);
//    webUI.clearText(By.xpath("//input[@id='userNumber']"));
//    Thread.sleep(2000);
//    webUI.setText(By.xpath("//input[@id='userNumber']"), "0123456789");
//    Thread.sleep(2000);
//    webUI.getElementAttributeValue(By.xpath("//input[@id='dateOfBirthInput']"), "value");
//    webUI.verifyElementSelected(By.xpath("//input[@id='gender-radio-1']"));
//    System.out.println(webUI.verifyElementSelected(By.xpath("//input[@id='gender-radio-1']")));
//    webUI.clickElement(By.xpath("//label[@for='gender-radio-1']"));
//    Thread.sleep(2000);
//    webUI.verifyElementSelected(By.xpath("//input[@id='gender-radio-1']"));
//    System.out.println(webUI.verifyElementSelected(By.xpath("//input[@id='gender-radio-1']")));
//    webUI.getElementSize(By.xpath("//label[@for='gender-radio-1']"));
//    webUI.verifyElementVisible(By.xpath("//div[@class='subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3']"));
//    webUI.verifyElementClickable(By.xpath("//label[@for='hobbies-checkbox-1']"));
//    webUI.getElementCssValue(By.cssSelector("label[for='hobbies-checkbox-1']']"), "id");
//    Thread.sleep(2000);
//    webUI.scrollDown();
//    Thread.sleep(2000);
//    webUI.setText(By.xpath("//textarea[@id='currentAddress']"), "aaaa");
//    webUI.getElementLocation(By.xpath("//textarea[@id='currentAddress']"));
//    Thread.sleep(2000);
//    webUI.getElementAttribute(By.xpath("//textarea[@id='currentAddress']"), "id");
//    webUI.getElementTagName(By.xpath("//input[@id='uploadPicture']"));
//    Thread.sleep(2000);
//    webUI.clickElement(By.xpath("//button[@id='submit']"));
//    webUI.submitForm(By.xpath("//button[@id='submit']"));
    Thread.sleep(5000);
    webUI.closeBrowser();
  }

}
