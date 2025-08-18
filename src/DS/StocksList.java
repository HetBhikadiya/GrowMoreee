package DS;

import Model.Stock;
import java.util.ArrayList;
import java.util.List;

public class StocksList {
    private List<Stock> stocks = new ArrayList<>();

    // Insert stock into list
    public void InsertStocks(String sym, String name, String category, double prev, double today) {
        Stock stock = new Stock(sym, name, category, prev, today);
        stocks.add(stock);
    }

    // Display all stocks
    public void DisplayStock() {
        System.out.printf("%-10s %-30s %-20s %-15s %-15s%n",
                "Symbol", "Company Name", "Category", "Prev Close", "Today Open");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        for (Stock stock : stocks) {
            System.out.println(stock);
        }
    }

}
