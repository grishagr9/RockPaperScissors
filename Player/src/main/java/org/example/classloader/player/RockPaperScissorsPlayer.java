package org.example.classloader.player;

import org.example.classloader.RockPaperScissorsEnum;
import org.example.classloader.api.PlaybleRockPaperScissors;

import java.util.Random;

public class RockPaperScissorsPlayer implements PlaybleRockPaperScissors {
    @Override
    public RockPaperScissorsEnum play() {
        // Получаем массив значений enum
        RockPaperScissorsEnum[] days = RockPaperScissorsEnum.values();
        // Создаем экземпляр класса Random
        Random random = new Random();
        // Генерируем случайный индекс в пределах длины массива
        int index = random.nextInt(days.length);

        return days[index];
    }
}
