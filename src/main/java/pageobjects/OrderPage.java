package pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class OrderPage { private final WebDriver driver;


    private final By clientFirstName = By.xpath(".//input[@placeholder='* Имя']");

    //Локатор поля "Фамилия"
    private final By clientLastName = By.xpath(".//input[@placeholder='* Фамилия']");

    //Локатор поля "Адрес: куда привезти заказ"
    private final By deliveryAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    //Локатор поля "Станция метро"
    private final By deliveryMetroStation = By.xpath(".//input[@placeholder='* Станция метро']");

    //Локатор поля "Телефон: на него позвонит курьер"
    private final By deliveryClientPhoneNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    //Локатор кнопки "Далее"
    private final By nextButton = By.xpath(".//button[(@class ='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее')]");
    //Локатор кнопки "да все привыкли" сообщения о кукисах
    private final By cookieButton = By.id("rcc-confirm-button");

    //Конструктор класса
    public OrderPage (WebDriver driver) {
        this.driver = driver;
    }
    // Метод для принятия куки
    public void clickCookieButton() {
        driver.findElement(cookieButton).click();
    }
    //Ввод имени
    public OrderPage sendClientFirstName(String firstName) {
        driver.findElement(clientFirstName).sendKeys(firstName);
        return this;
    }
    //Ввод фамилии клиента
    public OrderPage sendClientLastName(String lastName) {
        driver.findElement(clientLastName).sendKeys(lastName);
        return this;
    }

    // Ввод адреса доставки
    public OrderPage sendDeliveryAddress(String address) {
        driver.findElement(deliveryAddress).sendKeys(address);
        return this;
    }

    //Выбор станции метро
    public OrderPage selectMetroStation(String metroStationFromOrder) {
        driver.findElement(deliveryMetroStation).click();
        driver.findElement(deliveryMetroStation).sendKeys(metroStationFromOrder);
        driver.findElement(deliveryMetroStation).sendKeys(Keys.DOWN,Keys.ENTER);
        return this;
    }

    //Ввод телефона
    public OrderPage sendDeliveryClientPhoneNumber(String phoneNumber) {
        driver.findElement(deliveryClientPhoneNumber).sendKeys(phoneNumber);
        return this;
    }

    // Клик по кнопке "Далее"
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

}

