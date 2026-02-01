package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionTest {

    private final String sex;
    private final boolean expectedHasMane;

    @Mock
    Predator predatorMock;

    public LionTest(String sex, boolean expectedHasMane) {
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
