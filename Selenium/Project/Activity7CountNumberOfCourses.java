import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Activity7CountNumberOfCourses {
    WebDriver driver;
    //h3

        @BeforeMethod
        public void BeforeMethod() {
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms");
    }
        @Test
        public void countOfCourses(){
        WebElement a=  driver.findElement(By.xpath("//a[@href ='https://alchemy.hguy.co/lms/all-courses/']"));
        a.click();
        System.out.println("Title of the current page is :"+driver.getTitle());

           List<WebElement> c = driver.findElements(By.xpath("//div[@class ='ld-course-list-items row']/div"));
           System.out.println(c.size());
            Assert.assertEquals(c.size(),3);

          }


    @AfterMethod
        public void AfterMethod(){
        driver.quit();
    }

    }
