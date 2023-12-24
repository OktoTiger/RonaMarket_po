package tests;


import data.ItemData;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.SearchPage;

public class SearchPageTest extends BaseTest{

    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();
    ItemData itemData = new ItemData();


    @Test
    @Tag("smoke")
    @Feature("Поиск")
    @Story("Поисковая выдача существующего товара")
    @Owner("Dmitry Nazarov")
    @DisplayName("RM-T8 Отображение запрошенного товара в поисковой выдаче")
    void itemIsDisplayedInSearchResults() {
        mainPage.openPage()
                .searchItem(itemData.Irrigator);
        searchPage.itemIsPresentedInSearchResults(itemData.Irrigator);
    }

}
