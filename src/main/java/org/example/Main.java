package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Book;
import model.Visitor;
import model.SmsMessage;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        // Чтение и парсинг JSON файла
        Gson gson = new Gson();
        FileReader reader = new FileReader("src/main/resources/books.json");
        Type visitorListType = new TypeToken<List<Visitor>>() {}.getType();
        List<Visitor> visitors = gson.fromJson(reader, visitorListType);

        // Задание 1: Список посетителей и их количество
        long visitorCount = visitors.size();
        System.out.println("Список посетителей:");
        visitors.forEach(visitor -> System.out.println(visitor.getName() + " " + visitor.getSurname()));
        System.out.println("Количество посетителей: " + visitorCount);

        // Задание 2: Список уникальных книг
        List<Book> uniqueBooks = visitors.stream()
                .flatMap(visitor -> visitor.getFavoriteBooks().stream())
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Список уникальных книг:");
        uniqueBooks.forEach(book -> System.out.println(book.getName()));
        System.out.println("Количество уникальных книг: " + uniqueBooks.size());

        // Задание 3: Сортировка по году издания и вывод
        List<Book> sortedBooks = uniqueBooks.stream()
                .sorted(Comparator.comparingInt(Book::getPublishingYear))
                .collect(Collectors.toList());
        System.out.println("Сортированные книги по году издания:");
        sortedBooks.forEach(book -> System.out.println(book.getName() + " (" + book.getPublishingYear() + ")"));

        // Задание 4: Проверка наличия книги Jane Austen
        boolean hasJaneAustenBook = visitors.stream()
                .flatMap(visitor -> visitor.getFavoriteBooks().stream())
                .anyMatch(book -> "Jane Austen".equals(book.getAuthor()));
        System.out.println("Есть ли книга Jane Austen: " + hasJaneAustenBook);

        // Задание 5: Максимальное число избранных книг
        int maxFavoriteBooks = visitors.stream()
                .mapToInt(visitor -> visitor.getFavoriteBooks().size())
                .max().orElse(0);
        System.out.println("Максимальное количество избранных книг: " + maxFavoriteBooks);

        // Задание 6: Создание SMS сообщений
        double averageFavoriteBooks = visitors.stream()
                .mapToInt(visitor -> visitor.getFavoriteBooks().size())
                .average().orElse(0);

        visitors.stream()
                .filter(Visitor::isSubscribed)
                .map(visitor -> {
                    String message;
                    int favoriteBooksCount = visitor.getFavoriteBooks().size();
                    if (favoriteBooksCount > averageFavoriteBooks) {
                        message = "you are a bookworm";
                    } else if (favoriteBooksCount < averageFavoriteBooks) {
                        message = "read more";
                    } else {
                        message = "fine";
                    }
                    return new SmsMessage(visitor.getPhone(), message);
                })
                .forEach(sms -> System.out.println("Отправка SMS на номер " + sms.getPhone() + ": " + sms.getMessage()));
    }
}
