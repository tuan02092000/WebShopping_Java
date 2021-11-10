package com.tuannv.Model;

public class ProductModel {
    private int id;
    private String name;
    private String image;
    private double price;
    private int categoryId;
    private int brandId;

    public ProductModel() {
    }

    public ProductModel(int id, String name, String image, double price, int categoryId, int brandId) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.categoryId = categoryId;
        this.brandId = brandId;
    }

    public ProductModel(String name, String image, double price, int categoryId, int brandId) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.categoryId = categoryId;
        this.brandId = brandId;
    }

    public ProductModel(String name, String image, double price) {
        this.name = name;
        this.image = image;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    @Override
    public String toString() {
        return "ProductModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", categoryId=" + categoryId +
                ", brandId=" + brandId +
                '}';
    }
}
