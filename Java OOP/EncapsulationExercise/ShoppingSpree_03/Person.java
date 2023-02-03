package ShoppingSpree_03;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {

        if (!name.trim().isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }

    private void setMoney(double money) {
        if (money >= 0) {
            this.money = money;
        } else {
            throw new IllegalArgumentException("Money cannot be negative");
        }
    }

    public void buyProduct(Product product) {

        if (this.money >= product.getCost()) {
            products.add(product);
            this.money -= product.getCost();
        } else {
            String exception = String.format("%s can't afford %s",
                    this.name, product.getName());
            throw new IllegalArgumentException(exception);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(" - ");

        if (products.isEmpty()) {
            sb.append("Nothing bought");
        } else {
            sb.append(String.join(", ", products.stream().map(e -> e.getName())
                    .collect(Collectors.toList())));

        }
        return sb.toString();
    }
}
