package com.orange.marvelapi.dto;

public class PriceComicDTO {

    private String type;
    private float price;

    public PriceComicDTO(String type, float price) {
        this.type = type;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public float getPrice() {
        return price;
    }
}
