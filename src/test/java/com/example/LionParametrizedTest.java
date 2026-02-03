package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionParametrizedTest {

    private final String sex;
    private final boolean expectedHasMane;

    public LionParametrizedTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void testDoesHaveMane() throws Exception {
        Predator predatorMock = mock(Predator.class);
        Lion lion = new Lion(sex, predatorMock);
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }
}
