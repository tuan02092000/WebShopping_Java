package com.tuannv.Model;

public class BrandModel {
    private int id;
    private String name;

    private int count;

    public BrandModel() {
    }

    public BrandModel(int id) {
        this.id = id;
    }

    public BrandModel(int id, String name, int count) {
        this.id = id;
        this.name = name;
        this.count = count;
    }

    public BrandModel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public BrandModel(String name) {
        this.name = name;
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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

    @Override
    public String toString() {
        return "BrandModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
