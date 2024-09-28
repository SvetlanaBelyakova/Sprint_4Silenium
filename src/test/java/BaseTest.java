import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;

public class BaseTest {
    WebDriver driver;

    //Выбор браузера
    @Before
    public void setUp() {
  //      WebDriverManager.chromedriver().setup();
   //     driver = new ChromeDriver();
   //    driver.manage().window().maximize();
  //     driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(5));



     WebDriverManager.firefoxdriver().create();
       driver = new FirefoxDriver();
       driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(5));
    }
    //Закрыть браузер
    @After
    public void tearDown() {
        if(driver != null){
            driver.quit();
        }
    }

}
