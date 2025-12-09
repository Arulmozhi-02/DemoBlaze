package com.base;

import java.awt.Robot;
import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class BaseClass {

	protected WebDriver driver;
    protected Actions actions;
    protected Robot robot;
    protected JavascriptExecutor js;
    
    // 1. Browser Launch
    public void launchBrowser(String browserName) {
        try {
            switch(browserName.toLowerCase()) {
                case "chrome":                    driver = new ChromeDriver();                  break;
                case "firefox":                   driver = new FirefoxDriver();                 break;
                case "edge":                      driver = new EdgeDriver();                    break;
                default:                    System.out.println("Invalid browser name");
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            js = (JavascriptExecutor) driver;
        } catch (Exception e) {
            Assert.fail();
        }
    }
    
    // 2. Close
    public void closeBrowser() {
        try {
        	driver.close();
            } catch (Exception e) {
            Assert.fail();
        }
    }
    
    // 3. Quit
    public void quitBrowser() {
        try {driver.quit();
         } catch (Exception e) {
            Assert.fail();
        }
    }
    
    // 4. Navigate To
    public void navigateTo(String url) {
        try {
            driver.navigate().to(url);
        } catch (Exception e) {
            Assert.fail();
        }
    }
    
    // 5. Navigate Back
    public void navigateBack() {
        try {
            driver.navigate().back();
        } catch (Exception e) {
            Assert.fail();
        }
    }
    
    // 6. Navigate Forward
    public void navigateForward() {
        try {
            driver.navigate().forward();
        } catch (Exception e) {
            Assert.fail("ERROR: ");
        }
    }
    
    // 7. Navigate Refresh
    public void navigateRefresh() {
        try {
            driver.navigate().refresh();
        } catch (Exception e) {
            Assert.fail();
        }
    }
    
    // 8. Get
    public void getUrl(String url) {
        try {
            driver.get(url);
        } catch (Exception e) {
            Assert.fail();
        }
    }
    
    // 9. Alert
    public void acceptAlert() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            Assert.fail();
        }
    }
    
    public void dismissAlert() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
        } catch (Exception e) {
            Assert.fail();
        }
    }
    
    public String getAlertText() {
        try {
            Alert alert = driver.switchTo().alert();
            return alert.getText();
        } catch (Exception e) {
            Assert.fail();
            return null;
        }
    }
    
    public void sendKeysToAlert(String text) {
        try {
            Alert alert = driver.switchTo().alert();
            alert.sendKeys(text);
        } catch (Exception e) {
            Assert.fail();
        }
    }
    
    // 10. Actions - All Methods
    public void moveToElement(WebElement element) {
        try {
            actions = new Actions(driver);
            actions.moveToElement(element).perform();
        } catch (Exception e) {
            Assert.fail();
        }
    }
    
    public void clickElement(WebElement element) {
        try {
            actions = new Actions(driver);
            actions.click(element).perform();
        } catch (Exception e) {
            Assert.fail();
        }
    }
    
    public void doubleClickElement(WebElement element) {
        try {
            actions = new Actions(driver);
            actions.doubleClick(element).perform();
        } catch (Exception e) {
            Assert.fail();
        }
    }
    
    public void rightClickElement(WebElement element) {
        try {
            actions = new Actions(driver);
            actions.contextClick(element).perform();
        } catch (Exception e) {
            Assert.fail("ERROR : ");
        }
    }
    
    public void dragAndDrop(WebElement source, WebElement target) {
        try {
            actions = new Actions(driver);
            actions.dragAndDrop(source, target).perform();
        } catch (Exception e) {
            Assert.fail();
        }
    }
    
    public void clickAndHold(WebElement element) {
        try {
            actions = new Actions(driver);
            actions.clickAndHold(element).perform();
        } catch (Exception e) {
            Assert.fail();
        }
    }
    
    public void release(WebElement element) {
        try {
            actions = new Actions(driver);
            actions.release(element).perform();
        } catch (Exception e) {
            Assert.fail();
        }
    }
    
    // 11. Frames
    public void switchToFrameByIndex(int index) {
        try {
            driver.switchTo().frame(index);
        } catch (Exception e) {
            Assert.fail();
        }
    }
    
    public void switchToFrameByName(String nameOrId) {
        try {
            driver.switchTo().frame(nameOrId);
        } catch (Exception e) {
            Assert.fail();
        }
    }
    
    public void switchToFrameByElement(WebElement element) {
        try {
            driver.switchTo().frame(element);
        } catch (Exception e) {
            Assert.fail();
        }
    }
    
    public void switchToDefaultContent() {
        try {
            driver.switchTo().defaultContent();
        } catch (Exception e) {
            Assert.fail();
        }
    }
    
    public void switchToParentFrame() {
        try {
            driver.switchTo().parentFrame();
        } catch (Exception e) {
            Assert.fail();
        }
    }
    
    // 12. Robot
    public void initializeRobot() {
        try {
            robot = new Robot();
        } catch (Exception e) {
            Assert.fail();
        }
    }
    
    public void robotKeyPress(int keyEvent) {
        try {
            if (robot == null) initializeRobot();
            robot.keyPress(keyEvent);
        } catch (Exception e) {
            Assert.fail();
        }
    }
    
    public void robotKeyRelease(int keyEvent) {
        try {
            if (robot == null) initializeRobot();
            robot.keyRelease(keyEvent);
        } catch (Exception e) {
            Assert.fail();
        }
    }
    
    // 13. Window Handles
    public void switchToWindow(String windowHandle) {
        try {
            driver.switchTo().window(windowHandle);
        } catch (Exception e) {
            Assert.fail();
        }
    }
    
    public String getCurrentWindowHandle() {
        try {
            return driver.getWindowHandle();
        } catch (Exception e) {
            Assert.fail();
            return null;
        }
    }
    
    public Set<String> getAllWindowHandles() {
        try {
            return driver.getWindowHandles();
        } catch (Exception e) {
            Assert.fail();
            return null;
        }
    }
    
    public void switchToNewWindow() {
        try {
            Set<String> handles = driver.getWindowHandles();
            for (String handle : handles) {
                driver.switchTo().window(handle);
            }
        } catch (Exception e) {
            Assert.fail();
        }
    }
    
    // 14. Drop Down
    public void selectByVisibleText(WebElement element, String text) {
        try {
            Select select = new Select(element);
            select.selectByVisibleText(text);
        } catch (Exception e) {
        	 Assert.fail();
        }
    }
    
    public void selectByValue(WebElement element, String value) {
        try {
            Select select = new Select(element);
            select.selectByValue(value);
        } catch (Exception e) {
        	Assert.fail();
        }
    }
    
    public void selectByIndex(WebElement element, int index) {
        try {
            Select select = new Select(element);
            select.selectByIndex(index);
        } catch (Exception e) {
        	Assert.fail();
        }
    }
    
    public void deselectAll(WebElement element) {
        try {
            Select select = new Select(element);
            select.deselectAll();
        } catch (Exception e) {
        	Assert.fail();
        }
    }
    
    // 15. Check Box
    public void selectCheckBox(WebElement element) {
        try {
            if (!element.isSelected()) {
                element.click();
            }
        } catch (Exception e) {
        	Assert.fail();
        }
    }
    
    public void deselectCheckBox(WebElement element) {
        try {
            if (element.isSelected()) {
                element.click();
            }
        } catch (Exception e) {
        	Assert.fail();
        }
    }
    
    // 16. Is Enabled
    public boolean isEnabled(WebElement element) {
        try {
            return element.isEnabled();
        } catch (Exception e) {
        	Assert.fail();
            return false;
        }
    }
    
    // 17. Is Displayed
    public boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
        	Assert.fail();
            return false;
        }
    }
    
    // 18. Is Selected
    public boolean isSelected(WebElement element) {
        try {
            return element.isSelected();
        } catch (Exception e) {
        	Assert.fail();
            return false;
        }
    }
    
    // 19. Get Options
    public List<WebElement> getOptions(WebElement element) {
        try {
            Select select = new Select(element);
            return select.getOptions();
        } catch (Exception e) {
        	Assert.fail();
            return null;
        }
    }
    
    // 20. Get Title
    public String getTitle() {
        try {
            return driver.getTitle();
        } catch (Exception e) {
        	Assert.fail();
            return null;
        }
    }
    
    // 21. Get Current URL
    public String getCurrentUrl() {
        try {
            return driver.getCurrentUrl();
        } catch (Exception e) {
        	Assert.fail();
            return null;
        }
    }
    
    // 22. Get Text
    public String getText(WebElement element) {
        try {
            return element.getText();
        } catch (Exception e) {
        	Assert.fail();
            return null;
        }
    }
    
    // 23. Get Attribute
    public String getAttribute(WebElement element, String attributeName) {
        try {
            return element.getAttribute(attributeName);
        } catch (Exception e) {
        	Assert.fail();
            return null;
        }
    }
    
    // 24. Wait
    public void implicitWait(int seconds) {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
        } catch (Exception e) {
        	Assert.fail();
        }
    }
    
    public void explicitWait(WebElement element, int seconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
        	Assert.fail();
        }
    }
    
    public void waitForElementClickable(WebElement element, int seconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
        	Assert.fail();
        }
    }
    
    public void fluentWait(WebElement element, int timeout, int polling) {
        try {
            Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(polling))
                .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
        	Assert.fail("ERROR : ");
        }
    }
    
    // 25. Take Screenshot
    public void takeScreenshot(String fileName) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            File destination = new File("D:\\GREENS SELENIUM COURSE\\Maven_Project\\Screenshots\\" + fileName + ".png");
            FileHandler.copy(source, destination);
        } catch (Exception e) {
        	Assert.fail();
        }
    }
    
    // 26. Scroll Up and Down
    public void scrollDown(int pixels) {
        try {
            js.executeScript("window.scrollBy(0," + pixels + ")");
        } catch (Exception e) {
        	Assert.fail();
        }
    }
    
    public void scrollUp(int pixels) {
        try {
            js.executeScript("window.scrollBy(0,-" + pixels + ")");
        } catch (Exception e) {
        	Assert.fail();
        }
    }
    
    public void scrollToElement(WebElement element) {
        try {
            js.executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception e) {
        	Assert.fail();
        }
    }
    
    public void scrollToBottom() {
        try {
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        } catch (Exception e) {
        	Assert.fail();
        }
    }
    
    public void scrollToTop() {
        try {
            js.executeScript("window.scrollTo(0, 0)");
        } catch (Exception e) {
        	Assert.fail();
        }
    }
    
    // 27. SendKeys
    public void sendKeys(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
        } catch (Exception e) {
        	Assert.fail();
        }
    }
    
    // 28. Get First Selected Option
    public WebElement getFirstSelectedOption(WebElement element) {
        try {
            Select select = new Select(element);
            return select.getFirstSelectedOption();
        } catch (Exception e) {
        	Assert.fail();
            return null;
        }
    }
    
    // 29. Get All Selected Options
    public List<WebElement> getAllSelectedOptions(WebElement element) {
        try {
            Select select = new Select(element);
            return select.getAllSelectedOptions();
        } catch (Exception e) {
            Assert.fail("Failed to get all selected options: " + e.getMessage());
            return null;
        }
    }
    
    // 30. Is Multiple
    public boolean isMultiple(WebElement element) {
        try {
            Select select = new Select(element);
            return select.isMultiple();
        } catch (Exception e) {
            Assert.fail("Failed to check if multiple: " + e.getMessage());
            return false;
        }
    }
    
    // 31. Click
    public void click(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            Assert.fail("Failed to click element: " + e.getMessage());
        }
    }
    
    // 32. Radio Button
    public void selectRadioButton(WebElement element) {
        try {
            if (!element.isSelected()) {
                element.click();
            }
        } catch (Exception e) {
            Assert.fail("Failed to select radio button: " + e.getMessage());
        }
    }
    
    // 33. JavaScript Executor - All Methods
    public void jsClick(WebElement element) {
        try {
            js.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            Assert.fail("Failed to perform JS click: " + e.getMessage());
        }
    }
    
    public void jsSendKeys(WebElement element, String text) {
        try {
            js.executeScript("arguments[0].value='" + text + "';", element);
        } catch (Exception e) {
            Assert.fail("Failed to perform JS sendKeys: " + e.getMessage());
        }
    }
    
    public void jsHighlight(WebElement element) {
        try {
            js.executeScript("arguments[0].style.border='3px solid red'", element);
        } catch (Exception e) {
            Assert.fail("Failed to highlight element: " + e.getMessage());
        }
    }
    
    public String jsGetTitle() {
        try {
            return js.executeScript("return document.title;").toString();
        } catch (Exception e) {
            Assert.fail("Failed to get title using JS: " + e.getMessage());
            return null;
        }
    }
    
    public String jsGetURL() {
        try {
            return js.executeScript("return document.URL;").toString();
        } catch (Exception e) {
            Assert.fail("Failed to get URL using JS: " + e.getMessage());
            return null;
        }
    }
    
    public void jsRefresh() {
        try {
            js.executeScript("history.go(0)");
        } catch (Exception e) {
        	Assert.fail();
        }
    }
    
    public void jsAlert(String message) {
        try {
            js.executeScript("alert('" + message + "')");
        } catch (Exception e) {
        	Assert.fail();
        }
    }
    
    public String jsGetInnerText() {
        try {
            return js.executeScript("return document.documentElement.innerText;").toString();
        } catch (Exception e) {
        	Assert.fail();
            return null;
        }
    }
    
    public void jsScrollIntoView(WebElement element) {
        try {
            js.executeScript("arguments[0].scrollIntoView();", element);
        } catch (Exception e) {
        	Assert.fail();
        }
    }
    
    public void jsChangeColor(WebElement element, String color) {
        try {
            js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);
        } catch (Exception e) {
        	Assert.fail();
        }
    }
}

