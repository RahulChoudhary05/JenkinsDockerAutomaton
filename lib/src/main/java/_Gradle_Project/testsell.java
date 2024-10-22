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
            js.executeScript("window.scrollTo({ top: document.body.scrollHeight, behavior: 'smooth' });");
            Thread.sleep(3000); // Pause to observe the smooth scrolling

            // 5. Click on the "Login" link
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Login")));
            loginButton.click();
            Thread.sleep(2000); // Pause to observe the action

            // 6. Wait for the login page to load and ensure visibility of email field
            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
            emailField.sendKeys("rahulchoudhary.sk@gmail.com");
            Thread.sleep(1000); // Pause after entering email

            // 7. Enter password using the XPath selector
            WebElement passwordField = driver.findElement(By.xpath("//input[@type='password' and @placeholder='Password']"));
            passwordField.sendKeys("rahulsk2005");
            Thread.sleep(1000); // Pause after entering password

            // 8. Click the login button using the XPath selector
            WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
            submitButton.click();
            Thread.sleep(2000); // Wait for login action

            // 9. Wait for the dashboard page to load (or adjust based on redirection)
            wait.until(ExpectedConditions.urlContains("dashboard"));
            Thread.sleep(2000); // Additional wait for smooth transition

            // 10. Navigate to the "All Products" section using the navbar link
            WebElement allProductsLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/allproduct']")));
            allProductsLink.click();
            Thread.sleep(2000); // Pause to observe the page

            // 11. Wait for the products to load
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='p-4 w-full md:w-1/4']")));

            // 12. Select the specific product "Samsung Galaxy A35 5G Pre"
            WebElement specificProduct = driver.findElement(By.xpath("//h1[contains(text(),'Samsung Galaxy A35 5G Pre')]"));
            specificProduct.click();
            Thread.sleep(2000); // Pause to observe the product details page

            // 13. Wait for the "Add to Cart" button to be clickable
            WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Add To Cart')]")));
            
            // 14. Click the "Add to Cart" button
            addToCartButton.click();
            Thread.sleep(2000); // Wait for the cart action to complete

            // 15. Open the "Cart" page
            WebElement cartLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/cart']")));
            cartLink.click();
            Thread.sleep(2000); // Pause to observe the cart page

            // 16. Increase the product quantity
            WebElement increaseQuantityButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='button' and contains(@class, 'flex h-7 w-7')]")));
            increaseQuantityButton.click();
            Thread.sleep(1000); // Pause to observe the quantity change

            // 17. Click the "Buy Now" button
            WebElement buyNowButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Buy now')]")));
            buyNowButton.click();
            Thread.sleep(2000); // Pause to observe the buy action

            // 18. Fill in the details in the popup
            // Enter Name
            WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("name")));
            nameField.sendKeys("Rahul Choudhary");
            Thread.sleep(1000); // Pause after entering name

            // Enter Address
            WebElement addressField = driver.findElement(By.name("address"));
            addressField.sendKeys("Una, Himachal Pradesh");
            Thread.sleep(1000); // Pause after entering address

            // Enter Pincode
            WebElement pincodeField = driver.findElement(By.name("pincode"));
            pincodeField.sendKeys("177208");
            Thread.sleep(1000); // Pause after entering pincode

            // Enter Mobile Number
            WebElement mobileNumberField = driver.findElement(By.name("mobileNumber"));
            mobileNumberField.sendKeys("1234567890");
            Thread.sleep(1000); // Pause after entering mobile number

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
