import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTest {

    static WebDriver driver;
    static WebDriverWait wait;
    static String url = "https://tichi-app-webapp-stage.web.app/login";

    // CHANGE THESE TWO EMAILS
    static String registeredEmail = "subalakshmimohanasundaram@gmail.com";
    static String newEmail = "kirithikaashanmugham@gmail.com";

    static By emailField = By.cssSelector("input[type='email']");
    static By continueButton = By.xpath("//button[contains(.,'Continue')]");

    public static void main(String[] args) {

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        try {
            test1_EmailFieldDisplayed();
            test2_ContinueButtonDisplayed();
            test3_ContinueButtonEnabled();
            test4_EmailFieldMandatory();
            test5_InvalidEmailWithoutAtRejected();
            test6_EmailWithMissingDomainRejected();
            test7_EmailWithIncompleteDomainRejected();
            test8_RegisteredEmailOpensPasswordStep();
            test9_UnregisteredEmailRedirectsToSignup();
            test10_EmailPrefilledAndReadOnlyOnSignup();

        } catch (Exception e) {
            System.out.println("AUTOMATION STOPPED: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }

    static void openLoginPage() {
        driver.get(url);
    }

    static void printResult(String testName, boolean result) {
        if (result) {
            System.out.println("PASS - " + testName);
        } else {
            System.out.println("FAIL - " + testName);
        }
    }

    static void test1_EmailFieldDisplayed() {
        openLoginPage();
        boolean result = driver.findElement(emailField).isDisplayed();
        printResult("TC_LOGIN_001 - Email Address field is displayed", result);
    }

    static void test2_ContinueButtonDisplayed() {
        openLoginPage();
        boolean result = driver.findElement(continueButton).isDisplayed();
        printResult("TC_LOGIN_003 - Continue button is displayed", result);
    }

    static void test3_ContinueButtonEnabled() {
        openLoginPage();
        boolean result = driver.findElement(continueButton).isEnabled();
        printResult("TC_LOGIN_003 - Continue button is enabled/clickable", result);
    }

    static void test4_EmailFieldMandatory() {
        openLoginPage();

        WebElement email = driver.findElement(emailField);
        driver.findElement(continueButton).click();

        boolean result = !email.getAttribute("validationMessage").isEmpty()
                || driver.getPageSource().toLowerCase().contains("email")
                && driver.getPageSource().toLowerCase().contains("required");

        printResult("TC_LOGIN_002 - Email Address field is mandatory", result);
    }

    static void test5_InvalidEmailWithoutAtRejected() {
        openLoginPage();
        WebElement email = driver.findElement(emailField);
        email.sendKeys("zxv");
        driver.findElement(continueButton).click();

        boolean result = !email.getAttribute("validationMessage").isEmpty();
        printResult("TC_AUTH_006 - Invalid email without @ is rejected", result);
    }

    static void test6_EmailWithMissingDomainRejected() {
        openLoginPage();
        WebElement email = driver.findElement(emailField);
        email.sendKeys("zxv@");
        driver.findElement(continueButton).click();

        boolean result = !email.getAttribute("validationMessage").isEmpty();
        printResult("TC_AUTH_007 - Email with missing domain is rejected", result);
    }

    static void test7_EmailWithIncompleteDomainRejected() {
        openLoginPage();
        WebElement email = driver.findElement(emailField);
        email.sendKeys("zxv@in");
        driver.findElement(continueButton).click();

        boolean result = driver.getCurrentUrl().contains("login");
        printResult("TC_AUTH_008 - Email with incomplete domain is rejected", result);
    }

    static void test8_RegisteredEmailOpensPasswordStep() throws InterruptedException {
        openLoginPage();
        driver.findElement(emailField).sendKeys(registeredEmail);
        driver.findElement(continueButton).click();
        Thread.sleep(2000);

        boolean result = driver.findElements(By.cssSelector("input[type='password']")).size() > 0;
        printResult("TC_AUTH_003 - Registered email opens password step", result);
    }

    static void test9_UnregisteredEmailRedirectsToSignup() throws InterruptedException {
        openLoginPage();
        driver.findElement(emailField).sendKeys(newEmail);
        driver.findElement(continueButton).click();
        Thread.sleep(2000);

        boolean result = !driver.getCurrentUrl().contains("/login");
        printResult("TC_AUTH_004 - Unregistered email redirects to Sign Up", result);
    }

    static void test10_EmailPrefilledAndReadOnlyOnSignup() throws InterruptedException {
        openLoginPage();
        driver.findElement(emailField).sendKeys(newEmail);
        driver.findElement(continueButton).click();
        Thread.sleep(2000);

        WebElement signupEmail = driver.findElement(By.cssSelector("input[type='email']"));

        boolean isPrefilled = signupEmail.getAttribute("value").equals(newEmail);
        boolean isReadOnly = signupEmail.getAttribute("readonly") != null
                || !signupEmail.isEnabled();

        printResult("TC_AUTH_005 - Email is prefilled and read-only on Sign Up",
                isPrefilled && isReadOnly);
    }
}