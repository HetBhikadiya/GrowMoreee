package DS;
import Service.StockService;
import Service.StockService.*;

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
}
