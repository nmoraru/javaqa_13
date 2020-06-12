package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    Book book1 = new Book(1, "Чистый код", 550, "Роберт Мартин");
    Book book2 = new Book(2, "Философия Java", 1500, "Эккель Брюс");

    @BeforeEach
    void init() {
        manager.add(book1);
        manager.add(book2);
    }

    @Test
    void shouldMatchesToBookName() {
        boolean actual = book1.matches("Чистый код");
        assertTrue(actual);
    }

    @Test
    void shouldMatchesToBookAuthor() {
        boolean actual = book2.matches("Эккель Брюс");
        assertTrue(actual);
    }

    @Test
    void shouldMatchesToBookNameIncorrect() {
        boolean actual = book1.matches("Гарри Поттер");
        assertFalse(actual);
    }

    @Test
    void shouldMatchesToBookAuthorIncorrect() {
        boolean actual = book2.matches("Джоан Роулинг");
        assertFalse(actual);
    }

}
