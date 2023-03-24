package practice;

public class BankAccount {

  private double scoring;


  public double getAmount() {
    return scoring;
  }

  public void put(double amountToPut) {
    if (amountToPut >= 0) {
      scoring = amountToPut;
    }

  }

  public void take(double amountToTake) {
    if (scoring >= amountToTake) {
      scoring -= amountToTake;
    }
  }
}
