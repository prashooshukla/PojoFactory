package org.prash.util;


import org.prash.datafactory.NameDataValues;
import org.prash.datafactory.AddressDataValues;
import org.prash.datafactory.ContentDataValues;
import org.prash.datafactory.impl.DefaultAddressDataValues;
import org.prash.datafactory.impl.DefaultContentDataValues;
import org.prash.datafactory.impl.DefaultNameDataValues;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Project: PojoFactory
 * Author: bittu
 * This is an extension of Data Factory repo.
 * I've modified DataFactory based on my requirement
 */


public final class DataFactory {

    private static Random random = new Random(93285);
    private static final int UUID_LENGTH = 6;

    private NameDataValues nameDataValues = new DefaultNameDataValues();
    private AddressDataValues addressDataValues = new DefaultAddressDataValues();
    private ContentDataValues contentDataValues = new DefaultContentDataValues();

    /**
     *
     *<b>Description: Generating UUID</b>
     *
     * @param length should be +ve
     * @return UUID string
     *
     * @author bittu
     */
    public String getUUID(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be positive");
        }

        StringBuilder sb = new StringBuilder();
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < length; i++) {
            int digit = random.nextInt(10); // Generate random digit between 0 and 9
            sb.append(digit);
        }
        return sb.toString();
    }

    public double getDouble(long min, long max) {
        return min + (max - min) * random.nextDouble();
    }

    public double getDouble() {
        return getDouble(10_000, 100_1000);
    }

    /**
     *
     *<b>Description: Generate UUID of length UUID_LENGTH</b>
     *
     * @return String of length UUID_LENGTH;
     *
     * @author bittu
     */
    public String getUUID() {
        return getUUID(UUID_LENGTH);
    }

    /**
     * @param prefix for UUID
     * @return UUID
     *
     * @author bittu
     */
    public String getUUID(String prefix) {
        return prefix + getUUID();
    }

    public String getUUID(String prefix, int uuidLength) {
        return prefix + getUUID(uuidLength);
    }

    /**
     *
     * @param prefixLength for UUID
     * @param uuidLength for UUID
     * @return UUID
     *
     * @author bittu
     */
    public String getUUID(int prefixLength, int uuidLength) {
        return getRandomText(prefixLength) + getUUID(uuidLength);
    }

    /**
     * Returns a random item from a list of items.
     *
     * @param <T>   Item type in the list and to return
     * @param items List of items to choose from
     * @return Item from the list
     */
    public <T> T getItem(List<T> items) {
        return getItem(items, 100, null);
    }

    /**
     * Returns a random item from a list of items or the null depending on the
     * probability parameter. The probability determines the chance (in %) of
     * returning an item off the list versus null.
     *
     * @param <T>         Item type in the list and to return
     * @param items       List of items to choose from
     * @param probability chance (in %, 100 being guaranteed) of returning an item from
     *                    the list
     * @return Item from the list or null if the probability test fails.
     */
    public <T> T getItem(List<T> items, int probability) {
        return getItem(items, probability, null);
    }

    /**
     * Returns a random item from a list of items or the defaultItem depending
     * on the probability parameter. The probability determines the chance (in
     * %) of returning an item off the list versus the default value.
     *
     * @param <T>         Item type in the list and to return
     * @param items       List of items to choose from
     * @param probability chance (in %, 100 being guaranteed) of returning an item from
     *                    the list
     * @param defaultItem value to return if the probability test fails
     * @return Item from the list or the default value
     */
    public <T> T getItem(List<T> items, int probability, T defaultItem) {
        if (items == null) {
            throw new IllegalArgumentException("Item list cannot be null");
        }
        if (items.isEmpty()) {
            throw new IllegalArgumentException("Item list cannot be empty");
        }

        return chance(probability) ? items.get(random.nextInt(items.size()))
                : defaultItem;
    }

    /**
     * Returns a random item from an array of items
     *
     * @param <T>   Array item type and the type to return
     * @param items Array of items to choose from
     * @return Item from the array
     */
    public <T> T getItem(T[] items) {
        return getItem(items, 100, null);
    }

    /**
     * Returns a random item from an array of items or null depending on the
     * probability parameter. The probability determines the chance (in %) of
     * returning an item from the array versus null.
     *
     * @param <T>         Array item type and the type to return
     * @param items       Array of items to choose from
     * @param probability chance (in %, 100 being guaranteed) of returning an item from
     *                    the array
     * @return Item from the array or the default value
     */
    public <T> T getItem(T[] items, int probability) {
        return getItem(items, probability, null);
    }

    /**
     * Returns a random item from an array of items or the defaultItem depending
     * on the probability parameter. The probability determines the chance (in
     * %) of returning an item from the array versus the default value.
     *
     * @param <T>         Array item type and the type to return
     * @param items       Array of items to choose from
     * @param probability chance (in %, 100 being guaranteed) of returning an item from
     *                    the array
     * @param defaultItem value to return if the probability test fails
     * @return Item from the array or the default value
     */
    public <T> T getItem(T[] items, int probability, T defaultItem) {
        if (items == null) {
            throw new IllegalArgumentException("Item array cannot be null");
        }
        if (items.length == 0) {
            throw new IllegalArgumentException("Item array cannot be empty");
        }
        return chance(probability) ? items[random.nextInt(items.length)]
                : defaultItem;
    }

    /**
     * @return A random first name
     */
    public String getFirstName() {
        return getItem(nameDataValues.getFirstNames());
    }

    /**
     *
     * @return a combination of first and last name values in one string
     */
    public String getName() {
        return getItem(nameDataValues.getFirstNames()) + " "
                + getItem(nameDataValues.getLastNames());
    }

    /**
     * @return A random last name
     */
    public String getLastName() {
        return getItem(nameDataValues.getLastNames());
    }

    /**
     * @return A random street name
     */
    public String getStreetName() {
        return getItem(addressDataValues.getStreetNames());
    }

    /**
     * @return A random street suffix
     */
    public String getStreetSuffix() {
        return getItem(addressDataValues.getAddressSuffixes());
    }

    /**
     * Generates a random city value
     *
     * @return City as a string
     */
    public String getCity() {
        return getItem(addressDataValues.getCities());
    }

    /**
     * Generates an address value consisting of house number, street name and
     * street suffix. I.e. <code>543 MG Road</code>
     *
     * @return Address as a string
     */
    public String getAddress() {
        int num = 404 + random.nextInt(1400);
        return num + " " + getStreetName() + " " + getStreetSuffix();
    }

    /**
     * Generates line 2 for a street address (usually an Apt. or Suite #).
     * Returns null if the probability test fails.
     *
     * @param probability Chance as % of have a value returned instead of null.
     * @return Street address line two or null if the probability test fails
     */
    public String getAddressLine2(int probability) {
        return getAddressLine2(probability, null);
    }

    /**
     * Generates line 2 for a street address (usually an Apt. or Suite #).
     * Returns default value if the probability test fails.
     *
     * @param probability  Chance as % of have a value returned instead of null.
     * @param defaultValue Value to return if the probability test fails.
     * @return Street address line two or null if the probability test fails
     */
    public String getAddressLine2(int probability, String defaultValue) {
        return chance(probability) ? getAddressLine2() : defaultValue;
    }

    /**
     * Generates line 2 for a street address (usually an Apt. or Suite #).
     * Returns default value if the probability test fails.
     *
     * @return Street address line 2
     */
    public String getAddressLine2() {
        int test = random.nextInt(100);
        if (test < 50) {
            return "Apt #" + 100 + random.nextInt(1000);
        } else {
            return "Suite #" + 100 + random.nextInt(1000);
        }
    }

    /**
     * Creates a random birthdate within the range of 1950 to 2024
     *
     * @return LocalDate representing a birthdate
     */
    public LocalDate getBirthDate() {
        Date base = new Date(0);
        return getDate(base, -365 * 15, 365 * 54);
    }

    /**
     * Returns a random int value.
     *
     * @return random number
     */
    public int getNumber() {
        return getNumberBetween(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * Returns a random number between 0 and max
     *
     * @param max Maximum value of result
     * @return random number no more than max
     */
    public int getNumberUpTo(int max) {
        return getNumberBetween(0, max);
    }

    /**
     * Returns a number between min and max
     *
     * @param min minimum value of result
     * @param max maximum value of result
     * @return Random number within range
     */
    public int getNumberBetween(int min, int max) {

        if (max < min) {
            throw new IllegalArgumentException(String.format(
                    "Minimum must be less than minimum (min=%d, max=%d)", min,
                    max));
        }

        return min + random.nextInt(max - min);
    }

    /**
     * <b>Description: Build a LocalDate from java.util.Date</b>
     *
     * @param date java.util.Date
     * @return LocalDate
     * @author bittu
     */

    public static LocalDate convertToLocalDate(Date date) {
        return date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    /**
     * <b>Description: Build a Date from LocalDate</b>
     *
     * @param date LocalDate
     * @return java.util.Date
     * @author bittu
     */
    public static Date convertToDate(LocalDate date) {
        return Date.from(date.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }

    /**
     * Builds a date from the year, month, day values passed in
     *
     * @param year  The year of the final {@link Date} result
     * @param month The month of the final {@link Date} result (from 1-12)
     * @param day   The day of the final {@link Date} result
     * @return LocalDate representing the passed in values.
     */
    public LocalDate getDate(int year, int month, int day) {
        return LocalDate.of(year, month, day);
    }

    /**
     * Returns a random date which is in the range <code>baseData</code> +
     * <code>minDaysFromData</code> to <code>baseData</code> +
     * <code>maxDaysFromData</code>. This method does not alter the time
     * component, and the time is set to the time value of the base date.
     *
     * @param baseDate        Date to start from
     * @param minDaysFromDate minimum number of days from the baseDate the result can be
     * @param maxDaysFromDate the maximum number of days from the baseDate the result can be
     * @return A random date
     */
    public LocalDate getDate(LocalDate baseDate, int minDaysFromDate, int maxDaysFromDate) {
        Random random = new Random();
        int diff = minDaysFromDate + random.nextInt(maxDaysFromDate - minDaysFromDate + 1);
        return baseDate.plusDays(diff);
    }

    public LocalDate getDate(Date date, int minDaysFromDate, int maxDaysFromDate) {
        LocalDate baseDate = convertToLocalDate(date);
        Random random = new Random();
        int diff = minDaysFromDate + random.nextInt(maxDaysFromDate - minDaysFromDate + 1);
        return baseDate.plusDays(diff);
    }

    /**
     * Returns a random date between two dates. This method will alter the time
     * component of the dates
     *
     * @param minDate Minimum date that can be returned
     * @param maxDate Maximum date that can be returned
     * @return random date between these two dates.
     */
    public LocalDate getDateBetween(LocalDate minDate, LocalDate maxDate) {
        Random random = new Random();

        // Calculate the number of days between minDate and maxDate
        long minDay = minDate.toEpochDay();
        long maxDay = maxDate.toEpochDay();
        long randomDay = minDay + random.nextInt((int) (maxDay - minDay + 1));

        // Convert randomDay back to LocalDate
        return LocalDate.ofEpochDay(randomDay);
    }

    /**
     * Returns random text made up of english words of length
     * <code>length</code>
     *
     * @param length length of returned string
     * @return string made up of actual words with length <code>length</code>
     */
    public String getRandomText(int length) {
        return getRandomText(length, length);
    }

    /**
     * Returns random text made up of english words
     *
     * @param minLength minimum length of returned string
     * @param maxLength maximum length of returned string
     * @return string of length between min and max length
     */
    public String getRandomText(int minLength, int maxLength) {
        validateMinMaxParams(minLength, maxLength);

        StringBuilder sb = new StringBuilder(maxLength);
        int length = minLength;
        if (maxLength != minLength) {
            length = length + random.nextInt(maxLength - minLength);
        }
        while (length > 0) {
            if (!sb.isEmpty()) {
                sb.append(" ");
                length--;
            }
            String word = getRandomWord(length);
            sb.append(word);
            length = length - word.length();
        }
        return sb.toString();

    }

    private void validateMinMaxParams(int minLength, int maxLength) {
        if (minLength < 0) {
            throw new IllegalArgumentException(
                    "Minimum length must be a non-negative number");
        }

        if (maxLength < 0) {
            throw new IllegalArgumentException(
                    "Maximum length must be a non-negative number");
        }

        if (maxLength < minLength) {
            throw new IllegalArgumentException(
                    String.format(
                            "Minimum length must be less than maximum length (min=%d, max=%d)", minLength, maxLength));
        }
    }

    /**
     * @return a random character
     */
    public char getRandomChar() {
        return (char) (random.nextInt(26) + 'a');
    }

    /**
     * Return a string containing <code>length</code> random characters
     *
     * @param length number of characters to use in the string
     * @return A string containing <code>length</code> random characters
     */
    public String getRandomChars(int length) {
        return getRandomChars(length, length);
    }

    /**
     * Return a string containing between <code>length</code> random characters
     *
     * @param minLength & maxLength
     *                  number of characters to use in the string
     * @return A string containing <code>length</code> random characters
     */
    public String getRandomChars(int minLength, int maxLength) {
        validateMinMaxParams(minLength, maxLength);
        StringBuilder sb = new StringBuilder(maxLength);

        int length = minLength;
        if (maxLength != minLength) {
            length = length + random.nextInt(maxLength - minLength);
        }
        while (length > 0) {
            sb.append(getRandomChar());
            length--;
        }
        return sb.toString();
    }

    /**
     * Returns a word of a length between 1 and 10 characters.
     *
     * @return A work of max length 10
     */
    public String getRandomWord() {
        return getItem(contentDataValues.getWords());
    }

    /**
     * Returns a valid word with a length of <code>length</code>
     * characters.
     *
     * @param length maximum length of the word
     * @return a word of a length up to <code>length</code> characters
     */
    public String getRandomWord(int length) {
        return getRandomWord(length, length);
    }

    /**
     * Returns a valid word with a length of up to <code>length</code>
     * characters. If the <code>exactLength</code> parameter is set, then the
     * word will be exactly <code>length</code> characters in length.
     *
     * @param length      maximum length of the returned string
     * @param exactLength indicates if the word should have a length of
     *                    <code>length</code>
     * @return a string with a length that matches the specified parameters.
     */
    public String getRandomWord(int length, boolean exactLength) {
        if (exactLength) {
            return getRandomWord(length, length);
        }
        return getRandomWord(0, length);
    }

    /**
     * Returns a valid word based on the length range passed in. The length will
     * always be between the min and max length range inclusive.
     *
     * @param minLength minimum length of the word
     * @param maxLength maximum length of the word
     * @return a word of a length between min and max length
     */
    public String getRandomWord(int minLength, int maxLength) {
        validateMinMaxParams(minLength, maxLength);

        // special case if we need a single char
        if (maxLength == 1) {
            if (chance(50)) {
                return "a";
            }
            return "I";
        }

        // start from random pos and find the first word of the right size
        String[] words = contentDataValues.getWords();
        int pos = random.nextInt(words.length);
        for (int i = 0; i < words.length; i++) {
            int idx = (i + pos) % words.length;
            String test = words[idx];
            if (test.length() >= minLength && test.length() <= maxLength) {
                return test;
            }
        }
        // we haven't a word for this length so generate one
        return getRandomChars(minLength, maxLength);
    }

    /**
     * @param chance Chance of a suffix being returned
     * @return suffix string
     */
    public String getSuffix(int chance) {
        return getItem(nameDataValues.getSuffixes(), chance);
    }

    /**
     * Return a person prefix or null if the odds are too low.
     *
     * @param chance Odds of a prefix being returned
     * @return Prefix string
     */
    public String getPrefix(int chance) {
        return getItem(nameDataValues.getPrefixes(), chance);
    }

    /**
     * Returns a string containing a set of numbers with a fixed number of
     * digits
     *
     * @param digits number of digits in the final number
     * @return Random number as a string with a fixed length
     */
    public String getNumberText(int digits) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < digits; i++) {
            result.append(random.nextInt(10));
        }
        return result.toString();
    }

    /**
     * Generates a random business name by taking a city name and adding a
     * business onto it.
     *
     * @return A random business name
     */
    public String getBusinessName() {
        return getCity() + " " + getItem(contentDataValues.getBusinessTypes());
    }

    /**
     * Generates an email address
     *
     * @return an email address
     */
    public String getEmailAddress() {
        int test = random.nextInt(100);
        String email;
        if (test < 50) {
            // name and initial
            email = getFirstName().charAt(0) + getLastName();
        } else {
            // 2 words
            email = getItem(contentDataValues.getWords())
                    + getItem(contentDataValues.getWords());
        }
        if (random.nextInt(100) > 80) {
            email = email + random.nextInt(100);
        }
        email = email + "@" + getItem(contentDataValues.getEmailHosts()) + "."
                + getItem(contentDataValues.getTlds());
        return email.toLowerCase();
    }

    /**
     * Gives you a true/false based on a probability with a random number
     * generator. Can be used to optionally add elements.
     *
     * <pre>
     * if (DataFactory.chance(70)) {
     * 	// 70% chance of this code being executed
     * }
     * </pre>
     *
     * @param chance % chance of returning true
     * @return boolean
     */
    public boolean chance(int chance) {
        return random.nextInt(100) < chance;
    }

    public NameDataValues getNameDataValues() {
        return nameDataValues;
    }

    /**
     * Call randomize with a seed value to reset the random number generator. By
     * using the same seed over different tests, you will get the same
     * results out for the same data generation calls.
     *
     * @param seed Seed value to use to generate random numbers
     */
    public void randomize(int seed) {
        random = new Random(seed);
    }

    /**
     * Set this to provide your own list of name data values by passing it a
     * class that implements the {@link NameDataValues} interface which just
     * returns the String arrays to use for the test data.
     *
     * @param nameDataValues Object holding the set of data values to use
     */
    public void setNameDataValues(NameDataValues nameDataValues) {
        this.nameDataValues = nameDataValues;
    }

    /**
     * Set this to provide your own list of address data values by passing it a
     * class that implements the {@link AddressDataValues} interface which just
     * returns the String arrays to use for the test data.
     *
     * @param addressDataValues Object holding the set of data values to use
     */
    public void setAddressDataValues(AddressDataValues addressDataValues) {
        this.addressDataValues = addressDataValues;
    }

    /**
     * Set this to provide your own list of content data values by passing it a
     * class that implements the {@link ContentDataValues} interface which just
     * returns the String arrays to use for the test data.
     *
     * @param contentDataValues Object holding the set of data values to use
     */
    public void setContentDataValues(ContentDataValues contentDataValues) {
        this.contentDataValues = contentDataValues;
    }

}
