import java.util.ArrayList;
import java.util.Arrays;

public class TaxManager {

    private final static Float salesTaxRate = 10f;
    private final static Float importDutyRate = 5f;
    private final static ArrayList<String> salesTaxExemptedGoods = new ArrayList<>(Arrays.asList("book","medical", "chocolate","pills"));

    public static void calculateTax(Product product){
        findSalesTax(product);
        findImportDuty(product);
    }

    private static void findSalesTax(Product product){
        if(!salesTaxExemptedGoods.stream().anyMatch(product.getProductDescription()::contains)){
            product.setSalesTax(product.getBasePrice()* salesTaxRate /100);
        }
    }

    private static void findImportDuty(Product product){
        if (product.getIsImported()){
            product.setImportDuty(product.getBasePrice()*importDutyRate/100);
        }
    }


}
