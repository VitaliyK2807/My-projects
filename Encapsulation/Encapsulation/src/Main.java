public class Main {
    public static void main(String[] args) {
        Dimensions cargo1Dimensions = new Dimensions(2.2, 3.3, 4.4);

        Cargo cargo1 = new Cargo(
                1.0,
                "ул. Программистов 15",
                true,
                "12GH33Q",
                false,
                cargo1Dimensions);
        System.out.println(cargo1);

        cargo1 = cargo1.setDeliveryAddress("ул. Промышленная");
        cargo1 = cargo1.setTurnOverCargo(false);
        cargo1 = cargo1.setRegistrationNumber("12HH33Q");
        cargo1 = cargo1.setFragileCargo(true);
        cargo1 = cargo1.setCargoWeight(2.5);


        Cargo copy = new Cargo(
                cargo1.getCargoWeight(),
                cargo1.getDeliveryAddress(),
                cargo1.getTurnOverCargo(),
                cargo1.getRegistrationNumber(),
                cargo1.getFragileCargo(),
                cargo1.getDimensions());


        System.out.println("-------------------");
        System.out.println(copy);

    }
}
