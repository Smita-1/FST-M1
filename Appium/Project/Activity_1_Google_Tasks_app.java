import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity_1_Google_Tasks_app {
           // Driver Declaration
        AndroidDriver driver;
    WebDriverWait wait;

        // Set up method
        @BeforeClass
        public void setUp() throws MalformedURLException {
            // Desired Capabilities
            UiAutomator2Options options = new UiAutomator2Options();
            options.setPlatformName("android");
            options.setAutomationName("UiAutomator2");
            options.setAppPackage("com.google.android.apps.tasks");
            options.setAppActivity(".ui.TaskListsActivity");
            options.noReset();

            // Server Address
            URL serverURL = new URL("http://localhost:4723/wd/hub");

            // Driver Initialization
            driver = new AndroidDriver(serverURL, options);
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

        // Test method
        @Test
        public void addTask_Complete_Activity_with_Google_Tasks() {
            // Add Task "Complete Activity with Google Tasks"
            driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
            wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.id("add_task_title")));
            driver.findElement(AppiumBy.id("add_task_title")).sendKeys("Complete Activity with Google Tasks");
            driver.findElement(AppiumBy.id("add_task_done")).click();
            //Print the  task name
            String task = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\"Complete Activity with Google Tasks\"]/android.view.ViewGroup/android.widget.TextView")).getText();

           // Assertion
           Assert.assertEquals(task, "Complete Activity with Google Tasks");
        }

        // Test method
        @Test
        public void addTaskCompleteActivityWithGoogleKeep() {

            // Add Task "Complete Activity with Google Keep"
            driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
            wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.id("add_task_title")));
            driver.findElement(AppiumBy.id("add_task_title")).sendKeys("Complete Activity with Google Keep");
            driver.findElement(AppiumBy.id("add_task_done")).click();
            //Print the  task name
            String task = driver.findElement(AppiumBy.xpath("//android.widget.TextView[contains(@text,'Complete Activity with Google Keep')]")).getText();

            // Assertion
            Assert.assertEquals(task, "Complete Activity with Google Keep");
        }

        // Test method
        @Test
        public void addTaskCompletetheSecondActivityGoogleKeep
            () {
            // Add Task "Complete the second Activity Google Keep"
            driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
            wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.id("add_task_title")));
            driver.findElement(AppiumBy.id("add_task_title")).sendKeys("Complete the second Activity Google Keep");
            driver.findElement(AppiumBy.id("add_task_done")).click();
            //Print the  task name
            String task = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\"Complete the second Activity Google Keep\"]/android.view.ViewGroup/android.widget.TextView")).getText();

            // Assertion
            Assert.assertEquals(task, "Complete the second Activity Google Keep");
        }

        // Tear down method **/
        @AfterClass
        public void tearDown() {
            // Close the app
            driver.quit();
        }
    }


