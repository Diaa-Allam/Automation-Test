package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class Test1 {
    @Test
    public void HappyPath() {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Form Authentication")).click();
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.className("radius")).click();
        String actualResult = driver.findElement(By.id("flash")).getText();
        String expectedResult = "You logged into a secure area!";
        assertTrue(actualResult.contains(expectedResult));
        driver.findElement(By.xpath("/html/body/div[2]/div/div/a")).click();
        driver.close();
    }
    @Test
    public void NegativeUsername(){
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Form Authentication")).click();
        driver.findElement(By.id("username")).sendKeys("Anas");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.className("radius")).click();
        String actualResult = driver.findElement(By.id("flash")).getText();
        String expectedResult = "Your username is invalid!";
        assertTrue(actualResult.contains(expectedResult));
        driver.close();
    }
    @Test
    public void NegativePassword(){
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Form Authentication")).click();
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        driver.findElement(By.className("radius")).click();
        String actualResult = driver.findElement(By.id("flash")).getText();
        String expectedResult = "Your password is invalid!";
        assertTrue(actualResult.contains(expectedResult));
        driver.close();

    }
}
