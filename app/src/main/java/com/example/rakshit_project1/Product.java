package com.example.rakshit_project1;

public class Product {

    int image;
    String item_name, item_description, item_flavours;
    float price;

    public String getItem_flavours() {
        return item_flavours;
    }

    public void setItem_flavours(String item_flavours) {
        this.item_flavours = item_flavours;
    }

    public Product(int image, String item_name, String item_description, String item_flavours, float price) {
        this.image = image;
        this.item_name = item_name;
        this.item_description = item_description;
        this.item_flavours = item_flavours;
        this.price = price;
    }

//    public Product(int image, String item_name, String item_description, float price) {
//        this.image = image;
//        this.item_name = item_name;
//        this.item_description = item_description;
//        this.price = price;
//    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_description() {
        return item_description;
    }

    public void setItem_description(String item_description) {
        this.item_description = item_description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
