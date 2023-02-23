import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity5NavigateToMyAccount {
    WebDriver driver;
    @BeforeMethod
    public void BeforeMethod(){
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms");

    }
    @Test
    public void NavigateMyAccount(){
        WebElement t=  driver.findElement(By.xpath("//a[@href ='https://alchemy.hguy.co/lms/my-account/']"));
      t.click();
        System.out.println("Title of the current page is :"+driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"My Account – Alchemy LMS");

    }
    @AfterMethod
    public void AfterMethod(){
        driver.quit();
    }
}
