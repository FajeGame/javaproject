package org.example;

import java.util.*;

public class CollectionsExample {

    public static void main(String[] args) {
        Random random = new Random();
        int N = 10;
        Integer[] array = generateRandomArray(random, N);

        System.out.println("Оригинальный массив: " + Arrays.toString(array));

        List<Integer> list = new ArrayList<>(Arrays.asList(array));
        System.out.println("Список: " + list);

        sortListAscending(list);
        sortListDescending(list);
        shuffleList(list);
        rotateList(list);
        printUniqueElements(list);
        printDuplicateElements(list);
        Integer[] newArray = convertListToArray(list);
        printFrequency(array);
    }

    // Метод для генерации массива случайных чисел
    private static Integer[] generateRandomArray(Random random, int N) {
        Integer[] array = new Integer[N];
        for (int i = 0; i < N; i++) {
            array[i] = random.nextInt(101);
        }
        return array;
    }

    // Метод для сортировки списка по возрастанию
    private static void sortListAscending(List<Integer> list) {
        Collections.sort(list);
        System.out.println("Отсортированный список (по возрастанию): " + list);
    }

    // Метод для сортировки списка по убыванию
    private static void sortListDescending(List<Integer> list) {
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("Отсортированный список (по убыванию): " + list);
    }

    // Метод для перемешивания списка
    private static void shuffleList(List<Integer> list) {
        Collections.shuffle(list);
        System.out.println("Перемешанный список: " + list);
    }

    // Метод для циклического сдвига списка
    private static void rotateList(List<Integer> list) {
        Collections.rotate(list, 1);
        System.out.println("Циклический сдвиг списка: " + list);
    }

    // Метод для вывода уникальных элементов
    private static void printUniqueElements(List<Integer> list) {
        Set<Integer> uniqueSet = new HashSet<>(list);
        System.out.println("Уникальные элементы: " + uniqueSet);
    }

    // Метод для вывода дублирующихся элементов
    private static void printDuplicateElements(List<Integer> list) {
        List<Integer> duplicates = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        for (Integer num : list) {
            if (!seen.add(num)) {
                duplicates.add(num);
            }
        }
        System.out.println("Дублирующиеся элементы: " + duplicates);
    }

    // Метод для преобразования списка обратно в массив
    private static Integer[] convertListToArray(List<Integer> list) {
        Integer[] newArray = list.toArray(new Integer[0]);
        System.out.println("Массив из списка: " + Arrays.toString(newArray));
        return newArray;
    }

    // Метод для подсчета частоты чисел в массиве
    private static void printFrequency(Integer[] array) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (Integer num : array) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        System.out.println("Частоты чисел: " + frequencyMap);
    }
}
