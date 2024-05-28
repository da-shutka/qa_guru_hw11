package pages;

import com.codeborne.selenide.SelenideElement;
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

    public RegistrationPage openPage() {
        open("automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        this.removeBanners();
        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage setUserEmail(String userEmail) {
        userEmailInput.setValue(userEmail);
        return this;
    }

    public RegistrationPage setGender(String gender) {
        userGender.$(byText(gender)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String number) {
        userNumber.setValue(number);
        return this;
    }

    public RegistrationPage setDateOfBirth(List<String> birthDay) {
        calendarInput.click();
        calendarComponent.setDate(birthDay.getFirst(), birthDay.get(1), birthDay.getLast());
        return this;
    }

    public RegistrationPage setSubjectsInput(String subject) {
        subjectsInput.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String hobby) {
        hobbiesInput.$$("label").filterBy(text(hobby)).first().click();
        return this;
    }

    public RegistrationPage uploadPicture(String fileName) {
        uploadPictureInput.uploadFromClasspath(fileName);
        return this;
    }

    public RegistrationPage setCurrentAddress(String address) {
        currentAddressInput.setValue(address);
        return this;
    }

    public RegistrationPage setState(String state) {
        stateInput.setValue(state).pressEnter();
        return this;
    }

    public RegistrationPage setCity(String city) {
        cityInput.setValue(city).pressEnter();
        return this;
    }

    public void submit() {
        $("#submit").click();
    }

    public RegistrationPage checkSuccessfulSubmit() {
        submittedForm.shouldHave(text("Thanks for submitting the form"));
        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        modal.checkTableRow(key, value);
        return this;
    }

    public void checkUnsuccessfulSubmit() {
        submittedForm.shouldBe(hidden);
    }
}
