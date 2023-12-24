package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CommonMethod;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class QuickViewPage {

    CommonMethod commonMethod = new CommonMethod();

    private SelenideElement favoriteIcon = $(byClassName("FavoriteBlock_Favorites__6577_")).$("path"),
            textSendInFavorite = $(byText("В избранное")),
            addToBasketButton = $(byText("Добавить в корзину")),

    goToBasketButton = $(byText("Перейти в корзину"));


    @Step("Нажать на иконку избранное")
    public QuickViewPage clickOnFavoriteIcon() {
        favoriteIcon.click();
        return this;
    }

    @Step("Проверка текста В избранное")
    public QuickViewPage textSendInFavoriteIsDisplayed() {
        commonMethod.checkTextIsDisplayed("В избранное");
        return this;
    }

    @Step("Проверка текста В избранном")
    public QuickViewPage textInFavoriteIsDisplayed() {
        commonMethod.checkTextIsDisplayed("В избранном");
        return this;
    }

    @Step("Нажать на кнопку 'В корзину'")
    public QuickViewPage clickOnButtonAddToBasket() {
        addToBasketButton.click();
        return this;
    }

    @Step("Перейти в корзину")
    public QuickViewPage clickOnButtonGoToBasket() {
        goToBasketButton.click();
        return this;
    }


}
