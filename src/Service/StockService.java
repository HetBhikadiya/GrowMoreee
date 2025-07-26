package Service;
import DS.StocksList;
import DB.DBConnection;
import Model.Stock;

import java.sql.*;
import java.util.*;

public class StockService {

    StocksList stocksList=new StocksList();

    public void getAllStocks() throws SQLException {
        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM stocks");

        while (rs.next()) {
            String sym=rs.getString("Symbols");
            String name=rs.getString("Company_names");
            double prev=rs.getDouble("Previous_ClosePrice");
            double today=rs.getDouble("Today_OpenPrice");

            stocksList.InsertStocks(sym,name,prev,today);
        }
        stocksList.DisplayStock();
    }

    // ✅ Helper method added inside the class
    public static String TableShow(String str, int length) {
        while (str.length() < length) {
            str += " ";
        }
        return str;
    }

    public Stock getStock(String symbol) throws SQLException {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM stocks WHERE symbol=?");
        ps.setString(1, symbol);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Stock(
                    rs.getString("Symbols"),
                    rs.getString("Company_names"),
                    rs.getDouble("Previous_ClosePrice"),
                    rs.getDouble("Today_OpenPrice")
            );
        }
        con.close();
        return null;
    }
}