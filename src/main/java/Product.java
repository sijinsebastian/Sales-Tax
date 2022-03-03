public class Product {
    private String productDescription;
    private int quantity;
    private Float basePrice;
    private boolean isImported;

    private Float salesTax = 0f;
    private Float importDuty = 0f;
    public Product(String productDescription, int quantity , Float basePrice, boolean isImported) {
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

    public Float getBasePrice() {
        return basePrice;
    }

    public boolean getIsImported() {
        return isImported;
    }

    public void setSalesTax(Float salesTax) {
        this.salesTax = salesTax;
    }

    public Float getSalesTax( ) {
        return salesTax;
    }

    public void setImportDuty(Float importDuty) {
        this.importDuty = importDuty;
    }

    public Float getImportDuty( ) {
        return importDuty;
    }

    public Float getGrossPrice(){
        return basePrice+ salesTax +importDuty;
    }

    public Float getNetTax(){
        return salesTax +importDuty;
    }
}