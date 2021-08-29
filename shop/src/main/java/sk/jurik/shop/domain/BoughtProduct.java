package sk.jurik.shop.domain;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Objects;

public class BoughtProduct {

    private int productId;
    private int customerId;
    private int quantity;
    private Timestamp bought_at;

    public BoughtProduct() {
    }

    public BoughtProduct(int productId, int customerId, int quantity) {
        this.productId = productId;
        this.customerId = customerId;
        this.quantity = quantity;
        this.bought_at = Timestamp.from(Instant.now());
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Timestamp getBought_at() {
        return bought_at;
    }

    public void setBought_at(Timestamp bought_at) {
        this.bought_at = bought_at;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BoughtProduct)) return false;
        BoughtProduct that = (BoughtProduct) o;
        return getProductId() == that.getProductId() && getCustomerId() == that.getCustomerId() && getQuantity() == that.getQuantity() && Objects.equals(getBought_at(), that.getBought_at());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductId(), getCustomerId(), getQuantity(), getBought_at());
    }
}
