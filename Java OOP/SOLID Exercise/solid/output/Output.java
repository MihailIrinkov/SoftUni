package solid.output;

import solid.products.Product;

import java.util.List;

public interface Output {

    public void outputSum(List<Product> products);
    public void outputAverage(List<Product> products);

}
