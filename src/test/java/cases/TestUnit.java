package cases;

import io.qameta.allure.Issue;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import pageObjects.*;
import utils.ConfProperties;
import utils.BrowserInit;
public class TestUnit {
    public WebDriver browser;
    public AddCustomerPage addCustomerPage;
    public ManagerMainPage managerMainPage;
    public CustomersListPage customersListPage;
    public static ConfProperties pr;

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
        browser.get(pr.getProperty("mainTestPage"));
        managerMainPage.clickAddCustomerButton();
        addCustomerPage
                .fillForm(
                        pr.getProperty("addCustomerTestFirstName"),
                        pr.getProperty("addCustomerTestLastName"),
                        pr.getProperty("addCustomerTestPostalCode"))
                .clickAddCustomerButton();
        Assert.assertTrue("Ошибка в тексте уведомления о регистрации новго пользователя", addCustomerPage.alertText().contains(pr.getProperty("assertRegistrationExpected")));
        managerMainPage.clickCustomersButton();
        customersListPage.clear();
    }
    @Test
    @Issue("UI-XYZBank-002")
    @DisplayName("Проверка сортировки списка клиентов по FirstName")
    public void testUIXYZ2() {
        browser.get(pr.getProperty("mainTestPage"));
        managerMainPage.clickCustomersButton();
        customersListPage.assertAbcSortFirstName()
                .assertCbeSortFirstName();
    }
    @Test
    @Issue("UI-XYZBank-003")
    @DisplayName("Проверка поиска клиента по FirstName")
    public void testUIXYZ3() {
        browser.get(pr.getProperty("mainTestPage"));
        managerMainPage.clickCustomersButton();
        customersListPage.fillSearchCustomerInput(pr.getProperty("testSearchName"));
        Assert.assertEquals(pr.getProperty("testSearchName"),customersListPage.getFirstCellName());
    }
    @After
    @Step("Очиска данных")
    public void after() {
        BrowserInit.closeWebdriver();
    }
}