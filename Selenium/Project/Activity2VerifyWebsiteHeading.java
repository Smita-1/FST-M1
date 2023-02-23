import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity2VerifyWebsiteHeading {
    WebDriver driver;

    @BeforeMethod
    public void BeforeMethod(){
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms");
    }
    @Test
    public void WebsiteTitle(){
        String title = driver.getTitle();
        System.out.println("Title of the page :" + title);
        Assert.assertEquals("Alchemy LMS – An LMS Application",title);
        WebElement Wt= driver.findElement(By.className("uagb-ifb-title"));
        System.out.println("WebsiteTitle is : "+ Wt.getText());
        Assert.assertEquals(Wt.getText(),"Learn from Industry Experts");

    }
    @AfterMethod
    public void AfterMethod(){
        driver.quit();
    }
}
