public class Basket {

    private static int count = 0;
    private String items;
    private int totalPrice = 0;
    private int limit;

    private static int totalCount = 0;
    private static int totalCost = 0;

    public static int getTotalCount() {
        return totalCount;
    }

    public static int getTotalCost() {
        return totalCost;
    }

    private double totalWeight = 0;

    public String getItems() {
        return items;
    }

    public int getLimit() {
        return limit;
    }

    public Basket() {
        increaseCount(1);
        items = "Список товаров:";
        this.limit = 1000000;
    }

    public Basket(int limit) {
        this();
        this.limit = limit;
    }

    public Basket(String items, int totalPrice) {
        this();
        this.items = this.items + items;
        this.totalPrice = totalPrice;

    }

    public static int getCount() {
        return count;
    }

    public static void increaseCount(int count) {

        Basket.count = Basket.count + count;
    }

    public void add(String name, int price) {

        add(name, price, 1, 0);
    }

    public void add(String name, int price, int count, double weight) {
        boolean error = false;

        if (contains(name)) {
            error = true;
        }

        if (totalPrice + count * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }

        totalCount = totalCount + count;

        totalPrice = totalPrice + count * price;
        totalWeight = totalWeight + weight * count;
        totalCost = totalCost + count * price;

        items = items + "\n" + name + " - " +
                getCount() + " шт. - стоимость: " + price + " руб.";
        if (weight > 0) {
            items = items + " Вес ед. товара: " + weight + " кг.";
        }

    }

    public void clear() {
        items = "";
        totalPrice = 0;
        totalWeight = 0;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
            System.out.println("Сумма: " + getTotalPrice() + " руб.");
            System.out.println("Общий вес: " + getTotalWeight() + " кг.");
            System.out.println();
        }
    }
}
