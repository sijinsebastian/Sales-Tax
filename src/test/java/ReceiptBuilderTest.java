import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ReceiptBuilderTest {

    @Test
    public void taxDomesticProducts() {
        List<String> shoppingList = new ArrayList<>();
        shoppingList.add("1 book at 12.49");
        shoppingList.add("1 music CD at 14.99");
        shoppingList.add("1 chocolate bar at 0.85");

        List<String> expectedReceipt = new ArrayList<>();
        expectedReceipt.add("1 book: 12.49");
        expectedReceipt.add("1 music CD: 16.49");
        expectedReceipt.add("1 chocolate bar: 0.85");
        expectedReceipt.add("Sales Taxes: 1.50");
        expectedReceipt.add("Total: 29.83");

        assertEquals(expectedReceipt, ReceiptBuilder.createReceipt(shoppingList));
    }

    @Test
    public void taxImportedProducts() {
        List<String> shoppingList = new ArrayList<>();
        shoppingList.add("1 imported box of chocolates at 10.00");
        shoppingList.add("1 imported bottle of perfume at 47.50");

        List<String> expectedReceipt = new ArrayList<>();
        expectedReceipt.add("1 imported box of chocolates: 10.50");
        expectedReceipt.add("1 imported bottle of perfume: 54.65");
        expectedReceipt.add("Sales Taxes: 7.65");
        expectedReceipt.add("Total: 65.15");

        assertEquals(expectedReceipt, ReceiptBuilder.createReceipt(shoppingList));
    }

    @Test
    public void taxDomesticAndImported() {
        List<String> shoppingList = new ArrayList<>();
        shoppingList.add("1 imported bottle of perfume at 27.99");
        shoppingList.add("1 bottle of perfume at 18.99");
        shoppingList.add("1 packet of headache pills at 9.75");
        shoppingList.add("1 box of imported chocolates at 11.25");

        List<String> expectedReceipt = new ArrayList<>();
        expectedReceipt.add("1 imported bottle of perfume: 32.19");
        expectedReceipt.add("1 bottle of perfume: 20.89");
        expectedReceipt.add("1 packet of headache pills: 9.75");
        expectedReceipt.add("1 box of imported chocolates: 11.85");
        expectedReceipt.add("Sales Taxes: 6.70");
        expectedReceipt.add("Total: 74.68");

        assertEquals(expectedReceipt, ReceiptBuilder.createReceipt(shoppingList));
    }
}