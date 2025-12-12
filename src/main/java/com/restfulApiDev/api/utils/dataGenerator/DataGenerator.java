package com.restfulApiDev.api.utils.dataGenerator;

import com.github.javafaker.Faker;

import java.util.Random;

public class DataGenerator {

    private static final String ALPHA_NUMERIC_STRING = "abcdefghijklmnopqrstuvwxyz0123456789";

    private static Faker faker = new Faker();

    /**
     * Generate faker randomize number with setting the minimum and maximum limits of values (int)
     *
     * @param min minimum limit of number which you want to get
     * @param max maximum limit of number which you want to get
     * @return a randomize string "1384"
     */
    public static int getFakerRandomIntNumberBetween(int min, int max) {
        return faker.number().numberBetween(min, max);
    }

    /**
     * Generate faker randomize number with decimals (double)
     *
     * @param maxNumberOfDecimals maximum number of decimals which you want to get
     * @param min                 minimum limit of number which you want to get
     * @param max                 maximum limit of number which you want to get
     * @return a randomize string "2615.379"
     */
    public static double getFakerRandomDoubleNumberBetween(int maxNumberOfDecimals, int min, int max) {
        return faker.number().randomDouble(maxNumberOfDecimals, min, max);
    }

    /**
     * Generate faker alpha numeric value
     *
     * @param count length string of symbol which you want to get
     * @return a randomize string "xd9lhx4ixg"
     */
    public static String randomAlphaNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }

    /**
     * Generate randomize Lowercase letters
     *
     * @param len length +1 string of letters which you want to get
     * @return a randomize string "rygf"
     */
    public static String genRandomLetter(int len) {
        String s = "";
        for (int i = 1; i < len; i++)
            s += (char) (char) (Math.random() * ('z' - 'a' + 1) + 'a');
        return s;
    }

    /**
     * Generate faker first name
     *
     * @return a randomize string "Jamienpb"
     */
    public static String getFakerFirstName() {
        return faker.name().firstName() + genRandomLetter(4);
    }

    /**
     * Generate faker street address
     *
     * @return a randomize string "0158 Anderson Place"
     */
    public static String getFakerAddress() {

        return faker.address().streetAddress();
    }

    /**
     * Generate faker randomize number (string)
     *
     * @param length length string of digits which you want to get
     * @return a randomize string "1113167882"
     */
    public static String getFakerRandomNumberString(int length) {
        String number = "";
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            number += String.valueOf(rand.nextInt(8) + 1);
        }
        return number;
    }

    /**
     * Generate faker date of birthday in format year-month-day
     *
     * @return a randomize string date "1960-09-24"
     */
    public static String getFakerDateOfBirthString1() {
        return getFakerRandomIntNumberBetween(1960, 2019) + "-0" +
                getFakerRandomIntNumberBetween(1, 9) + "-" +
                getFakerRandomIntNumberBetween(0, 3) +
                getFakerRandomIntNumberBetween(1, 9);
    }
}
