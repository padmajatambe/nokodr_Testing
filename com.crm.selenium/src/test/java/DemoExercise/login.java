package DemoExercise;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {

    public static void main(String[] args) {

        // Setup ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Visiting the login page directly
        driver.get("https://app-staging.nokodr.com/super/apps/auth/v1/index.html#/login");
        driver.manage().window().maximize();

        // Entering login credentials
        WebElement loginEmail = driver.findElement(By.xpath("//input[@name='username']"));
        loginEmail.click();
        loginEmail.sendKeys("tambepadmaja9@gmail.com");

        WebElement loginPassword = driver.findElement(By.xpath("//input[@name='password']"));
        loginPassword.click();
        loginPassword.sendKeys("Padmaja@123456789");

        WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Log In']"));
        loginButton.click();
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Close the browser
        //driver.quit();
    }
}
