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
        if(salesTaxExemptedGoods.stream().noneMatch(product.getProductDescription()::contains)){
            float salesTax = product.getBasePrice()* salesTaxRate /100;
            salesTax = (float)Math.ceil(salesTax*20f)/20f; //Rounding to nearest 0.05
            product.setSalesTax(salesTax);
        }
    }

    private static void findImportDuty(Product product){
        if (product.getIsImported()){
            float importDuty = product.getBasePrice()*importDutyRate/100;
            importDuty = (float) Math.ceil(importDuty*20f)/20f; //Rounding to nearest 0.05
            product.setImportDuty(importDuty);
        }
    }
}
