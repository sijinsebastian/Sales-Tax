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
            Float grossPrice = product.getBasePrice() +product.getSalesTax()+product.getImportDuty();
            receipt.add(String.format("%d %s: %.2f",product.getQuantity(), product.getProductDescription(), grossPrice));
            totalSalesTax += product.getSalesTax()+product.getImportDuty();
            totalPrice += grossPrice;
        }
        receipt.add(String.format("Sales Taxes: %.2f", totalSalesTax));
        receipt.add(String.format("Total: %.2f", totalPrice));
        return receipt;
    }

    private static Product createProduct(String listItem){
        String[] productDetails = listItem.split(" ", 2);
        int productQuantity = Integer.parseInt(productDetails[0]);
        String productDescription = productDetails[1].substring(0, productDetails[1].lastIndexOf(" at "));
        Float productPrice = Float.parseFloat(productDetails[1].substring(productDetails[1].lastIndexOf(" ")));
        Boolean isImported = false;
        if(productDescription.contains("imported")){
            isImported = true;
        }
        Product product = new Product(productDescription, productQuantity, productPrice, isImported);
        return product;
    }

}
