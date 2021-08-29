package sk.jurik.shop.db.services.api.response;

import org.springframework.lang.Nullable;

import java.util.Objects;

public class BuyProductResponse {

    private boolean success;
    @Nullable
    private String errorMessage;

    public BuyProductResponse(boolean success) {
        this.success = success;
    }

    public BuyProductResponse(boolean success, @Nullable String errorMessage) {
        this.success = success;
        this.errorMessage = errorMessage;
    }

    public boolean isSuccess() {
        return success;
    }

    @Nullable
    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BuyProductResponse)) return false;
        BuyProductResponse that = (BuyProductResponse) o;
        return isSuccess() == that.isSuccess() && Objects.equals(getErrorMessage(), that.getErrorMessage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(isSuccess(), getErrorMessage());
    }
}
