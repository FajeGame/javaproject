package org.example;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanTest {
    @Test
    public void testHumanCollections() {
        List<Human> humans = new ArrayList<>(Arrays.asList(
                new Human("Иван", "Иванов", 25),
                new Human("Анна", "Смирнова", 30),
                new Human("Алексей", "Петров", 20)
        ));

        // a) HashSet
        Set<Human> humanSet = new HashSet<>(humans);
        System.out.println("HashSet: " + humanSet);

        // b) LinkedHashSet
        Set<Human> linkedHashSet = new LinkedHashSet<>(humans);
        System.out.println("LinkedHashSet: " + linkedHashSet);

        // c) TreeSet (по умолчанию сортировка по возрасту)
        Set<Human> treeSet = new TreeSet<>(humans);
        System.out.println("TreeSet (по возрасту): " + treeSet);

        // d) TreeSet с компаратором по фамилии
        Set<Human> treeSetByLastName = new TreeSet<>(new HumanComparatorByLastName());
        treeSetByLastName.addAll(humans);
        System.out.println("TreeSet (по фамилии): " + treeSetByLastName);

        // e) TreeSet с анонимным компаратором по возрасту
        Set<Human> treeSetByAge = new TreeSet<>(Comparator.comparingInt(Human::getAge));
        treeSetByAge.addAll(humans);
        System.out.println("TreeSet (по возрасту с анонимным компаратором): " + treeSetByAge);

        // Проверка размеров сетов
        assertEquals(3, humanSet.size());
        assertEquals(3, linkedHashSet.size());
        assertEquals(3, treeSet.size());
        assertEquals(3, treeSetByLastName.size());
        assertEquals(3, treeSetByAge.size());
    }
}
