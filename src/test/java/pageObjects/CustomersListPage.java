package pageObjects;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CustomersListPage {
    private final WebDriver browser;
    @FindBy(xpath = ".//tr/td[text()='test']/../td/button")
    public WebElement delTestCustomerButton;
    @FindBy(xpath = "//tr/td/a[text()[contains(.,'First Name')]]")
    public WebElement firstNameHyper;
    @FindBy(xpath = "//tbody/tr")
    public List<WebElement> row;
    @FindBy(xpath = "//tbody/tr/td[1]")
    public WebElement firstCellAfterSearch;
    @FindBy(css = "input[type='text']")
    public WebElement customerSearchInput;

    public CustomersListPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
    }

    @Step("Нажатие на кнопку сортировки")
    public CustomersListPage clickSort() {
        firstNameHyper.click();
        return this;
    }

    @Step("Удаление тестового пользователя")
    public CustomersListPage clear() {
        delTestCustomerButton.click();
        return this;
    }

    public List<TableRow> getRows() {
        return row.stream().map(TableRow::new).collect(Collectors.toList());
    }

    @Step("Проверка сортировки по FirstName в обратном алфавитному порядке")
    public CustomersListPage assertCbeSortFirstName() {
        var actualResultCbe = clickSort().getRows().stream().map(TableRow::getFirstNameText).collect(Collectors.toList());
        var expectedResultCba = new ArrayList<>(actualResultCbe);
        Collections.sort(expectedResultCba);
        Collections.reverse(expectedResultCba);
        Assert.assertEquals(expectedResultCba, actualResultCbe);
        return this;
    }

    @Step("Проверка сортировки по FirstName в алфавитном порядке")
    public CustomersListPage assertAbcSortFirstName() {
        var actualResultAbc = clickSort().clickSort().getRows().stream().map(TableRow::getFirstNameText).collect(Collectors.toList());
        var expectedResultAbc = new ArrayList<>(actualResultAbc);
        Collections.sort(expectedResultAbc);
        Assert.assertEquals(expectedResultAbc, actualResultAbc);
        return this;
    }

    @Step("Заполнение строки поиска клиентов")
    public CustomersListPage fillSearchCustomerInput(String cutomerName) {
        customerSearchInput.sendKeys(cutomerName);
        return this;
    }

    @Step("Получение значения Firstname найденного пользователя")
    public String getFirstCellName() {
        return firstCellAfterSearch.getText();
    }
}
