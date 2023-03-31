package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AddCustomerPage {
    private final WebDriver browser;
    @FindBy(css = "input[ng-model='fName']")
    private WebElement inputFirstName;
    @FindBy(css = "input[ng-model='lName']")
    private WebElement inputLastName;
    @FindBy(css = "input[ng-model='postCd']")
    private WebElement inputPostalCode;
    @FindBy(css = ".btn-default")
    public WebElement buttonAddCustomer;

    public AddCustomerPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
    }
    @Step("Получение сообщения о регистрации пользователя")
    public String alertText() {
        Alert alert = browser.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }
    @Step("Заполнение формы регистрации")
    public AddCustomerPage fillForm(String testName, String testLastName, String testPostalCode) {
        inputFirstName.sendKeys(testName);
        inputLastName.sendKeys(testLastName);
        inputPostalCode.sendKeys(testPostalCode);
        return this;
    }
    @Step("Нажатие на кнопку AddCustomer на странице формы регистрации")
    public AddCustomerPage clickAddCustomerButton() {
        buttonAddCustomer.click();
        return this;
    }


}
