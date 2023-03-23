public class Cargo {

    private final double cargoWeight;
    private final String deliveryAddress;
    private final boolean turnOverCargo;
    private final String registrationNumber;
    private final boolean fragileCargo;
    private final Dimensions dimensions;

    public Cargo() {
        cargoWeight = 0.0;
        deliveryAddress = "N/A";
        turnOverCargo = false;
        registrationNumber = "N/A";
        fragileCargo = false;
        dimensions = getDimensions();
    }
    public Cargo(double cargoWeight,
                 String deliveryAddress,
                 boolean turnOverCargo,
                 String registrationNumber,
                 boolean fragileCargo,
                 Dimensions dimensions) {
        this.cargoWeight = cargoWeight;
        this.deliveryAddress = deliveryAddress;
        this.turnOverCargo = turnOverCargo;
        this.registrationNumber = registrationNumber;
        this.fragileCargo = fragileCargo;
        this.dimensions = dimensions;
    }
    public Cargo setCargoWeight(double cargoWeight) {
      return new Cargo(cargoWeight, deliveryAddress, turnOverCargo, registrationNumber, fragileCargo, dimensions);
    }

    public Cargo setDeliveryAddress(String deliveryAddress) {
        return new Cargo(cargoWeight, deliveryAddress, turnOverCargo, registrationNumber, fragileCargo, dimensions);
    }
    public Cargo setTurnOverCargo(boolean turnOverCargo) {
        return new Cargo(cargoWeight, deliveryAddress, turnOverCargo, registrationNumber, fragileCargo, dimensions);
    }
    public Cargo setRegistrationNumber(String registrationNumber) {
        return new Cargo(cargoWeight, deliveryAddress, turnOverCargo, registrationNumber, fragileCargo, dimensions);
    }
    public Cargo setFragileCargo(boolean fragileCargo) {
        return new Cargo(cargoWeight, deliveryAddress, turnOverCargo, registrationNumber, fragileCargo, dimensions);
    }

    public double getCargoWeight () { return  cargoWeight; }
    public String getDeliveryAddress() {
        return deliveryAddress;
    }
    public boolean getTurnOverCargo() {
        return turnOverCargo;
    }
    public String getRegistrationNumber() {
        return registrationNumber;
    }
    public boolean getFragileCargo() {
        return fragileCargo;
    }
    public Dimensions getDimensions() {
        return dimensions;
    }

    public String toString () {
        return "Груз, масса: " + getCargoWeight() + " кг." + "\n" +
                "Адрес доставки: " + deliveryAddress + "\n" +
                "Можно ли переворачивать: " + (turnOverCargo ? "Можно" : "Нельзя") + "\n" +
                "Регистрационный номер: " + registrationNumber + "\n" +
                "Хрупкий: " + (fragileCargo ? "Да" : "Нет") + "\n" +
                "Габариты: " + "\n" + dimensions;
    }

}
