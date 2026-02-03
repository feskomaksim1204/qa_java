package com.example;

import org.junit.Test;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LionTest {

    @Test(expected = Exception.class)
    public void testInvalidSexThrowsException() throws Exception {
        Predator predatorMock = mock(Predator.class);
        new Lion("Неизвестный", predatorMock);
    }

    @Test
    public void testGetKittens() throws Exception {
        Predator predatorMock = mock(Predator.class);
        when(predatorMock.getKittens()).thenReturn(3);

        Lion lion = new Lion("Самец", predatorMock);
        assertEquals(3, lion.getKittens());

        verify(predatorMock, times(1)).getKittens();
    }

    @Test
    public void testGetFood() throws Exception {
        Predator predatorMock = mock(Predator.class);
        List<String> expectedFood = List.of("Мясо", "Рыба");
        when(predatorMock.eatMeat()).thenReturn(expectedFood);

        Lion lion = new Lion("Самка", predatorMock);
        assertEquals(expectedFood, lion.getFood());

        verify(predatorMock, times(1)).eatMeat();
    }
}
