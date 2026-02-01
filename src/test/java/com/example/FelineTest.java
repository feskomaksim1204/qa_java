package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FelineTest {

    private final int expectedKittens;
    private final int inputCount;

    public FelineTest(int inputCount, int expectedKittens) {
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

    @Test
    public void testGetKittensDefault() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void testEatMeat() throws Exception {
        Feline feline = new Feline();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedFood, feline.eatMeat());
    }

    @Test
    public void testGetFamily() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testFelineIsPredator() {
        Feline feline = new Feline();
        assertTrue(feline instanceof Predator);
    }
}
