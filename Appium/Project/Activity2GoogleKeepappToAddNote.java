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

public class Activity2GoogleKeepappToAddNote {

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
            options.setAppPackage("com.google.android.keep");
            options.setAppActivity(".activities.BrowseActivity");
            options.noReset();

            // Server Address
            URL serverURL = new URL("http://localhost:4723/wd/hub");

            // Driver Initialization
            driver = new AndroidDriver(serverURL, options);
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

        // Test method
        @Test
        public void addNoteIntoGoogleKeep() {
            // Add Task "Complete Activity with Google Tasks"
            driver.findElement(AppiumBy.accessibilityId("New text note")).click();
            wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.id("editable_title")));
            driver.findElement(AppiumBy.id("editable_title")).sendKeys("LMS Activity");
            driver.findElement(AppiumBy.id("edit_note_text")).click();
            driver.findElement(AppiumBy.id("edit_note_text")).sendKeys("Activity to complete by today 01_03_2023");

        driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]")).click();
            //Print the  task name
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("index_note_title")));
            String NoteTitle = driver.findElement(AppiumBy.id("index_note_title")).getText();

            // Assertion
            Assert.assertEquals(NoteTitle, "LMS Activity");
        }
        // Tear down method **/
        @AfterClass
        public void tearDown() {
            // Close the app
            driver.quit();
        }
    }




