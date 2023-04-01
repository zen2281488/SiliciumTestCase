package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TableRow {
    private final WebElement rootElement;

    public TableRow(WebElement rootElement) {
        this.rootElement = rootElement;
    }

    public String getFirstNameText() {
        return rootElement.findElement(By.cssSelector("td:nth-child(1)")).getText();
    }
}
