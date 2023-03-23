public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add("Milk", 40);


        Basket vasyaBasket = new Basket();
        vasyaBasket.add("Хлеб", 25, 5, 0.5);
        vasyaBasket.add("Кетчуп", 250, 2, 0.2);

        Basket ivanBasket = new Basket();
        ivanBasket.add("Хлеб", 25, 2, 0.5);
        ivanBasket.add("Молоко", 45, 1, 1);
        ivanBasket.add("Cola", 95);

        basket.print("Корзина Basket");

        vasyaBasket.print("Корзина Васи");

        ivanBasket.print("Корзина Вани");

        System.out.println("Общее количество товаров во всех корзинах: " + basket.getTotalCount() + " шт.");
        System.out.println("Общая стоимость товаров во всех корзинах: " + basket.getTotalCost() + " руб.");


    }
}
