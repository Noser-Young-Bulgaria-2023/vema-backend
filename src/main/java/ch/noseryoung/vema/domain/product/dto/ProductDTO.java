package ch.noseryoung.vema.domain.product.dto;

public class ProductDTO {
    private String id;
    private String name;
    private float price;
    private String imagePath;
    private int amount;

    public ProductDTO(String id, String name, float price, String imagePath, int amount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imagePath = imagePath;
        this.amount = amount;
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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}
