public class Product {
    private String productDescription;
    private int quantity;
    private float basePrice;
    private boolean isImported;

    private float salesTax = 0f;
    private float importDuty = 0f;

    public Product(String productDescription, int quantity, float basePrice, boolean isImported) {
        this.productDescription = productDescription;
        this.basePrice = basePrice;
        this.quantity = quantity;
        this.isImported = isImported;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getBasePrice() {
        return basePrice;
    }

    public boolean getIsImported() {
        return isImported;
    }

    public void setSalesTax(float salesTax) {
        this.salesTax = salesTax;
    }

    public float getSalesTax() {
        return salesTax;
    }

    public void setImportDuty(float importDuty) {
        this.importDuty = importDuty;
    }

    public float getImportDuty() {
        return importDuty;
    }

    public float getGrossPrice() {
        return basePrice + salesTax + importDuty;
    }

    public float getNetTax() {
        return salesTax + importDuty;
    }
}