import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity4SecondMostPopularCourseTitle {
    WebDriver driver;
    @BeforeMethod
    public void BeforeMethod(){
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms/");
    }
    @Test
    public void SecondPopularCourseTitle(){
       WebElement title = driver.findElement(By.xpath("//h3[contains(.,'Email Marketing Strategies')]"));
        System.out.println("Title of Second most Popular course : " +title.getText());
        Assert.assertEquals(title.getText(),"Email Marketing Strategies");
    }
    @AfterMethod
    public void AfterMethod(){
        driver.quit();
    }
}
