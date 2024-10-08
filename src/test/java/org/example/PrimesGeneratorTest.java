package org.example;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrimesGeneratorTest {
    @Test
    public void testPrimesGenerator() {
        int N = 10; // Количество простых чисел для генерации
        PrimesGenerator generator = new PrimesGenerator(N);

        // Выводим простые числа в прямом порядке
        System.out.println("Простые числа в прямом порядке: " + generator.getPrimes());

        // Выводим простые числа в обратном порядке
        List<Integer> reversePrimes = new ArrayList<>(generator.getPrimes());
        Collections.reverse(reversePrimes);
        System.out.println("Простые числа в обратном порядке: " + reversePrimes);

        // Проверка
        List<Integer> expectedPrimes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        assertEquals(expectedPrimes.subList(0, N), generator.getPrimes());
    }
}
