package tests;


import data.ItemData;
import data.UserData;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.BasketPage;
import pages.MainPage;
import pages.components.CommonMethod;

public class BasketPageTest extends BaseTest {
    MainPage mainPage = new MainPage();
    CommonMethod commonMethod = new CommonMethod();
    BasketPage basketPage = new BasketPage();
    ItemData itemData = new ItemData();

    @Test
    @Tag("smoke")
    @Feature("Корзина")
    @Story("Добавление товара в корзину")
    @Owner("Dmitry Nazarov")
    @DisplayName("RM-T9 Добавление товара в корзину для авторизированного пользователя")
    void addedItemInBasket() {
        mainPage.openPage()
                .clickOnButtonEnter()
                .checkPhoneNumberMask()
                .setPhoneNumber(UserData.correctPhoneNumber)
                .cliclOnButtonCintinue()
                .setPinCode(UserData.correctCode)
                .clickOnPreview()
                .clickOnButtonAddToBasket()
                .clickOnButtonGoToBasket();
        commonMethod.checkTextIsDisplayed(itemData.itemMelnica);
        basketPage.clickOnDeleteButton();


    }

}
