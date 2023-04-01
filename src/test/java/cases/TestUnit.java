package cases;

import io.qameta.allure.Issue;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObjects.AddCustomerPage;
import pageObjects.CustomersListPage;
import pageObjects.ManagerMainPage;
import utils.BrowserInit;
import utils.ConfProperties;

public class TestUnit {
    public static ConfProperties pr;
    public WebDriver browser;
    public AddCustomerPage addCustomerPage;
    public ManagerMainPage managerMainPage;
    public CustomersListPage customersListPage;

    @Before
    @Step("Инициализация браузера")
    public void before() {
        browser = BrowserInit.getWebdriver();
        addCustomerPage = new AddCustomerPage(browser);
        managerMainPage = new ManagerMainPage(browser);
        customersListPage = new CustomersListPage(browser);
    }

    @Test
    @Issue("UI-XYZBank-001")
    @DisplayName("Проверка регистрации нового пользователя")
    public void testUIXYZ1() {
        browser.get(ConfProperties.getProperty("mainTestPage"));
        managerMainPage.clickAddCustomerButton();
        addCustomerPage
                .fillForm(
                        ConfProperties.getProperty("addCustomerTestFirstName"),
                        ConfProperties.getProperty("addCustomerTestLastName"),
                        ConfProperties.getProperty("addCustomerTestPostalCode"))
                .clickAddCustomerButton();
        Assert.assertTrue("Ошибка в тексте уведомления о регистрации новго пользователя", addCustomerPage.alertText().contains(ConfProperties.getProperty("assertRegistrationExpected")));
        managerMainPage.clickCustomersButton();
        customersListPage.clear();
    }

    @Test
    @Issue("UI-XYZBank-002")
    @DisplayName("Проверка сортировки списка клиентов по FirstName")
    public void testUIXYZ2() {
        browser.get(ConfProperties.getProperty("mainTestPage"));
        managerMainPage.clickCustomersButton();
        customersListPage.assertAbcSortFirstName()
                .assertCbeSortFirstName();
    }

    @Test
    @Issue("UI-XYZBank-003")
    @DisplayName("Проверка поиска клиента по FirstName")
    public void testUIXYZ3() {
        browser.get(ConfProperties.getProperty("mainTestPage"));
        managerMainPage.clickCustomersButton();
        customersListPage.fillSearchCustomerInput(ConfProperties.getProperty("testSearchName"));
        Assert.assertEquals(ConfProperties.getProperty("testSearchName"), customersListPage.getFirstCellName());
    }

    @After
    @Step("Очиска данных")
    public void after() {
        BrowserInit.closeWebdriver();
    }
}