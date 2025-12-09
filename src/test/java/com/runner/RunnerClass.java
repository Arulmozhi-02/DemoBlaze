package com.runner;

import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;

public class RunnerClass extends BaseClass {

	public static void main(String[] args) {
		RunnerClass test = new RunnerClass();
        
        // Run all test methods
        test.testAmazon();
        test.testFlipkart();
        test.testMyntra();
        //test.testDemoBlaze();
        test.testAutomationExercise();
        test.testSpiceJet();
        test.testWindowHandles();
        test.testRobotClass();
        //test.testActionsClass();
        test.testJavaScriptExecutor();
        test.testDropdownOperations();
        test.testWaitMechanisms();
        
    }
    
    // ==================== AMAZON TEST CASES ====================
    
    public void testAmazon() {
        System.out.println("\n========== TESTING AMAZON ==========");
        
        try {
            // Launch Browser
            System.out.println("Launching Chrome browser...");
            launchBrowser("chrome");
            
            // Navigate to Amazon
            System.out.println("Navigating to Amazon...");
            getUrl("https://www.amazon.in");
            
            // Get Title
            String title = getTitle();
            System.out.println("Page Title: " + title);
            
            // Get Current URL
            String url = getCurrentUrl();
            System.out.println("Current URL: " + url);
            
            // Search for product using SendKeys
            System.out.println("Searching for iPhone 15...");
            WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
            sendKeys(searchBox, "iPhone 15");
            
            // Click Search Button
            WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
            click(searchButton);
            
            // Wait for results
            Thread.sleep(3000);
            
            // Scroll Down
            System.out.println("Scrolling down...");
            scrollDown(500);
            
            // Take Screenshot
            System.out.println("Taking screenshot...");
            takeScreenshot("amazon_search_results");
            
            // Get text of first product
            try {
                WebElement firstProduct = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]"));
                String productText = getText(firstProduct);
                System.out.println("First Product: " + productText);
            } catch (Exception e) {
                System.out.println("Product element not found - continuing test");
            }
            
            // Navigate Back
            System.out.println("Navigating back...");
            navigateBack();
            Thread.sleep(2000);
            
            // Navigate Forward
            System.out.println("Navigating forward...");
            navigateForward();
            Thread.sleep(2000);
            
            // Scroll to Bottom
            System.out.println("Scrolling to bottom...");
            scrollToBottom();
            Thread.sleep(1000);
            
            // Scroll to Top
            System.out.println("Scrolling to top...");
            scrollToTop();
            
            System.out.println("Amazon test completed successfully!\n");
            
        } catch (Exception e) {
            System.out.println("Error in Amazon test: " + e.getMessage());
        } finally {
            quitBrowser();
        }
    }
    
    // ==================== FLIPKART TEST CASES ====================
    
    public void testFlipkart() {
        System.out.println("\n========== TESTING FLIPKART ==========");
        
        try {
            System.out.println("Launching Chrome browser...");
            launchBrowser("chrome");
            
            System.out.println("Navigating to Flipkart...");
            navigateTo("https://www.flipkart.com");
            
            Thread.sleep(3000);
            
            // Close Login Popup if present
            try {
                WebElement closeButton = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
                jsClick(closeButton);
                System.out.println("Closed login popup");
            } catch (Exception e) {
                System.out.println("No popup present - continuing");
            }
            
            // Search for product
            System.out.println("Searching for Samsung Galaxy S24...");
            WebElement searchBox = driver.findElement(By.name("q"));
            jsSendKeys(searchBox, "Samsung Galaxy S24");
            
            // Click search using JS
            WebElement searchBtn = driver.findElement(By.xpath("//button[@type='submit']"));
            jsClick(searchBtn);
            
            Thread.sleep(4000);
            
            // Get page title using JS
            String title = jsGetTitle();
            System.out.println("Page Title (JS): " + title);
            
            // Get URL using JS
            String url = jsGetURL();
            System.out.println("Current URL (JS): " + url);
            
            // Scroll down
            System.out.println("Scrolling down...");
            scrollDown(800);
            
            // Highlight element
            try {
                WebElement product = driver.findElement(By.xpath("(//div[@class='_4rR01T'])[1]"));
                jsHighlight(product);
                String productText = getText(product);
                System.out.println("Product: " + productText);
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("Product element not found - continuing");
            }
            
            // Take Screenshot
            System.out.println("Taking screenshot...");
            takeScreenshot("flipkart_search");
            
            // Refresh page using JS
            System.out.println("Refreshing page using JS...");
            jsRefresh();
            
            Thread.sleep(2000);
            System.out.println("Flipkart test completed successfully!\n");
            
        } catch (Exception e) {
            System.out.println("Error in Flipkart test: " + e.getMessage());
        } finally {
            quitBrowser();
        }
    }
    
    // ==================== MYNTRA TEST CASES ====================
    
    public void testMyntra() {
        System.out.println("\n========== TESTING MYNTRA ==========");
        
        try {
            System.out.println("Launching Chrome browser...");
            launchBrowser("chrome");
            
            System.out.println("Navigating to Myntra...");
            getUrl("https://www.myntra.com");
            
            Thread.sleep(3000);
            
            // Hover over Men category
            try {
                WebElement menMenu = driver.findElement(By.xpath("//a[@data-group='men']"));
                System.out.println("Hovering over Men menu...");
                moveToElement(menMenu);
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("Men menu not found - continuing");
            }
            
            // Search for product
            System.out.println("Searching for T-shirts...");
            WebElement searchBox = driver.findElement(By.className("desktop-searchBar"));
            sendKeys(searchBox, "T-shirts");
            
            // Submit search
            searchBox.submit();
            
            Thread.sleep(4000);
            
            // Check if elements are displayed
            try {
                WebElement productList = driver.findElement(By.className("results-base"));
                boolean displayed = isDisplayed(productList);
                System.out.println("Product list displayed: " + displayed);
            } catch (Exception e) {
                System.out.println("Product list not found - continuing");
            }
            
            // Scroll to bottom
            System.out.println("Scrolling to bottom...");
            scrollToBottom();
            
            Thread.sleep(2000);
            
            // Scroll to top
            System.out.println("Scrolling to top...");
            scrollToTop();
            
            // Take Screenshot
            System.out.println("Taking screenshot...");
            takeScreenshot("myntra_search");
            
            System.out.println("Myntra test completed successfully!\n");
            
        } catch (Exception e) {
            System.out.println("Error in Myntra test: " + e.getMessage());
        } finally {
            quitBrowser();
        }
    }
    
    // ==================== DEMOBLAZE TEST CASES ====================
    
    public void testDemoBlaze() {
        System.out.println("\n========== TESTING DEMOBLAZE ==========");
        
        try {
            System.out.println("Launching Chrome browser...");
            launchBrowser("chrome");
            
            System.out.println("Navigating to DemoBlaze...");
            navigateTo("https://www.demoblaze.com");
            
            Thread.sleep(3000);
            
            // Get page title
            String title = getTitle();
            System.out.println("Page Title: " + title);
            
            // Click on Sign Up
            System.out.println("Opening Sign Up modal...");
            WebElement signupLink = driver.findElement(By.id("signin2"));
            click(signupLink);
            
            Thread.sleep(2000);
            
            // Fill signup form
            System.out.println("Filling signup form...");
            WebElement username = driver.findElement(By.id("sign-username"));
            sendKeys(username, "testuser" + System.currentTimeMillis());
            
            WebElement password = driver.findElement(By.id("sign-password"));
            sendKeys(password, "Test@123");
            
            // Close modal
            WebElement closeBtn = driver.findElement(By.xpath("(//button[text()='Close'])[3]"));
            click(closeBtn);
            
            Thread.sleep(2000);
            
            // Navigate to Phones category
            System.out.println("Navigating to Phones category...");
            WebElement phonesLink = driver.findElement(By.linkText("Phones"));
            click(phonesLink);
            
            Thread.sleep(3000);
            
            // Click on first phone
            WebElement firstPhone = driver.findElement(By.xpath("//a[text()='Samsung galaxy s6']"));
            scrollToElement(firstPhone);
            String phoneText = getText(firstPhone);
            System.out.println("Phone: " + phoneText);
            jsHighlight(firstPhone);
            
            Thread.sleep(1000);
            
            // Take Screenshot
            System.out.println("Taking screenshot...");
            takeScreenshot("demoblaze_phones");
            
            // Navigate refresh
            System.out.println("Refreshing page...");
            navigateRefresh();
            
            Thread.sleep(2000);
            System.out.println("DemoBlaze test completed successfully!\n");
            
        } catch (Exception e) {
            System.out.println("Error in DemoBlaze test: " + e.getMessage());
        } finally {
            quitBrowser();
        }
    }
    
    // ==================== AUTOMATION EXERCISE TEST CASES ====================
    
    public void testAutomationExercise() {
        System.out.println("\n========== TESTING AUTOMATION EXERCISE ==========");
        
        try {
            System.out.println("Launching Chrome browser...");
            launchBrowser("chrome");
            
            System.out.println("Navigating to Automation Exercise...");
            getUrl("https://automationexercise.com");
            
            Thread.sleep(4000);
            
            // Verify homepage is visible
            String title = getTitle();
            System.out.println("Page Title: " + title);
            
            String url = getCurrentUrl();
            System.out.println("Current URL: " + url);
            
            // Click on Products
            try {
                WebElement productsLink = driver.findElement(By.linkText("Products"));
                System.out.println("Clicking on Products link...");
                click(productsLink);
                Thread.sleep(3000);
            } catch (Exception e) {
                System.out.println("Products link not accessible - continuing");
            }
            
            // Search for product
            try {
                WebElement searchInput = driver.findElement(By.id("search_product"));
                System.out.println("Searching for Jeans...");
                sendKeys(searchInput, "Jeans");
                
                WebElement searchBtn = driver.findElement(By.id("submit_search"));
                click(searchBtn);
                Thread.sleep(3000);
            } catch (Exception e) {
                System.out.println("Search functionality not available - continuing");
            }
            
            // Scroll down
            System.out.println("Scrolling down...");
            scrollDown(600);
            
            Thread.sleep(1000);
            
            // Get product details
            try {
                WebElement product = driver.findElement(By.xpath("//div[@class='product-image-wrapper']"));
                boolean displayed = isDisplayed(product);
                System.out.println("Product displayed: " + displayed);
                scrollToElement(product);
            } catch (Exception e) {
                System.out.println("Product details not found - continuing");
            }
            
            // Take Screenshot
            System.out.println("Taking screenshot...");
            takeScreenshot("automation_exercise_products");
            
            System.out.println("Automation Exercise test completed successfully!\n");
            
        } catch (Exception e) {
            System.out.println("Error in Automation Exercise test: " + e.getMessage());
        } finally {
            quitBrowser();
        }
    }
    
    // ==================== SPICEJET TEST CASES ====================
    
    public void testSpiceJet() {
        System.out.println("\n========== TESTING SPICEJET ==========");
        
        try {
            System.out.println("Launching Chrome browser...");
            launchBrowser("chrome");
            
            System.out.println("Navigating to SpiceJet...");
            navigateTo("https://www.spicejet.com");
            
            Thread.sleep(6000);
            
            // Get page title
            String title = getTitle();
            System.out.println("Page Title: " + title);
            
            // Select Round Trip Radio Button
            try {
                WebElement roundTrip = driver.findElement(By.xpath("//div[text()='round trip']"));
                System.out.println("Selecting Round Trip...");
                selectRadioButton(roundTrip);
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("Round trip selection not available - continuing");
            }
            
            // Select From City
            try {
                WebElement fromCity = driver.findElement(By.xpath("//div[text()='From']"));
                System.out.println("Selecting From city...");
                click(fromCity);
                Thread.sleep(1000);
                
                WebElement selectCity = driver.findElement(By.xpath("//div[text()='Delhi']"));
                click(selectCity);
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("From city selection not available - continuing");
            }
            
            // Select To City
            try {
                WebElement toCity = driver.findElement(By.xpath("//div[text()='To']"));
                System.out.println("Selecting To city...");
                click(toCity);
                Thread.sleep(1000);
                
                WebElement selectDestination = driver.findElement(By.xpath("//div[text()='Mumbai']"));
                click(selectDestination);
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("To city selection not available - continuing");
            }
            
            // Scroll down
            System.out.println("Scrolling down...");
            scrollDown(400);
            
            // Take Screenshot
            System.out.println("Taking screenshot...");
            takeScreenshot("spicejet_booking");
            
            Thread.sleep(2000);
            System.out.println("SpiceJet test completed successfully!\n");
            
        } catch (Exception e) {
            System.out.println("Error in SpiceJet test: " + e.getMessage());
        } finally {
            quitBrowser();
        }
    }
    
    // ==================== WINDOW HANDLES TEST ====================
    
    public void testWindowHandles() {
        System.out.println("\n========== TESTING WINDOW HANDLES ==========");
        
        try {
            System.out.println("Launching Chrome browser...");
            launchBrowser("chrome");
            
            System.out.println("Navigating to DemoBlaze...");
            getUrl("https://www.demoblaze.com");
            
            Thread.sleep(3000);
            
            // Get current window handle
            String parentWindow = getCurrentWindowHandle();
            System.out.println("Parent Window Handle: " + parentWindow);
            
            // Get all window handles
            Set<String> allWindows = getAllWindowHandles();
            System.out.println("Total Windows: " + allWindows.size());
            
            System.out.println("Window Handles test completed successfully!\n");
            
        } catch (Exception e) {
            System.out.println("Error in Window Handles test: " + e.getMessage());
        } finally {
            quitBrowser();
        }
    }
    
    // ==================== ROBOT CLASS TEST ====================
    
    public void testRobotClass() {
        System.out.println("\n========== TESTING ROBOT CLASS ==========");
        
        try {
            System.out.println("Launching Chrome browser...");
            launchBrowser("chrome");
            
            System.out.println("Navigating to Google...");
            getUrl("https://www.google.com");
            
            Thread.sleep(3000);
            
            // Initialize Robot
            System.out.println("Initializing Robot class...");
            initializeRobot();
            
            // Use Robot to press keys
            WebElement searchBox = driver.findElement(By.name("q"));
            click(searchBox);
            
            System.out.println("Typing 'SELENIUM' using Robot class...");
            // Type using Robot
            robotKeyPress(KeyEvent.VK_S);
            robotKeyRelease(KeyEvent.VK_S);
            
            robotKeyPress(KeyEvent.VK_E);
            robotKeyRelease(KeyEvent.VK_E);
            
            robotKeyPress(KeyEvent.VK_L);
            robotKeyRelease(KeyEvent.VK_L);
            
            robotKeyPress(KeyEvent.VK_E);
            robotKeyRelease(KeyEvent.VK_E);
            
            robotKeyPress(KeyEvent.VK_N);
            robotKeyRelease(KeyEvent.VK_N);
            
            robotKeyPress(KeyEvent.VK_I);
            robotKeyRelease(KeyEvent.VK_I);
            
            robotKeyPress(KeyEvent.VK_U);
            robotKeyRelease(KeyEvent.VK_U);
            
            robotKeyPress(KeyEvent.VK_M);
            robotKeyRelease(KeyEvent.VK_M);
            
            // Press Enter
            robotKeyPress(KeyEvent.VK_ENTER);
            robotKeyRelease(KeyEvent.VK_ENTER);
            
            Thread.sleep(3000);
            
            System.out.println("Taking screenshot...");
            takeScreenshot("robot_test");
            
            System.out.println("Robot Class test completed successfully!\n");
            
        } catch (Exception e) {
            System.out.println("Error in Robot Class test: " + e.getMessage());
        } finally {
            quitBrowser();
        }
    }
    
    // ==================== ACTIONS CLASS TEST ====================
    
    public void testActionsClass() {
        System.out.println("\n========== TESTING ACTIONS CLASS ==========");
        
        try {
            System.out.println("Launching Chrome browser...");
            launchBrowser("chrome");
            
            System.out.println("Navigating to Myntra...");
            getUrl("https://www.myntra.com");
            
            Thread.sleep(3000);
            
            // Mouse Hover
            try {
                WebElement menMenu = driver.findElement(By.xpath("//a[@data-group='men']"));
                System.out.println("Performing mouse hover on Men menu...");
                moveToElement(menMenu);
                Thread.sleep(2000);
                
                System.out.println("Performing double click...");
                doubleClickElement(menMenu);
                Thread.sleep(1000);
                
                System.out.println("Performing right click...");
                rightClickElement(menMenu);
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("Actions operations not fully executed - continuing");
            }
            
            System.out.println("Taking screenshot...");
            takeScreenshot("actions_test");
            
            System.out.println("Actions Class test completed successfully!\n");
            
        } catch (Exception e) {
            System.out.println("Error in Actions Class test: " + e.getMessage());
        } finally {
            quitBrowser();
        }
    }
    
    // ==================== JAVASCRIPT EXECUTOR TEST ====================
    
    public void testJavaScriptExecutor() {
        System.out.println("\n========== TESTING JAVASCRIPT EXECUTOR ==========");
        
        try {
            System.out.println("Launching Chrome browser...");
            launchBrowser("chrome");
            
            System.out.println("Navigating to Amazon...");
            navigateTo("https://www.amazon.in");
            
            Thread.sleep(3000);
            
            // Get title using JS
            String title = jsGetTitle();
            System.out.println("Title (JS): " + title);
            
            // Get URL using JS
            String url = jsGetURL();
            System.out.println("URL (JS): " + url);
            
            // Scroll using JS
            System.out.println("Scrolling using JS...");
            scrollDown(500);
            Thread.sleep(1000);
            
            // Highlight element
            try {
                WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
                System.out.println("Highlighting search box...");
                jsHighlight(searchBox);
                Thread.sleep(1000);
                
                // Send keys using JS
                System.out.println("Sending keys using JS...");
                jsSendKeys(searchBox, "Laptop");
                Thread.sleep(1000);
                
                // Click using JS
                WebElement searchBtn = driver.findElement(By.id("nav-search-submit-button"));
                System.out.println("Clicking using JS...");
                jsClick(searchBtn);
            } catch (Exception e) {
                System.out.println("JS operations partially executed - continuing");
            }
            
            Thread.sleep(3000);
            
            System.out.println("Taking screenshot...");
            takeScreenshot("js_executor_test");
            
            System.out.println("JavaScript Executor test completed successfully!\n");
            
        } catch (Exception e) {
            System.out.println("Error in JavaScript Executor test: " + e.getMessage());
        } finally {
            quitBrowser();
        }
    }
    
    // ==================== DROPDOWN OPERATIONS TEST ====================
    
    public void testDropdownOperations() {
        System.out.println("\n========== TESTING DROPDOWN OPERATIONS ==========");
        
        try {
            System.out.println("Launching Chrome browser...");
            launchBrowser("chrome");
            
            System.out.println("Navigating to Facebook...");
            getUrl("https://www.facebook.com");
            
            Thread.sleep(3000);
            
            // Click Create New Account
            try {
                WebElement createAccount = driver.findElement(By.linkText("Create new account"));
                System.out.println("Clicking Create New Account...");
                click(createAccount);
                Thread.sleep(3000);
                
                // Select Day dropdown
                WebElement dayDropdown = driver.findElement(By.id("day"));
                System.out.println("Selecting day: 15");
                selectByVisibleText(dayDropdown, "15");
                
                // Get first selected option
                WebElement firstOption = getFirstSelectedOption(dayDropdown);
                System.out.println("First Selected Option: " + getText(firstOption));
                
                // Select Month dropdown
                WebElement monthDropdown = driver.findElement(By.id("month"));
                System.out.println("Selecting month by index: 5");
                selectByIndex(monthDropdown, 5);
                
                // Select Year dropdown
                WebElement yearDropdown = driver.findElement(By.id("year"));
                System.out.println("Selecting year: 1995");
                selectByValue(yearDropdown, "1995");
                
                // Get all options
                List<WebElement> options = getOptions(yearDropdown);
                System.out.println("Total year options: " + options.size());
                
                // Check if multiple
                boolean isMultiple = isMultiple(dayDropdown);
                System.out.println("Is Multiple Select: " + isMultiple);
                
            } catch (Exception e) {
                System.out.println("Dropdown operations partially executed: " + e.getMessage());
            }
            
            System.out.println("Taking screenshot...");
            takeScreenshot("dropdown_test");
            
            System.out.println("Dropdown Operations test completed successfully!\n");
            
        } catch (Exception e) {
            System.out.println("Error in Dropdown Operations test: " + e.getMessage());
        } finally {
            quitBrowser();
        }
    }
    
    // ==================== WAIT MECHANISMS TEST ====================
    
    public void testWaitMechanisms() {
        System.out.println("\n========== TESTING WAIT MECHANISMS ==========");
        
        try {
            System.out.println("Launching Chrome browser...");
            launchBrowser("chrome");
            
            // Implicit Wait
            System.out.println("Setting implicit wait: 10 seconds");
            implicitWait(10);
            
            System.out.println("Navigating to Amazon...");
            navigateTo("https://www.amazon.in");
            
            Thread.sleep(3000);
            
            // Explicit Wait
            try {
                WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
                System.out.println("Applying explicit wait...");
                explicitWait(searchBox, 10);
                
                // Wait for element to be clickable
                System.out.println("Waiting for element to be clickable...");
                waitForElementClickable(searchBox, 10);
                
                sendKeys(searchBox, "Books");
                System.out.println("Search box interaction successful");
            } catch (Exception e) {
                System.out.println("Wait operations partially executed");
            }
            
            System.out.println("Wait Mechanisms test completed successfully!\n");
            
        } catch (Exception e) {
            System.out.println("Error in Wait Mechanisms test: " + e.getMessage());
        } finally {
            quitBrowser();
        }
    }
}
