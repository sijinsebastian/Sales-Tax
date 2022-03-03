import static org.junit.jupiter.api.Assertions.*;

class TaxManagerTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void taxExemptedGoods() {
        Product product = new Product("book", 1, 10.24f, false);
        TaxManager.calculateTax(product);
        assertEquals(0f, product.getSalesTax());
        assertEquals(0f, product.getImportDuty());
    }

    @org.junit.jupiter.api.Test
    void taxedGoods() {
        Product product = new Product("music CD", 1, 15f, false);
        TaxManager.calculateTax(product);
        assertEquals(1.5f, product.getSalesTax());
        assertEquals(0f, product.getImportDuty());
    }
}