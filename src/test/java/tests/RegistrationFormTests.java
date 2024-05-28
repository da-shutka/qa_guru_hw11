package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.TestData;

@Tag("demoqa_auto")
public class RegistrationFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();

    @Test
    @DisplayName("Регистрационная форма. Заполнены все поля")
    void checkRegistrationFormAllFieldsTest() {
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserEmail(testData.userEmail)
                .setGender(testData.gender)
                .setUserNumber(testData.phoneNumber)
                .setDateOfBirth(testData.birthDay)
                .setSubjectsInput(testData.subject)
                .setHobbies(testData.hobby)
                .uploadPicture(testData.file)
                .setCurrentAddress(testData.currentAddress)
                .setState(testData.state)
                .setCity(testData.city)
                .submit();

        registrationPage.checkSuccessfulSubmit()
                .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Student Email", testData.userEmail)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.phoneNumber)
                .checkResult("Date of Birth", String.format(
                        "%s %s,%s",
                        testData.birthDay.get(0),
                        testData.birthDay.get(1),
                        testData.birthDay.get(2)))
                .checkResult("Subjects", testData.subject)
                .checkResult("Hobbies", testData.hobby)
                .checkResult("Picture", testData.file)
                .checkResult("Address", testData.currentAddress)
                .checkResult("State and City", testData.state + " " + testData.city);
    }

    @Test
    @DisplayName("Регистрационная форма. Заполнены обязательные поля")
    void checkRegistrationFormMandatoryFieldsTest() {
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.gender)
                .setUserNumber(testData.phoneNumber)
                .setDateOfBirth(testData.birthDay)
                .submit();

        registrationPage.checkSuccessfulSubmit()
                .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.phoneNumber)
                .checkResult("Date of Birth", String.format(
                        "%s %s,%s",
                        testData.birthDay.get(0),
                        testData.birthDay.get(1),
                        testData.birthDay.get(2)));
    }

    @Test
    @DisplayName("Регистрационная форма. Заполнены дефолтные поля")
    void checkRegistrationFormNegativeTest() {
        registrationPage.openPage().submit();
        registrationPage.checkUnsuccessfulSubmit();
    }
}
