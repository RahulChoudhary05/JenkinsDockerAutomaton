package _Gradle_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class testsell {
    public static void main(String[] args) {
        // Initialize the ChromeDriver
        WebDriver driver = new ChromeDriver();

        try {
            // 1. Open Google Chrome and maximize the browser window
            driver.manage().window().maximize();

            // 2. Open the Bharat Market website
            driver.get("https://bharat-market-ecommerce-website.vercel.app/");
            Thread.sleep(2000); // Wait for 2 seconds to observe the page load

            // 3. Wait for the page to load
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("root")));
            Thread.sleep(2000); // Additional wait for smoother transition

            // 4. Autoscroll the page using JavaScript Executor
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            Thread.sleep(3000); // Pause to observe the scrolling

            // 5. Click on the "Login" link
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Login")));
            loginButton.click();
            Thread.sleep(2000); // Pause to observe the action

            // 6. Wait for the login page to load and ensure visibility of email field
            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
            emailField.sendKeys("rahulchoudhary.sk@gmail.com");
            Thread.sleep(1000); // Pause after entering email

            // 8. Wait for the dashboard page to load (or adjust based on redirection)
            wait.until(ExpectedConditions.urlContains("dashboard"));
            Thread.sleep(2000); // Additional wait for smooth transition

            // Additional actions after login (if needed)

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Ensure the browser is closed in case of an exception
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
