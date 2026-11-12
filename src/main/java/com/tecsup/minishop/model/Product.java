package com.tecsup.minishop.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Integer stock;

    public Product() {
    }

    public Product(Long id, String name, Double price, Integer stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    protected boolean canEqual(Object other) {
        return other instanceof Product;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Product product) || !product.canEqual(this)) {
            return false;
        }
        return Objects.equals(id, product.id)
                && Objects.equals(name, product.name)
                && Objects.equals(price, product.price)
                && Objects.equals(stock, product.stock);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, stock);
    }

    @Override
    public String toString() {
        return "Product(id=" + id + ", name=" + name + ", price=" + price + ", stock=" + stock + ")";
    }

    public static ProductBuilder builder() {
        return new ProductBuilder();
    }

    public static class ProductBuilder {
        private Long id;
        private String name;
        private Double price;
        private Integer stock;

        public ProductBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public ProductBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ProductBuilder price(Double price) {
            this.price = price;
            return this;
        }

        public ProductBuilder stock(Integer stock) {
            this.stock = stock;
            return this;
        }

        public Product build() {
            return new Product(id, name, price, stock);
        }
    }
}