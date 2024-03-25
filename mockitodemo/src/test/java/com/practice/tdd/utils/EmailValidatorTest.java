package com.practice.tdd.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmailValidatorTest {
    EmailValidator emailValidator;
    @BeforeEach
    void setUp(){
        emailValidator= new EmailValidator();
    }
    @ParameterizedTest
    @CsvSource({
            "corsec@kimiafarma.df.id,true",
            "kangoedin@gmail.com,true",
            "boss@id.abbott,true",
            "test@test.com,true",
            "@test.com,false",
            "testtest.com,false",
            "test@testcom,false"
    })
    void  itShouldValidateEmail(String input,boolean expected){
        //Given
        boolean isValid=emailValidator.test(input);
        assertEquals(expected,isValid);
    }

}
