package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;
import utils.TestData;

public class TextBoxTests extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();
    TestData testData = new TestData();

    @Test
    void checkTextBoxFormAllFieldsTest() {
        textBoxPage.openPage()
                .setFullName(testData.fullName)
                .setUserEmail(testData.userEmail)
                .setCurrentAddress(testData.currentAddress)
                .setPermanentAddress(testData.permanentAddress)
                .submit();

        textBoxPage.checkResult("Name", testData.fullName)
                .checkResult("Email", testData.userEmail)
                .checkResult("Current Address", testData.currentAddress)
                .checkResult("Permananet Address", testData.permanentAddress);
    }
}
