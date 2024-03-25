package com.practice.tdd.utils;

import java.util.function.Predicate;

public class EmailValidator implements Predicate<String> {
    public boolean test(String email) {
        //RFC standards +
       //return email.matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
        return email.matches("^[\\w\\-.]+@([\\w-]+\\.)+[\\w-]{2,}$");

    }
}
