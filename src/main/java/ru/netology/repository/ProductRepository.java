package ru.netology.repository;

import ru.netology.domain.Product;

public class ProductRepository {

    private Product[] products = new Product[0];

    public void save(Product product) {
        Product[] tmp = new Product[products.length + 1];

        System.arraycopy(products, 0, tmp, 0, products.length);

        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    public Product[] findAll() {
        return products;
    }

    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void removeById(int id) {
        Product[] tmp = new Product[products.length - 1];

        try {
            findById(id);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("Element with id: " + id + " not found");
        }

        int index = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[index] = product;
                index++;
            }
        }

        products = tmp;
    }

}
