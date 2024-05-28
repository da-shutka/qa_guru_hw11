package utils;

import java.util.List;

import static utils.RandomUtils.*;
import static utils.RandomUtils.getRandomCityBasedOnState;

public class TestData {

    public String
            firstName = getRandomFirstName(),
            lastName = getRandomLastName(),
            userEmail = getRandomUserEmail(),
            gender = getRandomGender(),
            phoneNumber = getRandomPhoneNumber(),
            file = getRandomFile(),
            currentAddress = getRandomFullAddress(),
            state = getRandomState(),
            city = getRandomCityBasedOnState(state),
            fullName = getRandomFullName(),
            permanentAddress = getRandomFullAddress(),
            subject = getRandomSubject(),
            hobby = getRandomHobby();

    public List<String> birthDay = getRandomBirthDay();
}
