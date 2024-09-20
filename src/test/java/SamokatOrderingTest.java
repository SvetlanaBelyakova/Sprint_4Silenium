import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageobjects.MainPage;
import pageobjects.OrderPage;
import pageobjects.RentPage;


@RunWith(Parameterized.class)
public class SamokatOrderingTest extends BaseTest {

    private final String firstName;
    private final String lastName;
    private final String deliveryAddress;
    private final String metroStation;
    private final String phoneNumber;
    private final String rentalDate;
    private final String color;
    private final String comment;

    public SamokatOrderingTest(String firstName, String lastName, String deliveryAddress, String metroStation,
                               String phoneNumber, String rentalDate, String color, String comment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.deliveryAddress = deliveryAddress;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
        this.rentalDate = rentalDate;
        this.color = color;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getDateSetForOrder() {
        return new Object[][] {
                {"Маша", "Иванова", "ул.Красная площадь, 9", "Площадь Революции", "89998885566", "10.10.2024", "Чёрный жемчуг", "Пожалуйста, быстрее!!!"},
                {"Василий", "Иномаркин", "ул.Ильинка, 4", "Китай-город", "895134416659", "08.09.2024", "Серый Отчаяние", "Опаздываю в автосалон!"},
        };
    }

    @Before
    public void setUp() {
        new MainPage(driver)
                .openSite()
                .clickCookieButton();
    }

    @Test
    public void samokatOrdering() {
        new MainPage(driver)
                .clickHeaderOrderButton();


        new OrderPage(driver)
                .sendClientFirstName(firstName)
                .sendClientLastName(lastName)
                .sendDeliveryAddress(deliveryAddress)
                .selectMetroStation(metroStation)
                .sendDeliveryClientPhoneNumber(phoneNumber)
                .clickNextButton();

        boolean isDisplayed;
        if (new RentPage(driver)
                .sendRentalDate(rentalDate)
                .setRentalTime()
                .clickCheckBoxColourBlackPearl(color)
                .clickCheckBoxColourGreyDespair(color)
                .sendComment(comment)
                .clickOrderButton()
                .clickOrderButtonYes()
                .checkOrderMessage()
                .isModalOrderWindowDisplayed()) isDisplayed = true;
        else isDisplayed = false;

        Assert.assertTrue("Нет окна заказа!", isDisplayed);
    }


}