import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity8ContactUs {

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

        driver.findElement(By.xpath("//a[@href ='https://alchemy.hguy.co/lms/contact/']")).click();
        driver.findElement(By.xpath("//input[@id ='wpforms-8-field_0']")).sendKeys("Smita Kumari");
        driver.findElement(By.xpath("//input[@id ='wpforms-8-field_1']")).sendKeys("smkumar9@in.ibm.com");
        driver.findElement(By.xpath("//input[@id ='wpforms-8-field_3']")).sendKeys("Training-Feb23");
        driver.findElement(By.xpath("//textarea[@id ='wpforms-8-field_2']")).sendKeys("Selenium Project LMS Practise -8 ");
        driver.findElement(By.xpath("//button[@id ='wpforms-submit-8']")).click();
      WebElement s = driver.findElement(By.xpath("//div[@id ='wpforms-confirmation-8']"));
      System.out.println("After submitting message:" + s.getText());
      Assert.assertEquals(s.getText(),"Thanks for contacting us! We will be in touch with you shortly.");

    }

    @AfterMethod
    public void AfterMethod() {
        //Close the Browser
        driver.quit();

    }
}
