package tasks.nivel_4;

/**
 * Создайте класс ProductService, который зависит от классов ProductRepository и InventoryManager.
 *    ProductRepository содержит метод getProductById(String productId),
 *    возвращающий объект Product по идентификатору продукта.
 *    InventoryManager содержит метод updateStock(String productId, int quantity),
 *    обновляющий количество товара на складе. Напишите тест, используя Mockito, чтобы убедиться,
 *    что методы getProductById и updateStock были вызваны с правильными аргументами.
 */
public class ProductService {
    private final ProductRepository productRepository;
    private final InventoryManager inventoryManager;

    public ProductService(ProductRepository productRepository, InventoryManager inventoryManager) {
        this.productRepository = productRepository;
        this.inventoryManager = inventoryManager;
    }

    public Product getProductById(String productId) {
        return productRepository.getProductById(productId);
    }

    public void updateStock(String productId, int quantity) {
        inventoryManager.updateStock(productId, quantity);
    }
}
