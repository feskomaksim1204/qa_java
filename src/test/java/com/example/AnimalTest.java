package com.example;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class AnimalTest {

    @Test
    public void testGetFamily() {
        Animal animal = new Animal();
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals(expected, animal.getFamily());
    }

    @Test
    public void testGetFoodForHerbivore() throws Exception {
        Animal animal = new Animal();
        List<String> expected = List.of("Трава", "Различные растения");
        assertEquals(expected, animal.getFood("Травоядное"));
    }

    @Test
    public void testGetFoodForPredator() throws Exception {
        Animal animal = new Animal();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, animal.getFood("Хищник"));
    }

    @Test(expected = Exception.class)
    public void testGetFoodThrowsExceptionForUnknownType() throws Exception {
        Animal animal = new Animal();
        animal.getFood("Неизвестный");
    }

    @Test
    public void testGetFoodExceptionMessage() {
        Animal animal = new Animal();
        try {
            animal.getFood("Неизвестный");
            fail("Expected exception was not thrown");
        } catch (Exception e) {
            assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", e.getMessage());
        }
    }
}
