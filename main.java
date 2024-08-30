import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Market stockMarket = new Market();

        // adding some stocks
        stockMarket.addStock(new Stock("NESTLE", "Nestle Pakistan Ltd.", 6850.5));
        stockMarket.addStock(new Stock("GOOGL", "Alphabet Class A", 3632.6));
        stockMarket.addStock(new Stock("AMZN", "Amazon.com Inc", 1242.9));
        stockMarket.addStock(new Stock("MSFT", "Microsoft", 4824.4));
        stockMarket.addStock(new Stock("WMT", "Walmart", 8567.2));

        System.out.println("Enter name: ");
        String name = input.nextLine();
        System.out.println("Enter your current balance: ");
        Double balance = input.nextDouble();
        input.nextLine(); // consumption of the line
        User user = new User(name, balance);

        // making the platform
        boolean running = true;
        while(running) { // this is to ensure that the user can keep accessing the options
            System.out.println("\n1. View Market Data");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Profile");
            System.out.println("5. Exit");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    stockMarket.displayMarket();
                    stockMarket.simulateMarket();
                    break;

                case 2:
                    System.out.println("Enter Stock Symbol: ");
                    String buySymbol = input.next().toUpperCase();
                    System.out.println("Enter the quantity of shares: ");
                    int buyShares = input.nextInt();
                    Stock buyStock = stockMarket.getStock(buySymbol);
                    if (buyStock != null)
                        user.getProfile().buyStocks(buyStock, buyShares);
                    else
                        System.out.println("Stock not found");
                    stockMarket.simulateMarket();
                    break;

                case 3:
                    System.out.println("Enter Stock Symbol: ");
                    String sellSymbol = input.next().toUpperCase();
                    System.out.println("Enter the quantity of shares: ");
                    int sellShares = input.nextInt();
                    Stock sellStock = stockMarket.getStock(sellSymbol);
                    if (sellStock != null)
                        user.getProfile().sellStocks(sellStock, sellShares);
                    else
                        System.out.println("Stock not found");
                    stockMarket.simulateMarket();
                    break;

                case 4:
                    user.getProfile().displayProfile();
                    stockMarket.simulateMarket();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}
