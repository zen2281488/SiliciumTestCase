package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagerMainPage {
    private final WebDriver browser;
    @FindBy(xpath = "//button[@ng-class='btnClass1']")
    public WebElement addCustomer;
    @FindBy(xpath = "//button[@ng-class='btnClass3']")
    public WebElement customers;

    public ManagerMainPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
    }

    @Step("Нажатие на кнопку Customers на главной странице")
    public ManagerMainPage clickCustomersButton() {
        customers.click();
        return this;
    }

    @Step("Нажатие на кнопку AddCustomer на главной странице")
    public ManagerMainPage clickAddCustomerButton() {
        addCustomer.click();
        return this;
    }
}
