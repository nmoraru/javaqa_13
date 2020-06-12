package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {

    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    Smartphone smartphone1 = new Smartphone(3, "iPhone 5S", 15000, "Apple");
    Smartphone smartphone2 = new Smartphone(4, "Galaxy S10E", 35000, "Samsung");

    @BeforeEach
    void init() {
        manager.add(smartphone1);
        manager.add(smartphone2);
    }

    @Test
    void shouldMatchesToSmartphoneName() {
        boolean actual = smartphone1.matches("iPhone 5S");
        assertTrue(actual);
    }

    @Test
    void shouldMatchesToSmartphoneManufacturer() {
        boolean actual = smartphone2.matches("Samsung");
        assertTrue(actual);
    }

    @Test
    void shouldMatchesToSmartphoneNameIncorrect() {
        boolean actual = smartphone1.matches("Чистый код");
        assertFalse(actual);
    }

    @Test
    void shouldMatchesToSmartphoneManufacturerIncorrect() {
        boolean actual = smartphone2.matches("Эккель Брюс");
        assertFalse(actual);
    }

}
