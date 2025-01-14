package DemoExercise;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class signup {

    public static void main(String[] args) {

        // Setup ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Visiting the noKodr platform
        driver.get("https://app-staging.nokodr.com");
        driver.manage().window().maximize();

        // Navigating to signUpPage
        WebElement SignUp = driver.findElement(By.xpath("//a[normalize-space()='Sign up']"));
        SignUp.click();

        // Validating mandatory fields
        WebElement email = driver.findElement(By.xpath("(//input[@name='username'])[2]"));
        email.click();
        email.sendKeys("tambepadmaja9@gmail.com");

        WebElement CheckBox = driver.findElement(By.xpath("//span[@class='slds-checkbox_faux']"));
        CheckBox.click();

        WebElement ClickProceed = driver.findElement(By.xpath("//div[@title='Proceed']"));
        ClickProceed.click();
        
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

            // Sleep for a short duration to avoid busy waiting
            try {
                Thread.sleep(500); // Check every 500 milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // Fill in the mandatory fields in the new window
        WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='firstName']")));
        firstName.click();
        firstName.sendKeys("Padmaja");

        WebElement lastname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='lastName']")));
        lastname.click();
        lastname.sendKeys("Chavan");

        WebElement Pass = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@name='password'])[2]")));
        Pass.click();
        Pass.sendKeys("Padmaja@12345");
        
        WebElement confirmPass = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password-confirmpassword']")));
        confirmPass.click();
        confirmPass.sendKeys("Padmaja@12345");
        
        WebElement submitButton = driver.findElement(By.xpath("//button[normalize-space()='Register']"));
        submitButton.click();
        // Close the browser
        //driver.quit();
    }
}