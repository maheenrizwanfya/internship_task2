import java.util.HashMap;
import java.util.Map;

public class Market {
    private Map<String, Stock> stocks;

    public Market(){
        stocks = new HashMap<>(); // didnt use Map here bcus then id have to implement a bunch of methods which arent necessary here
    }

    public void addStock(Stock stock){
        stocks.put(stock.getSymbol(), stock);
    }

    public Stock getStock(String symbol){
        return stocks.get(symbol); // get the stock from the map which has the specific symbol
    }

    public void simulateMarket(){
        for (Stock stock : stocks.values()){
            double randomChange = (Math.random() - 0.5) * 10; // the random change occurring in stock price between -5 and + 5
            stock.updatePrice(stock.getPrice() + randomChange); // the price that alr exists + the new update that came randomly
        }
    }

    public void displayMarket(){
        System.out.println("MARKET DATA: ");
        for (Stock stock : stocks.values()){
            System.out.println(stock);
        }
    }
}
