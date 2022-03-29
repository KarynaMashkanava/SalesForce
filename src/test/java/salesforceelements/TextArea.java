package salesforceelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextArea {
    String label;
    String locator = "//div[./label[normalize-space() = '%s']]/textarea";
    WebDriver driver;

    public TextArea(WebDriver driver, String label) {
        this.label = label;
        this.driver = driver;
    }

    public void typeIntoTextArea(String text) {
        locator = String.format(locator, label);
        driver.findElement(By.xpath(locator)).sendKeys(text);
    }
}
