package sk.jurik.shop.db.services.api.request;

import java.util.Objects;

public class BuyProductRequest {

    private int productId;
    private int customerId;
    private int quantity;

    public BuyProductRequest(int productId, int customerId, int quantity) {
        this.productId = productId;
        this.customerId = customerId;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BuyProductRequest)) return false;
        BuyProductRequest that = (BuyProductRequest) o;
        return getProductId() == that.getProductId() && getCustomerId() == that.getCustomerId() && getQuantity() == that.getQuantity();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductId(), getCustomerId(), getQuantity());
    }
}
