package sk.jurik.shop.domain;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Objects;

public class Product {

    @Nullable
    private Integer id;
    @NonNull
    private int merchantId;
    @NonNull
    private String name;
    @NonNull
    private String description;
    @NonNull
    private double price;
    @NonNull
    private Timestamp createdAt;
    @NonNull
    private int available;

    public Product(){
    }

    public Product(int merchantId, @NonNull String name, @NonNull String description, double price, int available) {
        this.merchantId = merchantId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.available = available;
        this.createdAt = Timestamp.from(Instant.now());
    }

    @Nullable
    public Integer getId() {
        return id;
    }

    public void setId(@Nullable Integer id) {
        this.id = id;
    }

    public int getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(int merchantId) {
        this.merchantId = merchantId;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    public void setDescription(@NonNull String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @NonNull
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(@NonNull Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return getMerchantId() == product.getMerchantId() && Double.compare(product.getPrice(), getPrice()) == 0 && getAvailable() == product.getAvailable() && Objects.equals(getId(), product.getId()) && getName().equals(product.getName()) && getDescription().equals(product.getDescription()) && getCreatedAt().getTime() == product.getCreatedAt().getTime();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMerchantId(), getName(), getDescription(), getPrice(), getCreatedAt(), getAvailable());
    }
}
