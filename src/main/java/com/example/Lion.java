package com.example;

import java.util.List;

public class Lion {

    private boolean hasMane;
    private Predator predator;  // Зависимость от интерфейса, а не класса

    public Lion(String sex, Predator predator) throws Exception {  // Инъекция через конструктор
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
        this.predator = predator;
    }

    public int getKittens() {
        return predator.getKittens();  // У Predator нет такого метода! Нужно добавить в интерфейс
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return predator.eatMeat();
    }
}
