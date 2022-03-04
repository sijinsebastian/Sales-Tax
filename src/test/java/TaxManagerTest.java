import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TaxManagerTest {

    @Test
    public void taxExemptedGoods() {
        Product product = new Product("book", 1, 10.24f, false);
        TaxManager.calculateTax(product);
        assertEquals(0f, (Object) product.getSalesTax());
        assertEquals(0f, (Object) product.getImportDuty());
    }

    @Test
    public void taxExemptedGoodsImported() {
        Product product = new Product("box of chocolate", 1, 11f, true);
        TaxManager.calculateTax(product);
        assertEquals(0f, (Object) product.getSalesTax());
        assertEquals(0.55f, (Object) product.getImportDuty());
    }

    @Test
    public void taxedGoods() {
        Product product = new Product("music CD", 1, 15f, false);
        TaxManager.calculateTax(product);
        assertEquals(1.5f, (Object) product.getSalesTax());
        assertEquals(0f, (Object) product.getImportDuty());
    }

    @Test
    public void taxedGoodsImported() {
        Product product = new Product("perfume", 1, 20f, true);
        TaxManager.calculateTax(product);
        assertEquals(2.00f, (Object) product.getSalesTax());
        assertEquals(1.00f, (Object) product.getImportDuty());
    }
}