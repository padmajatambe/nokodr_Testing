package DemoExercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class forgetpassword {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        
        driver.get("https://app-staging.nokodr.com/");
        driver.manage().window().maximize();

        // Click on "Forgot Password?"
        WebElement forgetPassword = driver.findElement(By.linkText("Forgot Password?"));
        forgetPassword.click();

        // Enter email
        WebElement email = driver.findElement(By.xpath("(//input[@name='username'])[2]"));
        email.click();
        email.sendKeys("tambepadmaja9@gmail.com");

        // Click on Proceed button
        WebElement loginButton = driver.findElement(By.xpath("//div[text()='Proceed']"));
        loginButton.click();

        // Wait for the verification code input field to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement verificationCodeField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='code']")));

        // Loop to check the length of the verification code
        while (true) {
            // Get the current value of the verification code field
            String verificationCode = verificationCodeField.getAttribute("value");

            // Check if the length of the verification code is 6
            if (verificationCode.length() == 6) {
                // Click the verify button
                WebElement verifyButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@title='Verify Code']")));
                verifyButton.click();
                break; // Exit the loop after clicking the button
            }
            try {
                Thread.sleep(500); // Check every 500 milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Wait for the new password input field to be visible
        WebElement newPass = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@name='password'])[2]")));
        newPass.click();
        newPass.sendKeys("Padmaja@123456789");

        // Wait for the confirm password input field to be visible
        WebElement confirmPass = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password-confirmpassword']")));
        confirmPass.click();
        confirmPass.sendKeys("Padmaja@123456789");

        WebElement submitButton = driver.findElement(By.xpath("//button[normalize-space()='Confirm']"));
        submitButton.click();

        // Close the driver
        driver.quit();
    }
}
