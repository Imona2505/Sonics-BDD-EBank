import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetProperties {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\madin\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.drjart.com/");
    }
}
