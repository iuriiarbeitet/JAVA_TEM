package tasks.nivel_4;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductServiceTest {
    @Test
    public void testUpdateStock() {
        ProductRepository productRepository = Mockito.mock(ProductRepository.class);
        InventoryManager inventoryManager = Mockito.mock(InventoryManager.class);
        String productId = "ABC";
        int quantity = 10;

        ProductService productService = new ProductService(productRepository, inventoryManager);
        productService.updateStock(productId, quantity);

        Mockito.verify(inventoryManager).updateStock(productId, quantity);
    }

    @Test
    public void testGetProductById() {
        ProductRepository productRepository = Mockito.mock(ProductRepository.class);
        InventoryManager inventoryManager = Mockito.mock(InventoryManager.class);
        String productId = "ABC";
        Product product = new Product(productId, "Test Product");

        Mockito.when(productRepository.getProductById(productId)).thenReturn(product);

        ProductService productService = new ProductService(productRepository, inventoryManager);
        Product result = productService.getProductById(productId);

        Mockito.verify(productRepository).getProductById(productId);
        assertEquals(product, result);
    }
}