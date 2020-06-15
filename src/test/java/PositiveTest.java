import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class PositiveTest {
    @DataProvider(name = "NewUserData")
    public Object[] newUserData() {
        UserData[] user = new UserData[1];
        user[0] = new UserData(
                "Severus",
                "Snape",
                "Gorgeous_Serpent6@mail.com",
                "SlytheriN",
                21,
                "February",
                1946,
                "Castle Hogwarts, vault",
                "Hammersmith",
                "London",
                40013,
                5,
                "89177249988"
        );
        return user;
    }

    @Severity(value = SeverityLevel.CRITICAL)
    @DisplayName("Регистрация")
    @Description("Проверка успешной регистрации нового пользователя\n" +
            "в тестовом онлайн магазине: http://automationpractice.com")
    @Test(dataProvider = "NewUserData")
    public void mainTest(UserData user) {
        WebElement signIn, input;
        System.setProperty("webdriver.chrome.driver", "C:/Users/DNS/AppData/Local/Google/Chrome/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--whitelisted-ips");
        WebDriver driver = new ChromeDriver();

        //Перейти на главную страницу сайта
        driver.get("http://automationpractice.com/");

        // Перейти на страницу регистрации
        signIn = (new WebDriverWait(driver, 10)).until(presenceOfElementLocated(By.className("login")));
        signIn.click();

        // Ввести email
        (new WebDriverWait(driver, 10)).until(presenceOfElementLocated(By.id("email_create"))).sendKeys(user.email);
        // Нажать "create an account"
        (new WebDriverWait(driver, 10)).until(presenceOfElementLocated(By.id("create-account_form"))).submit();

        // PERSONAL INFORMATION
        // firstName
        input = (new WebDriverWait(driver, 10)).until(presenceOfElementLocated(By.id("customer_firstname")));
        input.sendKeys(user.firstName);
        // lastName
        input = driver.findElement(By.id("customer_lastname"));
        input.sendKeys(user.lastName);
        // password
        input = driver.findElement(By.id("passwd"));
        input.sendKeys(user.password);
        // day
        input = driver.findElement(By.id("days"));
        input.sendKeys(Integer.toString(user.day));
        // month
        input = driver.findElement(By.id("months"));
        input.sendKeys(user.month);
        // year
        input = driver.findElement(By.id("years"));
        input.sendKeys(Integer.toString(user.year));

        // Address
        // firstName
        input = driver.findElement(By.id("firstname"));
        input.sendKeys(user.firstName);
        // lastName
        input = driver.findElement(By.id("lastname"));
        input.sendKeys(user.lastName);
        // address
        input = driver.findElement(By.id("address1"));
        input.sendKeys(user.address);
        // city
        input = driver.findElement(By.id("city"));
        input.sendKeys(user.city);
        // country
        input = driver.findElement(By.id("id_country"));
        input.sendKeys(Integer.toString(user.country));
        // state
        input = (new WebDriverWait(driver, 10)).until(presenceOfElementLocated(By.id("id_state")));
        input.sendKeys(user.state);
        // postalCode
        input = driver.findElement(By.id("postcode"));
        input.sendKeys(Integer.toString(user.postalCode));
        // phone
        input = driver.findElement(By.id("phone_mobile"));
        input.sendKeys(user.phone);

        // Регистрация
        driver.findElement(By.id("submitAccount")).click();
        driver.quit();
    }
}
