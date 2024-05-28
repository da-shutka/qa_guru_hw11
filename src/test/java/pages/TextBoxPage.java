package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.OutputComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage extends BasePage {

    private final SelenideElement
            fullNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress");

    OutputComponent output = new OutputComponent();

    public TextBoxPage openPage() {
        open("text-box");
        $("h1").shouldHave(text("Text Box"));
        this.removeBanners();
        return this;
    }

    public TextBoxPage setFullName(String fullName) {
        fullNameInput.setValue(fullName);
        return this;
    }

    public TextBoxPage setUserEmail(String email) {
        userEmailInput.setValue(email);
        return this;
    }

    public TextBoxPage setCurrentAddress(String address) {
        currentAddressInput.setValue(address);
        return this;
    }

    public TextBoxPage setPermanentAddress(String address) {
        permanentAddressInput.setValue(address);
        return this;
    }

    public void submit() {
        $("#submit").click();
    }

    public TextBoxPage checkResult(String key, String value) {
        output.checkOutputRow(key, value);
        return this;
    }
}
