package com.example.mailServer;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductInfo {
    private double price;
    private String title;
    private String description;
    private String imageUrl;

    public ProductInfo(@JsonProperty("price") double price, @JsonProperty("quantity") int quantity, @JsonProperty("title") String title,
                   @JsonProperty("description") String description,
                   @JsonProperty("url") String imageUrl) {
        this.price = price;
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public double getPrice() {
        return price;
    }


    public void setPrice(double price) {
        this.price = price;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
