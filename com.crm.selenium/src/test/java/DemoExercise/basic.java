package DemoExercise;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class basic {

    public static void main(String[] args) {

        // Setup ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Visiting the login page directly
        driver.get("https://app-staging.nokodr.com");
        driver.manage().window().maximize();
	}
}
