public class Elevator {

    private int currentFloor = 1;
    private int minFloor;
    private int maxFloor;

    public Elevator(int minFloor, int maxFloor) {
        this.maxFloor = maxFloor;
        this.minFloor = minFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void moveDown () {
        currentFloor = currentFloor - 1;
    }

    public void moveUp () {
        currentFloor = currentFloor + 1;
    }

    public void move(int floor) {
        if (floor == getCurrentFloor()) {
            System.out.println("Выбран текущий этаж: " + getCurrentFloor());
        }
        if (floor > getCurrentFloor() && floor <= maxFloor) {
            System.out.println("Текущий этаж: " + getCurrentFloor());
            System.out.println("Движение лифта вверх");
            for (int i = getCurrentFloor(); i < floor; i++) {
                moveUp();
                System.out.println("Этаж: " + getCurrentFloor());
            }
            System.out.println("Остановка лифта на этаже: " + floor);
        } else if (floor > maxFloor) {
            System.out.println("Введенный этаж выше максимального: " + maxFloor);
        }
        if (floor < getCurrentFloor() && floor >= minFloor) {
            System.out.println("Этаж: " + getCurrentFloor());
            System.out.println("Движение лифта вниз");
            for (int i = getCurrentFloor(); i > floor; i--) {
                moveDown();
                System.out.println("Текущий этаж: " + getCurrentFloor());
            }
            System.out.println("Остановка лифта на этаже: " + floor);
        } else if (floor < minFloor) {
            System.out.println("Введенный этаж ниже минимального: " + minFloor);
        }


    }

}
