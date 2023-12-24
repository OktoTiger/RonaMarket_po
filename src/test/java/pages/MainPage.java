package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CommonMethod;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    CommonMethod commonMethod = new CommonMethod();
    private SelenideElement buttonContinue = $(byText("Продолжить")),
            buttonEnter = $(byText("Войти")),
            phoneNumberInput = $("[name=phone_number]"),
            pinCodeInput = $("[inputmode=numeric]"),
            buttonProfile = $(byText("Профиль")),
            buttonLogOut = $(byText("Выйти")),
            errorMessage = $(byText("Отправить код повторно:")),
            closeIcon = $(".Modal_Content__exit__42MWn"),
            itemElement = $(".ProductCard_Image__fastPreview__N3QM2"),
            quikPreview = $x("//div[@class='ProductCard_Image__itFII']//span[text()='Быстрый просмотр']"),
            searchInput = $("[name=search]"),
            toysCategory = $(byText("Игрушки"));

    private ElementsCollection infoAboutUser = $$(".ViewMenu_Username__e_0eB");

    @Step("Открываем главную страницу сайта")
    public MainPage openPage() {
        open("https://rona.market/");
        cliclOnButtonCintinue();
        return this;
    }

    @Step("Нажимаем на кнопку Продолжить")
    public MainPage cliclOnButtonCintinue() {
        buttonContinue.click();
        return this;
    }

    @Step("Нажимаем на кнопку Войти")
    public MainPage clickOnButtonEnter() {
        buttonEnter.click();
        return this;
    }

    @Step("Вводим номер телефона")
    public MainPage setPhoneNumber(String phoneNumber) {
        phoneNumberInput.setValue(phoneNumber).click();
        return this;
    }

    @Step("Вводим Пин код")
    public MainPage setPinCode(String symbol) {
        pinCodeInput.setValue(symbol);
        for (int i = 0; i < 5; i++) {
            pinCodeInput.sibling(i).setValue(symbol);
        }
        return this;
    }

    @Step("Нажимаем на кнопку Профиль")
    public MainPage clickOnButtonProfile() {
        buttonProfile.hover();
        return this;
    }

    @Step("Проверка успешной авторизации")
    public MainPage checkSuccsesfullLogIn(String userData) {
        infoAboutUser.shouldHave(texts(userData));
        return this;
    }

    @Step("Выход из личного кабинета")
    public MainPage clickLogOut() {
        buttonLogOut.click();
        return this;
    }

    @Step("Проверка отображения кнопки Войти")
    public MainPage checkButtonEnterIsViasiable() {
        buttonEnter.shouldBe(Condition.visible);
        return this;
    }

    @Step("Проверка на неактивность кнопки Продолжить")
    public MainPage checkButtonContinueIsDisabled() {
        buttonContinue.parent().shouldBe(disabled);
        return this;
    }

    @Step("Окно авторизации должно быть закрыто")
    public MainPage checkErrorMassageIsVisiable() {
        errorMessage.shouldBe(visible, Duration.ofSeconds(60));
        return this;
    }

    @Step("Проверка маски в поле Номер телефона")
    public MainPage checkPhoneNumberMask() {
        phoneNumberInput.shouldHave(attribute("placeholder", "+7 ( ___ ) ___ - __ - __"));
        return this;
    }

    @Step("Нажать на товар")
    public QuickViewPage clickOnPreview() {
        itemElement.hover();
        quikPreview.click();
        return new QuickViewPage();
    }

    @Step("Ввести данные в поисковую строку")
    public SearchPage searchItem(String item) {
        searchInput.setValue(item).pressEnter();
        return new SearchPage();
    }


}
