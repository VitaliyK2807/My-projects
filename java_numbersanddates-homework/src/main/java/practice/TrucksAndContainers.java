package practice;

import java.util.Scanner;

public class TrucksAndContainers {

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        //получение количество коробок от пользователя
        int boxes = scanner.nextInt();
        int truckCount = 1;
        int containerCount = 1;
        int boxesCount = 0;
        calculateCount(boxes);
        int count = (getContainerCount() < 12 ? getContainerCount() : 12);
        while (truckCount <= getTrucksCount()) {
            System.out.println("Грузовик: " + truckCount);
            if (truckCount == 1) {
                while (containerCount <= count) {
                    System.out.println('\t' + "Контейнер: " + containerCount);
                    while (boxesCount < containerCount * 27) {
                        ++boxesCount;
                        if (boxesCount > boxes) {
                            break;
                        }
                        System.out.println("\t\t" + "Ящик: " + boxesCount);
                    }
                    containerCount++;
                }
            } else {
                while (containerCount <= getContainerCount()) {
                    System.out.println('\t' + "Контейнер: " + containerCount);
                    while (boxesCount < containerCount * 27) {
                        ++boxesCount;
                        if (boxesCount > boxes) {
                            break;
                        }
                        System.out.println("\t\t" + "Ящик: " + boxesCount);
                    }
                    containerCount++;
                }
            }
        truckCount++;
        }
        System.out.println("Необходимо:");
        System.out.println("грузовиков - " + getTrucksCount() + " шт.");
        System.out.println("контейнеров - " + getContainerCount() + " шт.");


        // TODO: вывести в консоль коробки разложенные по грузовикам и контейнерам
        // пример вывода при вводе 2
        // для отступа используйте табуляцию - \t

        /*
        Грузовик: 1
            Контейнер: 1
                Ящик: 1
                Ящик: 2
        Необходимо:
        грузовиков - 1 шт.
        контейнеров - 1 шт.
        */
    }

    private static final int MAX_COUNT_CONTAINER = 12;
    private static final int MAX_COUNT_BOXES = 27;

    private static int containerCount;
    private static int trucksCount;

    public static int getContainerCount() {
        return containerCount;
    }

    public static int getTrucksCount() {
        return trucksCount;
    }

    public static void calculateCount(int boxesCount) {
        containerCount = boxesCount / MAX_COUNT_BOXES +
                (boxesCount % MAX_COUNT_BOXES == 0 ? 0 : 1);
        trucksCount = containerCount / MAX_COUNT_CONTAINER +
                (containerCount % MAX_COUNT_CONTAINER == 0 ? 0 : 1);

    }



}
