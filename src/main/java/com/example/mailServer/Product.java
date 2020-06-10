package com.example.mailServer;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {
    private ProductInfo productInfo;
    private int quantity;


    public Product(@JsonProperty("product") ProductInfo productInfo, @JsonProperty("quantity") int quantity
                  ) {
        this.quantity = quantity;
        this.productInfo=productInfo;
    }

    public ProductInfo getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(ProductInfo productInfo) {
        this.productInfo = productInfo;
    }

    public int getQuantity() {
        return quantity;
    }


    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    @Override
    public String toString() {
        return "Product{" +
                "productInfo=" + productInfo +
                ", quantity=" + quantity +
                '}';
    }
}
