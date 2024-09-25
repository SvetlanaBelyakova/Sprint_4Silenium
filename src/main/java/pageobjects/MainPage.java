package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

//Элементы главной страницы сайта
public class MainPage {
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //Локатор кнопки "да все привыкли" сообщения о кукисах
    private static final By cookieButton = By.id("rcc-confirm-button");

    //Локатор Кнопки заказа в хэдере сайта
    private static final By headerOrderButton = By.className("Button_Button__ra12g");

    //Локатор кнопки заказа в середине сайта
    private static final By middleOrderButton = By.className("Button_Middle__1CSJM");

    //Массив локаторов кнопок с вопросами
    private static final String[] DROP_DOWN_QUESTIONS_ARRAY = new String[]{
            "accordion__heading-0",
            "accordion__heading-1",
            "accordion__heading-2",
            "accordion__heading-3",
            "accordion__heading-4",
            "accordion__heading-5",
            "accordion__heading-6",
            "accordion__heading-7"};

    //Массив локаторов панелей с текстом ответов
    private static final String[] DROP_DOWN_ANSWERS_ARRAY = new String[]{
            "accordion__panel-0",
            "accordion__panel-1",
            "accordion__panel-2",
            "accordion__panel-3",
            "accordion__panel-4",
            "accordion__panel-5",
            "accordion__panel-6",
            "accordion__panel-7"};
    //Методы для работы с элементами главной страницы

    //Открыть сайт
    public static final String SITE_URL = "https://qa-scooter.praktikum-services.ru/";

    public  MainPage openSite() {
        driver.get(SITE_URL);
        return this;
    }

    //Кликнуть по кнопке "да все привыкли"
    public pageobjects.MainPage clickCookieButton() {
        driver.findElement(cookieButton).click();
        return this;
    }

    //Кликнуть по кнопке заказа
    public void clickHeaderOrderButton() {
        driver.findElement(headerOrderButton).click();
    }

    //Кликнуть по кнопке заказа в середине сайта
    public void clickMiddleOrderButton() {
        driver.findElement(middleOrderButton).click();
    }

    //Прокрутка главной страницы до последнего элемента списка
    public MainPage scrollPageToEndOfList() {
        WebElement lastQuestionArrow = driver.findElement(By.id( DROP_DOWN_QUESTIONS_ARRAY[7]));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", lastQuestionArrow);
        return this;
    }

    //Клик по стрелке выпадающего списка
    public void clickQuestionArrow(int questionIndex) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.id( DROP_DOWN_QUESTIONS_ARRAY[questionIndex])));
        driver.findElement(By.id( DROP_DOWN_QUESTIONS_ARRAY[questionIndex])).click();
    }

    //Проверка текста в открытой панели
    public void checkTextInOpenPanel(String expectedAnswer, int questionIndex) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id( DROP_DOWN_ANSWERS_ARRAY[questionIndex])));
        String answerText = driver.findElement(By.id( DROP_DOWN_ANSWERS_ARRAY[questionIndex])).getText();
        assertEquals(expectedAnswer, answerText);
    }

    //Клик по кнопке вопроса
    public void clickQuestionButton(String questionButtonLocator) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.id(questionButtonLocator)));
        driver.findElement(By.id(questionButtonLocator)).click();
    }
}