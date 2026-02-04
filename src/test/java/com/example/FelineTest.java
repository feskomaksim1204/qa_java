package com.example;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class FelineTest {

    @Test
    public void testEatMeatReturnsPredatorFood() throws Exception {
        Feline feline = new Feline();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedFood, feline.eatMeat());
    }

    @Test
    public void testGetFamilyReturnsFeline() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testGetKittensWithoutParameterReturnsOne() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void testGetKittensWithParameterReturnsCorrectCount() {
        Feline feline = new Feline();
        assertEquals(3, feline.getKittens(3));
    }

    @Test
    public void testGetFoodForHerbivoreReturnsPlants() throws Exception {
        Feline feline = new Feline();
        List<String> expectedFood = List.of("Трава", "Различные растения");
        assertEquals(expectedFood, feline.getFood("Травоядное"));
    }

    @Test(expected = Exception.class)
    public void testGetFoodWithInvalidAnimalKindThrowsException() throws Exception {
        Feline feline = new Feline();
        feline.getFood("Неизвестно");
    }
}
