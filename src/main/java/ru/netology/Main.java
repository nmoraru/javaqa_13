package ru.netology;

import ru.netology.domain.Book;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

public class Main {
    public static void main(String[] args) {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        Book book1 = new Book(1, "Чистый код", 550, "Роберт Мартин");
        Book book2 = new Book(2, "Философия Java", 1500, "Эккель Брюс");
        Smartphone smartphone1 = new Smartphone(3, "iPhone 5S", 15000, "Apple");
        Smartphone smartphone2 = new Smartphone(4, "Galaxy S10E", 35000, "Samsung");

        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        repository.removeById(3);

        System.out.println("Hi !");
    }
}
