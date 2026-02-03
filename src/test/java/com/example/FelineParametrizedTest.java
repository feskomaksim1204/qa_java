package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FelineParametrizedTest {

    private final int expectedKittens;
    private final int inputCount;

    public FelineParametrizedTest(int inputCount, int expectedKittens) {
        this.inputCount = inputCount;
        this.expectedKittens = expectedKittens;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {1, 1},
                {0, 0},
                {5, 5},
                {10, 10}
        };
    }

    @Test
    public void testGetKittensWithCount() {
        Feline feline = new Feline();
        assertEquals(expectedKittens, feline.getKittens(inputCount));
    }
}
