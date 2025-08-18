package DS;
import Service.StockService;
import Service.StockService.*;

import java.util.List;

public class StocksList {
    class NewStock{
        NewStock next;
        String Symbol;
        String name;
        double prev;
        double today;

        public NewStock(String symbol, String name, double prev, double today) {
            Symbol = symbol;
            this.name = name;
            this.prev = prev;
            this.today = today;
        }
    }
    NewStock first=null;

    public void InsertStocks(String symbol, String name, double prev, double today){
        NewStock stock=new NewStock(symbol, name, prev, today);
        if(first==null){
            first=stock;
        }
        else{
            NewStock temp=first;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=stock;
        }
    }

    public void DisplayStock(){
        NewStock temp=first;
        while(temp.next!=null){
            String sym= StockService.TableShow(temp.Symbol,12);
            String sname=StockService.TableShow(temp.name,33);
            String sprev= "Previous Close: ₹" + temp.prev;
            String stoday = "Today Open: ₹" + temp.today;

            System.out.println(sym + sname + sprev + "     " + stoday);
            temp=temp.next;
        }
    }
    public void sortingByPrize(){
        if(first == null || first.next == null){
            return; // no need to sort
        }

        boolean swapped;
        do{
            swapped = false;
            NewStock current = first;
            while(current.next != null){
                if(current.today > current.next.today){
                    // swap all fields
                    String tsym = current.Symbol;
                    String tname = current.name;
                    double tprev = current.prev;
                    double ttoday = current.today;

                    current.Symbol = current.next.Symbol;
                    current.name = current.next.name;
                    current.prev = current.next.prev;
                    current.today = current.next.today;

                    current.next.Symbol = tsym;
                    current.next.name = tname;
                    current.next.prev = tprev;
                    current.next.today = ttoday;

                    swapped = true;
                }
                current = current.next;
            }
        }while(swapped);
    }
}
