package pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import static org.junit.Assert.assertEquals;

public class RentPage {
    WebDriver driver;

    //Локаторы данных страницы "Про аренду"
    //Локатор поля даты начала аренды
    private final By rentalDateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //Локатор поля срока аренды
    private final By rentalTimeField = By.className("Dropdown-placeholder");
    //Локатор списка срока аренды
    private final By rentalTime = By.xpath(".//*[(@role ='option' and text()='трое суток')]");
    //Локатор цвета самоката "Черный жемчуг"
    private final By checkBoxColorBlackPearl = By.xpath(".//input[@id='black']");
    //Локатор цвета самоката "Серая безысходность"
    private final By checkBoxColorGreyDespair = By.xpath(".//input[@id='grey']");
    //Локатор поля комментария для курьера
    private final By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //Локатор кнопки "Заказать"
    private final By orderButton = By.xpath(".//button[(@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать')]");
    //Локатор кнопки "Да" оформления заказа
    private final By orderButtonYes = By.xpath(".//*[@id='root']/div/div[2]/div[5]/div[2]/button[2]");
    //Локатор модального окна
    private final By modalOrderWindow = By.xpath(".//div[contains(@class, 'Order_ModalHeader')]");


    //Модальное окно "Заказ Оформлен"
    public boolean isModalOrderWindowDisplayed() {

        return driver.findElement(modalOrderWindow).isDisplayed();
    }

    //Конструктор класса
    public RentPage(WebDriver driver) {

        this.driver = driver;
    }

    //Методы для работы с элементами страницы аренды
     //Ввод даты доставки
    public RentPage sendRentalDate(String date) {
        driver.findElement(rentalDateField).sendKeys(date);
        driver.findElement(rentalDateField).sendKeys(Keys.ENTER);
        return this;
    }


    //Ввод срока аренды
    public RentPage setRentalTime() {
        driver.findElement(rentalTimeField).click();
        driver.findElement(rentalTime).click();
        return this;
    }

    // Выбор цвета самоката "Черный жемчуг"
    public RentPage clickCheckBoxColourBlackPearl(String color) {
        driver.findElement(checkBoxColorBlackPearl).click();
        return this;
    }

    //Выбор цвета самоката "Серая безысходность"
    public RentPage clickCheckBoxColourGreyDespair(String color) {
        driver.findElement(checkBoxColorGreyDespair).click();
        return this;
    }

    // Ввод комментария для курьера
    public RentPage sendComment(String userComment) {
        driver.findElement(commentField).sendKeys(userComment);
        return this;
    }

    // Клик по Кнопке "Заказать"
    public RentPage clickOrderButton() {
        driver.findElement(orderButton).click();
        return this;
    }
    //Получение сообщения "Заказ оформлен"
    public RentPage checkOrderMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement orderMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'Order_ModalHeader__3FDaJ')]")));
        assertEquals("Заказ оформлен", orderMessage.getText());
        return this;
    }

    //Клик по кнопке "Да" оформления заказа
    public RentPage clickOrderButtonYes() {
        driver.findElement(orderButtonYes).click();
        return this;
    }

}