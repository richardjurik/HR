package sk.jurik.shop.domain;

import java.util.Objects;

public class CustomerAccount {

    private int customerId;
    private double money;

    public CustomerAccount() {
    }

    public CustomerAccount(int customerId , double money) {
        this.customerId = customerId;
        this.money = money;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerAccount)) return false;
        CustomerAccount that = (CustomerAccount) o;
        return getCustomerId() == that.getCustomerId() && Double.compare(that.getMoney(), getMoney()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomerId(), getMoney());
    }
}
