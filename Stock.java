public class Stock {
    String symbol;
    String name;
    double price;

    public Stock(String symbol, String name, double price){
        this.symbol = symbol;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getSymbol() {
        return symbol;
    }

    public void updatePrice(double newPrice){
        this.price = newPrice;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "symbol=" + symbol +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
