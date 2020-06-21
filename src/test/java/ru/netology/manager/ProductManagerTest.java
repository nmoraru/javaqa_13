package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.NotFoundException;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    Book book1 = new Book(1, "Чистый код", 550, "Роберт Мартин");
    Book book2 = new Book(2, "Философия Java", 1500, "Эккель Брюс");
    Smartphone smartphone1 = new Smartphone(3, "iPhone 5S", 15000, "Apple");
    Smartphone smartphone2 = new Smartphone(4, "Galaxy S10E", 35000, "Samsung");

    @BeforeEach
    void init() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);
    }

    @Test
    void shouldRemoveByValidId() {
        String expected = null;
        repository.removeById(2);
        assertEquals(expected, repository.findById(2));
    }

    @Test
    void shouldRemoveByInvalidId() {
        assertThrows(NotFoundException.class, () -> repository.removeById(5));
    }

    @Test
    void shouldSearchByNameBook() {
        Product[] expected = new Product[]{book1};
        assertArrayEquals(expected, manager.searchBy("Чистый код"));
    }

    @Test
    void shouldSearchByAuthorBook() {
        Product[] expected = new Product[]{book2};
        assertArrayEquals(expected, manager.searchBy("Эккель Брюс"));
    }

    @Test
    void shouldSearchBySmartphoneName() {
        Product[] expected = new Product[]{smartphone2};
        assertArrayEquals(expected, manager.searchBy("Galaxy S10E"));

    }

    @Test
    void shouldSearchBySmartphoneManufacturer() {
        Product[] expected = new Product[]{smartphone1};
        assertArrayEquals(expected, manager.searchBy("Apple"));
    }

    /*
    * negative tests
    * */

    @Test
    void shouldSearchBySmartphoneManufacturerIncorrect() {
        Product[] expected = {};
        assertArrayEquals(expected, manager.searchBy("ZTE"));
    }

    @Test
    void shouldSearchBySmartphoneNameIncorrect() {
        Product[] expected = {};
        assertArrayEquals(expected, manager.searchBy("3310"));
    }

    @Test
    void shouldSearchByNameBookIncorrect() {
        Product[] expected = {};
        assertArrayEquals(expected, manager.searchBy("Золотой ключик"));
    }

    @Test
    void shouldSearchByAuthorBookIncorrect() {
        Product[] expected =  {};
        assertArrayEquals(expected, manager.searchBy("Лев Толстой"));
    }

}
