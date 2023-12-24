package tests;


import data.UserData;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;

public class QuickViewPageTest extends BaseTest {
    MainPage mainPage = new MainPage();

    @Test
    @Tag("smoke")
    @Feature("Отображение карточки товара")
    @Story("Карточка товара для быстрого просмотра")
    @Owner("Dmitry Nazarov")
    @DisplayName("RM-T7 Нажатие на иконку В избранное")
    void checkFavoriteIconIsClicable() {
        mainPage.openPage()
                .clickOnButtonEnter()
                .checkPhoneNumberMask()
                .setPhoneNumber(UserData.correctPhoneNumber)
                .cliclOnButtonCintinue()
                .setPinCode(UserData.correctCode)
                .clickOnPreview()
                .textSendInFavoriteIsDisplayed()
                .clickOnFavoriteIcon()
                .textInFavoriteIsDisplayed()
                .clickOnFavoriteIcon();
    }
}
