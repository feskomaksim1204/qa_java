package com.example;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class AnimalTest {

    @Test
    public void testGetFamilyReturnsCorrectMessage() {
        Animal animal = new Animal();
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals(expected, animal.getFamily());
    }

    @Test
    public void testGetFoodForPredatorReturnsMeat() throws Exception {
        Animal animal = new Animal();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, animal.getFood("Хищник"));
    }

    @Test
    public void testGetFoodForHerbivoreReturnsPlants() throws Exception {
        Animal animal = new Animal();
        List<String> expected = List.of("Трава", "Различные растения");
        assertEquals(expected, animal.getFood("Травоядное"));
    }

    @Test(expected = Exception.class)
    public void testGetFoodWithInvalidAnimalKindThrowsException() throws Exception {
        Animal animal = new Animal();
        animal.getFood("Неизвестно");
    }

    @Test
    public void testGetFoodWithNullThrowsException() throws Exception {
        Animal animal = new Animal();
        try {
            animal.getFood(null);
            fail("Should throw exception for null");
        } catch (Exception e) {
            // Ожидаемое поведение
            assertTrue(e.getMessage().contains("Неизвестный вид животного"));
        }
    }

    @Test
    public void testGetFoodWithEmptyStringThrowsException() throws Exception {
        Animal animal = new Animal();
        try {
            animal.getFood("");
            fail("Should throw exception for empty string");
        } catch (Exception e) {
            // Ожидаемое поведение
            assertTrue(e.getMessage().contains("Неизвестный вид животного"));
        }
    }
}
