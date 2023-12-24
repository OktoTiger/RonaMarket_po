package pages.components;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CommonMethod {
    public void checkTextIsDisplayed(String text) {
        $(byText(text)).shouldBe(Condition.visible);
    }
}


