package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchPage {

    private SelenideElement searchedItem = $(".ProductCard_Image__itFII"),
            robotItem = $(byText("Робот 'Dance Hero' танцующий")),
            buyButton = $(byText("Купить")),
            basketButton = $(byText("Корзина"));

    private ElementsCollection searchedItems = $$(".ProductsPanel_ProductsPanel___sDlS");

    @Step("Проверка отображения товара в поисковой выдаче")
    public SearchPage itemIsPresentedInSearchResults(String item) {
        searchedItems.shouldHave(CollectionCondition.texts(item));
        return this;
    }

    @Step("Нажать кнопку Купить")
    public SearchPage clickOnBuyButton(String item) {
        searchedItem.hover();
        buyButton.click();
        return this;
    }

    @Step("Нажать на кнопку Корзина")
    public BasketPage clickOnBasketButton() {
        basketButton.click();
        return new BasketPage();
    }

}
