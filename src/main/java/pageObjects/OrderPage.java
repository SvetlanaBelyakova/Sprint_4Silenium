package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class OrderPage { private final WebDriver driver;

    // Локатор поля "Имя"
    private final By clientFirstName = By.xpath(".//input[@placeholder='* Имя']");

    //Локатор поля "Фамилия"
    private final By clientLastName = By.xpath(".//input[@placeholder='* Фамилия']");

    //Локатор поля "Адрес: куда привезти заказ"
    private final By deliveryAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    //Локатор поля "Станция метро"
    private final By deliveryMetroStation = By.xpath(".//input[@placeholder='* Станция метро']");

    // Локатор поля "Телефон: на него позвонит курьер"
    private final By deliveryClientPhoneNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    //Локатор кнопки "Далее"
    private final By NextButton = By.xpath(".//button[(@class ='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее')]");

    // Конструктор класса
    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //Методы для работы с элементами заказа
    //Ввод имени
    public OrderPage sendClientFirstName(String firstName) {
        driver.findElement(clientFirstName).sendKeys(firstName);
        return this;
    }
    // Ввод фамилии
    public OrderPage sendClientLastName(String lastName) {
        driver.findElement(clientLastName).sendKeys(lastName);
        return this;
    }

    //Ввод адреса доставки
    public OrderPage sendDeliveryAddress(String address) {
        driver.findElement(deliveryAddress).sendKeys(address);
        return this;
    }

    // Выбор станции метро
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
    public OrderPage clickNextButton() {
        driver.findElement(NextButton).click();
        return this;
    }

}

