package sk.jurik.shop.db.services.api.request;

import org.springframework.lang.NonNull;

import java.util.Objects;

public class UpdateProductRequest {

    @NonNull
    private String name;
    @NonNull
    private String description;
    @NonNull
    private double price;
    @NonNull
    private int available;

    public UpdateProductRequest(@NonNull String name, @NonNull String description, double price, int available) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.available = available;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getAvailable() {
        return available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UpdateProductRequest)) return false;
        UpdateProductRequest that = (UpdateProductRequest) o;
        return Double.compare(that.getPrice(), getPrice()) == 0 && getAvailable() == that.getAvailable() && getName().equals(that.getName()) && getDescription().equals(that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDescription(), getPrice(), getAvailable());
    }
}
