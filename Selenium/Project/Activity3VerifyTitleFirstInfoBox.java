import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity3VerifyTitleFirstInfoBox {
    WebDriver driver;
    @BeforeMethod
    public void BeforeMethod(){
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms");

    }
    @Test
    public void FirstInfoBoxTitle(){
       WebElement FstInfoBox = driver.findElement(By.xpath("//h3[contains(.,' Actionable Training ')]"));
        System.out.println("First Info Box Title is : "+FstInfoBox.getText());
        Assert.assertEquals(FstInfoBox.getText(),"Actionable Training");

    }
    @AfterMethod
    public void AfterMethod(){
        driver.quit();
    }
}
