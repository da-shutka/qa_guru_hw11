package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TableResultComponent {

    private final SelenideElement table = $(".table-responsive");

    public void checkTableRow(String key, String value) {
        table.$(byText(key)).parent().shouldHave(text(value));
    }
}
