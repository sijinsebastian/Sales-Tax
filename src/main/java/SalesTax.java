import java.util.ArrayList;
import java.util.List;

public class SalesTax {

    public static List<String> createReceipt(List<String> shoppingList) {

        Float totalSalesTax = 0f;
        Float totalPrice = 0f;
        List<String> receipt = new ArrayList<>();

        for ( String listItem: shoppingList ){
            Product product = createProduct(listItem);
            TaxManager.calculateTax(product);
            receipt.add(getReceiptLine(product));
            totalSalesTax += product.getNetTax();
            totalPrice += product.getGrossPrice();
        }
        receipt.add(String.format("Sales Taxes: %.2f", totalSalesTax));
        receipt.add(String.format("Total: %.2f", totalPrice));

        return receipt;
    }

    private static Product createProduct(String listItem){
        String[] productDetails = listItem.split(" ", 2); //separate quantity and other Details of the product
        int productQuantity = Integer.parseInt(productDetails[0]);
        String productDescription = productDetails[1].substring(0, productDetails[1].lastIndexOf(" at "));
        Float productPrice = Float.parseFloat(productDetails[1].substring(productDetails[1].lastIndexOf(" ")));
        boolean isImported = productDescription.contains("imported");
        
        return new Product(productDescription, productQuantity, productPrice, isImported);
    }

    private static String getReceiptLine(Product product){
        return String.format("%d %s: %.2f",product.getQuantity(), product.getProductDescription(), product.getGrossPrice());
    }

}
