package com.practice.tdd.utils;

import java.util.function.Predicate;

public class PhoneNumberValidator implements Predicate<String> {

    @Override
    public boolean test(String phoneNumber) {

        return phoneNumber.startsWith("+91") &&
                phoneNumber.length() == 13;
    }
}
