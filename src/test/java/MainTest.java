package org.example;

import model.Book;
import model.Visitor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private List<Visitor> visitors;

    @BeforeEach
    void setUp() {
        // Создание тестовых данных
        Book book1 = new Book();
        book1.setName("Pride and Prejudice");
        book1.setAuthor("Jane Austen");
        book1.setPublishingYear(1813);

        Book book2 = new Book();
        book2.setName("1984");
        book2.setAuthor("George Orwell");
        book2.setPublishingYear(1949);

        Book book3 = new Book();
        book3.setName("To Kill a Mockingbird");
        book3.setAuthor("Harper Lee");
        book3.setPublishingYear(1960);

        Visitor visitor1 = new Visitor();
        visitor1.setName("Alice");
        visitor1.setSurname("Smith");
        visitor1.setPhone("1234567890");
        visitor1.setSubscribed(true);
        visitor1.setFavoriteBooks(Arrays.asList(book1, book2));

        Visitor visitor2 = new Visitor();
        visitor2.setName("Bob");
        visitor2.setSurname("Johnson");
        visitor2.setPhone("0987654321");
        visitor2.setSubscribed(false);
        visitor2.setFavoriteBooks(Arrays.asList(book2, book3));

        visitors = Arrays.asList(visitor1, visitor2);
    }

    @Test
    void testVisitorCount() {
        assertEquals(2, visitors.size());
    }

    @Test
    void testUniqueBooks() {
        List<Book> uniqueBooks = visitors.stream()
                .flatMap(visitor -> visitor.getFavoriteBooks().stream())
                .distinct()
                .toList();
        assertEquals(3, uniqueBooks.size());
    }

    @Test
    void testSortedBooks() {
        List<Book> sortedBooks = visitors.stream()
                .flatMap(visitor -> visitor.getFavoriteBooks().stream())
                .distinct()
                .sorted((b1, b2) -> Integer.compare(b1.getPublishingYear(), b2.getPublishingYear()))
                .toList();

        assertEquals("Pride and Prejudice", sortedBooks.get(0).getName());
        assertEquals("1984", sortedBooks.get(1).getName());
        assertEquals("To Kill a Mockingbird", sortedBooks.get(2).getName());
    }

    @Test
    void testHasJaneAustenBook() {
        boolean hasJaneAustenBook = visitors.stream()
                .flatMap(visitor -> visitor.getFavoriteBooks().stream())
                .anyMatch(book -> "Jane Austen".equals(book.getAuthor())); // Исправлено здесь
        assertTrue(hasJaneAustenBook);
    }

    @Test
    void testMaxFavoriteBooks() {
        int maxFavoriteBooks = visitors.stream()
                .mapToInt(visitor -> visitor.getFavoriteBooks().size())
                .max().orElse(0);
        assertEquals(2, maxFavoriteBooks);
    }

}
