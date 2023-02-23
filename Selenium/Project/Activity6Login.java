import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity6Login {
    WebDriver driver;
    @BeforeMethod
    public void BeforeMethod() {
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms");
    }
    @Test
    public void login(){
        WebElement t=  driver.findElement(By.xpath("//a[@href ='https://alchemy.hguy.co/lms/my-account/']"));
        t.click();
        System.out.println("Title of the current page is :"+driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"My Account – Alchemy LMS");

        WebElement l =  driver.findElement(By.xpath("//a[@href ='#login']"));
        l.click();

        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("root");
        driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys("pa$$w0rd");

        driver.findElement(By.xpath("//input[@type='submit']")).click();
       WebElement img = driver.findElement(By.xpath("//img[@class ='avatar avatar-96 photo']"));
       Boolean status = img.isDisplayed();
       System.out.println("Image is displayed: "+ status);
    }
    @AfterMethod
    public void AfterMethod(){
        driver.quit();
    }

}
