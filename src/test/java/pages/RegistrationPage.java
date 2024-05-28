package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;
import pages.components.TableResultComponent;

import java.util.List;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage extends BasePage {

    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userGender = $("#genterWrapper"),
            userNumber = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            uploadPictureInput = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#state input"),
            cityInput = $("#city input"),
            submittedForm = $("#example-modal-sizes-title-lg");

    CalendarComponent calendarComponent = new CalendarComponent();
    TableResultComponent modal = new TableResultComponent();

    @Step("Открыть регистрационную форму")
    public RegistrationPage openPage() {
        open("automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        this.removeBanners();
        return this;
    }

    @Step("Ввести имя")
    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    @Step("Ввести фамилию")
    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    @Step("Ввести электронную почту")
    public RegistrationPage setUserEmail(String userEmail) {
        userEmailInput.setValue(userEmail);
        return this;
    }

    @Step("Выбрать пол")
    public RegistrationPage setGender(String gender) {
        userGender.$(byText(gender)).click();
        return this;
    }

    @Step("Ввести номер телефона")
    public RegistrationPage setUserNumber(String number) {
        userNumber.setValue(number);
        return this;
    }

    @Step("Выбрать дату рождения")
    public RegistrationPage setDateOfBirth(List<String> birthDay) {
        calendarInput.click();
        calendarComponent.setDate(birthDay.get(0), birthDay.get(1), birthDay.get(2));
        return this;
    }

    @Step("Задать предметы")
    public RegistrationPage setSubjectsInput(String subject) {
        subjectsInput.setValue(subject).pressEnter();
        return this;
    }

    @Step("Выбрать хобби")
    public RegistrationPage setHobbies(String hobby) {
        hobbiesInput.$$("label").filterBy(text(hobby)).first().click();
        return this;
    }

    @Step("Загрузить фото")
    public RegistrationPage uploadPicture(String fileName) {
        uploadPictureInput.uploadFromClasspath(fileName);
        return this;
    }

    @Step("Ввести адрес проживания")
    public RegistrationPage setCurrentAddress(String address) {
        currentAddressInput.setValue(address);
        return this;
    }

    @Step("Выбрать область")
    public RegistrationPage setState(String state) {
        stateInput.setValue(state).pressEnter();
        return this;
    }

    @Step("Выбрать город")
    public RegistrationPage setCity(String city) {
        cityInput.setValue(city).pressEnter();
        return this;
    }

    @Step("Нажать Submit")
    public void submit() {
        $("#submit").click();
    }

    @Step("Проверить успешность регистрации")
    public RegistrationPage checkSuccessfulSubmit() {
        submittedForm.shouldHave(text("Thanks for submitting the form"));
        return this;
    }

    @Step("Проверить поле {key}")
    public RegistrationPage checkResult(String key, String value) {
        modal.checkTableRow(key, value);
        return this;
    }

    @Step("Проверить неуспешность регистрации")
    public void checkUnsuccessfulSubmit() {
        submittedForm.shouldBe(hidden);
    }
}
