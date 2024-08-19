import java.util.HashMap;
import java.util.Map;

public class Profile {
    private Map<Stock, Integer> holdings;
    double cash;

    public Profile(double cash){
        this.cash = cash;
        holdings = new HashMap<>();
    }

    public void buyStocks(Stock stock, int quantity){
        if (cash >= (stock.getPrice() * quantity)) {
            cash = cash - (stock.getPrice() * quantity);
            holdings.put(stock,quantity);
            System.out.println("Bought " + quantity + " shares of " + stock.getName());
        }
        else
            System.out.println("Not enough cash to make this transaction.");
    }

    public void sellStocks(Stock stock, int quantity){
        int currentShares = holdings.getOrDefault(stock,0); // this gives the current amount of shares of a specific stock
        if (currentShares >= quantity) {
            cash = cash + (stock.getPrice() * quantity);
            holdings.put(stock, currentShares - quantity);
            System.out.println("Sold " + quantity + " shares of " + stock.getName());
        }
        else
            System.out.println("Not enough shares for this transaction.");
    }

    public double getEvaluation(){
       double total = cash;
       for (Stock stock : holdings.keySet()){
           total += stock.getPrice() * holdings.get(stock);
       }
       return total;
    }

    public void displayProfile(){
        System.out.println("Profile:");
        for (Stock stock : holdings.keySet()) {
            System.out.println(stock.getName() + ": " + holdings.get(stock) + " shares @ " + stock.getPrice() + " Rs.");
        }
        System.out.println("Cash: " + cash + " Rs.");
        System.out.println("Total Worth: " + getEvaluation() + " Rs.");
    }
}
