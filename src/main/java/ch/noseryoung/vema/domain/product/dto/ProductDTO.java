package ch.noseryoung.vema.domain.product.dto;

import org.bson.types.Binary;

public class ProductDTO {
    private String id;
    private String name;
    private float price;
    private int amount;
    private Binary image;

    public ProductDTO() {
    }

    public ProductDTO(String id, String name, float price, int amount, Binary image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.image = image;
    }

    public Binary getImage() {
        return image;
    }

    public void setImage(Binary image) {
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}
