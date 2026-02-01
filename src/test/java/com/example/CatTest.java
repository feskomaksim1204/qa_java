package com.example;

import org.junit.Test;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CatTest {

    @Test
    public void testGetSound() {
       Predator predatorMock = mock(Predator.class);

        Cat cat = new Cat(predatorMock);

        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {
        Predator predatorMock = mock(Predator.class);
        List<String> expectedFood = List.of("Мясо", "Рыба", "Птица");

        when(predatorMock.eatMeat()).thenReturn(expectedFood);

        Cat cat = new Cat(predatorMock);
        assertEquals(expectedFood, cat.getFood());

        verify(predatorMock, times(1)).eatMeat();
    }

    @Test(expected = Exception.class)
    public void testGetFoodThrowsException() throws Exception {
        Predator predatorMock = mock(Predator.class);

        when(predatorMock.eatMeat()).thenThrow(new Exception("Ошибка"));

        Cat cat = new Cat(predatorMock);
        cat.getFood();
    }

    @Test
    public void testCatConstructorWithPredator() {
        Predator predatorMock = mock(Predator.class);
        Cat cat = new Cat(predatorMock);

        assertNotNull(cat);
    }
}
