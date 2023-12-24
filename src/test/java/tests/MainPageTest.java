package tests;


import data.UserData;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;

public class MainPageTest extends BaseTest{
    MainPage mainPage = new MainPage();

    @Test
    @Tag("smoke")
    @Feature("Авторизация пользователя")
    @Story("Успешная авторизация пользователя на сайте")
    @Owner("Dmitry Nazarov")
    @DisplayName("RM-T1 Успешная авторизация и выход из личного кабинета")
    void successfullyLogOut() {
        mainPage.openPage()
                .clickOnButtonEnter()
                .checkPhoneNumberMask()
                .setPhoneNumber(UserData.correctPhoneNumber)
                .cliclOnButtonCintinue()
                .setPinCode(UserData.correctCode)
                .clickOnButtonProfile()
                .checkSuccsesfullLogIn(UserData.correctPhoneNumberInProfile)
                .clickLogOut()
                .checkButtonEnterIsViasiable();
    }
    @Test
    @Tag("negative")
    @Feature("Авторизация пользователя")
    @Story("Не успешная авторизация пользователя на сайте")
    @Owner("Dmitry Nazarov")
    @DisplayName("RM-T2 Попытка регистрации с невалидным номером телефона")
    void setSymbolsInCodeInput() {
        mainPage.openPage()
                .clickOnButtonEnter()
                .setPhoneNumber(UserData.inCorrectPhoneNumber)
                .checkButtonContinueIsDisabled();
    }

    @Test
    @Tag("negative")
    @Feature("Авторизация пользователя")
    @Story("Не успешная авторизация пользователя на сайте")
    @Owner("Dmitry Nazarov")
    @DisplayName("RM-T3 Попытка ввода символов в поле для номера телефона")
    void setSymbolsInPnoneNumberInput() {
        mainPage.openPage()
                .clickOnButtonEnter()
                .checkButtonContinueIsDisabled()
                .setPhoneNumber(UserData.sybolPhoneNumber)
                .checkButtonContinueIsDisabled();
    }

    @Test
    @Tag("negative")
    @Feature("Авторизация пользователя")
    @Story("Не успешная авторизация пользователя на сайте")
    @Owner("Dmitry Nazarov")
    @DisplayName("RM-T4 Ввод неверного кода ОТР при авторизации")
    void setIncorrectCode() {
        mainPage.openPage()
                .clickOnButtonEnter()
                .setPhoneNumber(UserData.correctPhoneNumber)
                .cliclOnButtonCintinue()
                .setPinCode(UserData.inCorretCode)
                .checkErrorMassageIsVisiable();
    }

    @Test
    @Tag("negative")
    @Feature("Авторизация пользователя")
    @Story("Не успешная авторизация пользователя на сайте")
    @Owner("Dmitry Nazarov")
    @DisplayName("RM-T5 Закрытие окна ввода ОТР без завершения авторизации")
    void repeatSendCodeAfterTimerEnds() {
        mainPage.openPage()
                .clickOnButtonEnter()
                .setPhoneNumber(UserData.correctPhoneNumber)
                .cliclOnButtonCintinue();
    }

    @Test
    @Tag("smoke")
    @Feature("Отображение карточки товара")
    @Story("Карточка товара для быстрого просмотра")
    @Owner("Dmitry Nazarov")
    @DisplayName("RM-T6 Проверка отображения кнопки быстрого просмотра при наведении курсора на карточку товара")
    void checkCardItemThroughQuickView() {
        mainPage.openPage()
                .clickOnButtonEnter()
                .checkPhoneNumberMask()
                .setPhoneNumber(UserData.correctPhoneNumber)
                .cliclOnButtonCintinue()
                .setPinCode(UserData.correctCode)
                .clickOnPreview();
    }
}
