import pageObjects.MainPage;
import pageObjects.OrderPage;
import pageObjects.RentPage;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SamokatOrderingTest extends BaseTest {

    //Тест заказа через кнопку в верхней части сайта
    @Test
    public void samokatOrderingByHeaderOrderButton() {
        new MainPage(driver)
                .openSite()
                .clickCookieButton()
                .clickHeaderOrderButton();

        new OrderPage(driver)
                .sendClientFirstName("Маша")
                .sendClientLastName("Иванова")
                .sendDeliveryAddress("ул.Красная площадь, 9")
                .selectMetroStation("Площадь Революции")
                .sendDeliveryClientPhoneNumber("89998885566")
                .clickNextButton();

        boolean isDisplayed = new RentPage(driver)
                .sendRentalDate("10.10.2024")
                .setRentalTime()
                .clickCheckBoxColourBlackPearl()
                .sendComment("Пожалуйста, быстрее!!!")
                .clickOrderButton()
                .clickOrderButtonYes()
                .isModalOrderWindowDisplayed();
        assertTrue("Окно заказа не появилось?", isDisplayed);
    }
    // Тест заказа через кнопку в нижней части сайта
    @Test
    public void samokatOrderingByMiddleOrderButton() {
        new MainPage(driver)
                .openSite()
                .clickCookieButton()
                .clickMiddleOrderButton();

        new OrderPage(driver)
                .sendClientFirstName("Василий")
                .sendClientLastName("Иномаркин")
                .sendDeliveryAddress("ул.Ильинка, 4")
                .selectMetroStation("Китай-город")
                .sendDeliveryClientPhoneNumber("895134416659")
                .clickNextButton();

        boolean isDisplayed = new RentPage(driver)
                .sendRentalDate("08.09.2024")
                .setRentalTime()
                .clickCheckBoxColourGreyDespair()
                .sendComment("Опаздываю в автосалон!")
                .clickOrderButton()
                .clickOrderButtonYes()
                .isModalOrderWindowDisplayed();
        assertTrue("Нет окна заказа!", isDisplayed);
    }
}