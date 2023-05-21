package tasks.nivel_4;

public class Product {
    private String productId;
    private String testProduct;

    public Product(String productId, String testProduct) {
        this.productId = productId;
        this.testProduct = testProduct;
    }

    public String getProductId() {
        return productId;
    }

    public String getTestProduct() {
        return testProduct;
    }
}
