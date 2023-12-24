package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class BasketPage {

    private SelenideElement deleteButton = $(".BasketItem_DeleteIcon__iqjP0");


    @Step("Кликнуть на кнопку удалить товар")
    public BasketPage clickOnDeleteButton() {
        deleteButton.click();
        return this;
    }


}
