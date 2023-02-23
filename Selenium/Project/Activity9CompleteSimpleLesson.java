import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity9CompleteSimpleLesson {
    WebDriver driver;

    @BeforeMethod
    public void BeforeMethod() {
        //create a new instance of firefox driver
        driver = new FirefoxDriver();
        //Open a browser
        driver.get("https://alchemy.hguy.co/lms/");
    }

    @Test
    public void TestTitle() {
//Check the title of page
        String title = driver.getTitle();
        //print the title of the page
        System.out.println("Page title is : " + title);
        //Assertion for the page title
        Assert.assertEquals("Alchemy LMS – An LMS Application", title);

        //Ignoring since the courses are showing 100% completed already in UI ,To complete option is not showing
    }

    @AfterMethod
    public void AfterMethod() {
        //Close the Browser
        driver.quit();

    }
}
