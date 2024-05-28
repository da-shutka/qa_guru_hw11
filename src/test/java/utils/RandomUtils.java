package utils;

import com.github.javafaker.Faker;
import com.google.common.collect.Lists;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static String[] subjects = {"Accounting",
            "Arts",
            "Biology",
            "Chemistry",
            "Civics",
            "Computer Science",
            "Commerce",
            "Economics",
            "English",
            "Hindi",
            "History",
            "Maths",
            "Physics",
            "Social Studies"};

    public static String[] hobbies = {"Sports",
            "Reading",
            "Music"};

    public static String getRandomFirstName() {
        return new Faker().name().firstName();
    }

    public static String getRandomLastName() {
        return new Faker().name().lastName();
    }

    public static String getRandomFullName() {
        return new Faker().name().fullName();
    }

    public static String getRandomUserEmail() {
        return new Faker().internet().emailAddress();
    }

    public static String getRandomGender() {
        return new Faker().demographic().sex();
    }

    public static String getRandomPhoneNumber() {
        return new Faker().number().digits(10);
    }

    public static String getRandomFile() {
        return new Faker().options().option("comma.jpg", "flower.png");
    }

    public static String getRandomFullAddress() {
        return new Faker().address().fullAddress();
    }

    public static String getRandomState() {
        return new Faker().options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    }

    public static List<String> getRandomBirthDay() {
        return getRandomDate(new Faker().date().birthday());
    }

    public static List<String> getRandomDate(Date date) {
        List<String> dayMonthYear = new ArrayList<String>();

        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        String day = String.valueOf(localDate.getDayOfMonth());

        Format f = new SimpleDateFormat("MMMM", Locale.ENGLISH);
        String month = f.format(date);

        f = new SimpleDateFormat("yyyy");
        String year = f.format(date);

        dayMonthYear.add(day);
        dayMonthYear.add(month);
        dayMonthYear.add(year);

        return dayMonthYear;
    }

    public static String getRandomSubject() {
        return new Faker().options().option(subjects);
    }

    public static String getRandomHobby() {
        return new Faker().options().option(hobbies);
    }

    public static String getRandomCityBasedOnState(String state) {
        List<String> citiesNCR = Lists.newArrayList("Delhi", "Gurgaon", "Noida");
        List<String> citiesUttar = Lists.newArrayList("Agra", "Lucknow", "Merrut");
        List<String> citiesHaryana = Lists.newArrayList("Karnal", "Panipat");
        List<String> citiesRajasthan = Lists.newArrayList("Jaipur", "Jaiselmer");
        List<String> target = new ArrayList<>();

        switch (state) {
            case "NCR":
                target.addAll(citiesNCR);
                break;
            case "Uttar Pradesh":
                target.addAll(citiesUttar);
                break;
            case "Haryana":
                target.addAll(citiesHaryana);
                break;
            case "Rajasthan":
                target.addAll(citiesRajasthan);
                break;
        }
        return getRandomItemFromList(target);
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomItemFromList(List<String> array) {
        int index = getRandomInt(0, array.size() - 1);
        return array.get(index);
    }
}
