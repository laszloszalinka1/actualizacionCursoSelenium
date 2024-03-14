package pages;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
    protected static WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    static{
       // System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO\\Desktop\\automation\\herculesCompensar\\app\\src\\test\\resources\\webDriver\\chromedriver.exe");
        ChromeOptions chrome = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chrome);
    }
    public BasePage(WebDriver driver){
        BasePage.driver = driver;
    }
    public static void navigateTo(String url){
        driver.get(url);

    }
    public static void logout(){
        driver.quit();
    }
    public WebElement find(String locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));

    }
    public void clickElement(String locator){
        find(locator).click();

    }
     public void selectedFromDropdownByValue(String locator, String valueToSelect){
        Select dropdown = new Select(find(locator));
        dropdown.selectByValue(valueToSelect);

    }
    public void selectedFromDropdownByIndex(String locator, int valueToSelect){
        Select dropdown = new Select(find(locator));
        dropdown.selectByIndex(valueToSelect);

    }
    public void selectedFromDropdownByText(String locator, String valueToSelect){
        Select dropdown = new Select(find(locator));
        dropdown.selectByVisibleText(valueToSelect);
    }
    public List<String> getDropdownValues(String locator){
        Select dropdown = new Select(find(locator));
        List<WebElement> dropDownOptions = dropdown.getOptions();
        List<String> values = new ArrayList<>();
        for(WebElement option: dropDownOptions){
            values.add(option.getText());
        }
        return values;
    }
    
}
