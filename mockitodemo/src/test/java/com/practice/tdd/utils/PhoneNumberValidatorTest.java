package com.practice.tdd.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PhoneNumberValidatorTest {
    private PhoneNumberValidator phoneNumberValidator;

    @BeforeEach
    void setUp(){
        phoneNumberValidator= new PhoneNumberValidator();
    }
    @ParameterizedTest
    @CsvSource({
            "+919012345678,true",
            "+9190123456781234562345,false",
            "-919012345678,false",
            "+449012345678,false",

    })
    void itShouldValidatePhoneNumber(String input,boolean expected){
        //when
        boolean isValid =phoneNumberValidator.test(input);
        //then
        assertEquals(expected,isValid);
    }

}