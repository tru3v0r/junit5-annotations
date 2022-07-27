package com.baeldung.junit5.templates;

import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserIdGeneratorImplUnitTest {
    @TestTemplate
    @ExtendWith(UserIdGeneratorTestInvocationContextProvider.class)
    public void whenUserIdRequested_thenUserIdIsReturnedInCorrectFormat(UserIdGeneratorTestCase testCase) {
        UserIdGenerator userIdGenerator = new UserIdGeneratorImpl(testCase.isFeatureEnabled());

        String actualUserId = userIdGenerator.generate(testCase.getFirstName(), testCase.getLastName());


        assertTrue(actualUserId.equals(testCase.getExpectedUserId()));
    }
}